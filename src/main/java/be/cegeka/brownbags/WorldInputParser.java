package be.cegeka.brownbags;

import be.cegeka.brownbags.worldobject.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static java.util.stream.Collectors.toList;

public class WorldInputParser {

    public World parse() {
        List<String> lines = readInput();
        return parseFromString(lines);
    }

    public World parseFromString(String worldAsString){
        return parseFromString(newArrayList(worldAsString.split("\\n")));
    }

    public World parseFromString(List<String> lines) {
        List<List<WorldObject>> objects = lines.stream()
                .map(this::toListOfObjects)
                .collect(toList());

        return new World(objects);
    }

    private List<WorldObject> toListOfObjects(String line) {
        return line.chars().mapToObj(this::mapToObject)
                .collect(toList());
    }

    private WorldObject mapToObject(int thingy) {
        switch (thingy) {
            case '#':
                return new Wall();
            case '.':
                return new OpenSpace();
            case 'G':
                return Pion.goblin();
            case 'E':
                return Pion.elf();
            default:
                throw new RuntimeException(String.format("Jonathan zaagt veel %s", thingy));
        }
    }

    private List<String> readInput() {
        try {
            return Files.readAllLines(Paths.get("C:\\_Projects\\Cegeka\\advent-of-code-15\\src\\main\\resources\\input.txt"));
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
