package TransportClasses;

import interfaces.StationType;
import interfaces.TransportType;
import interfaces.Types;

import java.util.ArrayList;
import java.util.List;

public abstract class Station implements StationType {
    private final String name;
    private final List<TransportType> lines;
    private final Types type;


    @Override
    public String getName() {
        return name;
    }

    public Station(String name, Types type) {
        this.name = name;
        this.type = type;
        this.lines = new ArrayList<>();
    }

    @Override
    public List<TransportType> getLines() {
        return lines;
    }

    public void addLines(TransportType line){
        if(!this.lines.contains(line)) {
            this.lines.add(line);
        }
    }

    public void delLines(TransportType line){
        this.lines.remove(line);
    }

    @Override
    public Types type() {
        return type;
    }

    @Override
    public int compareTo(StationType stType) {
        return Integer.compare(this.lines.size(), stType.getLines().size());
    }

    public String toString(){
        return this.name + " serving " + this.type;
    }

}
