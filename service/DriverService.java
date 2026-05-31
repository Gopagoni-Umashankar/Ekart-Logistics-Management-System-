package com.example.Ekart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveDriverdto;
import com.example.Ekart.entity.Carrier;
import com.example.Ekart.entity.Driver;
import com.example.Ekart.entity.Truck;
import com.example.Ekart.exception.CarrierNotFoundException;
import com.example.Ekart.exception.DriverAlreadyExistsException;
import com.example.Ekart.exception.DriverNotFoundException;
import com.example.Ekart.exception.TruckNotFoundException;
import com.example.Ekart.repository.CarrierRepo;
import com.example.Ekart.repository.DriverRepo;
import com.example.Ekart.repository.TruckRepo;



@Service
public class DriverService 
{
	@Autowired
	private DriverRepo driverrepo;
	
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(SaveDriverdto driverdto) 
	{
		if (driverrepo.findByContact(driverdto.getContact()).isPresent()) 
		{
	        throw new DriverAlreadyExistsException();
	    }

	    //save new driver
	    Driver d = new Driver();
	    d.setName(driverdto.getName());
	    d.setContact(driverdto.getContact());

	    Driver saved = driverrepo.save(d);

	    //Response
	    ResponseStructure<Driver> rs = new ResponseStructure<>();
	    rs.setStatusCode(HttpStatus.CREATED.value());
	    rs.setMessage("Driver saved successfully");
	    rs.setData(saved);

	    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Driver>> findDriver(long contact)
	{
		Driver d1=driverrepo.findByContact(contact).orElseThrow(()->new DriverNotFoundException("driver not exist"));
		ResponseStructure<Driver>rs=new ResponseStructure<Driver>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Driver");
		rs.setData(d1);
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);		
	}

	public ResponseEntity<ResponseStructure<Driver>> deleteDriver(long contact) 
	{
		Driver d2=driverrepo.findByContact(contact).orElseThrow(()->new DriverNotFoundException("driver not exist"));
		driverrepo.delete(d2);
		ResponseStructure<Driver>rs=new ResponseStructure<Driver>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Driver deleted successfully");
		rs.setData(d2);
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);		
	}

	public ResponseEntity<ResponseStructure<Driver>> driverDeleteById(int id)
	{
	  Driver d=driverrepo.findById(id).orElseThrow(()->new DriverNotFoundException("driver not exist"));
	  ResponseStructure<Driver>rs=new ResponseStructure<Driver>();
	  driverrepo.delete(d);
	  rs.setStatusCode(HttpStatus.OK.value());
	  rs.setMessage("driver deleted");
	  rs.setData(d);
	  return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
		
	}

	public ResponseEntity<ResponseStructure<List<Driver>>> getalldriver() 
	{
	  List<Driver> dlist=driverrepo.findAll();
	  if(dlist.isEmpty())
	  {
		  throw new DriverNotFoundException("driver not avaliable");
	  }
	ResponseStructure<List<Driver>>rs=new ResponseStructure<List<Driver>>();
	rs.setStatusCode(HttpStatus.OK.value());
	rs.setMessage("all drivers list");
	rs.setData(dlist);
	 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}

	@Autowired
	private TruckRepo truckrepo;
	@Autowired
	private CarrierRepo carrierrepo;
	//assign truckid and carrier id to driver
	public ResponseEntity<ResponseStructure<Driver>> assignTruckAndCarrierToDriver(int driverid, int truckid, int carrierid)
	{
	  Driver driver=driverrepo.findById(driverid).orElseThrow(()->new DriverNotFoundException("driver not found"));
	  Truck truck=truckrepo.findById(truckid).orElseThrow(()->new TruckNotFoundException("truck not found"));
	  Carrier carrier=carrierrepo.findById(carrierid).orElseThrow(()->new CarrierNotFoundException("carrier not found"));
	  
	  driver.setTruck(truck);
	  driver.setCarrier(carrier);
	  driverrepo.save(driver);
	  
	  ResponseStructure<Driver>rs=new ResponseStructure<Driver>();
	  rs.setStatusCode(HttpStatus.OK.value());
	  rs.setMessage("driver with this is"+driverid+"assigned successfully");
	  rs.setData(driver);
	  return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Driver>> updateDriver(int id, SaveDriverdto driverdto) 
	{
	   Driver d=driverrepo.findById(id).orElseThrow(()->new DriverNotFoundException("Driver not found"));
	   d.setName(driverdto.getName());
	   d.setContact(driverdto.getContact());
	   Driver updated=driverrepo.save(d);
	   ResponseStructure<Driver>rs=new ResponseStructure<Driver>();
	   rs.setData(updated);
	   rs.setMessage("updated the driver");
	   rs.setStatusCode(HttpStatus.OK.value());
	   return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	   
	}

	
	
}


