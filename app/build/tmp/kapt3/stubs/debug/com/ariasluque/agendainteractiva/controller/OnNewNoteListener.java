package com.ariasluque.agendainteractiva.controller;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&J\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\rH&J \u0010\u000e\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H&\u00a8\u0006\u0012"}, d2 = {"Lcom/ariasluque/agendainteractiva/controller/OnNewNoteListener;", "", "onHomeListener", "", "onNoteClick", "note", "Lcom/ariasluque/agendainteractiva/models/Notes;", "onNoteListener", "content", "", "onUpdateNote", "onUpdatePaintNoteListener", "bitmap", "Landroid/graphics/Bitmap;", "onUpdateTextNoteListener", "textColor", "", "bgColor", "app_debug"})
public abstract interface OnNewNoteListener {
    
    public abstract void onHomeListener();
    
    public abstract void onNoteListener(@org.jetbrains.annotations.NotNull()
    java.lang.String content);
    
    public abstract void onUpdateNote(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Notes note);
    
    public abstract void onUpdatePaintNoteListener(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap);
    
    public abstract void onUpdateTextNoteListener(@org.jetbrains.annotations.NotNull()
    java.lang.String content, int textColor, int bgColor);
    
    public abstract void onNoteClick(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Notes note);
}