
package alferez.it.pkg2e;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.*;

public class Execution {
    public void orderInput(){
        Scanner scan = new Scanner(System.in);
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate dateToday = LocalDate.now();
        
        System.out.print("Enter no. of Orders: ");
        int count = scan.nextInt();
        
        Implementor[] orders = new Implementor[count];
        
        for(int i = 0; i < count; i++){
            orders[i] = new Implementor();
            
            System.out.printf("\nEnter Details for Order %d:\n", (i + 1));
            
            boolean alreadyExist;
            int id;
            do {
                System.out.print("Order ID: ");
                id = scan.nextInt();
                alreadyExist = false;
                for (Implementor order : orders) {
                    if (order != null && order.id == id) {
                        System.out.println("This ID already exists. Please enter a different ID.");
                        alreadyExist = true;
                        break;
                    }
               }   
            } while (alreadyExist);
            
            scan.nextLine();
            System.out.print("Customer Name: ");
            String name = scan.nextLine();
            
            LocalDate date = null;
            while (date == null) {
                System.out.print("Order Date (yyyy-mm-dd): ");
                String dateInput = scan.nextLine();
                try {
                    date = LocalDate.parse(dateInput, dateFormat);
                    if (date.isAfter(dateToday)) {
                        System.out.println("Due date cannot be in the future.");
                        date = null; 
                    }
                }catch (DateTimeParseException e) {
                    System.out.println("Invalid date format.");
                }                
            }
            
            double amount;
            while(true){
                System.out.print("Order Amount: ");
                amount = scan.nextDouble();
                
                if(amount < 0){
                    System.out.println("Order Amount cannot be negative.");
                }else{
                    break;
                }
            }
            
            scan.nextLine();
            
            List<String> validStatus = Arrays.asList("Pending", "Shipped", "Delivered", "Cancelled");
            String stats;
            while (true){
                System.out.print("Status (Pending, Shipped, Delivered, Cancelled): ");
                stats = scan.nextLine();
                
                if(!validStatus.contains(stats)){
                    System.out.println("Invalid Status.");
                }else{
                    break;
                }
            }
            
            orders[i].addCustomerOrder(id, name, date, amount, stats);            
        }
        
        System.out.println("");
        System.out.printf("%-10s %-20s %-15s %-15s %-10s\n",
                "Order ID", "Customer Name", "Order Date", "Order Amount", "Order Status");
        for(Implementor order : orders){
            order.viewCustomerOrder();
        }
    }
}