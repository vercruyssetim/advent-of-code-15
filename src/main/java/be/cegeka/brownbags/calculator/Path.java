package be.cegeka.brownbags.calculator;

import be.cegeka.brownbags.Location;
import com.google.common.collect.Lists;
import com.google.common.collect.Queues;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

import static com.google.common.collect.Lists.newArrayList;

public class Path {
    private Deque<Location> locations = Queues.newArrayDeque();;

    public Path(Location location) {
        locations.add(location);
    }

    public static Path path(Location location) {
        return new Path(location);
    }

    public List<Location> getLocations() {
        return newArrayList(locations);
    }

    public Path push(Location location) {
        locations.addFirst(location);
        return this;
    }
}
