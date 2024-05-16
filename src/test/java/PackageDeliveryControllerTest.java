
import NavigationStrategy.NavigationStrategy;
import NavigationStrategy.StandardNavigation;
import PackageStatus.PackageStatus;
import PackageStatus.Delivered;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PackageDeliveryControllerTest {
    public PackageDeliveryController getPackageDeliverController(int weight, int navigationOption) {
        String input = weight + "\n" + navigationOption + "\n2\n"; // Example input: package weight, navigation strategy, package status
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner mockScanner = new Scanner(System.in);
        return new PackageDeliveryController(mockScanner);
    }

    @Test
    public void testStandardNavigation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PackageDeliveryController packageController = getPackageDeliverController(10, 1);
        packageController.executeDeliveryProcess();

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Current price is 25.0 based on Standard Navigation"));
    }

    @Test
    public void testExpressNavigation() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        PackageDeliveryController packageController = getPackageDeliverController(10, 2);
        packageController.executeDeliveryProcess();

        String output = outputStream.toString();
        Assertions.assertTrue(output.contains("Current price is 35.0 based on Express Navigation"));
    }

    @Test
    public void testCreatePackage(){
        String input = "14.5";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner mockScanner = new Scanner(System.in);

        PackageDeliveryController controller = new PackageDeliveryController(mockScanner);
        Package testPackage = controller.createPackage();

        Assertions.assertEquals(testPackage.getWeight(), 14.5);

    }

    @Test
    public void testGetPackageNavigationStrategy() {
        String input = "1";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner mockScanner = new Scanner(System.in);

        PackageDeliveryController controller = new PackageDeliveryController(mockScanner);
        NavigationStrategy strategy = controller.getPackageNavigationStrategy();

        Assertions.assertTrue(strategy instanceof StandardNavigation);
    }

    @Test
    public void testGetPackageStatus() {
        String input = "2";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner mockScanner = new Scanner(System.in);

        PackageDeliveryController controller = new PackageDeliveryController(mockScanner);
        PackageStatus status = controller.getPackageStatus();

        Assertions.assertTrue(status instanceof Delivered);
    }

}
