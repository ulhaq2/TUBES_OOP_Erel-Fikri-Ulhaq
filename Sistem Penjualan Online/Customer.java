public class Customer{
    private String name;
    private int customerId;
    
    public Customer(String name, int customerId){
        this.name = name;
        this.customerId = customerId;
    }

    public String getName(){
        return name;
    }

    public int getCustomerId(){
        return customerId;
    }

    public void setName(String newName){
        name = newName;
    }
    
    public void setCustomerId(int newCustomerId){
        customerId = newCustomerId;
    }
}