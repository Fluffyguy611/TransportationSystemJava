package tests;

import TransportClasses.*;
import interfaces.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class RoutingTest {

    @Test
    void routingBetweenStations() {
        AutobusStation station1 = new AutobusStation("Wojska polskiego");
        AutobusStation station2 = new AutobusStation("Wojska polskiego");

        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        station1.addLines(bus);
        station2.addLines(bus);

        Assertions.assertEquals("Routing between: Wojska polskiego and Wojska polskiego possible via line BUS 1",
                Routing.routingBetweenStations(station1, station2));
    }

    @Test
    void routingNotPossibleBetweenStations() {
        AutobusStation station1 = new AutobusStation("Wojska polskiego");
        AutobusStation station2 = new AutobusStation("Wojska polskiego");

        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        station1.addLines(bus);

        Assertions.assertEquals("Routing not possible",
                Routing.routingBetweenStations(station1, station2));
    }

    @Test
    void isStationSameType() {
        AutobusStation station1 = new AutobusStation("Wojska polskiego");
        AutobusStation station2 = new AutobusStation("Wojska polskiego");

        Assertions.assertTrue(Routing.isStationSameType(station1, station2));
    }

    @Test
    void isStationNotSameType() {
        AutobusStation station1 = new AutobusStation("Wojska polskiego");
        UndergroundStation station2 = new UndergroundStation("Podziemia", Types.METRO);

        Assertions.assertFalse(Routing.isStationSameType(station1, station2));
    }

    @Test
    void getScheduleOfTransportType() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        bus.addSingleSchedule(LocalTime.of(10, 43, 12));
        ArrayList<LocalTime> temp = new ArrayList<>();
        temp.add(LocalTime.of(10, 43, 12));
        Assertions.assertEquals(temp, Routing.getScheduleOfTransportType(bus));

    }

    @Test
    void getScheduleBetweenDates() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        bus.addSingleSchedule(LocalTime.of(10, 43, 12));
        ArrayList<LocalTime> temp = new ArrayList<>();
        temp.add(LocalTime.of(10, 43, 12));
        Assertions.assertEquals(temp, Routing.getScheduleBetweenDates(bus,
                LocalTime.of(9, 50, 50), LocalTime.of(11, 50, 0)));
    }


    @Test
    void getNearestSchedule() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        bus.addSingleSchedule(LocalTime.of(10, 43, 12));
        LocalTime temp = LocalTime.now();
        Assertions.assertTrue(temp.isAfter(Routing.getNearestSchedule(bus)));
    }
}