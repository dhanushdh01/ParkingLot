package main.Models;

import main.Models.Enums.GateStatus;
import main.Models.Enums.GateType;

public class Gate extends BaseModel {
    private int gateNumber;
    private GateType gateType;
    private GateStatus gateStatus;
    private String operatorName;

    public Gate() {
    }

    public Gate(String operatorName, GateStatus gateStatus, GateType gateType, int gateNumber) {
        this.operatorName = operatorName;
        this.gateStatus = gateStatus;
        this.gateType = gateType;
        this.gateNumber = gateNumber;
    }

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }
}
