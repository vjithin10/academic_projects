/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.ArrayList;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;
/**
 *
 * @author Jithin
 */
class Customers {
    private ArrayList<Customer> customers = new ArrayList();

    public Customers() {
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    @XmlElement(name = "Customer")
    public void setCustomers(ArrayList<Customer> studs) {
        this.customers = studs;
    }
    
}
