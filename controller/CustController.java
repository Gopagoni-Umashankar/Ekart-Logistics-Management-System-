package com.example.Ekart.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveCustDto;
import com.example.Ekart.datatransferobject.SaveOrderdto;
import com.example.Ekart.entity.Customer;
import com.example.Ekart.entity.Orders;
import com.example.Ekart.repository.CustomerRepo;
import com.example.Ekart.service.CustomerService;
import com.example.Ekart.service.OrderService;

import jakarta.validation.Valid;

@RestController
public class CustController 
{
	 @Autowired
	   private OrderService orderservice;
	    @PostMapping("/cust/placeorder")
	    public ResponseEntity<ResponseStructure<Orders>> placeorder(@Valid @RequestBody SaveOrderdto saveorderdto)
	    {
	        System.out.println("Controller hit"); // 🔥 debug
	        return orderservice.Placeorder(saveorderdto); // ✅ FIX
	    }
	    
	 @Autowired
	 private CustomerService customerservice;
	 @PostMapping("customer/savecustomer")
	 public ResponseEntity<ResponseStructure<Customer>> savecustomer(@Valid @RequestBody SaveCustDto custdto)
	 {
		 return customerservice.saveCust(custdto);
	 }
	 
	 @GetMapping("/cust/findcustomer")
	 public ResponseEntity<ResponseStructure<Customer>> findcustomer(@Valid @RequestParam long mobno)
	 {
		return  customerservice.findCust(mobno);
	 }
	 
	 @DeleteMapping("/cust/deletecustomer")
	 public ResponseEntity<ResponseStructure<Customer>> deletecustomer(@Valid @RequestParam long mobno)
	 {
		return customerservice.deleteCust(mobno);
	 }
	 
	 @PostMapping("/cust/placeorderid")
	 public ResponseEntity<ResponseStructure<Orders>> CustPlaceOrder(@Valid @RequestParam long mobno,@RequestBody SaveOrderdto orderdto)
	 {
		  return orderservice.customerplaceorder(mobno,orderdto);
	 }
	 
	 @GetMapping("/cust/getalloders")
	 public ResponseEntity<ResponseStructure<Customer>> customerallorders(@Valid @RequestParam long mobno)
	 {
		return  orderservice.customersallorders(mobno);
	 }
	 
	 @PutMapping("/cust/update/{id}")
	 public ResponseEntity<ResponseStructure<Customer>> updateCust(@Valid @RequestParam long mobno,@RequestBody SaveCustDto custdto)
	 {
		return  customerservice.updateCust(mobno,custdto);
	 }
} 
