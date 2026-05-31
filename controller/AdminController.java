package com.example.Ekart.controller;

import java.util.List;

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
import com.example.Ekart.datatransferobject.SaveAddressdto;
import com.example.Ekart.datatransferobject.SaveCarrierdto;
import com.example.Ekart.datatransferobject.SaveDriverdto;
import com.example.Ekart.datatransferobject.SaveTruckdto;
import com.example.Ekart.entity.Address;
import com.example.Ekart.entity.Carrier;
import com.example.Ekart.entity.Driver;
import com.example.Ekart.entity.Orders;
import com.example.Ekart.entity.Truck;
import com.example.Ekart.service.AddressService;
import com.example.Ekart.service.CarrierService;
import com.example.Ekart.service.DriverService;
import com.example.Ekart.service.OrderService;
import com.example.Ekart.service.TruckService;

import jakarta.validation.Valid;
@RestController
public class AdminController 
{
  //---------------------------------------------SAVE---------------------------------------------------------
  @Autowired
  private DriverService driverservice; //driver
  @PostMapping("/admin/save/driver")
  public ResponseEntity<ResponseStructure<Driver>> saveDriver( @Valid @RequestBody SaveDriverdto driverdto)
  {
	return driverservice.saveDriver(driverdto);
  }
  
  @Autowired
  private TruckService truckservice;  //truck
  @PostMapping("/admin/save/truck")
  public ResponseEntity<ResponseStructure<Truck>> saveTruck(@Valid @RequestBody SaveTruckdto truckdto)
  {
	 return  truckservice.saveTruck(truckdto);
  }
  
  @Autowired
  private CarrierService carrierservice; //carrier
  @PostMapping("/admin/save/carrier")
  public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(@Valid @RequestBody SaveCarrierdto carrierdto)
  {
	 return  carrierservice.saveCarrier(carrierdto);
  }
  
  @Autowired
  private AddressService addressservice; //address
  @PostMapping("/admin/save/address")
  public ResponseEntity<ResponseStructure<Address>> saveAddress(@Valid @RequestBody SaveAddressdto addressdto)
  {
	 return  addressservice.saveAddress(addressdto);
  }
  
 //----------------------------------------------------FIND-------------------------------------------------------------------
  //@Autowired 
  
  @GetMapping("/admin/find/truck/{number}")  //TRUCK FINDING
  public ResponseEntity<ResponseStructure<Truck>> findTruck(@Valid @PathVariable String number)
  {
	 return truckservice.findTruck(number); 
  }

  //@Autowired
  @GetMapping("/admin/find/address/{city}")   //ADDRESS FINDING
  public ResponseEntity<ResponseStructure<Address>> findAddress(@Valid @PathVariable String city)
  {
	  return addressservice.findAddress(city);
  }

//  @Autowired
  @GetMapping("/admin/find/driver/{contact}")
  public ResponseEntity<ResponseStructure<Driver>> findDriver(@Valid @PathVariable long contact)
  {
	  return driverservice.findDriver(contact);
  }
  
//  @Autowired
   @GetMapping("/admin/find/carrier/{mobno}")
   public ResponseEntity<ResponseStructure<Carrier>> findCarrier(@Valid @PathVariable long mobno)
   {
	  return carrierservice.findCarrier(mobno);
   }
//-----------------------------------------------------------DELETE-------------------------------------------------------------------------
//----------------------------------------------------Deleteing address using city/id--------------------------------------------------------------------------------
//  @Autowired
    @DeleteMapping("/admin/delete/address")
    public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @RequestParam String City)
    {
    	return addressservice.deleteAddress(City);
    }
    
    @DeleteMapping("/admin/delete/address/{id}")
    public ResponseEntity<ResponseStructure<Address>> deleteAddress(@Valid @PathVariable int id)
    {
    	return addressservice.deleteAddresBy(id);
    }
    
//--------------------------------------------------Deleting Driver using number/id----------------------------------------------------------------
//  @Autowired
    @DeleteMapping("/admin/delete/driver")
    public ResponseEntity<ResponseStructure<Driver>> deleteDriver(@Valid @RequestParam long Contact)
    {
    	return driverservice.deleteDriver(Contact);
    }
    
    @DeleteMapping("/admin/delete/driver/{id}")
    public ResponseEntity<ResponseStructure<Driver>> deleteDriver(@Valid  @PathVariable int id)
    {
    	return driverservice.driverDeleteById(id);
    }

////@Autowired------------------------------------------Deleting carrier using mobno/id--------------------------------------------------------
   @DeleteMapping("admin/delete/carrier")
   public ResponseEntity<ResponseStructure<Carrier>> deleteByMobno(@Valid  @RequestParam long mobno)
   {
	 return carrierservice.deleteCarrier(mobno);  
   }
    
    @DeleteMapping("/admin/delete/carrier/{id}")
    public ResponseEntity<ResponseStructure<Carrier>> deleteCarrier(@Valid  @PathVariable int id)
    {
    	return carrierservice.deleteCarrier(id);
    }
    
//  @Autowired -----------------------------------------Deleting truck using number/id----------------------------------------------
    @DeleteMapping("/admin/delete/truck")
    public ResponseEntity<ResponseStructure<Truck>> deleteTruck(@Valid  @RequestParam String Number)
    {
    	return truckservice.deleteTruck(Number);
    }
    
    
    @DeleteMapping("/admin/delete/truck/{id}")
    public ResponseEntity<ResponseStructure<Truck>> deleteTruck(@Valid  @PathVariable int id)
    {
    	return truckservice.deleteTruck(id);
    }
//  ------------------------------------------------------------------------------------------------------------------------------------
// ----------------------------------------------------FIND ALL-------------------------------------------------------------------------
    
    @GetMapping("/admin/findall/carrier")
    public ResponseEntity<ResponseStructure<List<Carrier>>> getallcarrier()
    {
    	return carrierservice.getcarrierall();
    }
    
    @GetMapping("admin/findall/truck")
    public ResponseEntity<ResponseStructure<List<Truck>>> getalltruck()
    {
    	return truckservice.getalltruck();
    }
    
    @GetMapping("/admin/findall/address")
    public ResponseEntity<ResponseStructure<List<Address>>> getalladdress()
    {
     return	addressservice.getalladdress();
    }
    
    @GetMapping("/admin/findall/driver")
    public ResponseEntity<ResponseStructure<List<Driver>>> getalldriver()
    {
    	return driverservice.getalldriver();
    }
    
    @Autowired
    private OrderService orderservice;
    @GetMapping("/admin/findall/orders")
    public ResponseEntity<ResponseStructure<List<Orders>>> getallorders()
    {
    	return orderservice.getallorders();
    }
    //------------------------------------------------------assign truck,carrier and driver------------------------------------------------
    @PostMapping("/admin/assign/driver")
    public ResponseEntity<ResponseStructure<Driver>> assignTruckAndCarrierToDriver(@Valid  @RequestParam int driverid,@RequestParam int truckid,@RequestParam int carrierid)
    {
          return driverservice.assignTruckAndCarrierToDriver(driverid,truckid,carrierid);
    }
    
    @PostMapping("/admin/assign/truck")
    public ResponseEntity<ResponseStructure<Truck>> assignCarrier(@Valid @RequestParam int truckid,@RequestParam int carrierid)
    {
    	return truckservice.assignCarriertoTruck(truckid,carrierid);
    }
    
    @PostMapping("/admin/assign/order")
    public ResponseEntity<ResponseStructure<Orders>> assignCarrierToOrder(@Valid @RequestParam int orderid,@RequestParam int truckid)
    {
    	return orderservice.assigncarrierToOrder(orderid,truckid);
    }
    
    //---------------------------------------------------------update order set date time status Loading and unloading-----------------------
    @PostMapping("/admin/order/update/updateloading")
    public ResponseEntity<ResponseStructure<Orders>> updateLoading(@Valid @RequestParam int orderid)
    {
    	return orderservice.UpdateDateAndTimeStatusLoading(orderid);
    }
    @PostMapping("/admin/order/update/updateunloading")
    public ResponseEntity<ResponseStructure<Orders>> updateUnLoading(@Valid @RequestParam int orderid)
    {
    	return orderservice.UpdateDateAndTimeStatusUnLoading(orderid);
    }
    
    //-----------------------------------------updateing driver, Carrier, Address,truck-----------------------------------------
    
    @PutMapping("/admin/update/driver/{id}")
    public ResponseEntity<ResponseStructure<Driver>> updateDriver(@Valid @PathVariable int id, @RequestBody SaveDriverdto driverdto)
    {
    	return driverservice.updateDriver(id,driverdto);
    }
    
    @PutMapping("admin/update/carrier/{id}")
    public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(@Valid @PathVariable int id,@RequestBody SaveCarrierdto carrierdto)
    {
    	return carrierservice.updateCarrier(id,carrierdto);
    }
    
    @PutMapping("/admin/update/address/{id}")
    public ResponseEntity<ResponseStructure<Address>> updateAddress(@Valid @PathVariable int id,@RequestBody SaveAddressdto addressdto)
    {
    	return addressservice.updateAddress(id,addressdto);
    }
    
    @PutMapping("/admin/update/truck/{id}")
    public ResponseEntity<ResponseStructure<Truck>> updateTruck(@Valid @PathVariable int id,@RequestBody SaveTruckdto truckdto)
    {
    	return truckservice.updateTruck(id,truckdto);
    }
}



