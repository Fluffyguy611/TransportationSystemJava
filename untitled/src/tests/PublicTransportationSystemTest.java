package tests;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;
import interfaces.Types;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PublicTransportationSystemTest {

    @Test
    void addLines() {

        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        system.addLines(bus);
        Assertions.assertNotNull(system.getLines());
        Assertions.assertEquals(1, system.getLines().size());

    }

    @Test
    void delLines() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        system.addLines(bus);
        system.delLines(bus);
        Assertions.assertEquals(0, system.getLines().size());
    }

    @Test
    void addStation() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        system.addStation(station);
        Assertions.assertNotNull(system.getStationNames());
        Assertions.assertEquals(1, system.getStationNames().size());
    }

    @Test
    void delStations() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Station station = new Station("Wojska polskiego", Types.BUS);
        system.addStation(station);
        system.delStations(station);
        Assertions.assertEquals(0, system.getStationNames().size());
    }

    @Test
    void getTransportationTypes() {
        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        system.addLines(bus);
        Assertions.assertTrue(system.getTransportationTypes().contains(Types.BUS));
    }

    @Test
    void compareTo() {
        PublicTransportationSystem system1 = new PublicTransportationSystem("Gdanskie autobusy");
        PublicTransportationSystem system2 = new PublicTransportationSystem("Gdanskie pociągi");
        Autobus bus = new Autobus(system1);
        Autobus bus2 = new Autobus(system1);
        Station station = new Station("Wojska polskiego", Types.BUS);
        system1.addLines(bus);
        system1.addLines(bus2);
        system1.addStation(station);

        Assertions.assertEquals(1, system1.compareTo(system2));

    }

    @Test
    void systemToString() {
        PublicTransportationSystem system1 = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system1);
        Station station = new Station("Wojska polskiego", Types.BUS);
        system1.addLines(bus);
        system1.addStation(station);

        Assertions.assertEquals("Gdanskie autobusy having " +
                "[BUS] and 1 lines and 1 stations", system1.toString());
    }
}