package main.Exceptions;

public class ParkingSpotNotFoundForVechicleException extends RuntimeException {
    public ParkingSpotNotFoundForVechicleException(){

    }

    public ParkingSpotNotFoundForVechicleException(String message){
        super(message);
    }
}
