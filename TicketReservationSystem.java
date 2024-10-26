import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Ticket {
    private int ticketNumber;
    private String passengerName;
    private boolean isReserved;

    public Ticket(int ticketNumber, String passengerName) {
        this.ticketNumber = ticketNumber;
        this.passengerName = passengerName;
        this.isReserved = false;
    }

    public int getTicketNumber() {
        return ticketNumber;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public boolean isReserved() {
        return isReserved;
    }

    public void reserve() {
        isReserved = true;
    }

    public void cancelReservation() {
        isReserved = false;
    }
}

class ReservationSystem {
    private List<Ticket> tickets;

    public ReservationSystem() {
        tickets = new ArrayList<>();
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    public void reserveTicket(int ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                if (!ticket.isReserved()) {
                    ticket.reserve();
                    System.out.println("Ticket " + ticketNumber + " has been reserved for " + ticket.getPassengerName());
                } else {
                    System.out.println("Ticket " + ticketNumber + " is already reserved.");
                }
                return;
            }
        }
        System.out.println("Ticket " + ticketNumber + " not found.");
    }

    public void cancelReservation(int ticketNumber) {
        for (Ticket ticket : tickets) {
            if (ticket.getTicketNumber() == ticketNumber) {
                if (ticket.isReserved()) {
                    ticket.cancelReservation();
                    System.out.println("Reservation for Ticket " + ticketNumber + " has been canceled.");
                } else {
                    System.out.println("Ticket " + ticketNumber + " is not reserved.");
                }
                return;
            }
        }
        System.out.println("Ticket " + ticketNumber + " not found.");
    }
}

public class TicketReservationSystem {
    public static void main(String[] args) {
        ReservationSystem reservationSystem = new ReservationSystem();

        // Creating sample tickets
        Ticket ticket1 = new Ticket(101, "John Doe");
        Ticket ticket2 = new Ticket(102, "Jane Smith");
        Ticket ticket3 = new Ticket(103, "David Johnson");

        // Adding tickets to the reservation system
        reservationSystem.addTicket(ticket1);
        reservationSystem.addTicket(ticket2);
        reservationSystem.addTicket(ticket3);

        // User interaction
        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("1. Reserve a ticket");
            System.out.println("2. Cancel a reservation");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the ticket number: ");
                    int ticketNumberToReserve = scanner.nextInt();
                    reservationSystem.reserveTicket(ticketNumberToReserve);
                    break;
                case 2:
                    System.out.print("Enter the ticket number: ");
                    int ticketNumberToCancel = scanner.nextInt();
                    reservationSystem.cancelReservation(ticketNumberToCancel);
                    break;
                case 3:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
            System.out.println();
        }

        scanner.close();
    }
}
