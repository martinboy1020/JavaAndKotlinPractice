package guessnumber

import java.text.DecimalFormat
import java.util.*

fun main() {
    startGame()
}

fun startGame() {

    val userNumber : Int
    val scanner = Scanner(System.`in`)

    println("Please enter one number between 1 to 10")
    userNumber = scanner.nextInt()

    if(userNumber in 1..10) {

        GuessNumber().judgeNumber(userNumber) {
            returnString, randomNum ->
            println(returnString)
            println("randomNum: $randomNum")
        }

    } else {
        println("Number Error")
        startGame()
    }

}

class GuessNumber {

    // Any代表可以傳出所以類型 如果要指定類型 就把Any改成想要指定的類型
    fun judgeNumber(userNumber : Int, callback : (Any, String) -> Unit) {

        val randomNum = (Math.random() * 10)

        when {

            userNumber > randomNum -> {
                callback("Your number is bigger than random number.", DecimalFormat("0").format(randomNum))
            }

            userNumber < randomNum -> {
                callback("Your number is smaller than random number.", DecimalFormat("0").format(randomNum))
            }

            else -> {
                callback("Your number is equal than random number.", DecimalFormat("0").format(randomNum))
            }

        }

    }

}