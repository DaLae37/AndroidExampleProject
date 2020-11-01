package com.dalae37.myapplication

import android.content.Intent
import android.graphics.drawable.BitmapDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private val layouts : ArrayList<LinearLayout> = ArrayList<LinearLayout>()
    private var index : Int = 0
    private var curX : Float = 0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        layouts.add(findViewById(R.id.first_a))
        layouts.add(findViewById(R.id.first_b))
        layouts.add(findViewById(R.id.first_c))
        layouts.add(findViewById(R.id.first_d))
        layouts.add(findViewById(R.id.first_e))
        layouts.add(findViewById(R.id.first_f))
        layouts.add(findViewById(R.id.first_g))
        layouts.add(findViewById(R.id.first_h))
        layouts.add(findViewById(R.id.first_i))

        SetScrollView_Platform()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        Toast.makeText(applicationContext, "뒤로 가기 버튼", Toast.LENGTH_LONG).show()
        startActivity((Intent(applicationContext, MainActivity2::class.java)))
        finish()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val action : Int? = event?.action
        layouts[index].visibility = View.GONE
        when(action){
            MotionEvent.ACTION_DOWN->{
                curX = event.x
            }
            MotionEvent.ACTION_UP->{
                val diffX : Float = curX - event.x
                if(diffX > 50){
                    index++
                    if(index > layouts.size - 1){
                        index = 0
                    }
                }
                else if(diffX < 50){
                    index--
                    if(index < 0){
                        index = layouts.size - 1
                    }
                }
            }
        }
        layouts[index].visibility = View.VISIBLE
        return true
    }

    fun SetScrollView_Platform(){
        val scroll : ScrollView = findViewById(R.id.scrollView_Platform)
        scroll.isHorizontalScrollBarEnabled = true
        scroll.isVerticalScrollBarEnabled = true

        val img : ImageView = findViewById(R.id.image_Platform)
        val bitmap : BitmapDrawable = getDrawable(R.drawable.platform_architecture) as BitmapDrawable
        val width : Int = bitmap.intrinsicWidth
        val height : Int = bitmap.intrinsicHeight

        img.setImageDrawable(bitmap)
        img.layoutParams.width = width
        img.layoutParams.height = height
    }
}