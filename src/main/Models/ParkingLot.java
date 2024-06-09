package main.Models;

import main.Models.Enums.ParkingLotStatus;
import main.Models.Enums.VehicleType;
import main.Strategies.BillCalculationStrategy.BillCalculationStrategy;
import main.Strategies.SpotAllocationStrategy.SpotAllocationStrategy;

import java.util.List;

public class ParkingLot extends BaseModel {
    private String name;
    private int capacity;
    private String address;
    private ParkingLotStatus parkingLotStatus;
    private List<ParkingFloor> parkingFloors;
    private List<VehicleType> vehicleTypes;
    private BillCalculationStrategy billCalculationStrategy;
    private SpotAllocationStrategy spotAllocationStrategy;

    public ParkingLot() {
    }

    public ParkingLot(String name, int capacity, String address, ParkingLotStatus parkingLotStatus, List<ParkingFloor> parkingFloors,
                      List<VehicleType> vehicleTypes, BillCalculationStrategy billCalculationStrategy,
                      SpotAllocationStrategy spotAllocationStrategy) {
        this.name = name;
        this.capacity = capacity;
        this.address = address;
        this.parkingLotStatus = parkingLotStatus;
        this.parkingFloors = parkingFloors;
        this.vehicleTypes = vehicleTypes;
        this.billCalculationStrategy = billCalculationStrategy;
        this.spotAllocationStrategy = spotAllocationStrategy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public BillCalculationStrategy getBillCalculationStrategy() {
        return billCalculationStrategy;
    }

    public void setBillCalculationStrategy(BillCalculationStrategy billCalculationStrategy) {
        this.billCalculationStrategy = billCalculationStrategy;
    }

    public SpotAllocationStrategy getSpotAllocationStrategy() {
        return spotAllocationStrategy;
    }

    public void setSpotAllocationStrategy(SpotAllocationStrategy spotAllocationStrategy) {
        this.spotAllocationStrategy = spotAllocationStrategy;
    }
}
