package main.Services;

import main.Models.Enums.ParkingSpotStatus;
import main.Models.ParkingLot;
import main.Models.ParkingSpot;
import main.Models.Ticket;
import main.Models.Vehicle;
import main.Repositories.GateRepository;
import main.Repositories.ParkingLotRepository;
import main.Repositories.ParkingSpotRepository;
import main.Repositories.TicketRepository;
import main.Strategies.SpotAllocationStrategy.SpotAllocationStrategy;
import main.Strategies.SpotAllocationStrategy.SpotAllocationStrategyFactory;

import java.time.LocalDateTime;

public class TicketService {
    private TicketRepository ticketRepository;
    private ParkingLotRepository parkingLotRepository;
    private GateRepository gateRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public TicketService(TicketRepository ticketRepository, ParkingLotRepository parkingLotRepository, GateRepository gateRepository, ParkingSpotRepository parkingSpotRepository) {
        this.ticketRepository = ticketRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.gateRepository = gateRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public Ticket generateTicket(Vehicle vehicle,int gateId,int parkingLotId) {
        SpotAllocationStrategy spotAllocationStrategy = SpotAllocationStrategyFactory.getSpotAllocationStrategy();
        ParkingLot parkingLot = parkingLotRepository.get(parkingLotId);

        ParkingSpot allocatedSpot = spotAllocationStrategy.getSpotForVehicle(parkingLot,vehicle);
        allocatedSpot.setParkingSpotStatus(ParkingSpotStatus.OCCUPIED);
        allocatedSpot.setVehicle(vehicle);
        parkingSpotRepository.put(allocatedSpot);

        Ticket ticket =new Ticket();
        ticket.setEntryTime(LocalDateTime.now());
        ticket.setEntryGate(gateRepository.get(gateId));
        ticket.setParkingSpot(allocatedSpot);
        ticket.setVehicle(vehicle);
        return ticketRepository.put(ticket);
    }
}
