package supermarket_billing_system;
import java.util.*;
import java.io.*; 
import java.util.ArrayList;

//Class representing a shopping cart
public class ShoppingCart {
private List<Product> items;
private double discount;

//Constructor for the ShoppingCart class
public ShoppingCart() {
 items = new ArrayList<>();
 discount = 0.0;
}

//Add a product to the cart
public void addItem(Product product) {
 items.add(product);
}

//Remove a product from the cart based on the index
public void removeItem(int index) {
 items.remove(index);
}

//Calculate the total cost of all items in the cart after applying the discount
public double calculateTotal() {
 double total = 0;
 for (Product item : items) {
     total += item.getPrice() * item.getQuantity();
 }
 total -= discount;
 return total;
}

//Set the discount amount
public void setDiscount(double discount) {
 this.discount = discount;
}

//Print the invoice with details of all items, the total cost, and the applied discount
public void printInvoice() {
 System.out.println("----------- INVOICE -----------");
 for (int i = 0; i < items.size(); i++) {
     Product item = items.get(i);
     System.out.println((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity());
 }
 System.out.println("-------------------------------");
 System.out.println("Total: $" + calculateTotal());
 System.out.println("Discount: $" + discount);
 System.out.println("-------------------------------");
}

public int getCartSize() {
 return items.size();
}

public Product getItem(int i) {
 return items.get(i);
}

//Save the invoice to a file
public void saveInvoiceToFile() {
 try (FileWriter writer = new FileWriter("invoice.txt")) {
     writer.write("----------- INVOICE -----------\n");
     for (int i = 0; i < items.size(); i++) {
         Product item = items.get(i);
         writer.write((i + 1) + ". " + item.getName() + "\t$" + item.getPrice() + "\tQty: " + item.getQuantity() + "\n");
     }
     writer.write("-------------------------------\n");
     writer.write("Total: $" + calculateTotal() + "\n");
     writer.write("Discount: $" + discount + "\n");
     writer.write("-------------------------------\n");
     System.out.println("Invoice saved to file.");
 } catch (IOException e) {
     System.out.println("Failed to save invoice to file: " + e.getMessage());
 }
}
}
