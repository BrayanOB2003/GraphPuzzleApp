package com.project.graphpuzzleapp

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.project.model.Game

class PaintGame(context: Context?, attrs: AttributeSet?) : View(context, attrs) {

    private lateinit var game: Game
    private var loaded: Boolean = false;

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        if(loaded){

            val game = this.game
            val figurePaint = Paint()



            val coordinatesXY: HashMap<Int, Int> = HashMap()
            val coordinatesX: ArrayList<Int> = ArrayList()

            val matrixGame: ArrayList<ArrayList<Int>> = game.matrixGame

            val txtPaint = Paint()
            txtPaint.color = Color.BLUE
            txtPaint.textSize = 40F

            coordinatesX.add(150)
            coordinatesXY[150] = 300

            val relativeLeft: Int = canvas?.width?.minus(151)!!

            coordinatesX.add(relativeLeft)
            coordinatesXY[relativeLeft] = 300

            val relativeCenter: Int = (relativeLeft + 150)/2

            coordinatesX.add(relativeCenter)
            coordinatesXY[relativeCenter] = 150

            val relativeDown: Int = canvas?.height?.minus(150)!!   //relative Y position, vertexes down

            coordinatesX.add(200)
            coordinatesXY[200] = relativeDown

            coordinatesX.add(relativeLeft + 1)
            coordinatesXY[relativeLeft + 1] = relativeDown - 150


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

    fun setGame(game: Game){
        this.game = game
        loaded = true;
    }

}