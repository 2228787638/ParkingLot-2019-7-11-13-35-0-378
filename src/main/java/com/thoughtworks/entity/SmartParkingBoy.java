package com.thoughtworks.entity;

import java.util.List;

public class SmartParkingBoy extends ParkingBoy{

    public SmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket returnTicketByCar(Car car){
        ParkingLot maxParkingLot=null;
        //找出剩余空位最多的停车场
        for(ParkingLot parkingLot:parkingLotList) {
            if(maxParkingLot==null) {
                maxParkingLot = parkingLot;
            }
            if(parkingLot.getParkLot().size() < 10&&parkingLot.getParkLot().size() <= maxParkingLot.getParkLot().size()){
                maxParkingLot=parkingLot;
            }
        }
        for(ParkingLot parkingLot:parkingLotList) {
            if (maxParkingLot==parkingLot) {
                Ticket ticket = new Ticket();
                parkingLot.getParkLot().put(ticket, car);
                return ticket;
            }
        }
        return null;
    }
}
