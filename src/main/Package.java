
import NavigationStrategy.NavigationStrategy;
import PackageStatus.PackageStatus;

public class Package {
    private PackageStatus packageStatus;
    private NavigationStrategy navigationStrategy;
    private double weight;


    public Package(double weight) {
        this.weight = weight;
    }

    public void setPackageStatus(PackageStatus packageStatus) {
        this.packageStatus = packageStatus;
        this.packageStatus.printStatus();
    }

    public void setNavigationStrategy(NavigationStrategy navigationStrategy) {
        this.navigationStrategy = navigationStrategy;
        this.navigationStrategy.calculateNavigationPrice(this.weight);
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public PackageStatus getPackageStatus() {
        return packageStatus;
    }

    public NavigationStrategy getNavigationStrategy() {
        return navigationStrategy;
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return navigationStrategy.calculateNavigationPrice(this.weight);
    }
}
