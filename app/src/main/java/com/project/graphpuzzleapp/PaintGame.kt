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
        val figurePaint = Paint()

        val game = Game()

        val height: Int? = canvas?.height?.minus(100)
        val width: Int? = canvas?.width?.minus(100)
        val collectionX: ArrayList<Int> = ArrayList((100..width!! step 150).toMutableList())
        val collectionY: ArrayList<Int> = ArrayList((100..height!! step 150).toMutableList())
        val coordinatesXY: HashMap<Int, Int> = HashMap()
        val coordinatesX: ArrayList<Int> = ArrayList()
        var x: Int
        var y: Int

        val matrixGame: ArrayList<ArrayList<Int>> = game.matrixGame

        val txtPaint = Paint()
        txtPaint.color = Color.BLUE
        txtPaint.textSize = 40F

        for(i in 0 until matrixGame.size){  //Create random coordinates
            x = collectionX.random()
            y = collectionY.random()
            coordinatesXY[x] = y
            coordinatesX.add(x)
            collectionX.remove(x)
            collectionY.remove(y)
        }

        figurePaint.color = Color.YELLOW
        figurePaint.strokeWidth = 10F


        var startTempX: Float
        var endTempX: Float

        var averageX: Float
        var averageY: Float

        for(i in 0 until matrixGame.size){  //Paint the edges and the costs of these
            startTempX = coordinatesX[i].toFloat()
            for(j in 1 until matrixGame.size){
                if(matrixGame[i][j] != 0){
                    endTempX = coordinatesX[j].toFloat()
                    canvas?.drawLine(startTempX.toFloat(), coordinatesXY[startTempX.toInt()]!!.toFloat(),
                        endTempX.toFloat(), coordinatesXY[endTempX.toInt()]!!.toFloat(), figurePaint)

                    averageX = (startTempX + endTempX) /2;
                    averageY = (coordinatesXY[startTempX.toInt()]!!.toFloat() + coordinatesXY[endTempX.toInt()]!!.toFloat()) / 2

                    canvas?.drawText(matrixGame[i][j].toString(), averageX,averageY, txtPaint)
                }
            }
        }

        figurePaint.strokeWidth = 100F
        figurePaint.setARGB(255,255,0,0)

        for (i in 0 until coordinatesX.size){  //Paint the vertex with circles and the name of these
            canvas?.drawCircle(coordinatesX[i].toFloat(),coordinatesXY[coordinatesX[i]]!!.toFloat(), 50F, figurePaint)
            canvas?.drawText(game.vertexes[i].toString(), coordinatesX[i].toFloat() - 10F,coordinatesXY[coordinatesX[i]]!!.toFloat()+ 10F, txtPaint)
        }
    }

}