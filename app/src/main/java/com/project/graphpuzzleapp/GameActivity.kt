package com.project.graphpuzzleapp

import android.graphics.Paint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModel
import com.project.graphpuzzleapp.databinding.ActivityGameBinding
import com.project.graphpuzzleapp.databinding.ActivityMainBinding
import com.project.model.Game

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val game = Game()
        binding.gameGraph.setGame(game)
    }
}