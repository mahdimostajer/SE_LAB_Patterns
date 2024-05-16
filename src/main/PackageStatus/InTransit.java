package PackageStatus;

public class InTransit implements PackageStatus{
    @Override
    public void printStatus() {
        System.out.println("package is in transit!");
    }
}
