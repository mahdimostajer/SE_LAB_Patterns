package NavigationStrategy;

public class ExpressNavigation implements NavigationStrategy{
    @Override
    public double calculateNavigationPrice(double weight) {
        double price = 3.5 * weight;
        System.out.println("Current price is " + price + " based on Express Navigation");
        return price;
    }
}
