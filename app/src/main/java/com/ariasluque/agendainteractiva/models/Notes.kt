package com.ariasluque.agendainteractiva.models

import android.graphics.Color
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Notes : RealmObject {

    @PrimaryKey
    var idNote : Int = 0
    var titleNote : String = ""
    var contentNote : String? = ""
    var textColor : Int = Color.BLACK
    var noteColor : Int = Color.WHITE
    var creationDate : String = ""
    var urlImage : String = ""

    constructor()

    // Constructor de nota de texto
    constructor(
        idNote : Int,
        titleNote : String,
        textNote : String,
        textColor : Int,
        noteColor : Int,
        creationDate : String,
        urlImage : String
    ){
        this.idNote = idNote
        this.titleNote = titleNote
        this.contentNote = textNote
        this.textColor = textColor
        this.noteColor = noteColor
        this.creationDate = creationDate
        this.urlImage = urlImage
    }
}