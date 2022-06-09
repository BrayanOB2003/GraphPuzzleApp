package com.project.graphpuzzleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var t: TextView = findViewById(R.id.txt) as TextView

        var test: Array<Array<Int>> =  arrayOf(arrayOf(0,4,5,3), arrayOf(-1,0,1,-1), arrayOf(-2,2,0,1), arrayOf(0,4,2,0))
        var instance: Roads = Roads(test,test)
        var result: Array<Array<Int>> = instance.mapRoads()

        t.text = result[0][1].toString() + result[0][2] + result[0][3];
    }
}