import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        List<Order> orderHistory = new ArrayList<>();

        Product milk = new Product(1, "Milk", 10, "White water with cow", "water");
        Product juice = new Product(2, "Juice", 8, "Orange sweet water", "water");
        products.add(milk);
        products.add(juice);

        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();
        boolean running = true;
        while (running) {
            System.out.println("1: Показати всі товари.");
            System.out.println("2: Додати товар до кошику");
            System.out.println("3: Зробити замовлення.");
            System.out.println("4: Знайти товар за назвою.");
            System.out.println("5: Переглянути кошик.");
            System.out.println("6: Переглянути історію замовлень.");
            System.out.println("7: Видалити товар з кошика.");

            try {
                int option = Integer.parseInt(scanner.nextLine());

                switch (option) {
                    case 1:
                        System.out.println("Всі товари");
                        for (Product product : products) {
                            System.out.println("Назва " + product.getName() + " Ціна: " + product.getPrice() + " Опис " + product.getData()
                                    + " Категорія " + product.getCategory());
                        }
                        System.out.println();
                        break;
                    case 2:
                        // Додавання товару до кошика
                        System.out.println("Введіть назву товару який хотіли б додати: ");
                        String name = scanner.nextLine().toLowerCase();
                        boolean NotFound = true;
                        for (Product product : products) {
                            String productName = product.getName().toLowerCase();
                            if (productName.equals(name)) {
                                NotFound = false;
                                System.out.println("Ваш продукт знайдено та додано до кошику: " + '\n' + name);
                                System.out.println(product.getPrice());
                                System.out.println(product.getData());
                                System.out.println(product.getCategory());
                                cart.addProduct(product);
                            }
                            if (NotFound) {
                                System.out.println("Такого товару не знайдено");
                            }
                        }
                        break;
                    case 3:
                        // Зроблення замовлення
                        if (!cart.getProducts().isEmpty()) {
                            String shippingAddress = scanner.nextLine();
                            Order order = new Order(cart, shippingAddress);
                            orderHistory.add(order);
                            System.out.println("Замовлення успішно оформлено!");
                            cart.displayCart();
                            cart = new Cart(); // Очистити кошик після замовлення
                        } else {
                            System.out.println("Кошик порожній. Додайте товари до кошика.");
                        }
                        break;

                    case 4:
                        // Пошук товару за назвою
                        System.out.println("Введіть товар який хочете ввести");
                        String findProduct = scanner.nextLine();
                        boolean found = false;
                        for (Product product : products) {
                            if (product.getName().toLowerCase().equals(findProduct)) {
                                System.out.println(product.getName() + " " + product.getPrice() + " грн");
                                found = true;
                                break;
                            }
                            if (!found) {
                                System.out.println("Такого товару не знайдено");
                            }
                        }
                        break;
                    case 5:
                        // Перегляд кошика
                        cart.displayCart();

                        break;
                    case 6:
                        // Перегляд історії замовлень
                        System.out.println("Історія замовлень:");
                        if (orderHistory.isEmpty()) {
                            System.out.println("Історія замовлень порожня.");
                        } else {
                            for (Order order : orderHistory) {
                                order.getCart().displayCart();
                            }
                        }
                        break;
                    case 7:
                        for (Product product : products) {
                            System.out.println("Назва " + product.getName() + " Ціна: " + product.getPrice() + " Опис " + product.getData()
                                    + " Категорія " + product.getCategory());
                        }
                        System.out.println("Який товар ви хочете видалити?");
                        String removeProduct = scanner.nextLine();
                        cart.removeProductByName(removeProduct);
                        break;

                    default:
                        System.out.println("Невірний варіант. Спробуйте ще раз.");
                }


            } catch (NumberFormatException e) {
                System.out.println("Ви ввели неправильний формат опції. Будь ласка, введіть ціле число.");
            }
        }
    }
}
