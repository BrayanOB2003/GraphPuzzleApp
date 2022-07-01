package com.project.model

class Game (game: GraphGame){

    private val gameWay:Array<String>
    private val gameNodes: Array<String>
    private val hitScore: Int = 50
    private val missScore: Int = 25
    private var score: Int = 0

    init {
        gameWay = game.way
        gameNodes = game.nodes
    }

    fun calculateScore(way: Array<String>, time: Int): Int {
        for (i in gameWay.indices){
            println(gameWay[i])
            if(way[i] == gameWay[i]){
                score += hitScore
            } else if(missScore <= score){
                score -= missScore
            }
        }
        score /= time

        return score
    }
}