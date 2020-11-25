package com.ariasluque.agendainteractiva.ui.notes.paint

import android.graphics.*

class FingerPath(
    var color: Int, // Color
    var emboss: Boolean, // Relieve
    var blur: Boolean, // Difuminado
    var strokeWidth: Float, // Ancho del Trazo
    var path: Path // Ruta
)