package be.cegeka.brownbags;

import be.cegeka.brownbags.worldobject.Pion;

public interface WorldObject {
    void playTurn(int x, int y, World world);

    boolean isEnemyOf(WorldObject worldObject);

    boolean canBeMovedThru();
}
