package com.ariasluque.agendainteractiva.controller

import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.models.Notes
import com.bumptech.glide.Glide
import io.realm.RealmResults
import kotlinx.android.synthetic.main.card_notes_item.view.*

class MyNotesRecyclerViewAdapter(
    private val mValues: RealmResults<Notes>,
    private val mListener: OnNotesInteractionListener?
) : RecyclerView.Adapter<MyNotesRecyclerViewAdapter.ViewHolder>() {

    // Objeto listener para el click sobre el item de la nota
    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Notes
            mListener?.onNoteClick(item)
        }
    }

    // ------------------------ ON CREATE VIEW ------------------------ //

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // Devuelve el layout con los datos de las notas (Cards de la lista de notas)
        return ViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.card_notes_item, parent, false))
    }

    // Introduce los datos en los diferentes elementos del layout
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = mValues[position]

        holder.mDateView.text = item!!.creationDate
        holder.mTitleView.text = item.titleNote
        holder.mDateView.setTextColor(item.textColor)
        holder.mTitleView.setTextColor(item.textColor)

        // Muestra en el caso de ser texto
        if(item.urlImage == "") {
            holder.mContentView.text = item.contentNote // Texto
            holder.mContentView.setTextColor(item.textColor) // Color del texto
            holder.mView.cardContainer.setCardBackgroundColor(item.noteColor) // Color de la nota
        }else{
            // Cambia los valores de visualización para que solo se muestre la imagen
            holder.mPaintView.visibility = View.VISIBLE
            holder.mContentView.visibility = View.GONE

            // TODO Arreglar visualizacion
            Glide.with(holder.mPaintView.context)
                .load(item.urlImage)
                .into(holder.mPaintView)
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
        val mTitleView: TextView = mView.findViewById(R.id.note_title)
        val mContentView: TextView = mView.findViewById(R.id.note_content)
        val mPaintView: ImageView = mView.findViewById(R.id.paintContainer)

        override fun toString(): String {
            return super.toString() + " '" + mContentView.text + "'"
        }
    }
}
