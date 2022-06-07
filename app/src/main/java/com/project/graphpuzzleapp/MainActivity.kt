package com.project.graphpuzzleapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

    fun exampleInstance (){
        var arreglo: Array<Array<Int>> = arrayOf(arrayOf(1,2,3), arrayOf(1,2,3), arrayOf(1,2,3))
        var road: Array<Array<Int>> = arrayOf(arrayOf(1,2,3), arrayOf(1,2,3), arrayOf(1,2,3))

        val values: Roads = Roads(arreglo,road)

        values.mapRoads()
    }
}