package be.cegeka.brownbags.calculator;

import be.cegeka.brownbags.Location;
import be.cegeka.brownbags.World;
import be.cegeka.brownbags.WorldObject;
import be.cegeka.brownbags.worldobject.Wall;

import java.util.List;
import java.util.stream.Collectors;

import static com.google.common.collect.Lists.newArrayList;

public class NearestPathCalculator {

    public Path calculatePath(Location attackerLocation, World world) {
        WorldObject attacker = world.getAtLocation(attackerLocation);
        return getPath(world, attacker, newArrayList(attackerLocation));
    }

    private Path getPath(World world, WorldObject attacker, List<Location> visitedLocations) {
        List<Location> toCheckLocations = visitedLocations.get(visitedLocations.size() - 1).getSurroundingLocations().stream()
                .filter(toCheckLocation -> !visitedLocations.contains(toCheckLocation))
                .filter(toCheckLocation -> !(world.getAtLocation(toCheckLocation) instanceof Wall))
                .collect(Collectors.toList());

        for (Location location : toCheckLocations) {
            if (world.getAtLocation(location).isEnemyOf(attacker)) {
                return Path.path(location);
            }
        }
        for (Location location : toCheckLocations) {
            visitedLocations.add(location);
            return getPath(world, attacker, visitedLocations).push(location);
        }
        return null;
    }
}
