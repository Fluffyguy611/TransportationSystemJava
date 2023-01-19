package TransportClasses;

import interfaces.StationType;
import interfaces.Types;

import java.util.ArrayList;

public class Station implements StationType {
    private final String name;
    private ArrayList<Integer> lines;
    private final Types type;


    @Override
    public String getName() {
        return name;
    }

    public Station(String name, Types type) {
        this.name = name;
        this.type = type;
    }

    @Override
    public ArrayList<Integer> getLines() {
        return lines;
    }

    public void addLines(Integer line){
        if(!this.lines.contains(line)) {
            this.lines.add(line);
        }
    }

    public void delLines(Integer line){
        this.lines.remove(line);
    }

    @Override
    public Types type() {
        return type;
    }

    public String toString(){
        return this.name + " serving " + this.type + " " + this.lines;
    }

}
