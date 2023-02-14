package tests;

import TransportClasses.*;
import interfaces.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void addLines() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        AutobusStation station = new AutobusStation(("Wojska polskiego"));
        Autobus bus1 = new Autobus(system);

        station.addLines(bus1);

        Assertions.assertEquals(1, station.getLines().size());

    }

    @Test
    void delLines() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        AutobusStation station = new AutobusStation(("Wojska polskiego"));
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        station.delLines(bus1);


        Assertions.assertEquals(0, station.getLines().size());

    }

    @Test
    void compareTo() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        AutobusStation station = new AutobusStation(("Wojska polskiego"));
        UndergroundStation station1 = new UndergroundStation("Wojska polskiego", Types.METRO);
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        Assertions.assertEquals(1, station.compareTo(station1));
    }

    @Test
    void testToString() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        AutobusStation station = new AutobusStation(("Wojska polskiego"));
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        Assertions.assertEquals("Wojska polskiego serving BUS", station.toString());
    }
}
