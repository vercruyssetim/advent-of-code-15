package be.cegeka.brownbags.worldobject;

import be.cegeka.brownbags.World;
import be.cegeka.brownbags.WorldObject;

public class Wall implements WorldObject {

    @Override
    public String toString() {
        return "#";
    }

    @Override
    public void playTurn(int x, int y, World world) {

    }

    @Override
    public boolean isEnemyOf(WorldObject worldObject) {
        return false;
    }
}
