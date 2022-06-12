package com.project.graphpuzzleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.project.model.Game
import com.project.model.Roads

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t: TextView = findViewById(R.id.txt) as TextView

        var instance: Game = Game()
        var array: ArrayList<String> = instance.road()
        var text: String = ""
        var size: Int = array.size - 1
        var temp: ArrayList<ArrayList<Int>> =  instance.matrixGame
        text +=  instance.nodes.size.toString() + " " + instance.nodes[0] + " " + instance.nodes[1] + " \n"
        for (i in 0..(temp.size - 1)){
            for(j in 0..(temp.size - 1)){
                text += " " + temp[i][j]
            }
            text += "\n"
        }

        for(i in 0..size){
            text += " " + array[i]
        }

        t.text = text
    }
}