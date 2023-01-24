package TransportClasses;

import interfaces.TransportType;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Routing {

    public static String routingBetweenStations(Station station1, Station station2) {
        List<TransportType> lines2 = station2.getLines();
        List<TransportType> lines1 = station1.getLines();
        Iterator<TransportType> lineIterator = lines2.iterator();
        if (isStationSameType(station1, station2)) {
            for(int i=0; i<lines2.size();i++){
                if (lines2.contains(lines1.get(i)))
                {
                    return ("Routing between: " + station1.getName() + " and " + station2.getName()
                            + " possible via line " + lineIterator.next().name());
                }
            }
        }
        return ("Routing not possible");
    }
    public static boolean isStationSameType(Station station1, Station station2){
        return station1.type().equals(station2.type());
    }
}
