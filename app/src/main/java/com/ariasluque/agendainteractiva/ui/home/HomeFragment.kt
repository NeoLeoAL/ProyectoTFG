package com.ariasluque.agendainteractiva.ui.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ariasluque.agendainteractiva.controller.MyNotesRecyclerViewAdapter
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener
import com.ariasluque.agendainteractiva.models.Notes
import io.realm.Realm
import io.realm.RealmResults
import io.realm.kotlin.where

class HomeFragment : Fragment() {

    private var COLUMN_COUNT = 2

    private var mListener: OnNotesInteractionListener? = null // Listener de las notas

    private lateinit var realm: Realm
    private lateinit var notesBDList : RealmResults<Notes> // Listado de notas de BD

    // ------------------------ ON CREATE ------------------------ //

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)

        // Toma una instancia de Realm
        realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_list, container, false)

        // Lista de la BD con las notas
        notesBDList = realm.where<Notes>().findAll()

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                GridLayoutManager(context, COLUMN_COUNT)

                adapter =
                    MyNotesRecyclerViewAdapter(
                        notesBDList,
                        mListener
                    )
            }
        }

        return view
    }

    override fun onAttach(
        context: Context
    ) {
        super.onAttach(context)
        if (context is OnNotesInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }
    }

    override fun onDetach() {
        super.onDetach()
        mListener = null
    }
}
