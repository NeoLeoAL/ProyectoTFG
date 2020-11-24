package com.ariasluque.agendainteractiva.controller

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.models.Task
import io.realm.RealmResults

class MyTaskRecyclerViewAdapter (
    private val mValues: RealmResults<Task>,
    private val mListener: OnTasksInteractionListener?

) : RecyclerView.Adapter<MyTaskRecyclerViewAdapter.ViewHolder>() {

    // Objeto listener para el click sobre el item de la task
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Task
            mListener?.onTaskClick(item)
        }
    }

    // ------------------------ ON CREATE VIEW ------------------------ //

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Devuelve el layout con los datos de las tasks (Cards de la lista de tasks)
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.card_task_item, parent, false))
    }

    // Introduce los datos en los diferentes elementos del layout
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mDateView.text = item!!.creationDate
        holder.mTitleView.text = item.titleTask
        holder.mCheckView.isChecked = item.taskDone

        // Escucha cada vez que el checkboz es checkeado
        holder.mCheckView.setOnClickListener { v ->
            mListener?.onTaskDone(item)
        }

        with(holder.mView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = mValues.size

    // Variables con las vistas del layout
    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mDateView: TextView = mView.findViewById(R.id.task_date)
        val mTitleView: TextView = mView.findViewById(R.id.task_title)
        val mCheckView: CheckBox = mView.findViewById(R.id.task_checkBox)

        override fun toString(): String {
            return super.toString() + " '" + mTitleView.text + "'"
        }
    }
}