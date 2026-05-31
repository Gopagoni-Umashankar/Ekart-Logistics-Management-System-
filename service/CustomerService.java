package com.example.Ekart.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveCustDto;
import com.example.Ekart.entity.Customer;
import com.example.Ekart.exception.CustomerNotFoundException;
import com.example.Ekart.exception.GeneralException;
import com.example.Ekart.repository.CustomerRepo;

@Service
public class CustomerService 
{
  @Autowired
  private  CustomerRepo customerrepo;
  
  public ResponseEntity<ResponseStructure<Customer>> saveCust(SaveCustDto custdto) {
	    
	    // Check duplicate first
	    if (customerrepo.findByMobno(custdto.getMobno()).isPresent()) {
	        throw new GeneralException("customer already exists");
	    }
	    
	    Customer cust = new Customer();
	    cust.setName(custdto.getName());
	    cust.setAge(custdto.getAge());
	    cust.setMobno(custdto.getMobno());   // ✅ from DTO, not from cust
	    cust.setEmail(custdto.getEmail());
	    
	    Customer saved = customerrepo.save(cust);  // ✅ actually save it
	    
	    ResponseStructure<Customer> rs = new ResponseStructure<>();
	    rs.setStatusCode(HttpStatus.CREATED.value());
	    rs.setMessage("customer saved successfully");
	    rs.setData(saved);
	    return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);
	}

  public ResponseEntity<ResponseStructure<Customer>> findCust(long mobno)
  {
    Customer cust=customerrepo.findByMobno(mobno).orElseThrow(()->new GeneralException("customer not exist"));
    ResponseStructure<Customer>rs=new ResponseStructure<Customer>();
	  rs.setStatusCode(HttpStatus.OK.value());
	  rs.setMessage(" cust details");
	  rs.setData(cust);
	  return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
  }

  public ResponseEntity<ResponseStructure<Customer>> deleteCust(long mobno)
  {
	  Customer cust=customerrepo.findByMobno(mobno).orElseThrow(()->new GeneralException("customer not exist"));
	    ResponseStructure<Customer>rs=new ResponseStructure<Customer>();
	      customerrepo.delete(cust);
		  rs.setStatusCode(HttpStatus.OK.value());
		  rs.setMessage(" cust details deleted");
		  rs.setData(cust);
		  return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
  }

  public  ResponseEntity<ResponseStructure<Customer>> updateCust(long mobno, SaveCustDto custdto)
  {
	Customer cust=customerrepo.findByMobno(mobno).orElseThrow(()->new CustomerNotFoundException("cust not found"));
	cust.setAge(custdto.getAge());
	cust.setEmail(custdto.getEmail());
	cust.setMobno(custdto.getMobno());
	cust.setName(custdto.getName());
	Customer c=customerrepo.save(cust);
	ResponseStructure<Customer>rs=new ResponseStructure<Customer>();
	rs.setStatusCode(HttpStatus.OK.value());
	rs.setMessage("updated");
	rs.setData(c);
	 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
  }
}
