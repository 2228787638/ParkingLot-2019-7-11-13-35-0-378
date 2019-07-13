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
}
