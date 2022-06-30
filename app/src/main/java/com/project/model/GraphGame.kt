package com.project.model

class GraphGame {
        val matrixGame: ArrayList<ArrayList<Int>>
        val nodes: Array<String>
        val way: Array<String>
        val vertexes: Array<Char>
        private val instance: Roads
        private val sizeOfArray: Int = 4

        init {
            val matrix = generateRandomArray()
            matrixGame = matrix.first
            instance = Roads(matrix.second)   //the clone of the game matrix is assigned
            vertexes = instance.lettersVertex
            nodes = instance.randomVertexes()
            way = road()
        }

        private fun generateRandomArray(): Pair<ArrayList<ArrayList<Int>>,ArrayList<ArrayList<Int>>> { //Generate random adjacency matrix with method of Erdos-Renyi
            val tempMatrix:ArrayList<ArrayList<Int>> = ArrayList()
            val clone: ArrayList<ArrayList<Int>> = ArrayList()
            var tempArray: ArrayList<Int> = ArrayList()
            val density = (0..100)
            val numbers = (0..10)
            val probability: Int = 80

            for (i in 0..sizeOfArray){
                for (j in 0..sizeOfArray){
                    if(i != j && density.random() <= probability){
                        tempArray.add(numbers.random())
                    } else {
                        tempArray.add(0)
                    }
                }
                tempMatrix.add(tempArray)
                clone.add(ArrayList(tempArray.toList()))   //Clone array list
                tempArray = ArrayList()
            }

            for(i in 0..sizeOfArray){
                tempArray = ArrayList(tempMatrix[i].toList()) //Copy rows in columns to do simple graphs
                for(j in 0..sizeOfArray) {
                    tempMatrix[j][i] = tempArray[j]
                    clone[i][j] = tempArray[j];
                }
            }

            return Pair(tempMatrix,clone)
        }

        private fun road(): Array<String>{ //Take the vertexes where stay shortest way
            val way: ArrayList<String> = ArrayList()
            val roads: ArrayList<ArrayList<String>> = instance.mapRoads()
            var node0: Int = vertexes.indexOf(nodes[0].single())
            var node1: Int = vertexes.indexOf(nodes[1].single())
            val nodes: ArrayList<String> = ArrayList(this.nodes.toList())


            way.add(nodes[0])

            while (nodes[0] != nodes[1]){

                if(node1 != vertexes.indexOf(roads[node0][node1].single())){
                    node1 = vertexes.indexOf(roads[node0][node1].single())
                } else{
                    way.add(roads[node0][node1])
                    nodes[0] = roads[node0][node1]
                    node0 = vertexes.indexOf(nodes[0].single())
                    node1 = vertexes.indexOf(nodes[1].single())
                }
            }

            while(way.size != 5){
                way.add("")
            }

            return way.toTypedArray()
        }
}