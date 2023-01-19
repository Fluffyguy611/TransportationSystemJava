package TransportClasses;

import interfaces.TransportType;
import interfaces.Types;

import java.lang.module.FindException;
import java.util.ArrayList;
import java.util.Hashtable;

public class Autobus implements TransportType {
    private String name;
    private final Types type;
    private int number;

    private int amountOfStations;

    private final PublicTransportationSystem systemName;

    private ArrayList<String> Stations;

    private Hashtable<Station, Integer> stationsOnLine;

    public Autobus(PublicTransportationSystem system) {
        this.type = Types.BUS;
        this.name = name();
        this.systemName = system;
        number();
        this.amountOfStations = 0;
    }


    public Hashtable<Station, Integer> addStationOnLine(Station station) {
        if (!stationsOnLine().containsKey(station) && checkIfLineStationSameType(this, station)) {
            this.amountOfStations++;
            this.stationsOnLine.put(station, this.amountOfStations);
            station.addLines(this.number);
            return stationsOnLine;
        }
        throw new FindException("Station cannot be added");
    }
    public Hashtable<Station, Integer> delStationOnLine(Station station) {
        if (stationsOnLine().containsKey(station)) {
            this.amountOfStations--;
            this.stationsOnLine.remove(station);
            station.delLines(this.number);
            return stationsOnLine;
        }
        throw new FindException("Station is not present on this line");
    }
    @Override
    public String name() {
        if (this.type.equals(Types.BUS)) {
            this.name = "BUS " + this.number;
        }
        return name;
    }

    @Override
    public void setNumber(PublicTransportationSystem system) {
        int number = 1;
        int i = 0;
        while (i < 1000) {
            if (this.systemName.getLines().containsValue(number)) {
                this.number = number;
            } else {
                number++;
                i++;
            }
        }
        throw new ArithmeticException("Too many lines in the system");
    }

    @Override
    public ArrayList<String> stationNames() {
        return Stations;
    }

    @Override
    public Hashtable<Station, Integer> stationsOnLine() {
        return stationsOnLine;
    }
    @Override
    public boolean checkIfLineStationSameType(Autobus bus, Station station){
        return bus.type.equals(station.type());
    }
    @Override
    public PublicTransportationSystem system() {
        return systemName;
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
    public ArrayList<String> getStations() {
        return Stations;
    }

    public void delStations(String station){
        this.Stations.remove(station);
    }

    public String toString(){
        return this.type + " number " + this.number + " serving " + this.stationsOnLine;
    }

}
