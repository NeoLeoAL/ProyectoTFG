package com.ariasluque.agendainteractiva.models

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class Task : RealmObject {

    @PrimaryKey
    var idTask : Long = 0
    var titleTask : String = ""
    var creationDate : String = ""
    var taskDone : Boolean = false

    constructor()

    // Constructor de nota de texto
    constructor(idTask : Long, titleTask : String, creationDate : String,
                taskDone : Boolean){

        this.idTask = idTask
        this.titleTask = titleTask
        this.creationDate = creationDate
        this.taskDone = taskDone
    }
}