package com.ariasluque.agendainteractiva;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 M2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001MB\u0005\u00a2\u0006\u0002\u0010\u0005J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u001bH\u0002J\u0010\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0002J\u0010\u0010\u001f\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!H\u0002J\u0010\u0010\"\u001a\u00020\f2\u0006\u0010#\u001a\u00020\u0007H\u0003J\u0010\u0010$\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010%\u001a\u00020\fH\u0002J\u0010\u0010&\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\fH\u0002J\b\u0010(\u001a\u00020\u001bH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\b\u0010*\u001a\u00020\u001bH\u0002J\u0010\u0010+\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\fH\u0002J\u0010\u0010,\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u0007H\u0016J\b\u0010-\u001a\u00020\u001bH\u0016J\u0012\u0010.\u001a\u00020\u001b2\b\u0010/\u001a\u0004\u0018\u000100H\u0015J\u0012\u00101\u001a\u00020!2\b\u00102\u001a\u0004\u0018\u000103H\u0016J\b\u00104\u001a\u00020\u001bH\u0016J\b\u00105\u001a\u00020\u001bH\u0002J\u0010\u00106\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\fH\u0016J\b\u00107\u001a\u00020\u001bH\u0002J\u0010\u00108\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0007H\u0017J\u0010\u0010:\u001a\u00020!2\u0006\u0010;\u001a\u00020<H\u0016J\u0010\u0010=\u001a\u00020\u001b2\u0006\u0010\'\u001a\u00020\fH\u0016J\u0010\u0010>\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010?\u001a\u00020\u001b2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\b\u0010@\u001a\u00020\u001bH\u0016J\u0010\u0010A\u001a\u00020\u001b2\u0006\u00109\u001a\u00020\u0007H\u0017J\u0010\u0010B\u001a\u00020\u001b2\u0006\u0010C\u001a\u00020DH\u0017J\b\u0010E\u001a\u00020\u001bH\u0017J \u0010F\u001a\u00020\u001b2\u0006\u0010G\u001a\u00020\u00072\u0006\u0010H\u001a\u00020\f2\u0006\u0010I\u001a\u00020\fH\u0016J\u0010\u0010J\u001a\u00020\u001b2\u0006\u0010K\u001a\u00020LH\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\tX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\fX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0007X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006N"}, d2 = {"Lcom/ariasluque/agendainteractiva/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ariasluque/agendainteractiva/controller/OnNotesInteractionListener;", "Lcom/ariasluque/agendainteractiva/controller/OnTasksInteractionListener;", "Lcom/ariasluque/agendainteractiva/controller/OnPreferenceListener;", "()V", "CALENDAR_URL", "", "FIELDS", "", "[Ljava/lang/String;", "ID_CALENDAR", "", "REQUEST_CODE", "THEME_MODE_LIGHT", "THEME_MODE_NIGHT", "WRITE_CALENDAR", "WRITE_STORAGE_PERMISSION", "navView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "note", "Lcom/ariasluque/agendainteractiva/models/Notes;", "realm", "Lio/realm/Realm;", "task", "Lcom/ariasluque/agendainteractiva/models/Task;", "addOrUpdateNote", "", "addOrUpdateTask", "changeLocale", "lang", "changeTheme", "theme", "", "checkPermission", "permission", "copyTask", "generateRandomId", "getNotePreferences", "idNote", "insertEvent", "loadPreference", "loadRealm", "noteIdPreference", "onChangeLocale", "onChangeTheme", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onHomeListener", "onInfoNoteFragment", "onNoteClick", "onNoteFragment", "onNoteListener", "title", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onPassNote", "onTaskClick", "onTaskDone", "onTaskFragment", "onTaskListener", "onUpdatePaintNoteListener", "bitmap", "Landroid/graphics/Bitmap;", "onUpdateTask", "onUpdateTextNoteListener", "content", "textColor", "bgColor", "showCalendar", "timeMillis", "", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener, com.ariasluque.agendainteractiva.controller.OnTasksInteractionListener, com.ariasluque.agendainteractiva.controller.OnPreferenceListener {
    private final int REQUEST_CODE = 100;
    private final java.lang.String WRITE_STORAGE_PERMISSION = "android.permission.WRITE_EXTERNAL_STORAGE";
    private final java.lang.String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    private final int THEME_MODE_NIGHT = androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES;
    private final int THEME_MODE_LIGHT = androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM;
    private final java.lang.String CALENDAR_URL = "content://com.android.calendar/events";
    private final int ID_CALENDAR = 3;
    private final java.lang.String[] FIELDS = {"_id", "title"};
    private com.google.android.material.bottomnavigation.BottomNavigationView navView;
    private io.realm.Realm realm;
    private com.ariasluque.agendainteractiva.models.Notes note;
    private com.ariasluque.agendainteractiva.models.Task task;
    public static com.ariasluque.agendainteractiva.MainActivity instance;
    @org.jetbrains.annotations.NotNull()
    public static final com.ariasluque.agendainteractiva.MainActivity.Companion Companion = null;
    private java.util.HashMap _$_findViewCache;
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void loadRealm() {
    }
    
    private final void addOrUpdateNote() {
    }
    
    private final void addOrUpdateTask() {
    }
    
    @java.lang.Override()
    public boolean onCreateOptionsMenu(@org.jetbrains.annotations.Nullable()
    android.view.Menu menu) {
        return false;
    }
    
    @java.lang.Override()
    public boolean onOptionsItemSelected(@org.jetbrains.annotations.NotNull()
    android.view.MenuItem item) {
        return false;
    }
    
    @java.lang.Override()
    public void onHomeListener() {
    }
    
    private final void onNoteFragment() {
    }
    
    private final void onInfoNoteFragment() {
    }
    
    @java.lang.Override()
    public void onTaskFragment() {
    }
    
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onNoteListener(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void onPassNote(int idNote) {
    }
    
    @java.lang.Override()
    public void onUpdateTextNoteListener(@org.jetbrains.annotations.NotNull()
    java.lang.String content, int textColor, int bgColor) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onUpdatePaintNoteListener(@org.jetbrains.annotations.NotNull()
    android.graphics.Bitmap bitmap) {
    }
    
    @java.lang.Override()
    public void onNoteClick(int idNote) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @android.annotation.SuppressLint(value = {"SimpleDateFormat"})
    @java.lang.Override()
    public void onTaskListener(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    private final void insertEvent() {
    }
    
    private final void showCalendar(long timeMillis) {
    }
    
    @java.lang.Override()
    public void onTaskClick(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Task task) {
    }
    
    @java.lang.Override()
    public void onTaskDone(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Task task) {
    }
    
    @android.annotation.SuppressLint(value = {"Recycle"})
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    @java.lang.Override()
    public void onUpdateTask() {
    }
    
    private final void copyTask(com.ariasluque.agendainteractiva.models.Task task) {
    }
    
    private final void noteIdPreference(int idNote) {
    }
    
    @java.lang.Override()
    public void onChangeLocale(@org.jetbrains.annotations.NotNull()
    java.lang.String lang) {
    }
    
    private final void changeLocale(java.lang.String lang) {
    }
    
    @java.lang.Override()
    public void onChangeTheme() {
    }
    
    private final void changeTheme(boolean theme) {
    }
    
    private final void loadPreference() {
    }
    
    private final void getNotePreferences(int idNote) {
    }
    
    private final int generateRandomId() {
        return 0;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final int checkPermission(java.lang.String permission) {
        return 0;
    }
    
    public MainActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/ariasluque/agendainteractiva/MainActivity$Companion;", "", "()V", "instance", "Lcom/ariasluque/agendainteractiva/MainActivity;", "getInstance", "()Lcom/ariasluque/agendainteractiva/MainActivity;", "setInstance", "(Lcom/ariasluque/agendainteractiva/MainActivity;)V", "app_debug"})
    public static final class Companion {
        
        @org.jetbrains.annotations.NotNull()
        public final com.ariasluque.agendainteractiva.MainActivity getInstance() {
            return null;
        }
        
        public final void setInstance(@org.jetbrains.annotations.NotNull()
        com.ariasluque.agendainteractiva.MainActivity p0) {
        }
        
        private Companion() {
            super();
        }
    }
}