package me.xeroup.otlang

import java.awt.Color
import java.awt.image.BufferedImage

object Data {
    var column = 0
    var row = 0
    var brush = 0
    var brushSize = 1
    val canvas = createCanvas()
}

fun createCanvas() : BufferedImage {
    val canvas = BufferedImage(512, 512, BufferedImage.TYPE_INT_RGB)
    val graphics = canvas.createGraphics()
    graphics.color = Color.WHITE
    graphics.fillRect(0, 0, 512, 512)
    return canvas
}