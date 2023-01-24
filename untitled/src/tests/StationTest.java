package tests;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;
import interfaces.Types;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StationTest {

    @Test
    void addLines() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        Autobus bus1 = new Autobus(system);

        station.addLines(bus1);

        Assertions.assertEquals(1, station.getLines().size());

    }

    @Test
    void delLines() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        station.delLines(bus1);


        Assertions.assertEquals(0, station.getLines().size());

    }

    @Test
    void compareTo() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        Station station2 = new Station("Galeria bałtycka", Types.TRAM);
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        Assertions.assertEquals(1, station.compareTo(station2));
    }

    @Test
    void testToString() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        Autobus bus1 = new Autobus(system);
        station.addLines(bus1);

        Assertions.assertEquals("Wojska polskiego serving BUS", station.toString());
    }
}