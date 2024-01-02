import java.util.Date; 
import java.util.List;

public class Order{
    private List<Product> products;
    private Customer customer;
    private Date orderDate;

    public Order(List<Product> products, Customer customer, Date orderDate){
        this.products = products;
        this.customer = customer;
        this.orderDate = orderDate;
    }

    public List<Product> getProducts(){
        return products;
    }

    public Customer getCustomer(){
        return customer;
    }

    public Date getOrderDate(){
        return orderDate;
    }

    public void setProducts(List<Product> newProducts){
        products = newProducts;
    }
    
    public void setCustomerId(Customer newCustomer){
        customer = newCustomer;
    }

    public void setOrderDate(Date newOrderDate){
        orderDate = newOrderDate;
    }
}
