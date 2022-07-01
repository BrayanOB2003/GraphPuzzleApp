package com.project.graphpuzzleapp

import android.graphics.Canvas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.project.graphpuzzleapp.databinding.ActivityGameBinding
import com.project.model.Game
import com.project.model.GraphGame
import com.project.model.Player

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private lateinit var graphGame: GraphGame
    private lateinit var game: Game
    private lateinit var player: Player

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        newGame()
        nextGame()
    }

    private fun nextGame(){
        val begin = System.nanoTime()
        player = ViewModelProvider(this)[Player::class.java]

        binding.score.text = binding.score.text.toString() + " " + player.getScore().toString()

        binding.nextButton.setOnClickListener{

            player.addScore(1)

            this.recreate()
        }
    }

    private fun newGame(){
        graphGame = GraphGame()
        binding.gameGraph.setGame(graphGame)
    }

    private fun nextLevel(time: Int):Int{

        val value1: String = binding.vertex1.text.toString()
        val value2: String = binding.vertex2.text.toString()
        val value3: String = binding.vertex3.text.toString()
        val value4: String = binding.vertex4.text.toString()
        val value5: String = binding.vertex5.text.toString()

        val way: Array<String> = arrayOf(value1, value2, value3, value4, value5)

        return game.calculateScore(way,time)
    }
}