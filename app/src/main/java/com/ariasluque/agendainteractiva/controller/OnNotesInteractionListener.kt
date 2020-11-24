package com.ariasluque.agendainteractiva.controller

import android.graphics.Bitmap
import com.ariasluque.agendainteractiva.models.Notes

interface OnNotesInteractionListener {
    fun onHomeListener()
    fun onNoteListener(content : String)
    fun onUpdateNote(note : Notes)
    fun onUpdatePaintNoteListener(bitmap: Bitmap)
    fun onUpdateTextNoteListener(content: String, textColor: Int, bgColor: Int)
    fun onNoteClick(note : Notes)
}