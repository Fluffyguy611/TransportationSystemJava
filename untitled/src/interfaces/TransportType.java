package interfaces;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;

import java.util.Hashtable;
import java.util.List;

public interface TransportType {
    public String name();
    public Types type();
    public int number();

    int setNumber(PublicTransportationSystem system);

    public List<Station> stationNames();

    public Hashtable<Station, Integer> stationsOnLine();

    boolean checkIfLineStationSameType(TransportType bus, Station station);

    public PublicTransportationSystem system();

    public int compareTo(TransportType trType);


}
