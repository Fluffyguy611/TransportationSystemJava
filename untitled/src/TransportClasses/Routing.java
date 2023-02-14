package TransportClasses;

import interfaces.TransportType;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class Routing {

    public static String routingBetweenStations(Station station1, Station station2) {
        List<TransportType> lines2 = station2.getLines();
        List<TransportType> lines1 = station1.getLines();
        if (isStationSameType(station1, station2)) {
            for(TransportType line : lines2){
                if (lines1.contains(line))
                {
                    return ("Routing between: " + station1.getName() + " and " + station2.getName()
                            + " possible via line " + line.name());
                }
            }
        }
        return ("Routing not possible");
    }
    public static boolean isStationSameType(Station station1, Station station2){
        return station1.type().equals(station2.type());
    }


    public static ArrayList<LocalTime> getScheduleOfTransportType(TransportType vehicle){
        return vehicle.getSchedule();
    }

    public static ArrayList<LocalTime> getScheduleBetweenDates(TransportType vehicle,
                                                               LocalTime time1, LocalTime time2){
        ArrayList<LocalTime> temp_schedule = new ArrayList<>();
        for (LocalTime time: vehicle.getSchedule()) {
            if(time.isAfter(time1) && time.isBefore(time2)){
                temp_schedule.add(time);
            }
        }
        return temp_schedule;
    }

    public static ArrayList<LocalTime> getScheduleNow(TransportType vehicle){
        LocalTime time = LocalTime.now();
        ArrayList<LocalTime> temp_schedule = new ArrayList<>();
        for (LocalTime schedule: vehicle.getSchedule()) {
            if(time.isAfter(schedule)){
                temp_schedule.add(schedule);
            }
        }
        return temp_schedule;
    }

    public static LocalTime getNearestSchedule(TransportType vehicle) {
        return getScheduleNow(vehicle).get(0);
    }

    public static HashMap<TransportType, LocalTime> getNearestBusScheduleFromStation(Station station){
        LocalTime time = LocalTime.now();
        HashMap<TransportType, LocalTime> schedules = new HashMap<>();
        for (TransportType vehicle: station.getLines()) {
            LocalTime schedule_now = getNearestSchedule(vehicle);
            schedules.put(vehicle, schedule_now);
        }
        return schedules;
    }
}




