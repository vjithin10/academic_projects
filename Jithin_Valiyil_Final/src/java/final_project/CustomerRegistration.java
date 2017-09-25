/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.primefaces.event.SelectEvent;
import org.primefaces.context.RequestContext;
import org.primefaces.event.UnselectEvent;
import final_soap.CustomerService;
/**
 *
 * @author Jithin
 */

@ManagedBean(name = "customerRegistration")
@SessionScoped
public class CustomerRegistration implements Serializable{
    private Customer customer;
    private Customer selectedCustomer;
    private List<Customer> customerList = new ArrayList<Customer>();
    private CustomerDataModel  dataModel;
    CustomerService port = new CustomerService();
    private static int id = 0;
    private String[] states = {"AK","AL","AR","AZ","CA","CO","CT","DC","DE","FL","GA",
        "GU","HI","IA","ID", "IL","IN","KS","KY","LA","MA","MD","ME","MH","MI","MN",
        "MO","MS","MT","NC","ND","NE","NH","NJ","NM","NV","NY", "OH","OK","OR","PA",
        "PR","PW","RI","SC","SD","TN","TX","UT","VA","VI","VT","WA","WI","WV","WY"};
    
    private String[] products = {"Computer Science 101", "History 101", "Geography 101", "English 101", "Biology 101", "Algebra 101", "Calculus 101"};
    
    private String fName;
    
    public CustomerRegistration(){
        customer = new Customer();
        dataModel = new CustomerDataModel(customerList);
    }
    
    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer c) {
        this.customer = c;
    }
    public List<Customer> getCustomers() {
        return customerList;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        this.customerList = customers;
    }
    
    public String getFirstName() {
        return customer.getBillAddress().getFirstName();
        
    }

    public void setFirstName(String firstName) {
        customer.getBillAddress().setFirstName(firstName);
        customer.getShipAddress().setFirstName(firstName);
    }

    public String getLastName() {
        return customer.getBillAddress().getLastName();
    }

    public void setLastName(String lastName) {
        customer.getBillAddress().setLastName(lastName);
        customer.getShipAddress().setLastName(lastName);
    }

    public String getAddress() {
        return customer.getBillAddress().getStreetAddress();
    }

    public void setAddress(String address) {
        customer.getBillAddress().setStreetAddress(address);
        customer.getShipAddress().setStreetAddress(address);
    }

    public String getCity() {
        return customer.getBillAddress().getCity();
    }

    public void setCity(String city) {
        customer.getBillAddress().setCity(city);
        customer.getShipAddress().setCity(city);
    }

    public String getState() {
        return customer.getBillAddress().getState();
    }

    public String[] getStates(){
        return this.states;
    }
    
    public void setState(String state) {
       customer.getBillAddress().setState(state);
       customer.getShipAddress().setState(state);
    }

    public String getZipcode() {
        return customer.getBillAddress().getZipCode();
    }

    public void setZipcode(String zipcode) {
        customer.getBillAddress().setZipCode(zipcode);
        customer.getShipAddress().setZipCode(zipcode);
    }
    
    public String getProduct(){
        return customer.getOrder().getProduct();
    }
    
    public void setProduct(String product){
        customer.getOrder().setProduct(product);
    }
    
    public String[] getProducts(){
        return this.products;
    }
    
    public String getQuantity(){
        return customer.getOrder().getQuantity();
    }
    
    public void setQuantity(String quantity){
        customer.getOrder().setQuantity(quantity);
    }
    
    public String getCost(){
        return customer.getOrder().getTotalCost();
    }
    
    public String getPaymentType(){
        return customer.getOrder().getPaymentType();
    }
    
    public void setPaymentType(String payment){
        customer.getOrder().setPaymentType(payment);
    }
    
    public String getAcct(){
        return customer.getOrder().getAccountNumber();
    }
    
    public void setAcct(String account){
        customer.getOrder().setAccountNumber(account);
    }
    
    public void registerCustomer() throws Exception{
        System.out.println(" Submit Button clicked..");
        System.out.println(" First Name  = " + customer.getBillAddress().getFirstName());
        this.fName = customer.getBillAddress().getFirstName();
        System.out.println(" Last Name  = " + customer.getBillAddress().getLastName());
        System.out.println(" Address  = " + customer.getBillAddress().getStreetAddress());
        System.out.println(" City  = " + customer.getBillAddress().getCity());
        System.out.println(" State  = " + customer.getBillAddress().getState());
        System.out.println(" Zip  = " + customer.getBillAddress().getZipCode());
        System.out.println(" Product : " + customer.getOrder().getProduct());
        System.out.println(" Quantity : " + customer.getOrder().getQuantity());
        
        int result = Integer.parseInt(customer.getOrder().getQuantity()) * 50;
        customer.getOrder().setTotalCost(String.valueOf(result));
        System.out.println(" Total Cost : " + customer.getOrder().getTotalCost());
        System.out.println(" Payment Type : " + customer.getOrder().getPaymentType());
        System.out.println(" Account Number : " + customer.getOrder().getAccountNumber());
   
        
        String results = port.addCustomer(customer);
        String list = port.getCustomers();

        System.out.println(results);
        System.out.println(list);
        
        if (customer.getId() == null || customer.getId().equalsIgnoreCase("-1")) {
            customer.setId("" + (id++));
            customerList.add(customer);
            customer = new Customer(); customer.setId("-1");
        } 
        else {}
  
    }
  
    public void cancelRegister(){
        RequestContext.getCurrentInstance().reset("regForm");
        this.customer = new Customer();
    }
    public CustomerDataModel getDataModel() {
        return this.dataModel;
    }
    
    public Customer getSelectedCustomer() {
        if (customer != null)
        System.out.println(" Returning Customer ID = " + customer.getId());
        return this.customer;
    }
    
    public void setSelectedCustomer(Customer c) {
        if (c != null) {
        System.out.println(" Selected Customer ID = " + c.getId());
        this.customer = c;
        }
    }
    
    public void processCustomerSelection(SelectEvent evt) {
        System.out.println(" Customer Selected = " + evt.getObject());
        this.setSelectedCustomer((Customer)evt.getObject());
    }
    public void onRowUnselect(UnselectEvent event){
        System.out.println(" Row unselected from the Data Table . ");
        this.customer = new Customer();
    }
    
    
}
