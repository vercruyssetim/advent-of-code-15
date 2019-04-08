package be.cegeka.brownbags.worldobject;

import org.assertj.core.api.Assertions;
import org.junit.Test;

import static be.cegeka.brownbags.worldobject.Race.ELF;
import static be.cegeka.brownbags.worldobject.Race.GOBLIN;
import static org.assertj.core.api.Assertions.assertThat;

public class PionTest {

    private Pion pion;

    @Test
    public void isEnemyOf_ElfIsEnemyOfGoblin() {
        pion = Pion.elf();
        boolean actual = pion.isEnemyOf(Pion.goblin());

        assertThat(actual).isTrue();
    }

    @Test
    public void isEnemyOf_GoblinIsEnemyOfElf() {
        pion = Pion.goblin();
        boolean actual = pion.isEnemyOf(Pion.elf());

        assertThat(actual).isTrue();
    }

    @Test
    public void isEnemyOf_GoblinIsNotEnemyOfGoblin() {
        pion = Pion.goblin();
        boolean actual = pion.isEnemyOf(Pion.goblin());

        assertThat(actual).isFalse();
    }

    @Test
    public void isEnemyOf_ElfIsNotEnemyOfElf() {
        pion = Pion.elf();
        boolean actual = pion.isEnemyOf(Pion.elf());

        assertThat(actual).isFalse();
    }
}