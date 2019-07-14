package com.thoughtworks.entity;

import java.util.List;

public class SuperSmartParkingBoy extends  ParkingBoy{
    public SuperSmartParkingBoy(List<ParkingLot> parkingLotList) {
        this.parkingLotList = parkingLotList;
    }

    @Override
    public Ticket returnTicketByCar(Car car){
        ParkingLot parkLot=null;
        //找出剩余空位最多的停车场
        for(ParkingLot parkingLot:parkingLotList) {
            if(parkLot==null) {
                parkLot = parkingLot;
            }
            if(parkingLot.getParkLot().size()/parkingLot.getLotCount() <= parkLot.getParkLot().size()/parkLot.getLotCount()){
                parkLot=parkingLot;
            }
        }
        for(ParkingLot parkingLot:parkingLotList) {
            if (parkLot==parkingLot) {
                Ticket ticket = new Ticket();
                parkingLot.getParkLot().put(ticket, car);
                return ticket;
            }
        }
        return null;
    }
}
