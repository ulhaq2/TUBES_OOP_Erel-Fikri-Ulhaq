import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class OnlineStore {
    private List<Product> products;
    private List<Customer> customers;
    private List<Order> orders;

    public OnlineStore() {
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

    public void addProductMenu(Scanner input) {
        System.out.print("\nMasukkan ID produk: ");
        int productId = input.nextInt();
        input.nextLine(); 
        System.out.print("Masukkan nama produk: ");
        String productName = input.nextLine();
        System.out.print("Masukkan harga produk: ");
        int productPrice = input.nextInt();

    
        Product newProduct = new Product(productName, productPrice, productId);
        addProduct(newProduct);
        System.out.println("Produk berhasil ditambahkan.");
    }

    public void displayProducts() {
        System.out.println("\nDaftar Produk: ");
        for (Product product : products) {
            System.out.println("- ID Produk: " + product.getProductId() + " | Nama Produk: " + product.getName() + " | Harga: " + product.getPrice());
        }
    }

    public void addOrderMenu(Scanner input) {
        System.out.println("\nDaftar Pelanggan: ");
        for (Customer customer : customers) {
            System.out.println("- Nama Pelanggan: " + customer.getName() + " (ID: " + String.format("%04d", customer.getCustomerId()) + ")");
        } System.out.println();

        System.out.print("Masukkan ID pelanggan atau buat ID baru: ");
        int customerID = input.nextInt();
        input.nextLine(); 
        
        Customer selectedCustomer = null;
        boolean isNewCustomer = true;

        for (Customer customer : customers) {
            if (customer.getCustomerId() == customerID) {
                selectedCustomer = customer;
                isNewCustomer = false;
                break;
            }
        }

        if (selectedCustomer == null && isNewCustomer) {
            System.out.print("Masukkan nama pelanggan baru: ");
            String customerName = input.nextLine();
        
            Customer newCustomer = new Customer(customerName, customerID);
            customers.add(newCustomer);
            selectedCustomer = newCustomer;
        }

        System.out.println("\nDaftar Produk: ");
        for (Product product : products) {
            System.out.println("- Nama Produk: " + product.getName() + " | Harga: " + product.getPrice() + " | ID: " + product.getProductId());
        } System.out.println();

        System.out.print("Pilih ID produk yang akan dipesan: ");
        int productID = input.nextInt();
        input.nextLine(); 


        Product selectedProduct = null;
        for (Product product : products) {
            if (product.getProductId() == productID) {
                selectedProduct = product;
                break;
            }
        }

        if (selectedCustomer != null && selectedProduct != null) {
            List<Product> orderedProducts = new ArrayList<>();
            orderedProducts.add(selectedProduct);

            Order newOrder = new Order(orderedProducts, selectedCustomer, new Date());
            addOrder(newOrder);
            System.out.println("Order berhasil ditambahkan.");
        } else {
            if (selectedProduct == null) {
                System.out.println("ID produk tidak valid. Produk dengan ID tersebut tidak ditemukan.");
            } else {
                System.out.println("ID pelanggan tidak valid. Pelanggan dengan ID tersebut tidak ditemukan.");
            }
            System.out.println("Gagal menambahkan order.");
        }
    }

    public void displayOrders() {
        System.out.println("\nDaftar Orderan: ");
        for (Order ord : orders) {
            System.out.println("- Nama Pengorder: " + ord.getCustomer().getName());
            System.out.print("  Produk yang dipesan: ");

            List<Product> orderProd = ord.getProducts();
            for (int i = 0; i < orderProd.size(); i++) {
                Product prod = orderProd.get(i);
                System.out.print(prod.getName());

                if (i < orderProd.size() - 1) {
                    System.out.print(", ");
                }
            }
            
            System.out.println("\n  Tanggal transaksi: " + ord.getOrderDate());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        OnlineStore store = new OnlineStore();
        Scanner input = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("\n[ REFRESHMENT JUNCTION ONLINE STORE SYSTEM ]\n");
            System.out.println("Menu:");
            System.out.println("1. Tambahkan daftar produk");
            System.out.println("2. Tampilkan daftar produk");
            System.out.println("3. Tambahkan orderan");
            System.out.println("4. Tampilkan history order yang telah dilakukan");
            System.out.println("5. Exit");
            System.out.print("Pilih menu (1-5): ");

            choice = input.nextInt();
            input.nextLine(); 

            switch (choice) {
                case 1:
                    store.addProductMenu(input);
                    break;
                case 2:
                    store.displayProducts();
                    break;
                case 3:
                    store.addOrderMenu(input);
                    break;
                case 4:
                    store.displayOrders();
                    break;
                case 5:
                    System.out.println("Terima kasih! Keluar dari program.");
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan pilih angka 1-5.");
                    break;
            }
        } while (choice != 5);

        input.close(); 
    }
}
