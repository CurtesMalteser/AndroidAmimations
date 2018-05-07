package com.curtesmalteser.amimations

import android.app.ActivityOptions
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.animation.DynamicAnimation
import android.support.animation.SpringAnimation
import android.support.animation.SpringForce.DAMPING_RATIO_NO_BOUNCY
import android.support.animation.SpringForce.STIFFNESS_HIGH
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import android.util.Log
import android.view.MotionEvent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_transition_animation.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.debug

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSpring.setOnClickListener({
            startActivity(Intent(this@MainActivity, SpringAnimationActivity::class.java))
        })

        btnTransition.setOnClickListener({
            startActivity(Intent(this, TransitionAnimationActivity::class.java),
                    ActivityOptions.makeSceneTransitionAnimation(this@MainActivity,
                            btnTransition, resources.getString(R.string.transition_button)
                    ).toBundle())
        })

    }
}
