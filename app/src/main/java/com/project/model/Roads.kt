package com.project.model

class Roads(dtc: ArrayList<ArrayList<Int>>) {

    private var distance: ArrayList<ArrayList<Int>> = dtc
    private val size: Int = dtc.size - 1
    private var roads: ArrayList<ArrayList<String>>
    private val lettersVertex: Array<Char> = arrayOf('A', 'B', 'C', 'D', 'E')

    init {
        roads = initRoads()

    }

    fun mapRoads(): ArrayList<ArrayList<String>>{
        for(i in 0..size){
            searchWay(i)
        }

        return roads
    }

    fun randomVertexes():Array<String>{
        var temp: ArrayList<Char> = lettersVertex.toCollection(ArrayList())
        var vertexes: ArrayList<String> = ArrayList()
        /*
        for(i in 0..1){
            vertexes.add(temp.random().toString())
            temp.remove(vertexes[i].single())
        }
        */
        vertexes.add("A")
        vertexes.add("E")

        return vertexes.toTypedArray()
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
                            roads[i][j] = lettersVertex[fixedPosition].toString()
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
                    tempArray.add(lettersVertex[j].toString())
                } else {
                    tempArray.add("-")
                }

            }
            tempMatrix.add(tempArray)
            tempArray = ArrayList()
        }

        return tempMatrix
    }

    fun vertexIndex(vertex: Char): Int{
        return lettersVertex.indexOf(vertex)
    }
}