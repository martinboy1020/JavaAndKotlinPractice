package boxchoose

import java.util.*

fun main(args : Array<String>) {

    val box3 = KBox3()
    val box5 = KBox5()
    val scanner = Scanner(System.`in`)
    println("Please enter object's length")
    val objectLength = scanner.nextFloat()
    println("Please enter object's width")
    val objectWidth = scanner.nextFloat()
    println("Please enter object's height")
    val objectHeight = scanner.nextInt()

    when {
        objectLength <= 0 || objectWidth <= 0 || objectHeight <= 0 -> {
            print("Object Error")
        }
        box3.validate(objectLength, objectWidth, objectHeight) -> {
            println("Box3")
        }
        box5.validate(objectLength, objectWidth, objectHeight) -> {
            println("Box5")
        }
        else -> {
            println("Both not")
        }
    }
}

// KBox3 extends KBox
class KBox3 : KBox(23f, 14f, 13f)

// KBox5 extends KBox
class KBox5 : KBox(39.5f, 27.5f, 23f)

open class KBox(private val boxLength: Float, private val boxWidth : Float, private val boxHeight : Float) {

    fun validate(objectLength : Float, objectWidth: Float, objectHeight: Int) : Boolean {
        return objectLength <= boxLength && objectWidth <= boxWidth && objectHeight <= boxHeight
    }
}

