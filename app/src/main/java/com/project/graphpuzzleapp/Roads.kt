package com.project.graphpuzzleapp

class Roads constructor(dtc: Array<Array<Int>>, roads: Array<Array<Int>>){

    private var distance: Array<Array<Int>> = dtc

    fun mapRoads() {
        var size: Int = distance.size

        for(i in 0..size){
            for(j in 0..size){

            }
        }
    }

    private fun searchBelow(row: Int, column: Int){
        var size: Int = distance.size-1
        var sumtemp: Int = 0
        var col: Int = column

        for(i in row..size) {
            for (j in column..size) {
                sumtemp = distance[i+1][col] + distance[i][j + 1]

                if (sumtemp < distance[i][j + 1]) {
                    distance[i][j + 1] = sumtemp
                }
            }
        }
    }

    private fun searchUp(row: Int, column: Int){
        var size: Int = distance.size-1
        var recoil: Int = -column
        var sumtemp: Int = 0
        var aux: Boolean = true

        for(i in 0..row) {
            for (j in 0..size) {
                if(i!=j) {
                    sumtemp = distance[i][column] + distance[i - 1][j + 1]

                    if (sumtemp < distance[i + 1][j + 1]) {
                        distance[i + 1][j + 1] = sumtemp
                    }
                }
            }
        }
    }
}