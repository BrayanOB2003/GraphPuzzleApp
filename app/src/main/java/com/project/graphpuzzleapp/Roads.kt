package com.project.graphpuzzleapp

class Roads(dtc: ArrayList<ArrayList<Int>>) {

    private var distance: ArrayList<ArrayList<Int>> = dtc
    private var size: Int = dtc.size - 1
    private var roads: ArrayList<ArrayList<String>>
    private val letters: Array<Char> = arrayOf('A', 'B', 'C', 'D', 'E','F','G','H')

    init {
        roads = initRoads()

    }

    fun mapRoads(): ArrayList<ArrayList<String>>{
        for(i in 0..size){
            searchWay(i)
        }

        return roads
    }

    private fun searchWay(fixedPosition: Int) {
        var temporarySum: Int

        for (i in 0..size) {
            for (j in 0..size) {
                if (i != fixedPosition) {
                    if (j != fixedPosition) {
                        temporarySum = distance[i][fixedPosition] + distance[fixedPosition][j]
                        if (temporarySum < distance[i][j]) {
                            distance[i][j] = temporarySum
                            roads[i][j] = letters[fixedPosition].toString()
                        }
                    }
                }
            }
        }
    }

    private fun initRoads():ArrayList<ArrayList<String>>{

        val tempMatrix:ArrayList<ArrayList<String>> = ArrayList()
        var tempArray: ArrayList<String> = ArrayList()

        for(i in 0..size){
            for (j in 0..size) {
                if(i != j){
                    tempArray.add(letters[j].toString())
                } else {
                    tempArray.add("-")
                }

            }
            tempMatrix.add(tempArray)
            tempArray = ArrayList()
        }

        return tempMatrix
    }
}