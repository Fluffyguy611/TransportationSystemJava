package interfaces;

import TransportClasses.Autobus;
import TransportClasses.PublicTransportationSystem;
import TransportClasses.Station;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public interface TransportType {
    public String name();
    public Types type();
    public int number();

    int setNumber(PublicTransportationSystem system);

    public Hashtable<Station, Integer> stationsOnLine();

    public ArrayList<LocalTime> getSchedule();

    public void setSchedule(ArrayList<LocalTime>  schedule);

    public void sortSchedule();

    boolean checkIfLineStationSameType(TransportType bus, Station station);

    public PublicTransportationSystem system();

    public int compareTo(TransportType trType);


}
