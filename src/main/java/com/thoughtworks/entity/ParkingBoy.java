package com.thoughtworks.entity;

public class ParkingBoy {
    private ParkingLot parkingLot;
    private String message;
    public ParkingBoy() {
        parkingLot=new ParkingLot();
    }

    public Car getCarByTicket(Ticket ticket){
        return parkingLot.getCarByTicket(ticket);
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
        if(parkingLot.createTicketByCar(car)==null){
            return "Not enough position.";
        }
       return null;
    }

}
