package main.Services;

import main.Models.Enums.*;
import main.Models.Gate;
import main.Models.ParkingFloor;
import main.Models.ParkingLot;
import main.Models.ParkingSpot;
import main.Repositories.GateRepository;
import main.Repositories.ParkingFloorRepository;
import main.Repositories.ParkingLotRepository;
import main.Repositories.ParkingSpotRepository;

import java.util.ArrayList;
import java.util.List;

public class InitialisationService {
    private GateRepository gateRepository;
    private ParkingLotRepository parkingLotRepository;
    private ParkingFloorRepository parkingFloorRepository;
    private ParkingSpotRepository parkingSpotRepository;

    public InitialisationService(GateRepository gateRepository, ParkingLotRepository parkingLotRepository, ParkingFloorRepository parkingFloorRepository, ParkingSpotRepository parkingSpotRepository) {
        this.gateRepository = gateRepository;
        this.parkingLotRepository = parkingLotRepository;
        this.parkingFloorRepository = parkingFloorRepository;
        this.parkingSpotRepository = parkingSpotRepository;
    }

    public ParkingLot init(){
        System.out.println("Starting Initialising...");

        // Creating a parking Lot Object
        ParkingLot parkingLot = new ParkingLot();
        parkingLot.setId(1);
        parkingLot.setName("Parking Center ");
        parkingLot.setAddress("SomeWhere inside a costly mall");
        parkingLot.setParkingLotStatus(ParkingLotStatus.OPEN);
        parkingLot.setCapacity(100);
        parkingLot.setVehicleTypes(List.of(VehicleType.TWO_WHEELER,VehicleType.FOUR_WHEELER,VehicleType.EV_BIKE));

        List<ParkingFloor> floors = new ArrayList<>();
        //Running a loop to create a parking floor object
        for(int i = 1; i <= 10; i++) {
            ParkingFloor parkingFloor = new ParkingFloor();
            parkingFloor.setId(i);
            parkingFloor.setFloorNumber(i);
            parkingFloor.setParkingFloorStatus(ParkingFloorStatus.AVAILABLE);
            List<ParkingSpot> parkingSpots = new ArrayList<>();
            //for each floor to create parking spot objects
            for(int j = 1 ;j<= 10;j++){
                ParkingSpot parkingSpot = new ParkingSpot();
                parkingSpot.setId(j);
                parkingSpot.setNumber((i*100)+j);
                parkingSpot.setParkingSpotStatus(ParkingSpotStatus.EMPTY);
                parkingSpot.setVehicleType(VehicleType.TWO_WHEELER);
                parkingSpots.add(parkingSpot);
                parkingSpotRepository.put(parkingSpot);
            }
            parkingFloor.setParkingSpots(parkingSpots);
            //Creating entry gate object
            Gate entryGate = new Gate();
            entryGate.setId((i*1000)+1);
            entryGate.setGateNumber(i*100+1);
            entryGate.setGateStatus(GateStatus.OPEN);
            entryGate.setGateType(GateType.ENTRY);
            entryGate.setOperatorName("Operator : " + i + 1);
            parkingFloor.setEntryGate(entryGate);
            gateRepository.put(entryGate);

            //Creating exit gate object
            Gate exitGate = new Gate();
            exitGate.setId((i*1000)+2);
            exitGate.setGateNumber(i*100+2);
            exitGate.setGateStatus(GateStatus.OPEN);
            exitGate.setGateType(GateType.EXIT);
            exitGate.setOperatorName("Operator : " + i + 2);
            parkingFloor.setEntryGate(exitGate);
            gateRepository.put(exitGate);


            floors.add(parkingFloor);
            //adding the floor to floor list
            parkingFloorRepository.put(parkingFloor);
            //saving the floor to repository
        }
        parkingLot.setParkingFloors(floors);
        //adding floor list to parking lot
        parkingLotRepository.put(parkingLot);
        return parkingLotRepository.get(1);
    }
}
