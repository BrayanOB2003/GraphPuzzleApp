package com.project.graphpuzzleapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.airbnb.lottie.LottieAnimationView
import com.airbnb.lottie.LottieDrawable
import com.project.graphpuzzleapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setAnimation(binding.gameImage,R.raw.game)

    }

    public fun openGame(view: View){
        val intent = Intent(this, GameActivity::class.java)
        startActivity(intent)
    }

    private fun setAnimation(img: LottieAnimationView, animation: Int){
        img.setAnimation(animation)
        img.playAnimation()
        img.repeatMode = LottieDrawable.REVERSE
        img.loop(true)
    }
}