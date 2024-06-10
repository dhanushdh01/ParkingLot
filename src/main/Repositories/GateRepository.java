package main.Repositories;

import main.Exceptions.GateNotFoundException;
import main.Models.Gate;

import java.util.HashMap;
import java.util.Map;

public class GateRepository {
    private Map<Integer, Gate> gateMap;

    public GateRepository() {
        this.gateMap = new HashMap<>();
    }

    public Gate get(int gateId){
        Gate gate = gateMap.get(gateId);
        if(gate == null){
            throw new GateNotFoundException("Please enter a valid gateId, Gate is not found for the given id : " + gateId);
        }
        return gate;
    }
    public void put(Gate gate){
        gateMap.put(gate.getId(),gate);
        System.out.println("Gate has been added successfully");
    }
}
