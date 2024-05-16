import NavigationStrategy.StandardNavigation;
import PackageStatus.Delivered;
import PackageStatus.PackageStatus;
import NavigationStrategy.NavigationStrategy;
import NavigationStrategy.ExpressNavigation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageTest {
    private Package testPackage;

    @BeforeEach
    public void setUp() {
        double initialWeight = 10.0;
        testPackage = new Package(initialWeight);
    }

    @Test
    public void testSetPackageStatus() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PackageStatus expectedStatus = new Delivered();
        testPackage.setPackageStatus(expectedStatus);

        String expectedMessage = "package has been delivered!\n";
        assertEquals(expectedMessage, outputStream.toString());

        assertEquals(expectedStatus, testPackage.getPackageStatus());

    }

    @Test
    public void testSetStandardNavigationStrategy() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NavigationStrategy expectedStrategy = new StandardNavigation();
        testPackage.setNavigationStrategy(expectedStrategy);

        String expectedMessage = "Current price is 25.0 based on Standard Navigation\n";
        assertEquals(expectedMessage, outputStream.toString());

        assertEquals(expectedStrategy, testPackage.getNavigationStrategy());

        double price = testPackage.getPrice();
        assertEquals(25, price);
    }

    @Test
    public void testSetExpressNavigationStrategy() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        NavigationStrategy expectedStrategy = new ExpressNavigation();
        testPackage.setNavigationStrategy(expectedStrategy);

        String expectedMessage = "Current price is 35.0 based on Express Navigation\n";
        assertEquals(expectedMessage, outputStream.toString());

        assertEquals(expectedStrategy, testPackage.getNavigationStrategy());

        double price = testPackage.getPrice();
        assertEquals(35, price);
    }

    @Test
    public void testSetWeight() {
        double newWeight = 15.0;
        testPackage.setWeight(newWeight);
        assertEquals(newWeight, testPackage.getWeight());
    }
}
