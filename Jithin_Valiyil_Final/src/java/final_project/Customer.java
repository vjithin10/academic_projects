/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
/**
 *
 * @author Jithin
 */

@XmlRootElement(name = "Customer", namespace="")
@XmlType(propOrder = { "id", "billAddress", "shipAddress", "order"})
public class Customer {
    private Address billAddress = new Address();
    private Address shipAddress = new Address();
    private Order order = new Order();
    private String id;
    
    @XmlElement(name = "ID")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    @XmlElement(name = "BillAddress")
    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
        this.shipAddress = billAddress;
    }
    @XmlElement(name = "ShipAddress")
    public Address getShipAddress() {
        return shipAddress;
    }

    @XmlElement(name = "Order")
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }
    
    @Override
    public String toString(){
      return "{First name : " + billAddress.getFirstName() + ", Last Name: " + billAddress.getLastName() + ", Street Address: " + billAddress.getStreetAddress()+
              ", City: " + billAddress.getCity() + "}";  
    }
    
}