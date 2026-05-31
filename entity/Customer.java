package com.example.Ekart.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
public class Customer 
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  @Column(unique = true)
  private long mobno;
  private String email;
  private int age;
  
  @OneToMany
  private List<Orders>orderr;

  /*
  public Customer() {
	super();
  }

  public Customer(int id, String name, long mobno, String email, int age, List<Orders> orderr) {
	super();
	this.id = id;
	this.name = name;
	this.mobno = mobno;
	this.email = email;
	this.age = age;
	this.orderr = orderr;
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

  public long getMobno() {
	return mobno;
  }

  public void setMobno(long mobno) {
	this.mobno = mobno;
  }

  public String getEmail() {
	return email;
  }

  public void setEmail(String email) {
	this.email = email;
  }

  public int getAge() {
	return age;
  }

  public void setAge(int age) {
	this.age = age;
  }

  public List<Orders> getOrderr() {
	return orderr;
  }

  public void setOrderr(List<Orders> orderr) {
	this.orderr = orderr;
  }

  @Override
  public String toString() {
	return "Customer [id=" + id + ", name=" + name + ", mobno=" + mobno + ", email=" + email + ", age=" + age
			+ ", orderr=" + orderr + "]";
  }
  */
	
}
