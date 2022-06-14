package com.project.graphpuzzleapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.project.model.Game

class PaintGame(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        val figurePaint: Paint = Paint()

        val game: Game = Game()
        val height: Int? = canvas?.height?.minus(100)
        val width: Int? = canvas?.width?.minus(100)
        val collectionX: ArrayList<Int> = ArrayList((100..width!! step 150).toMutableList())
        val collectionY: ArrayList<Int> = ArrayList((100..height!! step 150).toMutableList())
        val coordinatesXY: HashMap<Int, Int> = HashMap()
        val coordinatesX: ArrayList<Int> = ArrayList()
        var x: Int
        var y: Int

        val matrixGame: ArrayList<ArrayList<Int>> = game.matrixGame

        for(i in 0 until matrixGame.size){
            x = collectionX.random()
            y = collectionY.random()
            coordinatesXY[x] = y
            coordinatesX.add(x)
            collectionX.remove(x)
            collectionY.remove(y)
        }

        figurePaint.color = Color.BLACK
        figurePaint.strokeWidth = 10F


        var startTempX: Int
        var endTempX: Int

        for(i in 0 until matrixGame.size){
            startTempX = coordinatesX[i]
            for(j in 1 until matrixGame.size){
                endTempX = coordinatesX[j]
                canvas?.drawLine(startTempX.toFloat(), coordinatesXY[startTempX]!!.toFloat(),
                    endTempX.toFloat(), coordinatesXY[endTempX.toInt()]!!.toFloat(), figurePaint)
            }
        }

        figurePaint.strokeWidth = 100F
        figurePaint.setARGB(255,255,0,0)

        val txtPaint: Paint = Paint()
        txtPaint.color = Color.BLACK
        txtPaint.textSize = 30F

        for (i in 0 until coordinatesX.size){
            canvas?.drawCircle(coordinatesX[i].toFloat(),coordinatesXY[coordinatesX[i]]!!.toFloat(), 50F, figurePaint)
            canvas?.drawText(game.vertexes[i].toString(), coordinatesX[i].toFloat(),coordinatesXY[coordinatesX[i]]!!.toFloat(), txtPaint)
        }
    }

}