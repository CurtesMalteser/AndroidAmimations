package com.curtesmalteser.amimations

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Scene
import android.transition.TransitionInflater
import android.transition.TransitionManager
import kotlinx.android.synthetic.main.activity_transition_animation.*
import android.transition.Transition



class TransitionAnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transition_animation)
        val buttonTransition = TransitionInflater.from(this).inflateTransition(R.transition.button_transition)
        window.sharedElementEnterTransition = buttonTransition

        btnCloseTransitionActivity.setOnClickListener({

            //not working
           /* TransitionManager.go(Scene.getSceneForLayout(root, R.layout.activity_transition_animation, this),
                    TransitionInflater.from(this)
                            .inflateTransition(R.transition.default_transition))*/

        })

       /* val animator1 = ObjectAnimator.ofFloat(btnCloseTransitionActivity, "translationX", -200f)
        animator1.repeatCount = 0
        animator1.duration = 1000

        val animator2 = ObjectAnimator.ofFloat(image, "translationX", 100f)
        animator2.repeatCount = 0
        animator2.duration = 1000

        val animator3 = ObjectAnimator.ofFloat(tvDummyText, "translationY", 100f)
        animator3.repeatCount = 0
        animator3.duration = 1000

        //sequencial animation
        val set = AnimatorSet()
        set.play(animator1)//.before(animator2)
        set.play(animator2)//.before(animator3)
        set.play(animator3)//.before(animator3)

        // btnCloseTransitionActivity.setOnClickListener({
        set.start()
        // })*/

    }
}
