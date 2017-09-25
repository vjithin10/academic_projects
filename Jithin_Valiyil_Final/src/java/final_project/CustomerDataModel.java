/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package final_project;

import java.util.List;  
import javax.faces.model.ListDataModel;  
import org.primefaces.model.SelectableDataModel; 
/**
 *
 * @author Jithin
 */
public class CustomerDataModel extends ListDataModel<Customer> implements SelectableDataModel<Customer> {
    
    public CustomerDataModel(){
    }
    
    public CustomerDataModel(List<Customer> data) {  
        super(data);  
    }  
      
    @Override  
    public Customer getRowData(String rowKey) {  
          
        System.out.println(" Key = " + rowKey);
        List<Customer> customers = (List<Customer>) getWrappedData();  
          
        for(Customer customer : customers) {  
            if(customer.getId().equals(rowKey))  
                return customer;  
        }  
          System.out.println(" User not found");
        return null;  
    }  
  
    @Override  
    public Object getRowKey(Customer st) {  
        return st.getId();
    }
}
