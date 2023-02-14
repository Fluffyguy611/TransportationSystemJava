package TransportClasses;

import interfaces.TransportType;
import interfaces.Types;

import java.lang.module.FindException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;

import static java.util.Collections.*;

public class Autobus implements TransportType {
    private String name;
    private final Types type;
    private final int number;

    private int amountOfStations;

    private final PublicTransportationSystem systemName;

    private final Hashtable<Station, Integer> stationsOnLine;
    private ArrayList<LocalTime> schedule = new ArrayList<>();

    public ArrayList<LocalTime> getSchedule() {
        return schedule;
    }

    @Override
    public void setSchedule(ArrayList<LocalTime> schedule) {
        this.schedule = schedule;
        this.sortSchedule();
    }

    @Override
    public void sortSchedule() {
        Collections.sort(schedule);
    }


    public void addSingleSchedule(LocalTime time){
        this.schedule.add(time);
        this.sortSchedule();
    }

    public void delSingleSchedule(LocalTime time){
        this.schedule.remove(time);
        this.sortSchedule();
    }



    public Autobus(PublicTransportationSystem system) {
        this.type = Types.BUS;
        this.systemName = system;
        this.number = setNumber(system);
        this.name = name();
        this.amountOfStations = 0;
        this.stationsOnLine = new Hashtable<>();
        system.addLines(this);
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
        try {
            if (stationsOnLine().containsKey(station)) {
                this.amountOfStations--;
                this.stationsOnLine.remove(station);
                station.delLines(this);
                return stationsOnLine;
            }
            else{
                throw new FindException("Station not found on this line");

                }
        }
        catch (FindException e){
            return stationsOnLine;
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
        int i = 1;
        List<TransportType> temp_buses = system.getLines();
        List<Integer> numbers = new ArrayList<>();
        for (TransportType bus: temp_buses) {
            numbers.add(bus.number());
        }
        while (i < 1000) {
            if (temp_buses.size() == 0) {
                return number;
            } else if (numbers.contains(number)) {
                number++;
                i++;
            }
            else{
                return number;
            }
        }
        throw new ArithmeticException("Too many lines in the system");
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

    public String toString(){
        return this.type + " number " + this.number + " serving " + this.stationsOnLine.size() + " stations";
    }

}
