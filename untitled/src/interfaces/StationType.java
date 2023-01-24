package interfaces;

import java.util.ArrayList;
import java.util.List;

public interface StationType {
    public String getName();
    public List<TransportType> getLines();
    public Types type();

    public int compareTo(StationType stType);

}
