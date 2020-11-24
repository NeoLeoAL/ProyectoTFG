package com.ariasluque.agendainteractiva.models;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0016\u0018\u00002\u00020\u0001B\u0007\b\u0016\u00a2\u0006\u0002\u0010\u0002B?\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0004\u0012\u0006\u0010\t\u001a\u00020\u0004\u0012\u0006\u0010\n\u001a\u00020\u0006\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u00a2\u0006\u0002\u0010\fR\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\n\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001e\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\t\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0015\"\u0004\b\u0019\u0010\u0017R\u001a\u0010\b\u001a\u00020\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0015\"\u0004\b\u001b\u0010\u0017R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u000f\"\u0004\b\u001d\u0010\u0011R\u001a\u0010\u000b\u001a\u00020\u0006X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u000f\"\u0004\b\u001f\u0010\u0011\u00a8\u0006 "}, d2 = {"Lcom/ariasluque/agendainteractiva/models/Notes;", "Lio/realm/RealmObject;", "()V", "idNote", "", "titleNote", "", "textNote", "textColor", "noteColor", "creationDate", "urlImage", "(ILjava/lang/String;Ljava/lang/String;IILjava/lang/String;Ljava/lang/String;)V", "contentNote", "getContentNote", "()Ljava/lang/String;", "setContentNote", "(Ljava/lang/String;)V", "getCreationDate", "setCreationDate", "getIdNote", "()I", "setIdNote", "(I)V", "getNoteColor", "setNoteColor", "getTextColor", "setTextColor", "getTitleNote", "setTitleNote", "getUrlImage", "setUrlImage", "app_debug"})
public class Notes extends io.realm.RealmObject {
    @io.realm.annotations.PrimaryKey()
    private int idNote = 0;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String titleNote = "";
    @org.jetbrains.annotations.Nullable()
    private java.lang.String contentNote = "";
    private int textColor = android.graphics.Color.BLACK;
    private int noteColor = android.graphics.Color.WHITE;
    @org.jetbrains.annotations.NotNull()
    private java.lang.String creationDate = "";
    @org.jetbrains.annotations.NotNull()
    private java.lang.String urlImage = "";
    
    public final int getIdNote() {
        return 0;
    }
    
    public final void setIdNote(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitleNote() {
        return null;
    }
    
    public final void setTitleNote(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getContentNote() {
        return null;
    }
    
    public final void setContentNote(@org.jetbrains.annotations.Nullable()
    java.lang.String p0) {
    }
    
    public final int getTextColor() {
        return 0;
    }
    
    public final void setTextColor(int p0) {
    }
    
    public final int getNoteColor() {
        return 0;
    }
    
    public final void setNoteColor(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCreationDate() {
        return null;
    }
    
    public final void setCreationDate(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUrlImage() {
        return null;
    }
    
    public final void setUrlImage(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    public Notes() {
        super();
    }
    
    public Notes(int idNote, @org.jetbrains.annotations.NotNull()
    java.lang.String titleNote, @org.jetbrains.annotations.NotNull()
    java.lang.String textNote, int textColor, int noteColor, @org.jetbrains.annotations.NotNull()
    java.lang.String creationDate, @org.jetbrains.annotations.NotNull()
    java.lang.String urlImage) {
        super();
    }
}