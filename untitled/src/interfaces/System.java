package interfaces;

import TransportClasses.Station;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface System {
    public String getName();
    public List<Types> getTransportationTypes();
    public List<TransportType> getLines();
    public HashMap<Station, List<TransportType>> getStationNames();

    public int compareTo(System system);
}
