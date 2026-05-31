package com.example.Ekart.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Driver 
{
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int id;
private String name;
@Column(unique = true)
private long contact;

@OneToOne
private Truck truck;
@OneToOne
private Carrier carrier;
/*
public Driver() {
	super();
}
public Driver( String name, long contact, Truck truck, Carrier carrier) {
	super();
	this.name = name;
	this.contact = contact;
	this.truck = truck;
	this.carrier = carrier;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public long getContact() {
	return contact;
}
public void setContact(long contact) {
	this.contact = contact;
}
public Truck getTruck() {
	return truck;
}
public void setTruck(Truck truck) {
	this.truck = truck;
}
public Carrier getCarrier() {
	return carrier;
}
public void setCarrier(Carrier carrier) {
	this.carrier = carrier;
}
@Override
public String toString() {
	return "Driver [id=" + id + ", name=" + name + ", contact=" + contact + ", truck=" + truck + ", carrier=" + carrier
			+ "]";
}
*/

}
