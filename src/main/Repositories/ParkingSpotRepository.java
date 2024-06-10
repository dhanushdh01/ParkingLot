package main.Repositories;

import main.Exceptions.ParkingSpotNotFoundException;
import main.Models.ParkingSpot;

import java.util.HashMap;
import java.util.Map;

public class ParkingSpotRepository {
    private Map<Integer, ParkingSpot> parkingSpotMap;

    public ParkingSpotRepository() {
        this.parkingSpotMap = new HashMap<>();
    }

    public ParkingSpot get(int parkingSpotId) {
        ParkingSpot parkingSpot = parkingSpotMap.get(parkingSpotId);
        if(parkingSpot == null){
            throw new ParkingSpotNotFoundException("Enter a Valid Id , the id you " + parkingSpotId +" entered is not found ! ");
        }
        return parkingSpot;
    }

    public void put(ParkingSpot parkingSpot){
        parkingSpotMap.put(parkingSpot.getId(),parkingSpot);
        System.out.println("ParkingSpot has been added successfully");
    }
}
