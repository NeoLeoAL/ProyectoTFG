package com.ariasluque.agendainteractiva.ui.notes

import android.app.AlertDialog
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.*
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ariasluque.agendainteractiva.R
import com.ariasluque.agendainteractiva.controller.OnNotesInteractionListener
import com.ariasluque.agendainteractiva.models.Notes
import com.ariasluque.agendainteractiva.ui.notes.dialog.NewNoteDialog
import com.ariasluque.agendainteractiva.ui.notes.paint.PaintView
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import io.realm.Realm
import io.realm.kotlin.where
import java.io.FileInputStream
import java.io.IOException


class NotesFragment : Fragment(), NavigationView.OnNavigationItemSelectedListener, BottomNavigationView.OnNavigationItemSelectedListener {

    private lateinit var root : View

    private val DEF_ID_NOTE_PREFERENCE = 0

    // Colores por defecto
    private var currentColor : Int = Color.BLACK
    private var currentBgColor : Int = Color.WHITE

    private lateinit var mInteractionListener : OnNotesInteractionListener // Listener para pasar los datos al activity
    private lateinit var newNoteDialog: NewNoteDialog // Dialogo de la primera nota

    private lateinit var btnTools : FloatingActionButton // Muestra el resto de botones
    private lateinit var btnTextOrBrush : FloatingActionButton // Cambia entre texto y dibujo
    private lateinit var btnTextColorOrEraser : FloatingActionButton // Cambia entre color de texto y goma de borrar
    private lateinit var btnNoteColor : FloatingActionButton // Muestra los colores de las notas
    private lateinit var navColor : NavigationView // Barra de navegación de colores

    // Fragment Layout
    private lateinit var paintView: View
    private lateinit var paintContainer : PaintView
    private lateinit var textView: View
    private lateinit var editText: EditText

    private var isOpen = false // Controla si esta mostrando o no el resto de btn
    private var isText = true // Controla si es el modo de texto o dibujo
    private var isColor = false // Controla se se muestra la barra de colores
    private var isNote = true // Controla si es el color del texto o de la nota

    // Animaciones de los botones
    private lateinit var fabOpenAnim : Animation
    private lateinit var fabCloseAnim : Animation

    private var note : Notes? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View {
        root = inflater.inflate(R.layout.fragment_notes, container, false)
        getLayoutItems()

        val idNote = getNoteIdPreference()

        // Si se está pasando una nota se recoge de la BD
        if(idNote != 0){
            // Busca la note con el id que se le ha pasado
            note = Realm.getDefaultInstance().where<Notes>().equalTo("idNote", idNote).findFirst()!!
            setNoteIdPreference()
        }

        init()
        setHasOptionsMenu(true)

        return root
    }

    // Coge la referencia a los elementos del layout
    private fun getLayoutItems(){
        // Botones flotantes
        btnTools = root.findViewById(R.id.floatingActionButton_tools)
        btnTextOrBrush = root.findViewById(R.id.floatingActionButton_text_or_brush)
        btnTextColorOrEraser = root.findViewById(R.id.floatingActionButton_text_color_or_eraser)
        btnNoteColor = root.findViewById(R.id.floatingActionButton_note_color)

        // NavigationView Color
        navColor = root.findViewById(R.id.nav_color)

        // Fragment Layout
        paintView = root.findViewById(R.id.paint_panel)
        paintContainer = root.findViewById(R.id.paintContainer)
        textView = root.findViewById(R.id.write_panel)
        editText = root.findViewById(R.id.editText)
    }

    // ------------------------ PREFERENCIAS ------------------------ //

    // Recibe el id del note desde las preferencias
    private fun getNoteIdPreference(): Int{
        return requireActivity().getSharedPreferences(getString(R.string.file_settings), Context.MODE_PRIVATE)
            .getInt("idNote", DEF_ID_NOTE_PREFERENCE)
    }

    // Cambia el id y lo pone a 0 por defecto en las preferencias
    private fun setNoteIdPreference(){
        requireActivity().getSharedPreferences(getString(R.string.file_settings), Context.MODE_PRIVATE)
            .edit()
            .putInt("idNote", DEF_ID_NOTE_PREFERENCE)
            .apply()
    }

    // ------------------------ INIT ------------------------ //

    // Recoge los elementos del layout
    private fun init(){
        // PaintView
        val metrics = DisplayMetrics()
        requireActivity().windowManager.defaultDisplay.getMetrics(metrics)
        paintContainer.init(metrics)

        // Quita el color de los iconos de la barra de colores
        navColor.itemIconTintList = null

        // Listener de los NavigationView
        navColor.setNavigationItemSelectedListener(this)

        // Listener de los btns
        showTools()
        changeModeTextOrBrush()
        changeModeTextColorOrErase()
        changeColorNotes()

        // Si se va a editar una nota se pega el contenido
        if(note != null){
            if(note!!.urlImage == ""){
                editText.setText(note!!.contentNote, TextView.BufferType.EDITABLE)
                editText.setTextColor(note!!.textColor)
                editText.setBackgroundColor(note!!.noteColor)

            }else{
                btnTextOrBrush.setImageResource(R.drawable.ic_title_white_24dp)
                btnTextColorOrEraser.setImageResource(R.drawable.ic_borrar_white_24dp)
                btnNoteColor.setImageResource(R.drawable.ic_palette_white_24dp)

                paintView.visibility = View.VISIBLE
                textView.visibility = View.GONE

                isText = false

                // TODO Arreglar Editar
                var bitmap: Bitmap? = null

                try {
                    val fileInputStream = FileInputStream(note!!.urlImage)
                    bitmap = BitmapFactory.decodeStream(fileInputStream)
                } catch (io: IOException) {
                    io.printStackTrace()
                }

                paintContainer.mBitmap = bitmap!!
            }

        }else{
            // Muestra el dialogo para crear una primera nota
            newNoteDialog = NewNoteDialog()
            newNoteDialog.show(requireFragmentManager(), resources.getString(R.string.new_note))
        }
    }

    // ------------------------ ACTION BAR ------------------------ //

    // Crea el menu de opciones del ActionBAR
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.toolbar_menu_notes, menu)

        // Quita la opción de editar del menú
        menu.removeItem(R.id.edit_note_tool)
    }

    override fun onOptionsItemSelected(item: MenuItem) = when (item.itemId) {

        R.id.new_note_tool -> {
            // Crea una ventana de dialogo
            val deleteDialog: AlertDialog.Builder = AlertDialog.Builder(activity)

            deleteDialog.setTitle(resources.getString(R.string.new_note))
                .setMessage(resources.getString(R.string.message_delete_current_note))
                .setPositiveButton(resources.getString(R.string.positive_yes)) { dialog, which ->
                    // Borra el contenido y abre el dialogo para añadir
                    clearContainers()
                    val toast = Toast.makeText(
                        activity,
                        resources.getString(R.string.removed_note),
                        Toast.LENGTH_SHORT
                    )
                    toast.show()

                    // Muestra el dialogo para crear una primera nota
                    newNoteDialog = NewNoteDialog()
                    newNoteDialog.show(
                        requireFragmentManager(),
                        resources.getString(R.string.new_note)
                    )
                }
                .setNegativeButton(resources.getString(R.string.negative_no)) { dialog, which ->
                    dialog.cancel()
                }

            deleteDialog.show()
            true
        }

        R.id.delete_note_tool -> {
            // Crea una ventana de dialogo
            val deleteDialog: AlertDialog.Builder = AlertDialog.Builder(activity)

            deleteDialog.setTitle(resources.getString(R.string.title_delete_notes))
                .setMessage(resources.getString(R.string.message_delete_notes))
                .setPositiveButton(resources.getString(R.string.positive_yes)) { dialog, which ->
                    // Borra el contenido y abre el dialogo para añadir
                    clearContainers()
                    val toast = Toast.makeText(
                        activity,
                        resources.getString(R.string.removed_notes),
                        Toast.LENGTH_SHORT
                    )
                    toast.show()
                }
                .setNegativeButton(resources.getString(R.string.negative_no)) { dialog, which ->
                    dialog.cancel()
                }

            deleteDialog.show()
            true
        }

        R.id.save_note_tool -> {
            paintContainer.isDrawingCacheEnabled = true // Permite guardar el bitmap

            // Guarda el texto
            if (isText) mInteractionListener.onUpdateTextNoteListener(
                editText.text.toString(),
                currentColor,
                currentBgColor
            )
            // Guarda la imagen en el almacenamiento
            else mInteractionListener.onUpdatePaintNoteListener(paintContainer.mBitmap)

            paintContainer.destroyDrawingCache()

            val toast = Toast.makeText(
                activity,
                resources.getString(R.string.saved_note),
                Toast.LENGTH_SHORT
            )
            toast.show()
            true
        }

        else -> {
            // If we got here, the user's action was not recognized.
            // Invoke the superclass to handle it.
            super.onOptionsItemSelected(item)
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)

        try {
            mInteractionListener = context as OnNotesInteractionListener

        } catch (e: ClassCastException) {
            throw ClassCastException(("$context must implement DialogListener"))
        }
    }



    // Muestra u oculta las herramientas de edición
    private fun showTools() {
        // Comprueba si se ha pulsado o no el btn
        btnTools.setOnClickListener{
            showBtnTools()
        }
    }

    private fun showBtnTools(){
        // Animaciones
        fabOpenAnim = AnimationUtils.loadAnimation(activity, R.anim.fab_open)
        fabCloseAnim = AnimationUtils.loadAnimation(activity, R.anim.fab_close)

        // Vuelve visible los botones
        if (!isOpen){
            btnTextOrBrush.animation = fabOpenAnim
            btnTextColorOrEraser.animation = fabOpenAnim
            btnNoteColor.animation = fabOpenAnim

            btnTextOrBrush.visibility = View.VISIBLE
            btnTextColorOrEraser.visibility = View.VISIBLE
            btnNoteColor.visibility = View.VISIBLE

            isOpen = true

            // Vuelve invisible los botones
        } else {
            btnTextOrBrush.animation = fabCloseAnim
            btnTextColorOrEraser.animation = fabCloseAnim
            btnNoteColor.animation = fabCloseAnim

            btnTextOrBrush.visibility = View.GONE
            btnTextColorOrEraser.visibility = View.GONE
            btnNoteColor.visibility = View.GONE

            isOpen = false
        }
    }

    // Cambia de modo texto a modo dibujo
    private fun changeModeTextOrBrush(){
        btnTextOrBrush.setOnClickListener{
            clearContainers() // Limpia el contenido de los paneles

            // Cambia al modo dibujo
            if(isText){
                // Cambia la imagen del btn
                btnTextOrBrush.setImageResource(R.drawable.ic_title_white_24dp)
                btnTextColorOrEraser.setImageResource(R.drawable.ic_borrar_white_24dp)
                btnNoteColor.setImageResource(R.drawable.ic_palette_white_24dp)

                paintView.visibility = View.VISIBLE
                textView.visibility = View.GONE

                isText = false

                // Cambia al modo texto
            }else{
                // Cambia la imagen del btn
                btnTextOrBrush.setImageResource(R.drawable.ic_mode_edit_white_24dp)
                btnTextColorOrEraser.setImageResource(R.drawable.ic_palette_white_24dp)
                btnNoteColor.setImageResource(R.drawable.ic_note_white_24dp)

                paintView.visibility = View.GONE
                textView.visibility = View.VISIBLE

                isText = true
            }

            showBtnTools()
        }
    }

    // Inicia los contenedores de dibujo y texto
    private fun clearContainers(){
        // PaintView
        paintContainer.clear()

        // Texto
        editText.setText(resources.getString(R.string.text))
        editText.setTextColor(resources.getColor(R.color.black))
        editText.setBackgroundColor(resources.getColor(R.color.white))
    }

    // Cambia del modo color de texto a goma de borrar
    private fun changeModeTextColorOrErase(){
        btnTextColorOrEraser.setOnClickListener{
            // Si es modo texto cambia el color del texto
            if(isText){
                isNote = false // Color Texto
                changeVisibilityNavColor()

                // Si es dibujo cambia a goma
            }else{
                // Si esta en modo lapiz cambia a modo borrado
                paintContainer.changeColor(resources.getColor(R.color.white))
            }

            showBtnTools()
        }
    }

    // Cambia el color de las notas
    private fun changeColorNotes(){
        btnNoteColor.setOnClickListener{
            isNote = true // Color Nota
            changeVisibilityNavColor()
            showBtnTools()
        }
    }

    private fun changeVisibilityNavColor(){
        // Si la barra es visible
        if(isColor) {
            navColor.visibility = View.GONE
            isColor = false

        } // Vuelve invisible la barra
        else {
            navColor.visibility = View.VISIBLE// Hace visible la barra
            isColor = true
        }
    }

    // Cambia el color del elemento según el seleccionado
    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            // -------------------------------   COLORS     ------------------------------------ //

            R.id.color_black -> changeColor(resources.getColor(R.color.black))
            R.id.color_gray -> changeColor(resources.getColor(R.color.gray))
            R.id.color_white -> changeColor(resources.getColor(R.color.white))
            R.id.color_red -> changeColor(resources.getColor(R.color.red))
            R.id.color_blue -> changeColor(resources.getColor(R.color.blue))
            R.id.color_green -> changeColor(resources.getColor(R.color.green))
            R.id.color_yellow -> changeColor(resources.getColor(R.color.yellow))
            R.id.color_orange -> changeColor(resources.getColor(R.color.orange))
            R.id.color_brown -> changeColor(resources.getColor(R.color.brown))
            R.id.color_purple -> changeColor(resources.getColor(R.color.purple))
        }

        return true
    }

    // Cambia el color de la nota o del texto
    private fun changeColor(color: Int){
        if(isText) {
            if(!isNote) {
                editText.setTextColor(color) // Color Texto
                currentColor = color
            }
            else {
                editText.setBackgroundColor(color) // Color Nota
                currentBgColor = color
            }

            // Cambia el color del pincel
        }else paintContainer.changeColor(color)

        // Cambia la visibilidad de la barra de colores
        changeVisibilityNavColor()
    }
}
