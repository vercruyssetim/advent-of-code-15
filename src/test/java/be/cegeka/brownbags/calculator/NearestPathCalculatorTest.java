package be.cegeka.brownbags.calculator;

import be.cegeka.brownbags.World;
import be.cegeka.brownbags.WorldInputParser;
import org.junit.Test;

import static be.cegeka.brownbags.Location.location;
import static org.assertj.core.api.Assertions.assertThat;

public class NearestPathCalculatorTest {

    private NearestPathCalculator nearestPathCalculator = new NearestPathCalculator();

    @Test
    public void calculatePath_givenGoblinNextToElf() {
        World world = new WorldInputParser().parseFromString("GE");

        Path actual = nearestPathCalculator.calculatePath(location(0, 0), world);

        assertThat(actual.getLocations()).containsExactly(location(1, 0));
    }

    @Test
    public void calculatePath_givenElfNextToGoblin() {
        World world = new WorldInputParser().parseFromString("GE");

        Path actual = nearestPathCalculator.calculatePath(location(1, 0), world);

        assertThat(actual.getLocations()).containsExactly(location(0, 0));
    }

    @Test
    public void calculatePath_givenTwoElfsNextToGoblin() {
        World world = new WorldInputParser().parseFromString(
                "E." + "\n" +
                        "GE");

        Path actual = nearestPathCalculator.calculatePath(location(0, 1), world);

        assertThat(actual.getLocations()).containsExactly(location(0, 0));
    }

    @Test
    public void calculatePath_givenElfNextToOpenSpaceAndGoblin() {
        World world = new WorldInputParser().parseFromString("G.E");

        Path actual = nearestPathCalculator.calculatePath(location(0, 0), world);

        assertThat(actual.getLocations()).containsExactly(location(1, 0), location(2, 0));
    }

    @Test
    public void calculatePath_givenSomeDifficultSetup() {
        World world = new WorldInputParser().parseFromString("E..G.E");

        Path actual = nearestPathCalculator.calculatePath(location(3, 0), world);

        assertThat(actual.getLocations()).containsExactly(location(4, 0), location(5, 0));
    }
}