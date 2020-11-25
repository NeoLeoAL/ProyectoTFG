package com.ariasluque.agendainteractiva.controller

import android.graphics.Bitmap
import com.ariasluque.agendainteractiva.models.Notes

interface OnNotesInteractionListener {
    fun onHomeListener()
    fun onNoteListener(title : String)
    fun onPassNote(idNote : Int)
    fun onUpdatePaintNoteListener(bitmap: Bitmap)
    fun onUpdateTextNoteListener(content: String, textColor: Int, bgColor: Int)
    fun onNoteClick(idNote : Int)
}