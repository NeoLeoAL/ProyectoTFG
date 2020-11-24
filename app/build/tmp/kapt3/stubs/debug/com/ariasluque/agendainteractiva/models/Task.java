package com.ariasluque.agendainteractiva.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B\'\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u00a2\u0006\u0002\u0010\nR\u001a\u0010\u0007\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/ariasluque/agendainteractiva/models/Task;", "Lio/realm/RealmObject;", "()V", "idTask", "", "titleTask", "", "creationDate", "taskDone", "", "(JLjava/lang/String;Ljava/lang/String;Z)V", "getCreationDate", "()Ljava/lang/String;", "setCreationDate", "(Ljava/lang/String;)V", "getIdTask", "()J", "setIdTask", "(J)V", "getTaskDone", "()Z", "setTaskDone", "(Z)V", "getTitleTask", "setTitleTask", "app_debug"})
public class Task extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey()
    private long idTask = 0L;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String titleTask = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String creationDate = "";
    private boolean taskDone = false;
    
    public final long getIdTask() {
        return 0L;
    }
    
    public final void setIdTask(long p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitleTask() {
        return null;
    }
    
    public final void setTitleTask(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreationDate() {
        return null;
    }
    
    public final void setCreationDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public final boolean getTaskDone() {
        return false;
    }
    
    public final void setTaskDone(boolean p0) {
    }
    
    public Task() {
        super();
    }
    
    public Task(long idTask, @org.jetbrains.annotations.NotNull()
    java.lang.String titleTask, @org.jetbrains.annotations.NotNull()
    java.lang.String creationDate, boolean taskDone) {
        super();
    }
}