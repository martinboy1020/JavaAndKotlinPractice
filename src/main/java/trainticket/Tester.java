package trainticket;

import java.util.Scanner;

public class Tester {

    public static void main (String[] args) {
        startBuyTicket();
    }

    private static void startBuyTicket() {

        int ticketNum;
        int roundTripNum;

        System.out.println("Please enter number of tickets");
        Scanner scanner = new Scanner(System.in);
        ticketNum = scanner.nextInt();

        if(checkTicketNum(ticketNum)) {

            System.out.println("How many round-trip tickets");
            roundTripNum = scanner.nextInt();

            Ticket ticket = new Ticket(ticketNum, roundTripNum);
            if(roundTripNum > 0 && roundTripNum <= ticketNum) {
                ticket.getTotal();
                startBuyTicket();
            } else {
                System.out.println("Round-trip tickets can not over than total ticket.");
                startBuyTicket();
            }

        } else {
            endBuyTicket();
        }

    }

    private static void endBuyTicket() {
        System.out.println("Finish Buy Ticket");
        System.exit(0);
    }

    private static boolean checkTicketNum(int ticketNum) {

//        if(ticketNum < 0)
//            System.out.println("Ticket Number must bigger then 0.");

        return ticketNum > 0;
    }

}

class Ticket {

    private int ticketNum;
    private int roundTripNum;
    private int singleTripNum;

    Ticket(int ticketNum, int roundTripNum) {

        this.ticketNum = ticketNum;
        this.roundTripNum = roundTripNum;
        singleTripNum = ticketNum - roundTripNum;
    }

    int getTicketNum() {
        return ticketNum;
    }

    int getRoundTripNum() {
        return roundTripNum;
    }

    void getTotal() {
        double single = 1000;
        double roundTrip = 2000 * 0.9;
        double total = 0;
        System.out.println("Total tickets: " + ticketNum);
        System.out.println("Round-trip: " + roundTripNum);
        total = (singleTripNum * single) + (roundTripNum * roundTrip);
        System.out.println("Total: " + total);
    }
}
