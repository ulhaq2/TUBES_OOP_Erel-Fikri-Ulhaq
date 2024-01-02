public class Product {
    private String name;
    private double price;
    private int productId;

    public Product(String name,double price,int productId){
        this.name = name;
        this.price = price;
        this.productId = productId;
    }

    public String getName(){
        return name;
    }

    public double getPrice(){
        return price;
    }

    public int getProductId(){
        return productId;
    }

    public void setName(String newName){
        name = newName;
    }

    public void setPrice(double newPrice){
        price = newPrice;
    }
    
    public void setProductId(int newProductId){
        productId = newProductId;
    }
    
}
