package be.cegeka.brownbags;

import be.cegeka.brownbags.worldobject.Wall;

import java.util.*;
import java.util.stream.Collectors;

public class World {
    List<List<WorldObject>> playingField = new ArrayList<>();

    public World(List<List<WorldObject>> playingField) {

        this.playingField = playingField;
    }

    @Override
    public String toString() {
        return playingField.stream()
                .map(this::toString)
                .collect(Collectors.joining("\n"));
    }

    private String toString(List<WorldObject> line) {
        return line.stream().map(Object::toString).collect(Collectors.joining());
    }

    public void playTurn() {
        for (int x = 0; x < playingField.size(); x++) {
            for (int y = 0; y < playingField.get(x).size(); y++){
                WorldObject worldObject = getAtLocation(new Location(x, y));
                worldObject.playTurn(x, y, this);
            }
        }
    }

    public WorldObject getAtLocation(Location location){
        if(location.getY() < 0 || location.getY() >= playingField.size() || location.getX() < 0 || location.getX() >= playingField.get(location.getY()).size()){
            return new Wall();
        }
        return playingField.get(location.getY()).get(location.getX());
    }

}
