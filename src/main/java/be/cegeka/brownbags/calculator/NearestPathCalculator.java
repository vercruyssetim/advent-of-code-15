package be.cegeka.brownbags.calculator;

import be.cegeka.brownbags.Location;
import be.cegeka.brownbags.World;
import be.cegeka.brownbags.WorldObject;
import com.google.common.collect.Sets;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

import static be.cegeka.brownbags.calculator.Path.path;

public class NearestPathCalculator {

    public Path calculatePath(Location attackerLocation, World world) {
        WorldObject attacker = world.getAtLocation(attackerLocation);
        return getPath(world, attacker, attackerLocation);
    }

    private Path getPath(World world, WorldObject attacker, Location startingLocation) {
        Deque<Path> paden = new ArrayDeque<>();
        paden.add(path(startingLocation));
        Set<Location> visitedLocations = Sets.newHashSet(startingLocation);
        while (!paden.isEmpty()) {
            Path path = paden.pop();
            Location lastVisitedLocation = path.getLast();
            visitedLocations.add(lastVisitedLocation);

            for (Location location : lastVisitedLocation.getSurroundingLocations()) {
                if (world.getAtLocation(location).isEnemyOf(attacker)) {
                    return path.createNewWith(location);
                }
                if (!visitedLocations.contains(location) && world.getAtLocation(location).canBeMovedThru()) {
                    paden.addLast(path.createNewWith(location));
                }
            }

        }
        return null;
    }
}
