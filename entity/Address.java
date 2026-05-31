package com.example.Ekart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Address
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
 private int id;
 private String street;
 @Column(unique = true)
 private String city;
 private int pincode;
 private String state;
 
 
// public Address() {
//	super();
// }
// public Address( String street, String city, int pincode, String state) {
//	super();
//	
//	this.street = street;
//	this.city = city;
//	this.pincode = pincode;
//	this.state = state;
// }
// public int getId() {
//	return id;
// }
// public void setId(int id) {
//	this.id = id;
// }
// public String getStreet() {
//	return street;
// }
// public void setStreet(String street) {
//	this.street = street;
// }
// public String getCity() {
//	return city;
// }
// public void setCity(String city) {
//	this.city = city;
// }
// public int getPincode() {
//	return pincode;
// }
// public void setPincode(int pincode) {
//	this.pincode = pincode;
// }
// public String getState() {
//	return state;
// }
// public void setState(String state) {
//	this.state = state;
// }
// @Override
// public String toString() {
//	return "Address [id=" + id + ", street=" + street + ", city=" + city + ", pincode=" + pincode + ", state=" + state
//			+ "]";
// }
// 
// 
}
