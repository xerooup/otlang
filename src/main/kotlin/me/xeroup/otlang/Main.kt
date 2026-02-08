package me.xeroup.otlang

import java.awt.image.BufferedImage
import java.io.File
import javax.imageio.ImageIO
import kotlin.system.exitProcess

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("usage: ./otlang <file>")
        exitProcess(1)
    }

    val file = File(args[0])

    if (!file.exists()) {
        println("file doesn't exist")
        exitProcess(1)
    }

    // removes comments from the code and turns it into a single line
    val lines = file.readLines().joinToString("\n") { it.substringBefore("//") }

    parse(lines)
    ImageIO.write(Data.canvas, "png", File("output.png"))
}