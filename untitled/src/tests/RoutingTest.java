package tests;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Routing;
import TransportClasses.Station;
import interfaces.Types;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoutingTest {

    @Test
    void routingBetweenStations() {
        Station station1 = new Station("Przystanek", Types.BUS);
        Station station2 = new Station("Przystanek 2", Types.BUS);

        PublicTransportationSystem system = new PublicTransportationSystem("Gdanskie autobusy");
        Autobus bus = new Autobus(system);
        station1.addLines(bus);
        station2.addLines(bus);

        Assertions.assertEquals("Routing between: Przystanek and Przystanek 2 possible via line BUS 1",
                Routing.routingBetweenStations(station1, station2));
    }

    @Test
    void isStationSameType() {
        Station station1 = new Station("Przystanek", Types.BUS);
        Station station2 = new Station("Przystanek 2", Types.BUS);

        Assertions.assertTrue(Routing.isStationSameType(station1, station2));
    }

    @Test
    void isStationNotSameType() {
        Station station1 = new Station("Przystanek", Types.BUS);
        Station station2 = new Station("Przystanek 2", Types.TRAM);

        Assertions.assertFalse(Routing.isStationSameType(station1, station2));
    }
}