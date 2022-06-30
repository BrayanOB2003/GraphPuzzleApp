package com.project.model

import androidx.lifecycle.ViewModel


class Player : ViewModel() {

    private var score: Int = 0
    lateinit var nickName: String

    fun addScore(tempScore: Int): Int{
        score += tempScore

        return score
    }

    fun getScore(): Int{
        return score
    }
}