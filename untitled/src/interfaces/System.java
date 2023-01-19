package interfaces;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public interface System {
    public String getName();
    public ArrayList<Types> getTransportationTypes();
    public HashMap<String, Integer> getLines();
    public HashMap<String, ArrayList<Integer>> getStationNames();
}
