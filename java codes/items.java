package COLLECTIONS;

public class items {
    private byte itemPrice;     
    private short quantity;    
    private int totalAmount;     
    private float salesTaxRate;  
    private double discount;   

    
    public items(byte itemPrice, short quantity, float salesTaxRate, double discount) {
        this.itemPrice = itemPrice;
        this.quantity = quantity;
        this.salesTaxRate = salesTaxRate;
        this.discount = discount;
        this.totalAmount = 0;  
    }

   
    public void calculateTotalAmount() {
        totalAmount = (itemPrice * quantity);  
    }
    
    public double calculateFinalAmount() {
        double priceAfterTax = totalAmount * (1 + salesTaxRate);  
        double priceAfterDiscount = priceAfterTax * (1 - discount); 
        return priceAfterDiscount;
    }

    
    public void displayItemDetails() {
        System.out.println("Item Price " + itemPrice / 100.0);  
        System.out.println("Quantity: " + quantity);
        System.out.println("Sales Tax Rate: " + (salesTaxRate * 100) + "%");
        System.out.println("Discount: " + (discount * 100) + "%");
        System.out.println("Total Amount Before Tax and Discount: " + totalAmount / 100.0);
        System.out.println("Final Price After Tax and Discount: " + calculateFinalAmount());
    }

    public static void main(String[] args) {
        
        items item = new items((byte) 250, (short) 3,700.0f, 0.1); 
        item.calculateTotalAmount();
        item.displayItemDetails();
    }
}