package be.cegeka.brownbags;

import java.util.List;
import java.util.Objects;

import static java.util.Arrays.asList;

public class Location {

    private final int x;
    private final int y;

    public Location(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static Location location(int x, int y){
        return new Location(x, y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return x == location.x &&
                y == location.y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public List<Location> getSurroundingLocations() {
        return asList(location(getX(), getY() - 1),
        location(getX() - 1, getY()),
        location(getX() + 1, getY()),
        location(getX(), getY() + 1));
    }
}
