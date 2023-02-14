import interfaces.*;
import TransportClasses.*;
import java.lang.System;
public class Main {
    public static void main(String[] args) {
        PublicTransportationSystem Gdansk = new PublicTransportationSystem("Gdańskie autobusy");
        AutobusStation station1 = new AutobusStation("Gdańsk Główny");
        AutobusStation station2 = new AutobusStation("Podwale Grodzicie");
        AutobusStation station3 = new AutobusStation("Hucisko");
        AutobusStation station4 = new AutobusStation("Targ Rybny");
        AutobusStation station5 = new AutobusStation("Wały Jagiellońskie");
        AutobusStation station6 = new AutobusStation("Trakt św. Wojciecha");
        AutobusStation station7 = new AutobusStation("Grunwaldzka");
        AutobusStation station8 = new AutobusStation("Chopina");
        AutobusStation station9 = new AutobusStation("Powstańców Warszawy");
        AutobusStation station10 = new AutobusStation("Pruszcz Gdański Osiedle Wschód");
        UndergroundStation station11 = new UndergroundStation("Dworzec główny - metro", Types.METRO);
        station11.addAccessPoints("Ul. Domowskiego");
        Autobus autobus100 = new Autobus(Gdansk);
        Autobus autobus200 = new Autobus(Gdansk);
        Autobus autobus205 = new Autobus(Gdansk);
        autobus100.addStationOnLine(station1);
        autobus100.addStationOnLine(station2);
        autobus100.addStationOnLine(station3);
        autobus100.addStationOnLine(station4);
        autobus200.addStationOnLine(station1);
        autobus200.addStationOnLine(station5);
        autobus200.addStationOnLine(station6);
        autobus200.addStationOnLine(station7);
        autobus200.addStationOnLine(station10);
        autobus205.addStationOnLine(station1);
        autobus205.addStationOnLine(station4);
        autobus205.addStationOnLine(station6);
        autobus205.addStationOnLine(station8);
        autobus205.addStationOnLine(station9);
        autobus205.addStationOnLine(station10);
        System.out.println(autobus100);
        System.out.println(autobus200);
        System.out.println(autobus205);
        System.out.println(station1.toString());
        System.out.println(station10.toString());
        System.out.println(autobus100.toString());
        System.out.println(Routing.routingBetweenStations(station1, station4));
        System.out.println(Routing.routingBetweenStations(station2, station10));
    }
}