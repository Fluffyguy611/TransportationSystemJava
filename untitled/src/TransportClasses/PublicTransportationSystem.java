package TransportClasses;
import interfaces.System;
import interfaces.TransportType;
import interfaces.Types;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class PublicTransportationSystem implements System{
    private final String name;
    private final ArrayList<Types> transportTypes;
    private final List<TransportType> lines;
    private final HashMap<Station, List<TransportType>> Stations;

    private List<TransportType> AllLines;
    public PublicTransportationSystem(String name) {
        this.name = name;
        this.transportTypes = new ArrayList<>();
        this.lines = new ArrayList<TransportType>();
        this.Stations = new HashMap<Station, List<TransportType>>();
    }

    public void addLines(TransportType vehicle){
        this.lines.add(vehicle);
        if(!this.transportTypes.contains(vehicle.type())){
            this.transportTypes.add(vehicle.type());
        }
    }
    public void delLines(TransportType vehicle){
        this.lines.remove(vehicle);
    }
    public void addStation(Station station){
        this.Stations.put(station, station.getLines());
    }
    public void delStations(Station station){
        this.Stations.remove(station);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Types> getTransportationTypes() {
        return this.transportTypes;
    }

    @Override
    public List<TransportType> getLines() {
        return this.lines;
    }

    @Override
    public HashMap<Station, List<TransportType>> getStationNames() {
        return Stations;
    }

    @Override
    public int compareTo(System system) {
        return Integer.compare(this.lines.size() + this.Stations.size(),
                system.getLines().size()+system.getStationNames().size());
    }

    public String toString(){
        return this.name + " having " + this.transportTypes + " and " + this.lines.size()
                + " lines and " + this.Stations.size() + " stations";
    }
}
