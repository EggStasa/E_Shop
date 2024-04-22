import java.util.ArrayList;
import java.util.List;

public class Cart {
    List<Product> products;
    double totalPrice;
    public Cart() {
        products = new ArrayList<>();
    }
    public void addProduct(Product product) {
        products.add(product);
        System.out.println("Product " + product.getName() + " add in cart.");

    }

    public double getTotalPrice() {
        double total = 0;
        for (Product product : products) {
            total += product.price;
        }
        return total;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void displayOrder(){
        System.out.println("Your order: ");
        for (Product product : products){
            System.out.println("Name " + product.name);
            System.out.println("Price " + product.price);
        }
        System.out.println("Total price " + totalPrice);
    }
    public void displayCart() {
        if (products.isEmpty()) {
            System.out.println("Cart empty.");
        } else
            System.out.println("Your products: ");
        for (Product product : products) {
            System.out.println("Name " + product.getName());
            System.out.println("Price " + product.getPrice());
            System.out.println("Data: " + product.getData());
            System.out.println("Category: " + product.getCategory());
            System.out.println("Id " + product.getId());
        }
    }
    public Product removeProduct(Product product) {
        products.remove(product);
        System.out.println("Product " + product.name + " removed from the order.");
        return product;
    }

    public void removeProductByName(String productName) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(productName)) {
                products.remove(product);
                System.out.println("Product " + product.getName() + " removed from the cart.");
                return; // Якщо продукт знайдено і видалено, вийдемо з методу
            }
        }
        System.out.println("Product " + productName + " not found in the cart.");
    }

}
