package com.ariasluque.agendainteractiva.ui.task

import android.app.AlertDialog
import android.content.ContentUris
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.provider.CalendarContract
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.MyTaskRecyclerViewAdapter
import com.ariasluque.agendainteractiva.controller.OnTasksInteractionListener
import com.ariasluque.agendainteractiva.models.Task
import com.ariasluque.agendainteractiva.ui.task.dialog.NewTaskDialog
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where


class TaskFragment : Fragment() {

    private var columnCount = 1

    private var mListenerTI: OnTasksInteractionListener? = null
    private lateinit var mListenerNT : OnInteractionListener
    private lateinit var newTaskDialog: NewTaskDialog // Dialogo de la tarea

    private lateinit var realm: Realm
    private lateinit var taskBDList : RealmResults<Task> // Listado de notas de BD

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

        val view = inflater.inflate(R.layout.fragment_task_list, container, false)

        // Lista de la BD con las notas
        taskBDList = realm.where<Task>().findAll()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                GridLayoutManager(context, columnCount)

                adapter =
                    MyTaskRecyclerViewAdapter(
                        taskBDList,
                        mListenerTI
                    )
            }
        }

        setHasOptionsMenu(true)
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.toolbar_menu_task, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.delete_task_tool -> {
            // Crea una ventana de dialogo
            val deleteDialog: AlertDialog.Builder = AlertDialog.Builder(activity)

            deleteDialog.setTitle(resources.getString(R.string.title_delete_tasks))
                .setMessage(resources.getString(R.string.message_delete_tasks))
                .setPositiveButton(resources.getString(R.string.positive_yes)) { _, _ ->

                    // Borra todas las TAKS realizadas de la BD
                    realm.executeTransaction { realm ->
                        var results: RealmResults<Task> = realm.where(Task::class.java)
                            .equalTo("taskDone", true)
                            .findAll()

                        // Elimina los eventos del calendario
                        for(task : Task in results){
                            val deleteUri: Uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, task.idTask)
                            activity?.contentResolver?.delete(deleteUri, null, null)
                        }

                        results.deleteAllFromRealm()
                    }

                    mListenerNT?.onTaskFragment() // Refresca el contenido del fragment

                    val toast = Toast.makeText(
                        activity,
                        resources.getString(R.string.removed_tasks),
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

        R.id.update_task_tool -> {
            mListenerNT.onUpdateTask()
            mListenerNT.onTaskFragment()

            val toast = Toast.makeText(
                activity,
                "Actualizado",
                Toast.LENGTH_SHORT
            )
            toast.show()
            true
        }

        R.id.new_task_tool -> {
            // Muestra el dialogo para crear una nueva tarea
            newTaskDialog = NewTaskDialog()
            newTaskDialog.show(requireFragmentManager(), resources.getString(R.string.new_task))

            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mListenerNT = context as OnInteractionListener

            if (context is OnTasksInteractionListener) mListenerTI = context
            else throw RuntimeException("$context must implement OnListFragmentInteractionListener")

        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement DialogListener"))
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListenerTI = null
    }
}
