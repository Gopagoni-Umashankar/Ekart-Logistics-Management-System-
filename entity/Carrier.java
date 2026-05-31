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

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Carrier 
{
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
  private int id;
  private String name;
  private String mail;
  @Column(unique = true)
  private long mobno;
  
  /*
  public Carrier() {
	super();
  }

  public Carrier( String name, String mail, long mobno) {
	super();
	
	this.name = name;
	this.mail = mail;
	this.mobno = mobno;
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

  public String getMail() {
	return mail;
  }

  public void setMail(String mail) {
	this.mail = mail;
  }

  public long getMobno() {
	return mobno;
  }

  public void setMobno(long mobno) {
	this.mobno = mobno;
  }

  @Override
  public String toString() {
	return "Carrier [id=" + id + ", name=" + name + ", mail=" + mail + ", mobno=" + mobno + "]";
  }
  
  
  */
}
