package com.thoughtworks.entity;

import java.util.HashMap;

public class ParkingLot {
    private static HashMap<Ticket,Car> parkLot;

    public HashMap<Ticket, Car> getParkLot() {
        return parkLot;
    }

    public void setParkLot(HashMap<Ticket, Car> parkLot) {
        ParkingLot.parkLot = parkLot;
    }

    public ParkingLot() {
        parkLot =new HashMap<>();
    }

    public Ticket createTicketByCar(Car car){
        Ticket ticket= new Ticket();
        parkLot.put(ticket,car);
        return ticket;
    }
    public Car getCarByTicket(Ticket ticket){
        Car car = parkLot.get(ticket);
        parkLot.remove(ticket);
        return car;
    }

}
