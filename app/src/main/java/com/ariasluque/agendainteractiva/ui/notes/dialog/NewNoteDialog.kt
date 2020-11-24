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

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater // Para obtener la referencia al layout a crear

            val root = inflater.inflate(R.layout.custom_new_note_dialog, null)

            isCancelable = false // Impide que al pulsar fuera desaparezca el cuadro de dialogo

            builder.setView(root) // Carga el layout en el cuadro de dialogo
            builder.setTitle(resources.getString(R.string.new_note))
                .setPositiveButton(resources.getString(R.string.positive_ok),
                    DialogInterface.OnClickListener { dialog, id ->
                        var editText = root.findViewById<EditText>(R.id.editTextDialog).text.toString() // Contenido del editText

                        dialog.dismiss()

                        // Si se ha escrito titulo se envía
                        if(!editText.isEmpty()) {
                            mInteractionListener.onNoteListener(editText) // Devuelve el texto del titulo
                            val toast = Toast.makeText(activity, editText, Toast.LENGTH_SHORT)
                            toast.show()
                        }else mInteractionListener.onNoteListener(resources.getString(R.string.title_note_data)) // Devuelve un texto por defecto
                    })
                .setNegativeButton(resources.getString(R.string.negative_cancel),
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                        mInteractionListener.onHomeListener()
                    })
            // Create the AlertDialog object and return it
            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Verify that the host activity implements the callback interface
        try {
            // Instantiate the NoticeDialogListener so we can send events to the host
            mInteractionListener = context as OnNotesInteractionListener

        } catch (e: ClassCastException) {
            // The activity doesn't implement the interface, throw exception
            throw ClassCastException((context.toString() + " must implement DialogListener"))
        }
    }
}