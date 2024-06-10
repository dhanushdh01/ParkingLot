package main.Exceptions;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(){

    }

    public TicketNotFoundException(String message) {
        super(message);
    }
}
