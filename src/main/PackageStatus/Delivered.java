package PackageStatus;

public class Delivered implements PackageStatus{
    @Override
    public void printStatus() {
        System.out.println("package has been delivered!");
    }
}
