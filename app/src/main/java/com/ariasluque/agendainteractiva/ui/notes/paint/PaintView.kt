package com.ariasluque.agendainteractiva.ui.notes.paint

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View

class PaintView : View {

    private val BRUSH_SIZE : Float = 10f // Tamaño del pincel
    private val DEFAULT_COLOR : Int = Color.BLACK // Color por defecto del pincel
    private val DEFAULT_BG_COLOR : Int = Color.WHITE // Color de fondo por defecto
    private val TOUCH_TOLERANCE : Float = 4f

    private var mX : Float = 0f
    private var mY : Float = 0f

    private lateinit var mPath : Path
    private var mPaint : Paint = Paint()
    private var paths : ArrayList<FingerPath> = ArrayList()

    private var currentColor : Int = DEFAULT_COLOR // Color actual del pincel
    private var bgColor : Int = DEFAULT_BG_COLOR
    private var strokeWidth : Float = BRUSH_SIZE // Anchura del trazo

    // OP?
    private var emboss : Boolean = false // Realzado
    private var blur : Boolean = false // Difuminado
    private var mEmboss : MaskFilter
    private var mBlur : MaskFilter

    lateinit var mBitmap : Bitmap
    lateinit var mCanvas: Canvas
    private var mBitmapPaint: Paint = Paint(Paint.DITHER_FLAG)

    constructor(context: Context) : this(context, null)

    constructor(context: Context?, attributeSet: AttributeSet?) : super(context, attributeSet) {
        mPaint.isAntiAlias = true
        mPaint.isDither = true
        mPaint.color = DEFAULT_COLOR
        mPaint.style = Paint.Style.STROKE
        mPaint.strokeJoin = Paint.Join.ROUND
        mPaint.strokeCap = Paint.Cap.ROUND
        mPaint.xfermode = null
        mPaint.alpha = 0xff

        mEmboss = EmbossMaskFilter(floatArrayOf(1f, 1f, 1f), 0.4f, 6f, 3.5f)
        mBlur = BlurMaskFilter(5f, BlurMaskFilter.Blur.NORMAL)
    }

    fun init(metrics: DisplayMetrics){
        var height = metrics.heightPixels
        var width = metrics.widthPixels

        mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
        mCanvas = Canvas(mBitmap)
    }

    fun changeColor(color : Int){
        currentColor = color
    }

    fun normal(){
        emboss = false
        blur = false
    }

    fun clear(){
        bgColor = DEFAULT_BG_COLOR
        currentColor = DEFAULT_COLOR
        paths.clear()

        normal()
        invalidate()
    }

    override fun onDraw(canvas: Canvas){
        canvas.save()
        mCanvas.drawColor(bgColor)

        for(fPath : FingerPath in paths){
            mPaint.color = fPath.color
            mPaint.strokeWidth = fPath.strokeWidth
            mPaint.maskFilter = null

            if (fPath.emboss) mPaint.maskFilter = mEmboss
            if (fPath.blur) mPaint.maskFilter = mBlur

            mCanvas.drawPath(fPath.path, mPaint)
        }

        canvas.drawBitmap(mBitmap, 0f, 0f, mBitmapPaint)
        canvas.restore()
    }

    private fun touchStar(x : Float, y : Float){
        mPath = Path()

        var fPath : FingerPath = FingerPath(currentColor, emboss, blur, strokeWidth, mPath)
        paths.add(fPath)

        mPath.reset()
        mPath.moveTo(x, y)
        mX = x
        mY = y
    }

    private fun touchMove(x : Float, y : Float){
        var dx = Math.abs(x - mX)
        var dy = Math.abs(y - mY)

        if(dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE){
            mPath.quadTo(mX, mY, (x + mX) / 2, (y + mY) / 2)
            mX = x
            mY = y
        }
    }

    private fun touchUp(){
        mPath.lineTo(mX, mY)
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        var x = event!!.x
        var y = event.y

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                touchStar(x, y)
                invalidate()
            }
            MotionEvent.ACTION_MOVE -> {
                touchMove(x, y)
                invalidate()
            }
            MotionEvent.ACTION_UP -> {
                touchUp()
                invalidate()
            }
        }

        return true
    }
}