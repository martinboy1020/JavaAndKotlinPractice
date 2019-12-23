package trainticket

import java.text.DecimalFormat
import java.util.*
import kotlin.system.exitProcess

fun main(args : Array<String>) {
    startBuyTicket()
}

fun startBuyTicket() {

    var ticketNum: Int
    var roundTripNum: Int
    var scanner = Scanner(System.`in`)
    println("Please enter number of tickets")
    ticketNum = scanner.nextInt()

    if(ticketNum >= 0) {

        println("How many round-trip tickets : ")

        roundTripNum = scanner.nextInt()

        if(ticketNum > 0 && roundTripNum <= ticketNum) {
//            val ticket = BuyTicket(ticketNum, roundTripNum)
//            ticket.printTotalFee()
            BuyTicket(ticketNum, roundTripNum).printTotalFee()
            startBuyTicket()
        } else {
            println("You don't buy any ticket or round trip ticket is more than total ticket. \n Please try again.")
            startBuyTicket()
        }

    } else {
        exitProcess(0)
    }

}

class BuyTicket (private val totalTicket : Int, private val roundTripTicket : Int) {

    // 相當於Java中 類裡面的static變量
    companion object{
        var singleFee = 1000
        var roundTripTicketFee = 2000 * 0.9
    }

//    fun printTotalFee() {
//
//        println("Total Ticket: $totalTicket\nRound-trip: $roundTripTicket\nTotal: $totalPrice")
//
//    }

    private val totalPrice = DecimalFormat("0").format((totalTicket - roundTripTicket) * singleFee + roundTripTicket * roundTripTicketFee)
    fun printTotalFee() = println("Total Ticket: $totalTicket\nRound-trip: $roundTripTicket\nTotal: $totalPrice")

}
