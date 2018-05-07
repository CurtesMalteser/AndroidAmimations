package com.curtesmalteser.amimations

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_spring_animation.*

class SpringAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_spring_animation)

        val springAnimation = SpringAnimation(tv, DynamicAnimation.TRANSLATION_Y, 0f)
        springAnimation.spring.setDampingRatio(SpringForce.DAMPING_RATIO_NO_BOUNCY).stiffness = SpringForce.STIFFNESS_HIGH

        springAnimation.addUpdateListener { animation, value, velocity ->

            if (value > 300) {
                springAnimation.animateToFinalPosition(value)
                finish()
            } else springAnimation.animateToFinalPosition(0f)
        }


        springAnimation.start()


        // The fixed difference between Y properties of two consecutive views (i.e., dragView and firstView, firstView and secondView) that they need to maintain.
        var dY = 0f

        tv.setOnTouchListener { view, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    dY = view.y - event.rawY
                }

                MotionEvent.ACTION_MOVE -> {
                    val newY = event.rawY + dY

                    view.animate().y(newY).setDuration(0).start()

                }

                MotionEvent.ACTION_UP -> {
                    springAnimation.animateToFinalPosition(0f)
                }
            }

            return@setOnTouchListener true
        }
    }
}
