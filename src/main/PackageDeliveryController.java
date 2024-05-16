
import NavigationStrategy.NavigationStrategy;
import NavigationStrategy.StandardNavigation;
import NavigationStrategy.ExpressNavigation;
import PackageStatus.PackageStatus;
import PackageStatus.Delivered;
import PackageStatus.InTransit;

import java.util.Scanner;

public class PackageDeliveryController {
    private final Scanner scanner;

    public PackageDeliveryController(Scanner scanner) {
        this.scanner = scanner;
    }

    public void executeDeliveryProcess() {
        System.out.println("**** Welcome to package navigation system ****");
        Package deliveryPackage = createPackage();

        while(true) {
            NavigationStrategy navigationStrategy = getPackageNavigationStrategy();
            deliveryPackage.setNavigationStrategy(navigationStrategy);

            PackageStatus packageStatus = getPackageStatus();
            deliveryPackage.setPackageStatus(packageStatus);

            if(packageStatus instanceof Delivered) {
                break;
            }
        }
    }

    public Package createPackage() {
        System.out.println("Please enter your package weight:");
        double weight = this.scanner.nextDouble();
        return new Package(weight);
    }

    public NavigationStrategy getPackageNavigationStrategy() {
        int navigationNumber;
        while(true) {
            System.out.println("Please choose your navigation strategy:");
            System.out.println("1- Standard");
            System.out.println("2- Express");
            navigationNumber = this.scanner.nextInt();
            if(navigationNumber == 1 || navigationNumber == 2) {
                break;
            } else {
                System.out.println("---- Wrong Input! ----");
            }
        }

        NavigationStrategy navigationStrategy;

        if(navigationNumber == 1) {
            navigationStrategy = new StandardNavigation();
        } else {
            navigationStrategy = new ExpressNavigation();
        }

        return navigationStrategy;
    }

    public PackageStatus getPackageStatus() {
        int statusNumber;
        while(true) {
            System.out.println("Please enter package status:");
            System.out.println("1- in transit");
            System.out.println("2- delivered");
            statusNumber = this.scanner.nextInt();
            if(statusNumber == 1 || statusNumber == 2) {
                break;
            } else {
                System.out.println("---- Wrong Input! ----");
            }
        }

        PackageStatus packageStatus;

        if(statusNumber == 1) {
            packageStatus = new InTransit();
        } else {
            packageStatus = new Delivered();
        }

        return packageStatus;
    }
}
