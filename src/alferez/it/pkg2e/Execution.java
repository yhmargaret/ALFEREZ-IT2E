
package alferez.it.pkg2e;

import java.util.*;
import java.util.Scanner;

        
public class Execution {
    public void getOrders(){
        Scanner scan = new Scanner (System.in);
        System.out.print("Enter no. of order: ");
        int count = scan.nextInt();
        
        Implementor[] impls = new Implementor[count];
        for (int i = 0; i < count; i++){
            impls[i] = new Implementor();
            
            System.out.println("\nEnter details of order" +(i+1));
            boolean alreadyExist;
            int id;
            do{
                System.out.print("Order ID: ");
                id = scan.nextInt();
                alreadyExist = false;
                for(Implementor impl : impls){
                    if(impl != null && impl.id == id){
                        System.out.println("Already Exists.");
                        alreadyExist = true;
                        break;
                        
                    }
                }
            }while(alreadyExist);       
        
        }       
    }
}