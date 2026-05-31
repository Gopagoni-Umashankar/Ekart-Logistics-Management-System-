package com.example.Ekart.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Unloading 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	 @Id
	 private int id;
	  private LocalDate date;
	  private LocalTime time;
	  
	  @ManyToOne
	  private Address address;

	  
	  public Unloading() {
		super();
	}

	  public Unloading( LocalDate date, LocalTime time, Address address) {
		super();
		this.date = date;
		this.time = time;
		this.address = address;
	  }

	  public int getId() {
		  return id;
	  }

	  public void setId(int id) {
		  this.id = id;
	  }

	  public LocalDate getDate() {
		  return date;
	  }

	  public void setDate(LocalDate localDate) {
		  this.date = localDate;
	  }

	  public LocalTime getTime() {
		  return time;
	  }

	  public void setTime(LocalTime localTime) {
		  this.time = localTime;
	  }

	  public Address getAddress() {
		  return address;
	  }

	  public void setAddress(Address address) {
		  this.address = address;
	  }

	  @Override
	  public String toString() {
		return "Unloading [id=" + id + ", date=" + date + ", time=" + time + ", address=" + address + "]";
	  }
	  
}
