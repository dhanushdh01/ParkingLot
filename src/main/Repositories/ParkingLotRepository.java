package main.Repositories;

import main.Exceptions.ParkingLotNotFoundException;
import main.Models.ParkingLot;

import java.util.HashMap;
import java.util.Map;

public class ParkingLotRepository {
    private Map<Integer, ParkingLot> parkingLotMap;
    private static int idCounter = 0 ;
    public ParkingLotRepository(){
        this.parkingLotMap = new HashMap<>();
    }

    public ParkingLot get(int parkingLotId){
        ParkingLot parkingLot = parkingLotMap.get(parkingLotId);
        if(parkingLot == null){
            throw new ParkingLotNotFoundException("Enter a Valid Id , the ID " + parkingLotId + " you entered is InValid !");
        }
        return parkingLot;
    }

    public void put(ParkingLot parkingLot) {
        parkingLotMap.put(parkingLot.getId(),parkingLot);
        parkingLot.setId(++idCounter);
        System.out.println("ParkingLot has Been Added Successfully");
    }
}
