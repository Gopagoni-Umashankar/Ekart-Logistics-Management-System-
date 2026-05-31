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
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Truck
{
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int id;
private String name;
@Column(unique = true)
private String number;
private double capacity;
private String status;

@OneToOne
private Carrier carrier;

/*
public Truck() {
	super();
}

public Truck(String name, String number, double capacity, String status, Carrier carrier) {
	this.name = name;
	this.number = number;
	this.capacity = capacity;
	this.status = status;
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

public String getNumber() {
	return number;
}

public void setNumber(String number) {
	this.number = number;
}

public double getCapacity() {
	return capacity;
}

public void setCapacity(double capacity) {
	this.capacity = capacity;
}

public String getStatus() {
	return status;
}

public void setStatus(String status) {
	this.status = status;
}

public Carrier getCarrier() {
	return carrier;
}

public void setCarrier(Carrier carrier) {
	this.carrier = carrier;
}

@Override
public String toString() {
	return "Truck [id=" + id + ", name=" + name + ", number=" + number + ", capacity=" + capacity + ", status=" + status
			+ ", carrier=" + carrier + "]";
}

	*/
}
