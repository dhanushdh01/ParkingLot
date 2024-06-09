package main.Models;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Ticket extends BaseModel {
    private LocalDateTime entryTime;
    private Gate entryGate;
    private Vehicle vehicle;
    private ParkingSpot parkingSpot;

    public Ticket() {
    }

    public Ticket(LocalDateTime entryTime, Gate entryGate, Vehicle vehicle, ParkingSpot parkingSpot) {
        this.entryTime = entryTime;
        this.entryGate = entryGate;
        this.vehicle = vehicle;
        this.parkingSpot = parkingSpot;
    }

    @Override
    public String toString() {
        return " { " +
                " \nTicketId = " + getId() +
                ", \nEntryTime = " + DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss z").format(entryTime) +
                ", \nVehicleNumber = " + vehicle.getVehicleNumber() +
                ", \nParkingSpot = " + parkingSpot.getNumber() +
                ", \nEntryGate = " + entryGate.getGateNumber() +
                "\n }";
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(LocalDateTime entryTime) {
        this.entryTime = entryTime;
    }

    public Gate getEntryGate() {
        return entryGate;
    }

    public void setEntryGate(Gate entryGate) {
        this.entryGate = entryGate;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }
}
