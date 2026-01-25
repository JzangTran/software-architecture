public class Application {
    public static void main(String[] args) {
        Transport truck = new Truck();
        truck.deliver();
        Transport ship = new Ship();
        ship.deliver();
    }
}
