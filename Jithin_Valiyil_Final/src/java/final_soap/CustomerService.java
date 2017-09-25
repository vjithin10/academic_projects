/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_soap;

import final_project.Customer;
import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import final_project.CustomerContainer;

/**
 *
 * @author Jithin
 */
@WebService(serviceName = "CustomerService")
public class CustomerService {

    private CustomerContainer container = CustomerContainer.getInstance();
    private ArrayList<String> list = new ArrayList();
    
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addCustomer")
    public String addCustomer(@WebParam(name = "customer") Customer customer) throws Exception {
        container.addCustomer(customer);
        JAXBContext context = JAXBContext.newInstance(Customer.class);
        Marshaller m = context.createMarshaller();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        m.marshal(customer, baos);
        
        list.add(baos.toString());
        
        String result = "Customer added...XML = " + baos.toString();
        return result;
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getCustomers")
    public String getCustomers() throws Exception{
        StringBuilder nList = new StringBuilder();
        
        for (String customer : list){
         nList.append(customer);
         nList.append("\n");
        }
        return "Customers in XML format: " + nList;
    }

}
