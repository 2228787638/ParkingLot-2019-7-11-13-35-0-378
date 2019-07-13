package com.thoughtworks.tdd;

import com.thoughtworks.entity.Car;
import com.thoughtworks.entity.ParkingBoy;
import com.thoughtworks.entity.ParkingLot;
import com.thoughtworks.entity.Ticket;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class StroyTwoTest {
    @Test
    public void should__use_wrong_ticket_can_return_unrecognized_mesage() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        Ticket ticket=parkingLot.createTicketByCar(car);
        Ticket wrongTicket=new Ticket();
        String message=parkingBoy.searchMessageByTicket(wrongTicket);
        //then
        assertThat("Unrecognized parking ticket.", is(message));
    }
    @Test
    public void should__use_hava_used_ticket_can_return_unrecognized_mesage() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when

        Ticket ticket=parkingLot.createTicketByCar(car);
        Car reFirstCar=parkingBoy.getCarByTicket(ticket);
        String message=parkingBoy.searchMessageByTicket(ticket);

        //then
        assertThat(car, is(reFirstCar));
        assertThat("Unrecognized parking ticket.", is(message));
    }
    @Test
    public void should_have_no_ticket_fetch_car_can_return_please_provide_ticket() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        String message=parkingBoy.searchMessageByTicket();
        //then
        assertThat("Please provide your parking ticket.", is(message));
    }

    @Test
    public void should_have_no_position_park_car_can_return_not_enough_position() {
        //given
        Car car =new Car();
        ParkingBoy parkingBoy =new ParkingBoy();
        ParkingLot parkingLot = new ParkingLot();
        //when
        for(int i=0;i<=10;i++) {
            parkingLot.createTicketByCar(new Car());
        }
        String message=parkingBoy.searchMessageByCar(car);
        //then
        assertThat("Not enough position.", is(message));
    }


}
