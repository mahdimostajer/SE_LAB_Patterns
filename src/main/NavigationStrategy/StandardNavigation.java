package NavigationStrategy;

public class StandardNavigation implements NavigationStrategy{
    @Override
    public double calculateNavigationPrice(double weight) {
        double price = weight * 2.5;
        System.out.println("Current price is " + price + " based on Standard Navigation");
        return price;
    }
}
