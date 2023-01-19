package TransportClasses;

import java.util.ArrayList;

public class Routing {

    public void routingBetweenStations(Station station1, Station station2) {
        ArrayList<Integer> lines1 = station1.getLines();
        ArrayList<Integer> lines2 = station2.getLines();
        if (isStationSameType(station1, station2)) {
            for (int line : lines1) {
                if (lines2.contains(line)) {
                    System.out.println("Routing between: " + station1 + " " + station2 + "possible via line" + line);
                    return;
                }
            }
        }
        System.out.println("Routing not possible");
    }
    public boolean isStationSameType(Station station1, Station station2){
        return station1.type().equals(station2.type());
    }
}
