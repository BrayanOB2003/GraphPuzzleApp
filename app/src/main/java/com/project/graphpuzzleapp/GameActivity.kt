package com.project.graphpuzzleapp

import android.R
import android.os.Bundle
import android.text.InputFilter
import android.text.InputFilter.AllCaps
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
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

        initEditTextFormat()
        newGame()
        nextGame()

    }

    private fun initEditTextFormat(){ //Uppercase text filter formatting
        val vertex1 = binding.vertex1 as EditText
        vertex1.filters = arrayOf<InputFilter>(AllCaps())

        val vertex2 = binding.vertex2 as EditText
        vertex2.filters = arrayOf<InputFilter>(AllCaps())

        val vertex3 = binding.vertex3 as EditText
        vertex3.filters = arrayOf<InputFilter>(AllCaps())

        val vertex4 = binding.vertex4 as EditText
        vertex4.filters = arrayOf<InputFilter>(AllCaps())

        val vertex5 = binding.vertex5 as EditText
        vertex5.filters = arrayOf<InputFilter>(AllCaps())
    }

    private fun nextGame(){

        player = ViewModelProvider(this)[Player::class.java]

        binding.score.text = binding.score.text.toString() + " " + player.getScore().toString()

        val begin = System.nanoTime()
        binding.nextButton.setOnClickListener{

            val end = System.nanoTime()
            val time = (end - begin).toInt()

            val score = nextLevel(1)

            player.addScore(score)

            this.recreate()
        }
    }

    private fun newGame(){
        graphGame = GraphGame()
        game = Game(graphGame)
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