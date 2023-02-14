package TransportClasses;

import interfaces.Types;

import java.util.ArrayList;

public final class UndergroundStation extends Station{

    private final ArrayList<String> accessPoints = new ArrayList<>();


    public ArrayList<String> getAccessPoints() {
        return accessPoints;
    }
    public void addAccessPoints(String access){
        if (!accessPoints.contains(access)){
            accessPoints.add(access);
        }
    }

    public void delAccessPoints(String access){
        accessPoints.remove(access);
    }

    public UndergroundStation(String name, Types type) {
        super(name, type);
    }
}

