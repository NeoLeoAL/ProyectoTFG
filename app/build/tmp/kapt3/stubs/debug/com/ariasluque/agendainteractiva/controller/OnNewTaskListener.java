package com.ariasluque.agendainteractiva.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0010\u0010\u0005\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&J\b\u0010\b\u001a\u00020\u0003H&\u00a8\u0006\t"}, d2 = {"Lcom/ariasluque/agendainteractiva/controller/OnNewTaskListener;", "", "onHomeListener", "", "onTaskFragment", "onTaskListener", "task", "", "onUpdateTask", "app_debug"})
public abstract interface OnNewTaskListener {
    
    public abstract void onHomeListener();
    
    public abstract void onTaskFragment();
    
    public abstract void onUpdateTask();
    
    public abstract void onTaskListener(@org.jetbrains.annotations.NotNull()
    java.lang.String task);
}