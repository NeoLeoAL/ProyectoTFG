package com.ariasluque.agendainteractiva.ui.info

import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.*
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener
import com.ariasluque.agendainteractiva.models.Notes
import com.bumptech.glide.Glide
import io.realm.Realm
import io.realm.kotlin.where
import java.io.File


class InfoFragmentNote : Fragment() {

    private val DEF_ID_NOTE_PREFERENCE = 0

    private lateinit var mInteractionListener : OnNotesInteractionListener

    private lateinit var realm : Realm
    private lateinit var note : Notes

    // ------------------------ ON CREATE ------------------------ //

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_note, container, false)
        val idNote = getNoteIdPreference()

        if(idNote != 0){
            // Busca el note con el id que se le ha pasado
            realm = Realm.getDefaultInstance()
            note = realm.where<Notes>().equalTo("idNote", idNote).findFirst()!!

            // Cambia los datos del fagment
            changeViewData(view)

            // Una vez lo recibe el id vuelve a ponerle el valor a 0
            setNoteIdPreference()
        }

        setHasOptionsMenu(true)

        return view
    }

    // ------------------------ PREFERENCIAS ------------------------ //

    // Recibe el id del note desde las preferencias
    private fun getNoteIdPreference(): Int{
        return requireActivity().getSharedPreferences(getString(R.string.file_settings), Context.MODE_PRIVATE)
                                .getInt("idNote", DEF_ID_NOTE_PREFERENCE)
    }

    // Cambia el id y lo pone a 0 por defecto en las preferencias
    private fun setNoteIdPreference(){
        requireActivity().getSharedPreferences(getString(R.string.file_settings), Context.MODE_PRIVATE)
                            .edit()
                            .putInt("idNote", DEF_ID_NOTE_PREFERENCE)
                            .apply()
    }

    // ------------------------ DATOS NOTA ------------------------ //

    private fun changeViewData(view: View){
        // Recoge los elementos del layout y le guarda los datos de la nota
        val noteDate : TextView = view.findViewById(R.id.note_date)
        noteDate.text = note.creationDate // Fecha
        val noteTitle : TextView = view.findViewById(R.id.note_title)
        noteTitle.text = note.titleNote // Titulo
        val noteContent : TextView = view.findViewById(R.id.note_contentNote)

        // Comprueba si es una nota de texto o imagen dependiendo del contenido de la url
        if(note.urlImage == ""){
            view.findViewById<CardView>(R.id.cardContainer).setCardBackgroundColor(note.noteColor) // Color de la nota

            // Colores del texto
            noteDate.setTextColor(note.textColor)
            noteTitle.setTextColor(note.textColor)

            // Texto y color del texto de la nota
            noteContent.text = note.contentNote
            noteContent.setTextColor(note.textColor)

        }else{
            // Cambia el imageView a visible y esconde el textView
            view.findViewById<ImageView>(R.id.paintContainerI).visibility = View.VISIBLE
            noteContent.visibility = View.GONE

            // TODO: Visualiza el la imagen de la nota en la imageView cogiendo el url mediante la librería Glide
            Glide.with(view.context)
                .load(note.urlImage)
                .into(view.findViewById(R.id.paintContainerI))
        }
    }

    // ------------------------ ACTION BAR ------------------------ //

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        // Limpia el menú y lo coge por defecto
        menu.clear()
        inflater.inflate(R.menu.toolbar_menu_notes, menu)

        // Elimina las opciones de añadir y guardar
        menu.removeItem(R.id.new_note_tool)
        menu.removeItem(R.id.save_note_tool)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {
        // Opción de eliminación de la nota
        R.id.delete_task_tool -> {
            // Crea una ventana de dialogo
            createAlertDialog()
            true
        }

        R.id.edit_note_tool -> {
            // Envía el id de la nota para guardarla y tratarla en otro fragmento
            mInteractionListener.onPassNote(note.idNote)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    private fun createAlertDialog(){
        AlertDialog.Builder(activity).setTitle(resources.getString(R.string.title_delete_note))
            .setMessage(resources.getString(R.string.message_delete_note))
            .setPositiveButton(resources.getString(R.string.positive_yes)) { _, _ ->

                deleteNote() // Borra la nota
                mInteractionListener.onHomeListener() // Vuelve al home

                // Muestra un mensaje para indicar que se ha hecho correctamente
                Toast.makeText(
                    activity,
                    resources.getString(R.string.removed_note),
                    Toast.LENGTH_SHORT
                ).show()
            }
            .setNegativeButton(resources.getString(R.string.negative_no)) { dialog, _ ->
                dialog.cancel()
            }
            .show()
    }

    private fun deleteNote(){
        // Borra el fichero de la memoria interna
        if (note.urlImage != "") {
            val file = File(note.urlImage)
            if (file.exists())
                file.delete()
        }

        // Borra la nota de la BD
        realm.executeTransaction {
            note.deleteFromRealm()
        }
    }

    override fun onAttach(
        context: Context
    ) {
        super.onAttach(context)

        try {
            mInteractionListener = context as OnNotesInteractionListener

        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement Listener"))
        }
    }
}