/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Jithin
 */

public class CustomerContainer {
    private ArrayList<Customer> list = new ArrayList();
    private static CustomerContainer container = null;
    
    private CustomerContainer() {}
    
    public static synchronized CustomerContainer  getInstance() {
        if (container == null) {
            container = new CustomerContainer();
        }
        return container;
    }
    
    public void addCustomer(Customer customer) {
        list.add(customer);
    }
    
    public ArrayList<Customer> getCustomers() {
        return list;
    }
    @XmlElement(name = "List")
    public void setCustomers(ArrayList<Customer> customers) {
        this.list = customers;
    }
    
    @Override
    public String toString(){
     StringBuilder listString= new StringBuilder();
     
     for (Customer customer : list){
         listString.append(customer.toString());
         listString.append("\n");
     }
     return listString.toString();
    }
    
}
