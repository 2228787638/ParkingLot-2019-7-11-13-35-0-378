package com.thoughtworks.tdd;

import com.thoughtworks.entity.*;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StorySixTest {
    @Test
    public void should_can_fetch_car_with_specify_parkingboy_by_manager() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy =new ParkingBoy();
        //添加parkingboy到管理列表
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        //parkingManager指定parking boy停车
        Ticket ticket=parkingManager.getParkingBoys().get(0).returnTicketByCar(car);
        //parkingManager指定parking boy取车
        Car reCar = parkingManager.getParkingBoys().get(0).getCarByTicket(ticket);
        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_can_park_and_fetch_car_by_manager() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        Car car = new Car();
        //when
        //parkingManager停车
        Ticket ticket=parkingManager.returnTicketByCar(car);
        //parkingManager取车
        Car reCar = parkingManager.getCarByTicket(ticket);
        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_return_message_can_use_wrong_ticket_by_manager_tells_boy() {
        //given
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        //添加parkingboy到管理列表
        parkingManager.getParkingBoys().add(parkingBoy);
        Car car = new Car();
        //when
        //use wrong ticket to fetch car
        //parkingManager指定parkingboy停车
        Ticket ticket=parkingManager.getParkingBoys().get(0).returnTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        //parkingManager指定parkingboy取车.use wrong ticket
        String message = parkingManager.getParkingBoys().get(0).searchMessageByTicket(wrongTicket);
        parkingManager.setMessage(message);
        //then
        //use wrong ticket to fetch car
        assertThat("Unrecognized parking ticket.", is(parkingManager.getMessage()));

    }
}
