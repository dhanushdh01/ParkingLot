package main.Controllers;

import main.Models.ParkingLot;
import main.Services.InitialisationService;

public class InitController {
    private InitialisationService initialisationService;
    public InitController(InitialisationService initialisationService) {
        this.initialisationService = initialisationService;
    }
    public ParkingLot init(){
        return initialisationService.init();
    }
}
