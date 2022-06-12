package com.project.model

class Game {
        lateinit var matrixGame: ArrayList<ArrayList<Int>>
        val nodes: ArrayList<String>
        private val instance: Roads
        private var way: ArrayList<String>
        private val sizeOfArray: Int = 4

        init {
            instance = Roads(generateRandomArray())
            way = ArrayList()
            nodes = instance.randomVertexes()
        }

        private fun generateRandomArray(): ArrayList<ArrayList<Int>> {
            //val tempMatrix:ArrayList<ArrayList<Int>> = ArrayList()


            val tempMatrix: ArrayList<ArrayList<Int>> = ArrayList()
            tempMatrix.add(ArrayList(arrayOf(0,4,8,100,100).toList()))
            tempMatrix.add(ArrayList(arrayOf(4,0,1,2,100).toList()))
            tempMatrix.add(ArrayList(arrayOf(8,100,0,4,2).toList()))
            tempMatrix.add(ArrayList(arrayOf(100,2,4,0,7).toList()))
            tempMatrix.add(ArrayList(arrayOf(100,100,2,7,0).toList()))

            val clone: ArrayList<ArrayList<Int>> = ArrayList()
            clone.add(ArrayList(arrayOf(0,4,8,100,100).toList()))
            clone.add(ArrayList(arrayOf(4,0,1,2,100).toList()))
            clone.add(ArrayList(arrayOf(8,100,0,4,2).toList()))
            clone.add(ArrayList(arrayOf(100,2,4,0,7).toList()))
            clone.add(ArrayList(arrayOf(100,100,2,7,0).toList()))

            matrixGame = clone

            var tempArray: ArrayList<Int> = ArrayList()
            val numbers = (0..10)
/*
            for (i in 0..sizeOfArray){
                for (j in 0..sizeOfArray){
                    if(i != j){
                        tempArray.add(numbers.random())
                    } else {
                        tempArray.add(0)
                    }
                }
                tempMatrix.add(tempArray)
                tempArray = ArrayList()
            }
  */

            return tempMatrix
        }

        fun road(): ArrayList<String>{
            val roads: ArrayList<ArrayList<String>> = instance.mapRoads()
            var node0: Int = instance.vertexIndex(nodes[0].single())
            var node1: Int = instance.vertexIndex(nodes[1].single())
            var nodes: ArrayList<String> = ArrayList(this.nodes.toList())


            way.add(nodes[0])

            while (nodes[0] != nodes[1]){

                if(node1 != instance.vertexIndex(roads[node0][node1].single())){
                    node1 = instance.vertexIndex(roads[node0][node1].single())
                } else{
                    way.add(roads[node0][node1])
                    nodes[0] = roads[node0][node1]
                    node0 = instance.vertexIndex(nodes[0].single())
                    node1 = instance.vertexIndex(nodes[1].single())
                }
            }

            return way
        }
}