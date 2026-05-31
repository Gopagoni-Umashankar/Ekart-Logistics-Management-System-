package com.example.Ekart.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Ekart.datatransferobject.ResponseStructure;
import com.example.Ekart.datatransferobject.SaveAddressdto;
import com.example.Ekart.entity.Address;
import com.example.Ekart.exception.AddressAlreadyExistsException;
import com.example.Ekart.exception.AddressNotFoundException;
import com.example.Ekart.repository.AddressRepo;

@Service
public class AddressService 
{

	@Autowired
	private AddressRepo addressrepo;
	public ResponseEntity<ResponseStructure<Address>> saveAddress(SaveAddressdto addressdto)
	{
		if(addressrepo.findByCity(addressdto.getCity()).isPresent())
		{
			throw new AddressAlreadyExistsException();
		}
		Address a=new Address();
		a.setState(addressdto.getState());
		a.setCity(addressdto.getCity());
		a.setStreet(addressdto.getStreet());
		a.setPincode(addressdto.getPincode());
		Address saved=addressrepo.save(a);
		
		ResponseStructure<Address>rs=new ResponseStructure<>();
		rs.setStatusCode(HttpStatus.CREATED.value());
			    rs.setMessage("Address saved successfully");
			    rs.setData(saved);
			    return ResponseEntity.status(HttpStatus.CREATED).body(rs);
	
	}
	public ResponseEntity<ResponseStructure<Address>> findAddress(String city) 
	{
		Address a1=addressrepo.findByCity(city).orElseThrow(()-> new AddressNotFoundException("Address not exist"));	
		ResponseStructure<Address>rs=new ResponseStructure<Address>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("Address exist");
		rs.setData(a1);
		return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(String city) 
	{
       Address a2=addressrepo.findByCity(city).orElseThrow(()-> new AddressNotFoundException("Address not exist"));
       addressrepo.delete(a2);
       ResponseStructure<Address>rs=new ResponseStructure<>();
       rs.setStatusCode(HttpStatus.OK.value());
       rs.setMessage("address deleted successfully");
       rs.setData(a2);
       return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	public ResponseEntity<ResponseStructure<Address>> deleteAddresBy(int id) 
	{
	   Address a=addressrepo.findById(id).orElseThrow(()->new AddressNotFoundException("Address not exist"));
	   addressrepo.delete(a);
	   ResponseStructure<Address>rs=new ResponseStructure<Address>();
	   rs.setStatusCode(HttpStatus.OK.value());
	   rs.setMessage("address deleted successfully");
	   rs.setData(a);
	   return ResponseEntity.status(HttpStatus.OK).body(rs);
	}
	public ResponseEntity<ResponseStructure<List<Address>>> getalladdress() 
	{
	  List<Address> alist=addressrepo.findAll();	
	  if(alist.isEmpty())
	  {
		  throw new AddressNotFoundException("address not avaliable");
	  }
	  ResponseStructure<List<Address>>rs=new ResponseStructure<List<Address>>();
	  rs.setData(alist);
      rs.setMessage("all address");
      rs.setStatusCode(HttpStatus.OK.value());
      return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}
	public ResponseEntity<ResponseStructure<Address>> updateAddress(int id, SaveAddressdto addressdto) 
	{
		Address a=addressrepo.findById(id).orElseThrow(()->new AddressNotFoundException("Address not found"));
		a.setCity(addressdto.getCity());
		a.setPincode(addressdto.getPincode());
		a.setState(addressdto.getState());
		a.setStreet(addressdto.getStreet());
		Address update=addressrepo.save(a);
		ResponseStructure<Address>rs=new ResponseStructure<Address>();
		rs.setStatusCode(HttpStatus.OK.value());
		rs.setMessage("updated");
		rs.setData(update);
		return ResponseEntity.status(HttpStatus.OK.value()).body(rs);
	}	
	
	
}
