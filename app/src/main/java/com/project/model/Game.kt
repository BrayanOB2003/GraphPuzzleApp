package com.project.model

import kotlin.io.path.createTempDirectory
import kotlin.random.Random

class Game {
        private var randomArray: ArrayList<ArrayList<Int>>
        private var way: ArrayList<String>
        private val sizeOfArray: Int = 4

        init {
            randomArray = generateRandomArray()
            way = ArrayList()
        }

        private fun generateRandomArray(): ArrayList<ArrayList<Int>>{
            val tempMatrix:ArrayList<ArrayList<Int>> = ArrayList()
            var tempArray: ArrayList<Int> = ArrayList()
            val numbers = (0..100)

            for (i in 0..sizeOfArray){
                for (j in 0..sizeOfArray){
                    tempArray.add(numbers.random())
                }
                tempMatrix.add(tempArray)
                tempArray = ArrayList()
            }


            return tempMatrix
        }

        fun road(): ArrayList<String>{
            val instance: Roads = Roads(randomArray)
            val roads: ArrayList<ArrayList<String>> = instance.mapRoads()
            var txt:String = instance.randomVertexes().toString()
            var nodes: Array<String> = arrayOf(txt[0].toString(),  txt[1].toString())
            var node1: Int = instance.vertexIndex(nodes[0].single())
            var node2: Int = instance.vertexIndex(nodes[1].single())

            while (nodes[0] != nodes[1]){
                nodes[0] = roads[node1][node2]
                node1 = instance.vertexIndex(nodes[0].single())
                way.add(nodes[0])
            }

            return way
        }
}