package NavigationStrategy;

import NavigationStrategy.ExpressNavigation;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExpressNavigationTest {
    private final double DELTA = 0.0001; // Delta for double comparisons

    @Test
    public void testCalculateNavigationPrice() {
        ExpressNavigation expressNavigation = new ExpressNavigation();

        double weight1 = 5.0;
        double expectedPrice1 = 3.5 * weight1;
        assertEquals(expectedPrice1, expressNavigation.calculateNavigationPrice(weight1), DELTA);

        double weight2 = 10.0;
        double expectedPrice2 = 3.5 * weight2;
        assertEquals(expectedPrice2, expressNavigation.calculateNavigationPrice(weight2), DELTA);

    }
}
