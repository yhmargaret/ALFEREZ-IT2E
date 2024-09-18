
package alferez.it.pkg2e;

import java.time.LocalDate;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Implementor {
    int id;
    String customerName;
    LocalDate orderDate;
    double orderAmount;
    String status; 
    
    public void addCustomerOrder(int id, String name, LocalDate orderDate, double orderAmount, String status){
        this.id = id;
        this.customerName = name;
        this.orderDate  = orderDate;
        this.orderAmount = orderAmount;
        this.status = status;
                          
    } 
    
    public void viewCustomerOrder(){
        System.out.printf("%-10d %-20s %-15s S%-15.2f %-10s\n", id, customerName, orderDate.toString(), orderAmount, status);
    }
    
    
}
