package com.thoughtworks.entity;

import java.util.ArrayList;
import java.util.List;

public class ParkingBoy {
    protected List<ParkingLot> parkingLotList;
    protected String message;
    public ParkingBoy() {
        parkingLotList=new ArrayList<>();
        parkingLotList.add(new ParkingLot());
    }

    public ParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public List<ParkingLot> getParkingLotList() {
        return parkingLotList;
    }

    public void setParkingLotList(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Car getCarByTicket(Ticket ticket){
        for(ParkingLot parkingLot:parkingLotList){
            Car car = parkingLot.getParkLot().get(ticket);
            parkingLot.getParkLot().remove(ticket);
            return car;
        }
        return null;
    }
    public Ticket returnTicketByCar(Car car){
        for(ParkingLot parkingLot:parkingLotList) {
            if (parkingLot.getParkLot().size() < 10) {
                Ticket ticket = new Ticket();
                parkingLot.getParkLot().put(ticket, car);
                return ticket;
            }
        }
        return null;
    }
    public String searchMessageByTicket(Ticket ticket){
        if(getCarByTicket(ticket)==null){
            return "Unrecognized parking ticket.";
        }
        return null;
    }
    public String searchMessageByTicket(){
        return "Please provide your parking ticket.";
    }

    public String searchMessageByCar(Car car){
        for(ParkingLot parkingLot:parkingLotList) {
            if (returnTicketByCar(car) == null) {
                return "Not enough position.";
            }
        }
       return null;
    }

}
