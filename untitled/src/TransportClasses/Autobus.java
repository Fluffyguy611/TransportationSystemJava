package TransportClasses;

import interfaces.TransportType;
import interfaces.Types;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Autobus implements TransportType {
    private String name;
    private final Types type;
    private final int number;

    private int amountOfStations;

    private final PublicTransportationSystem systemName;

    private final List<Station> Stations;

    private final Hashtable<Station, Integer> stationsOnLine;

    public Autobus(PublicTransportationSystem system) {
        this.type = Types.BUS;
        this.name = name();
        this.systemName = system;
        this.number = setNumber(system);
        this.amountOfStations = 0;
        this.Stations = new ArrayList<>();
        this.stationsOnLine = new Hashtable<>();
    }


    public void addStationOnLine(Station station) {
        if (!stationsOnLine().containsKey(station) && checkIfLineStationSameType(this, station)) {
            this.amountOfStations++;
            this.stationsOnLine.put(station, this.amountOfStations);
            station.addLines(this);
        }
        else {
            throw new FindException("Station cannot be added");
        }
    }
    public Hashtable<Station, Integer> delStationOnLine(Station station) {
        if (stationsOnLine().containsKey(station)) {
            this.amountOfStations--;
            this.stationsOnLine.remove(station);
            station.delLines(this);
            return stationsOnLine;
        }
        else {
            throw new FindException("Station is not present on this line");
        }
    }
    @Override
    public String name() {
        if (this.type.equals(Types.BUS)) {
            this.name = "BUS " + this.number;
        }
        return name;
    }

    @Override
    public int setNumber(PublicTransportationSystem system) {
        int number = 1;
        int i = 0;
        while (i < 1000) {
            if (this.systemName.getLines() == null || !this.systemName.getLines().contains(this)) {
                return number;
            } else {
                number++;
                i++;
            }
        }
        throw new ArithmeticException("Too many lines in the system");
    }

    @Override
    public List<Station> stationNames() {
        return Stations;
    }

    @Override
    public Hashtable<Station, Integer> stationsOnLine() {
        return stationsOnLine;
    }
    @Override
    public boolean checkIfLineStationSameType(TransportType bus, Station station){
        return bus.type().equals(station.type());
    }
    @Override
    public PublicTransportationSystem system() {
        return systemName;
    }

    @Override
    public int compareTo(TransportType trType) {
        return Integer.compare(this.stationsOnLine.size(), trType.stationsOnLine().size());
    }

    @Override
    public Types type() {
        return Types.BUS;
    }

    @Override
    public int number() {
        return number;
    }

    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

    public int getNumber() {
        return number;
    }
    public List<Station> getStations() {
        return Stations;
    }

    public void delStations(Station station){
        this.Stations.remove(station);
    }

    public String toString(){
        return this.type + " number " + this.number + " serving " + this.stationsOnLine.size() + " stations";
    }

}
