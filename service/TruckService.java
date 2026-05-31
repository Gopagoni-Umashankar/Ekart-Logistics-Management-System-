package com.example.Ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveTruckdto;
import com.example.Ekart.entity.Carrier;
import com.example.Ekart.entity.Truck;
import com.example.Ekart.exception.CarrierNotFoundException;
import com.example.Ekart.exception.TruckAlreadyExistsException;
import com.example.Ekart.exception.TruckNotFoundException;
import com.example.Ekart.repository.CarrierRepo;
import com.example.Ekart.repository.TruckRepo;

@Service
public class TruckService 
{
	@Autowired
    private TruckRepo truckrepo;
	
	public ResponseEntity<ResponseStructure<Truck>>  saveTruck(SaveTruckdto truckdto)
	{
	   if (truckrepo.findByNumber(truckdto.getNumber()).isPresent()) 
			{
		        throw new TruckAlreadyExistsException();
		    }

		    //Saveing the truck details
		    Truck t = new Truck();
		    t.setName(truckdto.getName());
		    t.setNumber(truckdto.getNumber());
		    t.setCapacity(truckdto.getCapacity());
		    t.setStatus(truckdto.getStatus());
		    Truck saved = truckrepo.save(t);

		    //Response back 
		    ResponseStructure<Truck> rs = new ResponseStructure<>();
		    rs.setStatusCode(HttpStatus.CREATED.value());
		    rs.setMessage("Driver saved successfully");
		    return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);

		    
	}

	   public ResponseEntity<ResponseStructure<Truck>> findTruck(String number)
	   {
		   Truck t1 = truckrepo.findByNumber(number).orElseThrow(() -> new TruckNotFoundException("TRUCK NOT EXIST"));
		   {
			   ResponseStructure<Truck> rs = new ResponseStructure<>();
			    rs.setStatusCode(HttpStatus.OK.value());
			    rs.setMessage(" Truck exist");
			    rs.setData(t1);
                
			    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
		   }	
	   }

	   public ResponseEntity<ResponseStructure<Truck>> deleteTruck(String number) 
	   {
		   Truck t1 = truckrepo.findByNumber(number).orElseThrow(() -> new TruckNotFoundException("TRUCK NOT EXIST"));
		   {
			   truckrepo.delete(t1);
			   ResponseStructure<Truck> rs = new ResponseStructure<>();
			    rs.setStatusCode(HttpStatus.OK.value());
			    rs.setMessage(" Truck deleted");
			    rs.setData(t1);

			    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);  
		   }
	   }

	   public ResponseEntity<ResponseStructure<Truck>> deleteTruck(int id) 
	   {
		   
		   Truck t1 = truckrepo.findById(id).orElseThrow(() -> new TruckNotFoundException("TRUCK NOT EXIST"));
		   {
			   truckrepo.delete(t1);
			   ResponseStructure<Truck> rs = new ResponseStructure<>();
			    rs.setStatusCode(HttpStatus.OK.value());
			    rs.setMessage(" Truck deleted");
			    rs.setData(t1);

			    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);		   }
		
	   }

	   public ResponseEntity<ResponseStructure<List<Truck>>> getalltruck() 
	   {
		List<Truck> tlist=truckrepo.findAll();
		if(tlist.isEmpty())
		{
			throw new TruckNotFoundException("truck not avaliable");
		}
		ResponseStructure<List<Truck>>rs=new ResponseStructure<List<Truck>>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("all truck details");
		rs.setData(tlist);
         
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	   }

	   @Autowired
	   private CarrierRepo carrierrepo;
	   public ResponseEntity<ResponseStructure<Truck>> assignCarriertoTruck(int truckid, int carrierid) {
		    Truck truck = truckrepo.findById(truckid).orElseThrow(()-> new TruckNotFoundException("truck not found"));
		    Carrier carrier = carrierrepo.findById(carrierid).orElseThrow(()->new CarrierNotFoundException("carrier not found"));
		    truck.setCarrier(carrier);
		    Truck saved = truckrepo.save(truck);
		    ResponseStructure<Truck> rs = new ResponseStructure<>();
		    rs.setStatusCode(HttpStatus.OK.value());
		    rs.setMessage("Carrier assigned to truck");
		    rs.setData(saved);
		    return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
		}

	   public ResponseEntity<ResponseStructure<Truck>> updateTruck(int id, SaveTruckdto truckdto) 
	   {
		Truck t=truckrepo.findById(id).orElseThrow(()->new TruckNotFoundException("truck not found"));
		t.setCapacity(truckdto.getCapacity());
		t.setName(truckdto.getName());
		t.setNumber(truckdto.getNumber());
		t.setStatus(truckdto.getStatus());
		Truck updated=truckrepo.save(t);
		ResponseStructure<Truck>rs=new ResponseStructure<Truck>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("truck updated");
		rs.setData(updated);
		 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	   }
	
}
