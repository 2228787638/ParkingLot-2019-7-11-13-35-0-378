package com.thoughtworks.entity;

public class ParkingBoy {
    private ParkingLot parkingLot;

    public ParkingBoy() {
        parkingLot=new ParkingLot();
    }

    public Car getCarByTicket(Ticket ticket){
        return parkingLot.getCarByTicket(ticket);
    }
}
