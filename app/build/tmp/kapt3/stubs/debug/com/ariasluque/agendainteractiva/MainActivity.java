package com.ariasluque.agendainteractiva;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 1}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u008e\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\u0018\u0000 T2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u0006:\u0001TB\u0005\u00a2\u0006\u0002\u0010\u0007J\b\u0010\u001c\u001a\u00020\u001dH\u0002J\b\u0010\u001e\u001a\u00020\u001dH\u0002J\u0010\u0010\u001f\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\tH\u0002J\u0010\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020#H\u0002J\u0010\u0010$\u001a\u00020\u000e2\u0006\u0010%\u001a\u00020\tH\u0003J\u0010\u0010&\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\'\u001a\u00020\u000eH\u0002J\b\u0010(\u001a\u00020\u001dH\u0002J\b\u0010)\u001a\u00020\u001dH\u0002J\b\u0010*\u001a\u00020\u001dH\u0002J\u0010\u0010+\u001a\u00020\u001d2\u0006\u0010,\u001a\u00020\u000eH\u0002J\u0010\u0010-\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\tH\u0016J\b\u0010.\u001a\u00020\u001dH\u0016J\u0012\u0010/\u001a\u00020\u001d2\b\u00100\u001a\u0004\u0018\u000101H\u0014J\u0012\u00102\u001a\u00020#2\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00105\u001a\u00020\u001dH\u0016J\b\u00106\u001a\u00020\u001dH\u0002J\u0010\u00107\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u00108\u001a\u00020\u001dH\u0002J\u0010\u00109\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\tH\u0016J\u0010\u0010;\u001a\u00020#2\u0006\u0010<\u001a\u00020=H\u0016J-\u0010>\u001a\u00020\u001d2\u0006\u0010?\u001a\u00020\u000e2\u000e\u0010@\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u000b2\u0006\u0010A\u001a\u00020BH\u0016\u00a2\u0006\u0002\u0010CJ\u0010\u0010D\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0010\u0010E\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010F\u001a\u00020\u001dH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010:\u001a\u00020\tH\u0017J\u0010\u0010H\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010I\u001a\u00020\u001d2\u0006\u0010J\u001a\u00020KH\u0017J\b\u0010L\u001a\u00020\u001dH\u0016J \u0010M\u001a\u00020\u001d2\u0006\u0010N\u001a\u00020\t2\u0006\u0010O\u001a\u00020\u000e2\u0006\u0010P\u001a\u00020\u000eH\u0016J\u0010\u0010Q\u001a\u00020\u001d2\u0006\u0010R\u001a\u00020SH\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006U"}, d2 = {"Lcom/ariasluque/agendainteractiva/MainActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "Lcom/ariasluque/agendainteractiva/controller/OnNewNoteListener;", "Lcom/ariasluque/agendainteractiva/controller/OnNotesInteractionListener;", "Lcom/ariasluque/agendainteractiva/controller/OnNewTaskListener;", "Lcom/ariasluque/agendainteractiva/controller/OnTaskInteractionListener;", "Lcom/ariasluque/agendainteractiva/controller/OnPreferenceListener;", "()V", "CALENDAR_URL", "", "FIELDS", "", "[Ljava/lang/String;", "ID_CALENDAR", "", "REQUEST_CODE", "THEME_MODE_LIGHT", "THEME_MODE_NIGHT", "WRITE_CALENDAR", "WRITE_STORAGE_PERMISSION", "navView", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "note", "Lcom/ariasluque/agendainteractiva/models/Notes;", "realm", "Lio/realm/Realm;", "task", "Lcom/ariasluque/agendainteractiva/models/Task;", "addOrUpdateNote", "", "addOrUpdateTask", "changeLocale", "lang", "changeTheme", "theme", "", "checkPermission", "permission", "copyTask", "generateRandomId", "insertEvent", "loadPreference", "loadRealm", "noteIdPreference", "idNote", "onChangeLocale", "onChangeTheme", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateOptionsMenu", "menu", "Landroid/view/Menu;", "onHomeListener", "onInfoNoteFragment", "onNoteClick", "onNoteFragment", "onNoteListener", "title", "onOptionsItemSelected", "item", "Landroid/view/MenuItem;", "onRequestPermissionsResult", "requestCode", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onTaskClick", "onTaskDone", "onTaskFragment", "onTaskListener", "onUpdateNote", "onUpdatePaintNoteListener", "bitmap", "Landroid/graphics/Bitmap;", "onUpdateTask", "onUpdateTextNoteListener", "content", "textColor", "bgColor", "showCalendar", "timeMillis", "", "Companion", "app_debug"})
public final class MainActivity extends androidx.appcompat.app.AppCompatActivity implements com.ariasluque.agendainteractiva.controller.OnNewNoteListener, com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener, com.ariasluque.agendainteractiva.controller.OnNewTaskListener, com.ariasluque.agendainteractiva.controller.OnTaskInteractionListener, com.ariasluque.agendainteractiva.controller.OnPreferenceListener {
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
    
    @java.lang.Override()
    public void onNoteListener(@org.jetbrains.annotations.NotNull()
    java.lang.String title) {
    }
    
    @java.lang.Override()
    public void onUpdateNote(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Notes note) {
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
    public void onNoteClick(@org.jetbrains.annotations.NotNull()
    com.ariasluque.agendainteractiva.models.Notes note) {
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
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
    
    private final int generateRandomId() {
        return 0;
    }
    
    @androidx.annotation.RequiresApi(value = android.os.Build.VERSION_CODES.M)
    private final int checkPermission(java.lang.String permission) {
        return 0;
    }
    
    @java.lang.Override()
    public void onRequestPermissionsResult(int requestCode, @org.jetbrains.annotations.NotNull()
    java.lang.String[] permissions, @org.jetbrains.annotations.NotNull()
    int[] grantResults) {
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