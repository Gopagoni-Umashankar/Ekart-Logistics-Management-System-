package com.example.Ekart.datatransferobject;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveAddressdto 
{
	
	@NotBlank(message = "street sholud not be empty")
	 private String street;
	
	@NotBlank(message = "city sholud not be empty")
	 private String city;
	
	@NotNull(message = "pincode will not be not null")
	@Min(value = 100000, message = "pincode must be 6 digits")
	@Max(value = 999999, message = "pincode must be 6 digits")
	 private int pincode;
	
	@NotBlank(message = "state sholud not be empty")
	 private String state;
	 
//	 public SaveAddressdto() {
//		super();
//	}
//
//	 public SaveAddressdto(String street, String city, int pincode, String state) {
//		super();
//		this.street = street;
//		this.city = city;
//		this.pincode = pincode;
//		this.state = state;
//	 }
//
//	 public String getStreet() {
//		 return street;
//	 }
//
//	 public void setStreet(String street) {
//		 this.street = street;
//	 }
//
//	 public String getCity() {
//		 return city;
//	 }
//
//	 public void setCity(String city) {
//		 this.city = city;
//	 }
//
//	 public int getPincode() {
//		 return pincode;
//	 }
//
//	 public void setPincode(int pincode) {
//		 this.pincode = pincode;
//	 }
//
//	 public String getState() {
//		 return state;
//	 }
//
//	 public void setState(String state) {
//		 this.state = state;
//	 }
//
//	 @Override
//	 public String toString() {
//		return "SaveAddressdto [street=" + street + ", city=" + city + ", pincode=" + pincode + ", state=" + state
//				+ "]";
//	 }
	 
}
