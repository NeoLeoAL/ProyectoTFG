package com.ariasluque.agendainteractiva

import android.Manifest
import android.annotation.SuppressLint
import android.content.*
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.database.Cursor
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.provider.CalendarContract
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.preference.PreferenceManager
import com.ariasluque.agendainteractiva.controller.*
import com.ariasluque.agendainteractiva.models.Notes
import com.ariasluque.agendainteractiva.models.Task
import com.google.android.material.bottomnavigation.BottomNavigationView
import io.realm.Realm
import io.realm.RealmConfiguration
import io.realm.kotlin.where
import java.io.File
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), OnNotesInteractionListener, OnTasksInteractionListener, OnPreferenceListener {

    // Instancia del MainActivity
    companion object {
        lateinit var instance : MainActivity
    }

    // Permisos
    private val REQUEST_CODE = 100
    private val WRITE_STORAGE_PERMISSION = Manifest.permission.WRITE_EXTERNAL_STORAGE
    private val WRITE_CALENDAR = Manifest.permission.WRITE_CALENDAR

    // Theme
    private val THEME_MODE_NIGHT = AppCompatDelegate.MODE_NIGHT_YES
    private val THEME_MODE_LIGHT = AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM

    // Calendario
    private val CALENDAR_URL = "content://com.android.calendar/events"
    private val ID_CALENDAR = 3

    // Campos a recuperar de lo eventos del calendario
    private val FIELDS = arrayOf(
        CalendarContract.Events._ID,
        CalendarContract.Events.TITLE
    )

    private lateinit var navView: BottomNavigationView // Barra de navegacion

    private lateinit var realm: Realm // Objeto Realm para la BD
    private lateinit var note: Notes // Objeto de la clase nota
    private lateinit var task: Task // Objeto de la clase task

    // ------------------------ ON CREATE ------------------------ //

    override fun onCreate(
        savedInstanceState: Bundle?
    ) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        instance = this // Guarda la instancia de la propia clase

        // NavigationController para el cambio de fragmento desde la barra de navegación
        navView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        navView.setupWithNavController(navController)

        // Añade el custom actionBar
        setSupportActionBar(findViewById(R.id.toolbar))

        loadRealm()
        loadPreference() // Carga las preferencias de la apliación
    }

    // ------------------------ REALM BD ------------------------ //

    private fun loadRealm(){
        // Inicializa Realm con la configuración de las clases
        Realm.init(this)
        val realmConfiguration = RealmConfiguration.Builder()
            .name("database.realm")
            .schemaVersion(1)
            .migration(CustomRealmMigration())
            .deleteRealmIfMigrationNeeded()
            .build()

        Realm.setDefaultConfiguration(realmConfiguration)

        // Toma una instancia de Realm
        realm = Realm.getDefaultInstance()

        /*
        // Borra toda la BD
        realm.executeTransaction { realm ->
            // Delete all matches
            realm.deleteAll()
            realm.where<Notes>().findAll().deleteAllFromRealm()
            realm.where<Task>().findAll().deleteAllFromRealm()
        }

        // Configura Realm para no tener que migrar la BD cada vez que esta cambie
        RealmConfiguration.Builder()
            .deleteRealmIfMigrationNeeded()
            .build()
         */
    }

    // Añade o actualiza la nota en la BD
    private fun addOrUpdateNote(){
        realm.beginTransaction()
            realm.insertOrUpdate(note)
        realm.commitTransaction()
    }

    // Añade o actualiza la task en la BD
    private fun addOrUpdateTask(){
        realm.beginTransaction()
            realm.insertOrUpdate(task)
        realm.commitTransaction()
    }

    // ------------------------ ACTION BAR ------------------------ //

    // Crea el menu de opciones del ActionBAR
    override fun onCreateOptionsMenu(
        menu: Menu?
    ): Boolean {
        menuInflater.inflate(R.menu.toolbar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    // Controla la selección del elemento del ActionBar
    override fun onOptionsItemSelected(
        item: MenuItem
    ) = when (item.itemId) {
        // Muestra el fragmentSettings para la configuración de la App
        R.id.action_settings -> {
            val navController = findNavController(R.id.nav_host_fragment)
            navController.navigate(R.id.navigation_settings)
            true
        }

        else -> {
            super.onOptionsItemSelected(item)
        }
    }

    // ------------------------ ON FRAGMENTS ------------------------ //

    // Cambia al fragmento principal
    override fun onHomeListener() {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigation_home)
    }

    // Cambia al fragmento de creación de notas
    private fun onNoteFragment(){
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigation_notes)
    }

    // Cambia al fragmento con la información de la nota
    private fun onInfoNoteFragment(){
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigation_infoFragmentNote)
    }

    // Cambia al fragmento de listado de Tasks
    override fun onTaskFragment() {
        val navController = findNavController(R.id.nav_host_fragment)
        navController.navigate(R.id.navigation_task)
    }

    // ------------------------ NOTE LISTENER ------------------------ //

    // Crea una primera nota con los datos básicos
    @SuppressLint("SimpleDateFormat")
    override fun onNoteListener(
        title: String
    ) {
        note = Notes()
        note.idNote = generateRandomId() // Id generado aleatoriamente
        note.titleNote = title
        note.creationDate = SimpleDateFormat("dd/MM/yyyy").format(Date()) // Fecha actual formateada

        addOrUpdateNote() // Añade la nota a la BD de Realm
    }

    // Actualiza el contenido de la nota cuando se le da a "Guardar"
    override fun onPassNote(
        idNote: Int
    ) {
        // Guarda en las preferencias de la App el id de la nota que luego se pasará al fragmento
        noteIdPreference(note.idNote)
        onNoteFragment() // Cambia al fragmento de notas
    }

    // Actualiza el contenido de la nota en formato texto en la BD
    override fun onUpdateTextNoteListener(
        content: String,
        textColor: Int,
        bgColor: Int
    ) {
        note.contentNote = content
        note.textColor = textColor
        note.noteColor = bgColor

        addOrUpdateNote()
    }

    // Guarda la imagen de las notas "dibujadas" y la actualiza en BD
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onUpdatePaintNoteListener(
        bitmap: Bitmap
    ) {
        // Comprueba si tiene permiso de escritura en el almacenamiento externo
        if (checkPermission(WRITE_STORAGE_PERMISSION) == PackageManager.PERMISSION_GRANTED) {
            val dirImages = ContextWrapper(this).getDir("Imagenes", Context.MODE_PRIVATE)
            val myPath = File(dirImages, note.titleNote + ".png")

            // Comprime el bitmap y lo guarda en un fichero en una carpeta de la App llamada "Imagenes"
            try{
                val fos = FileOutputStream(myPath)
                bitmap.compress(Bitmap.CompressFormat.PNG, 10, fos)
                fos.flush()

            }catch (ex: FileNotFoundException){
                ex.printStackTrace()
            }

            // Lo guarda en el almacenamiento externo (Galería de imagenes)
            MediaStore.Images.Media.insertImage(
                contentResolver, bitmap,
                note.titleNote, null
            )

            note.urlImage = myPath.absolutePath // Guarda la ruta de la imagen
            addOrUpdateNote() // Actualiza la nota para guardar la url
        }
    }

    // Permite visualizar el contenido de la nota a detalle
    override fun onNoteClick(
        idNote: Int
    ) {
        // Guarda en las preferencias de la App el id de la nota que luego se pasará al fragmento
        getNotePreferences(idNote)

        onInfoNoteFragment() // Cambia al fragmento de información de notas
    }

    // ------------------------ TASK LISTENER ------------------------ //

    // Crea la task con los datos básicos y el evento en el calendario
    @SuppressLint("SimpleDateFormat")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onTaskListener(
        title: String
    ) {
        task = Task()
        task.titleTask = title

        // Fecha actual formateada
        task.creationDate = SimpleDateFormat("dd/MM/yyyy").format(Date())

        // Permisos de escritura del calendario
        if (checkPermission(WRITE_CALENDAR) == PackageManager.PERMISSION_GRANTED)
            insertEvent() // Creación del evento en el calendario
    }

    // Crea un evento en el calendario con los datos de la task
    private fun insertEvent(){
        // Fecha y hora actual en milisegundos
        val timeMillis = Calendar.getInstance().run {
            timeInMillis
        }

        // Guarda los valores por defecto que tendrá la task
        val values = ContentValues().apply {
            put(CalendarContract.Events.DTSTART, timeMillis)
            put(CalendarContract.Events.DTEND, timeMillis)
            put(CalendarContract.Events.TITLE, task.titleTask)
            put(CalendarContract.Events.CALENDAR_ID, ID_CALENDAR)
            put(CalendarContract.Events.EVENT_TIMEZONE, Calendar.getInstance().timeZone.toString())
        }

        // Guarda el id del evento del calendario como el propio id de la task
        task.idTask = contentResolver.insert(CalendarContract.Events.CONTENT_URI, values)!!
                                     .lastPathSegment?.toLong()!!
        addOrUpdateTask()
        // Se muestra el calendario para que actualice el evento y sea posible localizarlo
        showCalendar(timeMillis)
    }

    // Abre el calendario por la fecha actual
    private fun showCalendar(timeMillis : Long){
        val builder: Uri.Builder = CalendarContract.CONTENT_URI.buildUpon()
            .appendPath("time")
        ContentUris.appendId(builder, timeMillis)
        val intent = Intent(Intent.ACTION_VIEW)
            .setData(builder.build())
        startActivity(intent)
    }

    // Abre el evento creado de la task en el calendario
    override fun onTaskClick(task: Task) {
        val uri: Uri = ContentUris.withAppendedId(CalendarContract.Events.CONTENT_URI, task.idTask)
        val intent = Intent(Intent.ACTION_VIEW).setData(uri)
        startActivity(intent)
    }

    // Actualiza el checkbox del task
    override fun onTaskDone(task: Task) {
        copyTask(task)
        this.task.taskDone = !task.taskDone
        addOrUpdateTask()

        Toast.makeText(this, resources.getString(R.string.task_done), Toast.LENGTH_LONG).show()
    }

    // Actualiza el titulo del task si ha sido actualizado en el calendario
    @SuppressLint("Recycle")
    override fun onUpdateTask(){
        val taskBDList = realm.where<Task>().findAll() // Recoge todos los registros de la BD

        // Si existen task las actualiza
        if(!taskBDList.isEmpty()){
            // Recoge los campos ID y TITTLE de todos los eventos del calendario
            val cursor: Cursor? = contentResolver.query(
                Uri.parse(CALENDAR_URL),
                FIELDS,null,
                null, null
            )

            // Recorre ambos registros actualizando los que coincidan
            while(cursor!!.moveToNext()){
                for(task : Task in taskBDList){
                    // Si encuentra la task la actualiza
                    if(task.idTask == cursor.getLong(0)){
                        copyTask(task)
                        this.task.titleTask = cursor.getString(1)

                        addOrUpdateTask()
                        break
                    }
                }
            }

            // Vuelve a "recargar" el fragmento para que se visualicen los datos actualizados
            onTaskFragment()
        }
    }

    // Crea una nueva task y copia los valores de la que se pasa por parametros
    private fun copyTask(task : Task){
        this.task = Task()
        this.task.idTask = task.idTask
        this.task.creationDate = task.creationDate
        this.task.taskDone = task.taskDone
        this.task.titleTask = task.titleTask
    }

    // ------------------------ SETTINGS LISTENER ------------------------ //

    // Guarda en preferencias el id de la nota
    private fun noteIdPreference(
        idNote : Int
    ){
        getNotePreferences(idNote)
    }

    // Cambia el idioma de la App
    override fun onChangeLocale(
        lang: String
    ) {
        changeLocale(lang)
    }

    // Cambia la configuración del idioma por defecto
    private fun changeLocale(
        lang: String
    ){
        val res = baseContext.resources
        val config = Configuration(res?.configuration)

        val loc = Locale(lang)
        Locale.setDefault(loc)

        config.locale = loc
        res?.updateConfiguration(config, res.displayMetrics)

        // Cambia el idioma del titulo del actionBar
        supportActionBar?.title = resources.getString(R.string.app_name)

        // Cambia el idioma del menú de navegación
        navView.menu.findItem(R.id.navigation_task).title = resources.getString(R.string.title_task)
        navView.menu.findItem(R.id.navigation_home).title = resources.getString(R.string.title_home)
        navView.menu.findItem(R.id.navigation_notes).title = resources.getString(R.string.title_notes)

        // Vuelve al fragment "Home" para mostrar los cambios
        onHomeListener()
    }

    // Cambia el tema de la App
    override fun onChangeTheme() {
        val theme : Boolean = this.resources.configuration.uiMode and Configuration.UI_MODE_NIGHT_MASK == Configuration.UI_MODE_NIGHT_NO
        changeTheme(theme)
    }

    // Cambia los estilos
    private fun changeTheme(
        theme: Boolean
    ){
        when(theme){
            true -> AppCompatDelegate.setDefaultNightMode(THEME_MODE_NIGHT)
            false -> AppCompatDelegate.setDefaultNightMode(THEME_MODE_LIGHT)
        }
    }

    // Carga las preferencias en la configuración de la App
    private fun loadPreference(){
        // Establece las preferencias de idioma y estilos
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)

        val lang = sharedPreferences.getString("language_preference", "en")
        changeLocale(lang!!)

        val theme = sharedPreferences.getBoolean("theme_preference", false)
        changeTheme(theme)

        // Establece el parametro a pasar "idNote" en 0
        noteIdPreference(0)
    }

    private fun getNotePreferences(idNote : Int){
        getSharedPreferences(getString(R.string.file_settings), Context.MODE_PRIVATE)
            .edit()
            .putInt("idNote", idNote)
            .apply()
    }

    // ------------------------ UTILS ------------------------ //

    private fun generateRandomId() : Int {
        var available = false
        var number = 0

        // Genera un id aleatorio mientras exista
        while(!available){
            val random = Random()

            fun rand(from: Int = 1, to: Int = 1000000) : Int {
                return random.nextInt(to - from) + from
            }

            number = rand()

            realm = Realm.getDefaultInstance()

            // Comprueba si existe ese id en la BD
            val result = realm.where<Notes>()
                .equalTo("idNote", number)
                .findFirst()

            if(result == null) available = true
        }

        return number
    }

    // ------------------------ PERMISOS ------------------------ //

    // Comprueba los permisos que se le pasan como parametro
    @RequiresApi(Build.VERSION_CODES.M)
    private fun checkPermission(
        permission : String
    ) : Int{
        val hasPermission = checkSelfPermission(permission)

        // En caso de no tener permisos los solicita
        if (hasPermission != PackageManager.PERMISSION_GRANTED) {
            requestPermissions(arrayOf(permission), REQUEST_CODE)
        }

        return hasPermission
    }

    // Pide los permisos necesarios
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (REQUEST_CODE == requestCode) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                return
            } else {
                Toast.makeText(
                    this,
                    getString(R.string.permissions_not_granted) + Build.VERSION.SDK_INT,
                    Toast.LENGTH_LONG
                ).show()
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        }
    }
}
