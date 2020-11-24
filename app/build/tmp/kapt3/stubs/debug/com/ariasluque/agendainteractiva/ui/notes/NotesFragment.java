package com.ariasluque.agendainteractiva.ui.notes;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u009e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B\u0005\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u000bH\u0002J\b\u0010*\u001a\u00020(H\u0002J\b\u0010+\u001a\u00020(H\u0002J\b\u0010,\u001a\u00020(H\u0002J\b\u0010-\u001a\u00020(H\u0002J\b\u0010.\u001a\u00020(H\u0002J\b\u0010/\u001a\u00020(H\u0002J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u000202H\u0016J\u0018\u00103\u001a\u00020(2\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0016J&\u00108\u001a\u0004\u0018\u00010\"2\u0006\u00106\u001a\u0002092\b\u0010:\u001a\u0004\u0018\u00010;2\b\u0010<\u001a\u0004\u0018\u00010=H\u0016J\u0010\u0010>\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0016J\u0010\u0010A\u001a\u00020\u00132\u0006\u0010?\u001a\u00020@H\u0016J\b\u0010B\u001a\u00020(H\u0002J\b\u0010C\u001a\u00020(H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082.\u00a2\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\"X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006D"}, d2 = {"Lcom/ariasluque/agendainteractiva/ui/notes/NotesFragment;", "Landroidx/fragment/app/Fragment;", "Lcom/google/android/material/navigation/NavigationView$OnNavigationItemSelectedListener;", "Lcom/google/android/material/bottomnavigation/BottomNavigationView$OnNavigationItemSelectedListener;", "()V", "btnNoteColor", "Lcom/google/android/material/floatingactionbutton/FloatingActionButton;", "btnTextColorOrEraser", "btnTextOrBrush", "btnTools", "currentBgColor", "", "currentColor", "editText", "Landroid/widget/EditText;", "fabCloseAnim", "Landroid/view/animation/Animation;", "fabOpenAnim", "isColor", "", "isNote", "isOpen", "isText", "mListener", "Lcom/ariasluque/agendainteractiva/controller/OnNewNoteListener;", "navColor", "Lcom/google/android/material/navigation/NavigationView;", "newNoteDialog", "Lcom/ariasluque/agendainteractiva/ui/notes/dialog/NewNoteDialog;", "note", "Lcom/ariasluque/agendainteractiva/models/Notes;", "paintContainer", "Lcom/ariasluque/agendainteractiva/ui/notes/paint/PaintView;", "paintView", "Landroid/view/View;", "realm", "Lio/realm/Realm;", "root", "textView", "changeColor", "", "color", "changeColorNotes", "changeModeTextColorOrErase", "changeModeTextOrBrush", "changeVisibilityNavColor", "clearContainers", "init", "onAttach", "context", "Landroid/content/Context;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "inflater", "Landroid/view/MenuInflater;", "onCreateView", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onNavigationItemSelected", "item", "Landroid/view/MenuItem;", "onOptionsItemSelected", "showBtnTools", "showTools", "app_debug"})
public final class NotesFragment extends androidx.fragment.app.Fragment implements com.google.android.material.navigation.NavigationView.OnNavigationItemSelectedListener, com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener {
    private android.view.View root;
    private int currentColor = android.graphics.Color.BLACK;
    private int currentBgColor = android.graphics.Color.WHITE;
    private com.ariasluque.agendainteractiva.controller.OnNewNoteListener mListener;
    private com.ariasluque.agendainteractiva.ui.notes.dialog.NewNoteDialog newNoteDialog;
    private com.google.android.material.floatingactionbutton.FloatingActionButton btnTools;
    private com.google.android.material.floatingactionbutton.FloatingActionButton btnTextOrBrush;
    private com.google.android.material.floatingactionbutton.FloatingActionButton btnTextColorOrEraser;
    private com.google.android.material.floatingactionbutton.FloatingActionButton btnNoteColor;
    private com.google.android.material.navigation.NavigationView navColor;
    private android.view.View paintView;
    private com.ariasluque.agendainteractiva.ui.notes.paint.PaintView paintContainer;
    private android.view.View textView;
    private android.widget.EditText editText;
    private boolean isOpen = false;
    private boolean isText = true;
    private boolean isColor = false;
    private boolean isNote = true;
    private android.view.animation.Animation fabOpenAnim;
    private android.view.animation.Animation fabCloseAnim;
    private io.realm.Realm realm;
    private com.ariasluque.agendainteractiva.models.Notes note;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.Nullable()
    @java.lang.Override()
    public android.view.View onCreateView(@org.jetbrains.annotations.NotNull()
    android.view.LayoutInflater inflater, @org.jetbrains.annotations.Nullable()
    android.view.ViewGroup container, @org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
        return null;
    }
    
    @java.lang.Override()
    public void onCreateOptionsMenu(@org.jetbrains.annotations.NotNull()
    android.view.Menu menu, @org.jetbrains.annotations.NotNull()
    android.view.MenuInflater inflater) {
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onAttach(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
    
    private final void init() {
    }
    
    private final void showTools() {
    }
    
    private final void showBtnTools() {
    }
    
    private final void changeModeTextOrBrush() {
    }
    
    private final void clearContainers() {
    }
    
    private final void changeModeTextColorOrErase() {
    }
    
    private final void changeColorNotes() {
    }
    
    private final void changeVisibilityNavColor() {
    }
    
    @java.lang.Override()
    public boolean onNavigationItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    private final void changeColor(int color) {
    }
    
    public NotesFragment() {
        super();
    }
}