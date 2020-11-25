package com.ariasluque.agendainteractiva.controller

import com.ariasluque.agendainteractiva.models.Task

interface OnTasksInteractionListener {
    fun onHomeListener()
    fun onTaskFragment()
    fun onUpdateTask()
    fun onTaskListener(title : String)
    fun onTaskClick(task : Task)
    fun onTaskDone(task : Task)
}