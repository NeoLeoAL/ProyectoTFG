package com.ariasluque.agendainteractiva.ui.notes.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener

class NewNoteDialog : DialogFragment(){

    private lateinit var mInteractionListener : OnNotesInteractionListener

    // ------------------------ ON CREATE ------------------------ //

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Obtiene la referencia al layout de la ventana de dialogo a crear
            val root = requireActivity().layoutInflater.inflate(R.layout.custom_new_note_dialog, null)

            isCancelable = false // Impide que al pulsar fuera desaparezca el cuadro de dialogo

            AlertDialog.Builder(it)
                .setView(root) // Carga el layout en el cuadro de dialogo
                .setTitle(resources.getString(R.string.new_note))
                .setPositiveButton(resources.getString(R.string.positive_ok)) { dialog, _ ->
                    val editText =
                        root.findViewById<EditText>(R.id.editTextDialog).text.toString() // Contenido del editText

                    dialog.dismiss() // Cierra la ventana de dialogo

                    // Si se ha escrito titulo se envía
                    if (editText.isNotEmpty()) {
                        mInteractionListener.onNoteListener(editText) // Devuelve el texto del titulo
                        Toast.makeText(activity, editText, Toast.LENGTH_SHORT).show() // Muestra un mensaje indicando que se ha realizado correctamente

                    } else mInteractionListener.onNoteListener(resources.getString(R.string.title_note_data)) // Devuelve un texto por defecto
                }
                .setNegativeButton(resources.getString(R.string.negative_cancel)) { dialog, _ ->
                    dialog.dismiss() // Cierra la ventana de dialogo
                    mInteractionListener.onHomeListener() // Cambia al fragmento "Home"
                }
                .create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mInteractionListener = context as OnNotesInteractionListener

        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement DialogListener"))
        }
    }
}