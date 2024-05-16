package NavigationStrategy;

import NavigationStrategy.StandardNavigation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StandardNavigationTest {
    private final double DELTA = 0.0001; // Delta for double comparisons

    @Test
    public void testCalculateNavigationPrice() {
        StandardNavigation standardNavigation = new StandardNavigation();

        double weight1 = 5.0;
        double expectedPrice1 = weight1 * 2.5;
        assertEquals(expectedPrice1, standardNavigation.calculateNavigationPrice(weight1), DELTA);

        double weight2 = 10.0;
        double expectedPrice2 = weight2 * 2.5;
        assertEquals(expectedPrice2, standardNavigation.calculateNavigationPrice(weight2), DELTA);

    }
}
