package com.thoughtworks.entity;

import java.util.HashMap;

public class ParkingLot {
    private HashMap<Ticket,Car> parkLot;

    public HashMap<Ticket, Car> getParkLot() {
        return parkLot;
    }

    public void setParkLot(HashMap<Ticket, Car> parkLot) {
        this.parkLot = parkLot;
    }

    public ParkingLot() {
        parkLot =new HashMap<>();
    }


}
