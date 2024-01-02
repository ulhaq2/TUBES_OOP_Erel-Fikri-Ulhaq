import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OnlineStore0{
    private List<Product> products;
    private List<Customer> customers;
    private List<Order> orders;

    public OnlineStore0() {
        this.products = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.orders = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public static void main(String[] args) {
        OnlineStore0 store = new OnlineStore0();

        Product product1 = new Product("Mango Squash", 10000, 001);
        Product product2 = new Product("Orange Fizz", 12000, 002);
        Product product3 = new Product("Lychee Fizz", 13000, 003);

        store.addProduct(product1);
        store.addProduct(product2);
        store.addProduct(product3);

        Customer customer1 = new Customer("Ariel Christsando Yudistya Putra", 1202223311);
        Customer customer2 = new Customer("Muhammad Zulfikri Mansur", 1202223298);
        Customer customer3 = new Customer("Dhifulloh Dhiya Ulhaq", 1202220139);

        store.addCustomer(customer1);
        store.addCustomer(customer2);
        store.addCustomer(customer3);

        Order order1 = new Order(new ArrayList<>(List.of(product1)), customer1, new Date());
        store.addOrder(order1);
        Order order2 = new Order(new ArrayList<>(List.of(product2)), customer2, new Date());
        store.addOrder(order2);
        Order order3 = new Order(new ArrayList<>(List.of(product3)), customer3, new Date());
        store.addOrder(order3);

        System.out.println("\n[ REFRESHMENT JUNCTION ONLINE STORE SYSTEM ]\n");

        System.out.println("Daftar Produk: ");
        for (Product product : store.products) {
            System.out.println("- Nama Produk: " + product.getName() + " | Harga: " + product.getPrice());
        }

        System.out.println("\nDaftar Pelanggan: ");
        for (Customer customer : store.customers) {
            System.out.println("- Nama Pelanggan: " + customer.getName() + " (ID: " + String.format("%04d", customer.getCustomerId()) + ")");
        }

        System.out.println("\nDaftar Orderan: ");
        for (Order ord : store.orders) {
            System.out.print("- Order for " + ord.getCustomer().getName() + " on " + ord.getOrderDate() + " with products: ");
            
            List<Product> orderProd = ord.getProducts();
            for (int i = 0; i < orderProd.size(); i++) {
                Product prod = orderProd.get(i);
                System.out.print(prod.getName());
                
                if (i < orderProd.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println();
        }

        System.out.println("\nDaftar Orderan: ");
        for (Order ord : store.orders) {
            System.out.println("- Order for " + ord.getCustomer().getName() + " on " + ord.getOrderDate() +
                    " with products: " + ord.getProducts());
        }
    }
}

