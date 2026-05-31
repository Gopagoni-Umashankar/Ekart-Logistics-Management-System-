package com.example.Ekart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveCarrierdto;
import com.example.Ekart.entity.Carrier;
import com.example.Ekart.exception.CarrierAlreadyExistsException;
import com.example.Ekart.exception.CarrierNotFoundException;
import com.example.Ekart.repository.CarrierRepo;

@Service
public class CarrierService {

	@Autowired
	private CarrierRepo carrierrepo;

	public ResponseEntity<ResponseStructure<Carrier>> saveCarrier(SaveCarrierdto carrierdto) {
		if (carrierrepo.findBymobno(carrierdto.getMobno()).isPresent()) {
			throw new CarrierAlreadyExistsException();
		}

		Carrier c = new Carrier();
		c.setName(carrierdto.getName());
		c.setMail(carrierdto.getMail());
		c.setMobno(carrierdto.getMobno());
		Carrier saved = carrierrepo.save(c);

		ResponseStructure<Carrier> rs = new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("carrier saved successfully");
		rs.setData(saved);

		return ResponseEntity.status(HttpStatus.CREATED.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Carrier>> findCarrier(long mobno) {
		Carrier c1 = carrierrepo.findBymobno(mobno).orElseThrow(() -> new CarrierNotFoundException("not fonund"));
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Carrier found successfully");
		rs.setData(c1);
		return ResponseEntity.status(HttpStatus.OK.value()).body(rs);

	}


	public ResponseEntity<ResponseStructure<Carrier>> deleteCarrier(long mobno) 
	{
		Carrier c2 = carrierrepo.findBymobno(mobno).orElseThrow(() -> new CarrierNotFoundException("carrier not found"));
		carrierrepo.delete(c2);
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Carrier deleted successfully");
		rs.setData(c2);
		return ResponseEntity.status(HttpStatus.OK.value()).body(rs);	
	}


	public ResponseEntity<ResponseStructure<List<Carrier>>> getcarrierall()
	{
		List<Carrier> clist=carrierrepo.findAll();
		if(clist.isEmpty())
		{
			throw new CarrierNotFoundException("carrier not available");
		}
		ResponseStructure<List<Carrier>>rs=new ResponseStructure<List<Carrier>>();
		rs.setData(clist);
		rs.setMessage("carrier fetched success");
		rs.setStatusCode(HttpStatus.OK.value());
		return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}
	public ResponseEntity<ResponseStructure<Carrier>> deleteCarrier(int id) {
		Carrier c2 = carrierrepo.findById(id).orElseThrow(() -> new CarrierNotFoundException("carrier not found"));
		carrierrepo.delete(c2);
		ResponseStructure<Carrier> rs = new ResponseStructure<Carrier>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Carrier deleted successfully");
		rs.setData(c2);
		return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}

	public ResponseEntity<ResponseStructure<Carrier>> updateCarrier(int id, SaveCarrierdto carrierdto) 
	{
	 Carrier c=carrierrepo.findById(id).orElseThrow(()->new CarrierNotFoundException(" carrier not found"));
	 c.setMail(carrierdto.getMail());
	 c.setMobno(carrierdto.getMobno());
	 c.setName(carrierdto.getName());
	 Carrier updated=carrierrepo.save(c);
	 ResponseStructure<Carrier>rs=new ResponseStructure<Carrier>();
	 rs.setData(updated);
	 rs.setMessage("carrier updated");
	 rs.setStatusCode(HttpStatus.OK.value());
	 return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
		
	}

}
