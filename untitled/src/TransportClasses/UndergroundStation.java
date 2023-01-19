package TransportClasses;

import interfaces.Types;

import java.util.ArrayList;

public class UndergroundStation extends Station{
    private String name;
    private Types type;

    private ArrayList<String> accessPoints;

    @Override
    public String getName() {
        return name;
    }

    public Types getType() {
        return type;
    }

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
