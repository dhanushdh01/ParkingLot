package main.Strategies.SpotAllocationStrategy;

import main.Models.ParkingLot;
import main.Models.ParkingSpot;
import main.Models.Vehicle;

public interface SpotAllocationStrategy {
    ParkingSpot getSpotForVehicle(ParkingLot parkingLot, Vehicle vehicle);
}
