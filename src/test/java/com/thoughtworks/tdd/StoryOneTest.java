package com.thoughtworks.tdd;

import com.thoughtworks.entity.Car;
import com.thoughtworks.entity.ParkingBoy;
import com.thoughtworks.entity.ParkingLot;
import com.thoughtworks.entity.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StoryOneTest {
    @Test
    public void should_get_car_use_ticket_by_car() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket ticket=parkingLot.createTicketByCar(car);
        Car reCar=parkingBoy.getCarByTicket(ticket);

        //then
        assertThat(reCar, is(car));
    }
    @Test
    public void should_get_multiple_car_use_ticket_by_multiple_car() {
        //given
        Car firstCar =new Car();
        Car secondCar =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket firstTicket=parkingLot.createTicketByCar(firstCar);
        Ticket secondTicket=parkingLot.createTicketByCar(secondCar);
        Car reFirstCar=parkingBoy.getCarByTicket(firstTicket);
        Car reSecondCar=parkingBoy.getCarByTicket(secondTicket);

        //then
        assertThat(reFirstCar, is(firstCar));
        assertThat(reSecondCar, is(secondCar));
    }
    @Test
    public void should__use_wrong_ticket_fetch_car() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket ticket=parkingLot.createTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        Car reCar=parkingBoy.getCarByTicket(wrongTicket);

        //then
        assertThat(null, is(reCar));
    }
    @Test
    public void should__use_have_used_ticket_can_not_fetch_car() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket ticket=parkingLot.createTicketByCar(car);
        Car reFirstCar=parkingBoy.getCarByTicket(ticket);
        Car reSecondCar=parkingBoy.getCarByTicket(ticket);

        //then
        assertThat(car, is(reFirstCar));
        assertThat(null, is(reSecondCar));
    }
}
