package be.cegeka.brownbags.calculator;

import be.cegeka.brownbags.Location;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.util.*;

import static com.google.common.collect.Lists.newArrayList;

public class Path {
    private Deque<Location> locations = Queues.newArrayDeque();;

    public Path(Location location) {
        locations.add(location);
    }

    private Path(Deque<Location> locations){
        this.locations = locations;
    }

    public static Path path(Location location) {
        return new Path(location);
    }

    public List<Location> getLocations() {
        return newArrayList(locations);
    }

    public Location getLast(){
        return locations.getLast();
    }

    public Path createNewWith(Location location) {
        Deque<Location> result = Queues.newArrayDeque(this.locations);
        result.addLast(location);
        return new Path(result);
    }
}
