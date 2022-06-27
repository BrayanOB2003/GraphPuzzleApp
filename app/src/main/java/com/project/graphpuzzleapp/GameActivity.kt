package com.project.graphpuzzleapp

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.project.graphpuzzleapp.databinding.ActivityGameBinding
import com.project.graphpuzzleapp.databinding.ActivityMainBinding

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var restore : PaintGame = binding.gameGraph
    }

    override fun onResume() {
        super.onResume()

    }
}