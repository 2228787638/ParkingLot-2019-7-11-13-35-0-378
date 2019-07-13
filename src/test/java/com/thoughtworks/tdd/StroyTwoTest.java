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
}
