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
}
