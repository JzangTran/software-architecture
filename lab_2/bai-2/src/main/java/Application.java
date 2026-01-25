import model.Product;
import state.LuxuryProductState;
import state.NormalProductState;

public class Application {
    public static void main(String[] args) {
        Product normalProduct =
                new Product(1000, new NormalProductState());
        System.out.println("Normal Product Price: " +
                normalProduct.getFinalPrice());

        Product luxuryProduct =
                new Product(1000, new LuxuryProductState());
        System.out.println("Luxury Product Price: " +
                luxuryProduct.getFinalPrice());
    }
}
