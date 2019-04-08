package be.cegeka.brownbags.worldobject;

import be.cegeka.brownbags.World;
import be.cegeka.brownbags.WorldObject;

import static be.cegeka.brownbags.worldobject.Race.ELF;
import static be.cegeka.brownbags.worldobject.Race.GOBLIN;

public class Pion implements WorldObject {

    private Race race;

    private Pion(Race race) {
        this.race = race;
    }

    public static Pion elf(){
        return new Pion(ELF);
    }

    public static Pion goblin(){
        return new Pion(GOBLIN);
    }

    @Override
    public String toString() {
        return race.letterCode();
    }

    @Override
    public void playTurn(int x, int y, World world) {
    }

    @Override
    public boolean isEnemyOf(WorldObject worldObject) {
        return worldObject instanceof Pion && ((Pion)worldObject).race != this.race;
    }
}
