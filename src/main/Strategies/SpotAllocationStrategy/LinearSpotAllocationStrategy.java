package main.Strategies.SpotAllocationStrategy;

import main.Exceptions.ParkingSpotNotFoundForVechicleException;
import main.Models.Enums.ParkingSpotStatus;
import main.Models.ParkingFloor;
import main.Models.ParkingLot;
import main.Models.ParkingSpot;
import main.Models.Vehicle;

import java.util.List;

public class LinearSpotAllocationStrategy implements SpotAllocationStrategy{
    @Override
    public ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle){
        List<ParkingFloor> parkingFloors = parkingLot.getParkingFloors();
        for(ParkingFloor parkingFloor : parkingFloors){
            for(ParkingSpot parkingSpot : parkingFloor.getParkingSpots()){
                if(parkingSpot.getParkingSpotStatus().equals(ParkingSpotStatus.EMPTY) && parkingSpot.getVehicleType().equals(vehicle.getVehicleType())){
                    return parkingSpot;
                }
            }
        }
        throw new ParkingSpotNotFoundForVechicleException("The Parking Spot is Currently Not Available !");
    }
}
