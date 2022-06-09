package com.project.graphpuzzleapp

import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

@RunWith(AndroidJUnit4::class)
class RoadsTest {
    @Test
    fun roads(){
        var test: Array<Array<Int>> =  arrayOf(arrayOf(0,4,5,3), arrayOf(-1,0,1,-1), arrayOf(-2,2,0,1), arrayOf(0,4,2,0))
        var expected: Array<Array<Int>> = arrayOf()

        var instance: Roads = Roads(test,test)
        var result: Array<Array<Int>> = instance.mapRoads()

        assertNotEquals(test,result)
    }
}