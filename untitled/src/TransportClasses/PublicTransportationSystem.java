package TransportClasses;
import interfaces.System;
import interfaces.Types;

import java.util.ArrayList;
import java.util.HashMap;


public class PublicTransportationSystem implements System{
    private final String name;
    private ArrayList<Types> TransportTypes;
    private HashMap<String, Integer> lines;
    private HashMap<String, ArrayList<Integer>> Stations;

    private Autobus bus;
    public PublicTransportationSystem(String name) {
        this.name = name;
    }

    public void addLinesBus(String name, Autobus bus){
        this.lines.put(name, bus.getNumber());
    }
    public void delLines(String name, Autobus bus){
        this.lines.remove(name, bus.getNumber());
    }
    public void addStation(String name, ArrayList<Integer> lines){
        this.Stations.put(name, lines);
    }
    public void delStations(String name){
        this.Stations.remove(name);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public ArrayList<Types> getTransportationTypes() {
        return this.TransportTypes;
    }

    @Override
    public HashMap<String, Integer> getLines() {
        return this.lines;
    }

    @Override
    public HashMap<String, ArrayList<Integer>> getStationNames() {
        return Stations;
    }

    public String toString(){
        return this.name + " having " + this.TransportTypes + " and " + this.lines.size()
                + " amount of lines and " + this.Stations.size() + " amount of stations";
    }
}
