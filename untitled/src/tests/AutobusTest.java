package tests;

import TransportClasses.*;
import interfaces.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class AutobusTest {

    @Test
    void addStationOnLine() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        AutobusStation station = new AutobusStation("Wojska polskiego");
        bus.addStationOnLine(station);

        Assertions.assertEquals(1, bus.stationsOnLine().size());


    }

    @Test
    void delStationOnLine() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        AutobusStation station = new AutobusStation("Wojska polskiego");
        bus.addStationOnLine(station);
        bus.delStationOnLine(station);

        Assertions.assertEquals(0, bus.stationsOnLine().size());
    }

    @Test
    void setNumberByCreatingBus() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);

        Assertions.assertEquals(1, bus.getNumber());
    }

    @Test
    void setNumber() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        int number = bus.setNumber(system);

        Assertions.assertEquals(2, number);
    }

    @Test
    void checkIfLineStationSameType() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        UndergroundStation station = new UndergroundStation("Przystanek", Types.TRAM);
        Assertions.assertFalse(bus.checkIfLineStationSameType(bus, station));
    }

    @Test
    void testToString() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        AutobusStation station = new AutobusStation("Wojska polskiego");
        bus.addStationOnLine(station);

        Assertions.assertEquals("BUS number 1 serving 1 stations", bus.toString());
    }

    @Test
    void getSchedule() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        bus.addSingleSchedule(LocalTime.NOON);
        
        Assertions.assertEquals(LocalTime.NOON, bus.getSchedule().get(0));
    }

    @Test
    void setSchedule() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        ArrayList<LocalTime> temp = new ArrayList<>();
        temp.add(LocalTime.NOON);
        temp.add(LocalTime.MIDNIGHT);
        bus.setSchedule(temp);

        Assertions.assertEquals(temp, bus.getSchedule());
    }

    @Test
    void sortSchedule() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        ArrayList<LocalTime> temp = new ArrayList<>();
        temp.add(LocalTime.MIDNIGHT);
        temp.add(LocalTime.NOON);
        temp.add(LocalTime.of(10, 42, 10));
        bus.setSchedule(temp);
        bus.sortSchedule();
        bus.addSingleSchedule(LocalTime.of(10, 42, 10));
        Assertions.assertEquals(temp, bus.getSchedule());
    }

    @Test
    void getName() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Autobus bus2 = new Autobus(system);
        Assertions.assertEquals("BUS 2", bus2.getName());
    }

    @Test
    void getType() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Assertions.assertEquals(Types.BUS, bus.getType());
    }

    @Test
    void getNumber() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Assertions.assertEquals(1, bus.getNumber());
    }

    @Test
    void getStations() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        AutobusStation busstation = new AutobusStation("wojska polskiego");
        bus.addStationOnLine(busstation);
        Assertions.assertEquals(1, bus.stationsOnLine().get(busstation));
    }

    @Test
    void compareTo() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Autobus bus2 = new Autobus(system);

        Assertions.assertEquals(0, bus.compareTo(bus2));
    }
}