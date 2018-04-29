package com.curtesmalteser.amimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce.DAMPING_RATIO_NO_BOUNCY
import android.support.animation.SpringForce.STIFFNESS_HIGH
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class MainActivity : AppCompatActivity() {

    private val logWithASpecificTag = AnkoLogger("anim")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        logWithASpecificTag.debug("onCreate")

        //Used to get the view initial position
        /*val location = IntArray(2)
        tv.getLocationOnScreen(location)
        val y = Float.fromBits(location[0])

        Log.d("anim", "initial position: " + y)*/

        val springAnimation = SpringAnimation(tv, DynamicAnimation.TRANSLATION_Y, 0f)
        springAnimation.spring.setDampingRatio(DAMPING_RATIO_NO_BOUNCY).stiffness = STIFFNESS_HIGH

        springAnimation.addUpdateListener { animation, value, velocity ->
            Log.d("anim", "" + value)

            if (value > 300) {
                springAnimation.animateToFinalPosition(value)
                finish()
            } else springAnimation.animateToFinalPosition(0f)
        }


        springAnimation.start()


        // The fixed difference between Y properties of two consecutive views (i.e., dragView and firstView, firstView and secondView) that they need to maintain.
        val viewYDistance = 0
        var dY = 0f

        tv.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dY = view.y - event.rawY
                }

                MotionEvent.ACTION_MOVE -> {
                    val newY = event.rawY + dY

                    view.animate().y(newY).setDuration(0).start()


                    logWithASpecificTag.debug(newY)
                }

                MotionEvent.ACTION_UP -> {
                    springAnimation.animateToFinalPosition(0f)
                }
            }

            return@setOnTouchListener true
        }
    }
}
