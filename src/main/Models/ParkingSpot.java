package main.Models;

import main.Models.Enums.ParkingSpotStatus;
import main.Models.Enums.VehicleType;

public class ParkingSpot extends BaseModel {
    private int number;
    private Vehicle vehicle;
    private VehicleType vehicleType;
    private ParkingSpotStatus parkingSpotStatus;

    public ParkingSpot() {
    }

    public ParkingSpot(int number, Vehicle vehicle, VehicleType vehicleType, ParkingSpotStatus parkingSpotStatus) {
        this.number = number;
        this.vehicle = vehicle;
        this.vehicleType = vehicleType;
        this.parkingSpotStatus = parkingSpotStatus;
    }
    @Override
    public String toString() {
        return "ParkingSpot { number = " + number + ", vehicle = " + vehicle + ", vehicleType = "
                + vehicleType + ", parkingSpotStatus = " + parkingSpotStatus + " }";
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }
}
