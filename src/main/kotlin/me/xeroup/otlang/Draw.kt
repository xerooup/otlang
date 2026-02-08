package me.xeroup.otlang

import me.xeroup.otlang.Data.brush
import me.xeroup.otlang.Data.brushSize
import me.xeroup.otlang.Data.canvas
import me.xeroup.otlang.Data.column
import me.xeroup.otlang.Data.row
import java.awt.Color

fun draw(color: Color) {
    val graphics = canvas.createGraphics()
    graphics.color = color
    when (brush) {
        0 -> graphics.fillRect(column, row, brushSize, brushSize)
        1 -> graphics.fillOval(column, row, brushSize * 2, brushSize * 2)
    }
}