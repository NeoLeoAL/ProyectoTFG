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
    private lateinit var mInteractionListenerNN : OnNotesInteractionListener
    private lateinit var realm : Realm
    private lateinit var note : Notes

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Toma una instancia de Realm
        realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info_note, container, false)

        // Recibe el id del note desde el activity
        val prefs = requireActivity().getSharedPreferences("Preferences", Context.MODE_PRIVATE)
        val idNote = prefs.getInt("idNote", 0)

        val editor = prefs.edit()
        editor.putInt("idNote", 0)
        editor.commit()

        // Busca el note con el id que se le ha pasado
        note = realm.where<Notes>().equalTo("idNote", idNote?.let { it }).findFirst()!!

        // Cambia los datos del fagment
        changeViewData(view)

        setHasOptionsMenu(true)

        return view
    }

    private fun changeViewData(view: View){
        var noteDate : TextView = view.findViewById(R.id.note_date)
        noteDate.text = note.creationDate
        var noteTitle : TextView = view.findViewById(R.id.note_title)
        noteTitle.text = note.titleNote
        var noteContent : TextView = view.findViewById(R.id.note_contentNote)

        if(!note.contentNote!!.contains(".png")){
            var cardContainer : CardView = view.findViewById(R.id.cardContainer)
            cardContainer.setCardBackgroundColor(note.noteColor)

            noteDate.setTextColor(note.textColor)
            noteTitle.setTextColor(note.textColor)

            noteContent.text = note.contentNote
            noteContent.setTextColor(note.textColor)

        }else{
            // TODO Arreglar visualizacion
            view.findViewById<ImageView>(R.id.paintContainerI).visibility = View.VISIBLE
            noteContent.visibility = View.GONE

            Glide.with(view.context)
                .load(note.contentNote)
                .into(view.findViewById(R.id.paintContainerI))
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()

        inflater.inflate(R.menu.toolbar_menu_task, menu)

        val editTask : MenuItem? = menu.findItem(R.id.new_task_tool)
        editTask?.setIcon(R.drawable.ic_create_black_24dp)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.delete_task_tool -> {
            // Crea una ventana de dialogo
            val deleteDialog: AlertDialog.Builder = AlertDialog.Builder(activity)

            deleteDialog.setTitle(resources.getString(R.string.title_delete_note))
                .setMessage(resources.getString(R.string.message_delete_note))
                .setPositiveButton(resources.getString(R.string.positive_yes)) { dialog, which ->

                    // Borra el fichero de la memoria interna
                    if (note.contentNote!!.contains(".png")) {
                        val file = File(note.contentNote)
                        if (file.exists())
                            file.delete()
                    }

                    // Borra todas las TAKS realizadas de la BD
                    realm.executeTransaction { realm ->
                        note.deleteFromRealm()
                    }

                    mInteractionListenerNN?.onHomeListener() // Vuelve al home

                    val toast = Toast.makeText(
                        activity,
                        resources.getString(R.string.removed_note),
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
                .setNegativeButton(resources.getString(R.string.negative_no)) { dialog, which ->
                    dialog.cancel()
                }

            deleteDialog.show()

            true
        }

        R.id.new_task_tool -> {
            mInteractionListenerNN.onUpdateNote(note) // Envía la nota para tratarla en otro fragmento
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mInteractionListenerNN = context as OnNotesInteractionListener

        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement Listener"))
        }
    }
}