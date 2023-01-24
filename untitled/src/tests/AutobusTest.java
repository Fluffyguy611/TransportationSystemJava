package tests;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;
import interfaces.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AutobusTest {

    @Test
    void addStationOnLine() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Station station = new Station("Wojska polskiego", Types.BUS);
        bus.addStationOnLine(station);

        Assertions.assertEquals(1, bus.stationsOnLine().size());


    }

    @Test
    void delStationOnLine() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Station station = new Station("Wojska polskiego", Types.BUS);
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

        Assertions.assertEquals(1, number);
    }

    @Test
    void checkIfLineStationSameType() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Station station = new Station("Przystanek", Types.TRAM);
        Assertions.assertFalse(bus.checkIfLineStationSameType(bus, station));
    }

    @Test
    void testToString() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        Station station = new Station("Przystanek", Types.BUS);
        bus.addStationOnLine(station);

        Assertions.assertEquals("BUS number 1 serving 1 stations", bus.toString());
    }
}