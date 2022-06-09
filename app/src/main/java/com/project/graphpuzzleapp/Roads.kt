package com.project.graphpuzzleapp

class Roads constructor(dtc: Array<Array<Int>>, road: Array<Array<Int>>){

    private var distance: Array<Array<Int>> = dtc
    private var roads: Array<Array<Int>> = road

    fun mapRoads(): Array<Array<Int>>{
        var size: Int = distance.size-1

        for(i in 0..size){
            searchWay(i)
        }

        return distance
    }

    private fun searchWay(fixedPosition: Int) {
        var size: Int = distance.size-1
        var temporarySum: Int = 0

        for (i in 0..size){
            for(j in 0..size){
                if(i != fixedPosition){
                    temporarySum = distance[i][fixedPosition] + distance[fixedPosition][j]
                    if(temporarySum < distance[i][j]){
                        distance[i][j] = temporarySum
                    }
                }
            }
        }
    }
}