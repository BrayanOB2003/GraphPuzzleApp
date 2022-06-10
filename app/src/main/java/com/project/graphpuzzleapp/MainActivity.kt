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

        var test: ArrayList<ArrayList<Int>> =
            arrayOf(arrayOf(0,4,8,100,100).toList(), arrayOf(4,0,1,2,100).toList(), arrayOf(8,100,0,4,2).toList(), arrayOf(100,2,4,0,7).toList(), arrayOf(100,100,2,7,0).toList()).toList() as ArrayList<ArrayList<Int>>
        var instance: Game = Game()
        var array: ArrayList<String> = instance.road()
        var text: String = ""
        var size: Int = array.size - 1

        for(i in 0..size){
            text += " " + array[i]
        }

        t.text = text
    }
}