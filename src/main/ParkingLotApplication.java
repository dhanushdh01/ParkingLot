package main;

import main.Controllers.InitController;
import main.Controllers.TicketController;
import main.Models.Enums.VehicleType;
import main.Models.ParkingLot;
import main.Models.Ticket;
import main.Models.Vehicle;
import main.Repositories.*;
import main.Services.InitialisationService;
import main.Services.TicketService;

import java.util.Scanner;

public class ParkingLotApplication {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingLotRepository parkingLotRepository = new ParkingLotRepository();
        ParkingSpotRepository parkingSpotRepository = new ParkingSpotRepository();
        ParkingFloorRepository parkingFloorRepository = new ParkingFloorRepository();
        GateRepository gateRepository = new GateRepository();
        TicketRepository ticketRepository = new TicketRepository();

        InitialisationService initialisationService = new InitialisationService(
                gateRepository,
                parkingLotRepository,
                parkingFloorRepository,
                parkingSpotRepository
        );

        TicketService ticketService = new TicketService(
                ticketRepository,
                parkingLotRepository,
                gateRepository,
                parkingSpotRepository
        );

        TicketController ticketController = new TicketController(ticketService);

        InitController initController = new InitController(initialisationService);
        System.out.println("***PARKING LOT DATA INITIALISATION - START");
        ParkingLot parkingLot = initController.init();
        System.out.println("***PARKING LOT DATA INITIALISATION - END");
        System.out.println("Please enter an option -> \n 1. Enter Parking Lot \n 2. Exit Parking Lot \n 3. Exit");
        int option = sc.nextInt();
        while (true) {
            if (option == 1) {
                Vehicle vehicle = new Vehicle();
                System.out.println("Welcome to our parking lot");
                System.out.println("Please enter the vehicle details");
                System.out.println("Please enter the vehicle number");
                String number = sc.next();
                vehicle.setVehicleNumber(number);
                System.out.println("Please enter the vehicle color");
                String color = sc.next();
                vehicle.setColor(color);
                System.out.println("Please choose the vehicle type -> 1. Car and 2. Bike");
                int vehicleType = sc.nextInt();
                if(vehicleType == 1){
                    vehicle.setVehicleType(VehicleType.FOUR_WHEELER);
                } else {
                    vehicle.setVehicleType(VehicleType.TWO_WHEELER);
                }
                System.out.println("Please enter the parkingLot ID");
                int parkingLotId = sc.nextInt();
                System.out.println("Please enter the gate ID");
                int gateId = sc.nextInt();
                Ticket ticket = ticketController.generateTicket(vehicle, gateId, parkingLotId);
                System.out.println("Ticket details :" + ticket);
            } else if (option == 2) {
                // ask user for ticketId, and gate ID
                // call billcontroller
                // print bill details
                // ask for payment method
                // mark the bill as paid, and done.
            } else {
                System.out.println("THANKS");
                break;
            }
        }
    }
}