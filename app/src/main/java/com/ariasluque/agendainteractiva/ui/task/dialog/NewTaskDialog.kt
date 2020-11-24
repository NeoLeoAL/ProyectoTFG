package com.ariasluque.agendainteractiva.ui.task.dialog

import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.fragment.app.DialogFragment
import com.ariasluque.agendainteractiva.R


class NewTaskDialog : DialogFragment() {

    private lateinit var mListener : OnInteractionListener
    private lateinit var root : View

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            val builder = AlertDialog.Builder(it)
            val inflater = requireActivity().layoutInflater // Para obtener la referencia al layout a crear

            root = inflater.inflate(R.layout.custom_new_task_dialog, null)

            builder.setView(root) // Carga el layout en el cuadro de dialogo
            builder.setTitle(resources.getString(R.string.new_task))
                .setPositiveButton(resources.getString(R.string.positive_ok),
                    DialogInterface.OnClickListener { dialog, id ->
                        var editTitleTask =
                            root.findViewById<EditText>(R.id.editTitleTask).text.toString() // Titulo

                        // Si se ha escrito la tarea se envía
                        if (!editTitleTask.isEmpty() && editTitleTask != "Task") {
                            mListener.onTaskListener(editTitleTask) // Devuelve los campos de la tarea

                            val toast = Toast.makeText(
                                activity,
                                resources.getString(R.string.created_task),
                                Toast.LENGTH_SHORT
                            )
                            toast.show()

                            mListener.onTaskFragment()
                            dialog.dismiss()
                        } else {
                            val toast = Toast.makeText(
                                activity,
                                resources.getString(R.string.empty_message),
                                Toast.LENGTH_SHORT
                            )

                            toast.show()
                        }
                    })
                .setNegativeButton(resources.getString(R.string.negative_cancel),
                    DialogInterface.OnClickListener { dialog, id ->
                        dialog.dismiss()
                    })

            builder.create()

        } ?: throw IllegalStateException("Activity cannot be null")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mListener = context as OnInteractionListener

        } catch (e: ClassCastException) {
            throw ClassCastException((context.toString() + " must implement DialogListener"))
        }
    }
}
