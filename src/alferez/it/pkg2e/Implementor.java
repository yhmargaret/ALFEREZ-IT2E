
package alferez.it.pkg2e;

import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;

public class Implementor {
    int id;
    String customerName;
    int orderDate;
    double orderAmount;
    String status; 
    
    public void addCustomerOrder(int id, String name, int orderDate, double orderAmount, String status){
        this.id = id;
        this.customerName = name;
        this.orderDate  = orderDate;
        this.orderAmount = orderAmount;
        this.status = status;
                          
    } 
    
    public void viewCustomerOrder(){
        System.out.printf("%-8d %-12s %-12s %-10f %-8d", "ID", "Name", "Date", "Amount", "status");   
    }
    
    
}
