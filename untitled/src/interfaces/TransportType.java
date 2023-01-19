package interfaces;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;

import java.util.ArrayList;
import java.util.Hashtable;

public interface TransportType {
    public String name();
    public Types type();
    public int number();

    void setNumber(PublicTransportationSystem system);

    public ArrayList<String> stationNames();

    public Hashtable<Station, Integer> stationsOnLine();

    boolean checkIfLineStationSameType(Autobus bus, Station station);

    public PublicTransportationSystem system();


}
