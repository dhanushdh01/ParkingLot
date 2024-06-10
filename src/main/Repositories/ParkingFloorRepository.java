package main.Repositories;

import main.Exceptions.ParkingFloorNotFoundException;
import main.Models.ParkingFloor;

import java.util.HashMap;
import java.util.Map;

public class ParkingFloorRepository {
    // table
    private Map<Integer, ParkingFloor> parkingFloorMap;

    public ParkingFloorRepository() {
        this.parkingFloorMap = new HashMap<>();
    }

    public ParkingFloor get(int parkingFloorId) {
        ParkingFloor parkingFloor = parkingFloorMap.get(parkingFloorId);
        if(parkingFloor == null){
            throw new ParkingFloorNotFoundException("Enter a Valid Id , the id you " + parkingFloorId +" entered is not found ! ");
        }
        return parkingFloor;
    }

    public void put(ParkingFloor parkingFloor){
        parkingFloorMap.put(parkingFloor.getId(),parkingFloor);
        System.out.println("ParkingFloor has been added successfully");
    }
}
