package main.Repositories;

import main.Exceptions.TicketNotFoundException;
import main.Models.Ticket;

import java.util.HashMap;
import java.util.Map;

public class TicketRepository {

    private Map<Integer, Ticket> ticketMap;
    private static int idCounter = 0 ;
    public TicketRepository(){
        this.ticketMap = new HashMap<>();
    }

    public Ticket get(int ticketId){
        Ticket ticket = ticketMap.get(ticketId);
        if(ticket == null){
            throw new TicketNotFoundException("Enter a Valid Id , the ID " + ticketId + " you entered is InValid !");
        }
        return ticket;
    }

    public Ticket put(Ticket ticket) {
        ticketMap.put(ticket.getId(),ticket);
        ticket.setId(++idCounter);
        System.out.println("ParkingLot has Been Added Successfully");
        return  ticketMap.get(idCounter);
    }
}
