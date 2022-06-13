package com.project.model

class Game {
        val matrixGame: ArrayList<ArrayList<Int>>
        val nodes: Array<String>
        val way: Array<String>
        private val instance: Roads
        private val sizeOfArray: Int = 4

        init {
            val matrix = generateRandomArray()
            matrixGame = matrix.first
            instance = Roads(matrix.second)   //the clone of the game matrix is assigned
            nodes = instance.randomVertexes()
            way = road()

        }

        private fun generateRandomArray(): Pair<ArrayList<ArrayList<Int>>,ArrayList<ArrayList<Int>>> {
            val tempMatrix:ArrayList<ArrayList<Int>> = ArrayList()
            val clone: ArrayList<ArrayList<Int>> = ArrayList()
            var tempArray: ArrayList<Int> = ArrayList()
            val numbers = (0..10)

            for (i in 0..sizeOfArray){
                for (j in 0..sizeOfArray){
                    if(i != j){
                        tempArray.add(numbers.random())
                    } else {
                        tempArray.add(0)
                    }
                }
                tempMatrix.add(tempArray)
                clone.add(ArrayList(tempArray.toList()))
                tempArray = ArrayList()
            }

            return Pair(tempMatrix,clone)
        }

        private fun road(): Array<String>{
            val way: ArrayList<String> = ArrayList()
            val roads: ArrayList<ArrayList<String>> = instance.mapRoads()
            var node0: Int = instance.vertexIndex(nodes[0].single())
            var node1: Int = instance.vertexIndex(nodes[1].single())
            val nodes: ArrayList<String> = ArrayList(this.nodes.toList())


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

            return way.toTypedArray()
        }
}