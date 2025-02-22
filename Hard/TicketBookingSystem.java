import java.util.concurrent.locks.*;

class TicketBookingSystem {
    private int seats = 10; // Total available seats
    private final Lock lock = new ReentrantLock();

    public void bookTicket(String name) {
        lock.lock();
        try {
            if (seats > 0) {
                System.out.println(name + " booked seat " + seats);
                seats--;
            } else {
                System.out.println(name + " failed to book: No seats left");
            }
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        TicketBookingSystem system = new TicketBookingSystem();
        
        Thread vip1 = new Passenger(system, "VIP1", Thread.MAX_PRIORITY);
        Thread vip2 = new Passenger(system, "VIP2", Thread.MAX_PRIORITY);
        Thread user1 = new Passenger(system, "User1", Thread.NORM_PRIORITY);
        Thread user2 = new Passenger(system, "User2", Thread.NORM_PRIORITY);
        Thread user3 = new Passenger(system, "User3", Thread.MIN_PRIORITY);

        vip1.start();
        vip2.start();
        user1.start();
        user2.start();
        user3.start();
    }
}

class Passenger extends Thread {
    TicketBookingSystem system;

    public Passenger(TicketBookingSystem system, String name, int priority) {
        super(name);
        this.system = system;
        setPriority(priority);
    }

    public void run() {
        system.bookTicket(getName());
    }
}
