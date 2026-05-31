package com.example.Ekart.service;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveOrderdto;
import com.example.Ekart.entity.Address;
import com.example.Ekart.entity.Cargo;
import com.example.Ekart.entity.Customer;
import com.example.Ekart.entity.Loading;
import com.example.Ekart.entity.Orders;
import com.example.Ekart.entity.Truck;
import com.example.Ekart.entity.Unloading;
import com.example.Ekart.exception.AddressNotFoundException;
import com.example.Ekart.exception.CustomerNotFoundException;
import com.example.Ekart.exception.GeneralException;
import com.example.Ekart.exception.OrderProcessingException;
import com.example.Ekart.exception.OrderNotFoundException;
import com.example.Ekart.exception.TruckNotFoundException;
import com.example.Ekart.repository.AddressRepo;
import com.example.Ekart.repository.CarrierRepo;
import com.example.Ekart.repository.CustomerRepo;
import com.example.Ekart.repository.OrderRepo;
import com.example.Ekart.repository.TruckRepo;

import jakarta.persistence.criteria.Order;
import jakarta.servlet.http.HttpServlet;

@Service
public class OrderService 
{
    @Autowired
    private OrderRepo orderrepo;
    
    @Autowired
    private AddressRepo addressrepo;
    
        
    public ResponseEntity<ResponseStructure<Orders>> Placeorder(SaveOrderdto orderdto) 
    {
        Orders o = new Orders();
       
        o.setOrderdate(LocalDateTime.now());
       
                
        Cargo c = new Cargo();
        c.setName(orderdto.getCargoname());
        c.setDescription(orderdto.getCargodesc());
        c.setWeight(orderdto.getCargoweight());
        c.setCount(orderdto.getCargocount());
        o.setCargo(c); 
        
        Address loadingaddress = addressrepo.findById(orderdto.getLoadingaddressid()).orElseThrow(() -> new AddressNotFoundException("loading address not found"));        
        Loading load = new Loading();
        load.setAddress(loadingaddress);
        
        Address unloadingaddress = addressrepo.findById(orderdto.getUnloadingaddressid())
                .orElseThrow(() -> new AddressNotFoundException("unloading address not found"));
        
        Unloading unload = new Unloading();
        unload.setAddress(unloadingaddress);
        
        if(loadingaddress.getId()==unloadingaddress.getId())
        {
        	throw new GeneralException("Loading address id and unloading id is same");
        }
        
        o.setLoading(load);
        o.setUnloading(unload);
        o.setStatus("PLACED"); // or from DTO if you add later
        // ✅ FIXED
        double cost = calculateCost(c);
        o.setCost(cost);
        
        Orders savedOrder = orderrepo.save(o);
        ResponseStructure<Orders> rs = new ResponseStructure<>();
        rs.setStatusCode(HttpStatus.CREATED.value());
        rs.setData(savedOrder);
        rs.setMessage("Order placed successfully");
          
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);
    }

    // ✅ moved outside
    public double calculateCost(Cargo cargo) 
    {
    	double Cost=(cargo.getWeight()*cargo.getCount())*10;
    	return Cost;		
	}

	public ResponseEntity<ResponseStructure<List<Orders>>> getallorders()
	{
		 List<Orders> olist=orderrepo.findAll();	
		  if(olist.isEmpty())
		  {
			 throw new OrderNotFoundException("orders not avaliable");
		  }
		  ResponseStructure<List<Orders>>rs=new ResponseStructure<List<Orders>>();
		  rs.setData(olist);
	      rs.setMessage("all orders");
	      rs.setStatusCode(HttpStatus.OK.value());
	      return ResponseEntity.status(HttpStatus.OK.value()).body(rs);	
	}

	@Autowired
	private CustomerRepo custrepo;
	public ResponseEntity<ResponseStructure<Orders>> customerplaceorder(long mobno, SaveOrderdto orderdto) {
		Customer cust=custrepo.findByMobno(mobno).orElseThrow(()->new CustomerNotFoundException("cust not found"));
		Orders o=new Orders();
		o.setOrderdate(LocalDateTime.now());
		
		Cargo c=new Cargo();
		c.setName(orderdto.getCargoname());
		c.setDescription(orderdto.getCargodesc());
		c.setWeight(orderdto.getCargoweight());
		c.setCount(orderdto.getCargocount());
		
		o.setCargo(c);
		
		Address loadingAddress=addressrepo.findById(orderdto.getLoadingaddressid()).orElseThrow(()->new AddressNotFoundException("loading address not found"));
		Loading l=new Loading();
		l.setAddress(loadingAddress);
		
		Address unloadingaddress=addressrepo.findById(orderdto.getUnloadingaddressid()).orElseThrow(()->new AddressNotFoundException("unloading address not found"));
		if(loadingAddress.getId()==unloadingaddress.getId())
		{
			throw new GeneralException("loading and unloading address cannot be same");
		}
			Unloading unloading=new Unloading();
			unloading.setAddress(unloadingaddress);
			
			o.setLoading(l);
			o.setUnloading(unloading);
			
			o.setStatus("PLACED"); // or from DTO if you add later
	        // ✅ FIXED
	        double cost = calculateCost(c);
	        o.setCost(cost);
	        
	        cust.getOrderr().add(o);
	        orderrepo.save(o);
	        
	        ResponseStructure<Orders> rs=new ResponseStructure<>();
			rs.setStatusCode(HttpStatus.CREATED.value());
			rs.setMessage("order placed successfully");
			return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);
		
	}

	public ResponseEntity<ResponseStructure<Customer>> customersallorders(long mobno)
	{
		Customer cust=custrepo.findByMobno(mobno).orElseThrow(()->new GeneralException("no orders "));
		ResponseStructure<Customer>rs=new ResponseStructure<Customer>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("fetched customer orders successfully");
		rs.setData(cust);
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}
    
	@Autowired
	private TruckRepo truckrepo;
	public ResponseEntity<ResponseStructure<Orders>> assigncarrierToOrder(int orderid, int truckid) {
		Orders o=orderrepo.findById(orderid).orElseThrow(()->new OrderProcessingException("order not found"));
		Truck truck=truckrepo.findById(truckid).orElseThrow(()->new TruckNotFoundException("truck not found"));
		
		if(o.getCargo()==null)
		{
			throw new OrderProcessingException("cargo not found for this order");
		}
		double orderwt=o.getCargo().getWeight()*o.getCargo().getCount();
		if(truck.getCapacity()>=orderwt)
		{
			o.setCarrier(truck.getCarrier());
			o.setStatus("conformed");
			truck.setCapacity(truck.getCapacity()-orderwt);
			orderrepo.save(o);
			truckrepo.save(truck);
		}
		else
		{
			throw new OrderProcessingException("insufficent truck capacity");
		}
		ResponseStructure<Orders> rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
		rs.setMessage("carrier assigned successfully");
		return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Orders>> UpdateDateAndTimeStatusLoading(int orderid) {
		Orders o=orderrepo.findById(orderid).orElseThrow(()->new OrderProcessingException("order not found"));
		if(o.getLoading()==null)
		{
			throw new OrderProcessingException("loading details not found");
		}
		o.getLoading().setDate(LocalDate.now());
		o.getLoading().setTime(LocalTime.now());
		
		o.setStatus("on_the_way");
		orderrepo.save(o);
		
		ResponseStructure<Orders>rs=new ResponseStructure<Orders>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("order updated successfully");
		rs.setData(o);   
	    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Orders>> UpdateDateAndTimeStatusUnLoading(int orderid) {
		Orders o=orderrepo.findById(orderid).orElseThrow(()->new OrderProcessingException("order not found"));
		if(o.getUnloading()==null)
		{
			throw new OrderProcessingException("unloading details not found");
		}
		o.getUnloading().setDate(LocalDate.now());
		o.getUnloading().setTime(LocalTime.now());
		
		o.setStatus("delivered");
		orderrepo.save(o);
		ResponseStructure<Orders>rs=new ResponseStructure<Orders>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("order updated successfully");
		rs.setData(o);
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}
	
	
}