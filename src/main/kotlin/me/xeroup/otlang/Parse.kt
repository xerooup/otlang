package me.xeroup.otlang

import me.xeroup.otlang.Data.brush
import me.xeroup.otlang.Data.brushSize
import me.xeroup.otlang.Data.column
import me.xeroup.otlang.Data.row

import java.awt.Color
import kotlin.system.exitProcess

fun parse(text: String) {
    var line = 0;
    for (rawCommand in text.split(" ", "\n")) {
        line++
        val command = if (rawCommand.startsWith("0x")) { // allows writing 0x before a function
            rawCommand.substring(2)
        } else {
            rawCommand
        }

        when (command) {
            /**
             * Moving the pointer
             */

            // right
            "0" -> {
                row++
                if (row !in 0..511) {
                    row = 0
                }
            }
            // left
            "1" -> {
                row--
                if (row !in 0..511) {
                    row = 0
                }
            }
            // down
            "01" -> {
                column++
                if (column !in 0..511) {
                    column = 0
                }
            }
            // up
            "10" -> {
                column--
                if (column !in 0..511) {
                    column = 0
                }
            }

            /**
             * Drawing
            */

            "001" -> {
                draw(Color.WHITE)
            }
            "010" -> {
                draw(Color.BLACK)
            }
            "011" -> {
                draw(Color.YELLOW)
            }
            "100" -> {
                draw(Color.RED)
            }
            "101" -> {
                draw(Color.BLUE)
            }
            "111" -> {
                draw(Color.GREEN)
            }

            /**
             * Brush
            */

            "0001" -> {
                brush++
                if (brush !in 0..1) {
                    brush = 0
                }
            }
            "0010" -> {
                brushSize++
                if (brushSize !in 0..511) {
                    brushSize = 0
                }
            }
            "0011" -> {
                brushSize--
                if (brushSize !in 0..511) {
                    brushSize = 0
                }
            }

            "" -> {}

            else -> {
                println("$command??? bro, i don't know what this is")
                exitProcess(1)
            }
        }
    }
}