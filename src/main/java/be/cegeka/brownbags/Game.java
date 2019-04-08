package be.cegeka.brownbags;

import java.util.List;

public class Game {
    private World world;

    public Game(World world) {
        this.world = world;
    }

    private void start() {
        //List<Location> result = wieBeginLijst();
    }

    public static void main(String[] args){
        World world = new WorldInputParser().parse();
        new Game(world).start();
    }
}
