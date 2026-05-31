package com.example.Ekart.entity;


import java.time.LocalDate;
import java.time.LocalTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Loading 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
  private int id;
  private LocalDate date;
  private LocalTime time;
  
  @ManyToOne
  private Address address;

  public Loading() {
	super();
  }

  public Loading(int id, LocalDate date, LocalTime time, Address address) {
	super();
	this.id = id;
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

  public void setDate(LocalDate date) {
	this.date = date;
  }

  public LocalTime getTime() {
	return time;
  }

  public void setTime(LocalTime time) {
	this.time = time;
  }

  public Address getAddress() {
	return address;
  }

  public void setAddress(Address address) {
	this.address = address;
  }

  @Override
  public String toString() {
	return "Loading [id=" + id + ", date=" + date + ", time=" + time + ", address=" + address + "]";
  }
  
  
 
}
