package com.example.Ekart.datatransferobject;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveDriverdto 
{
  @NotBlank(message = "driver name cant be empty")
  private String name;
  
  @NotNull(message = "driver contact cant be null")
  @Digits(integer = 10, fraction = 0,message = "number len should be 10 and not in decimal")
  private long contact;
  
//  public SaveDriverdto() {
//	super();
//  }
//  public SaveDriverdto(String name, long contact) {
//	super();
//	this.name = name;
//	this.contact = contact;
//  }
//  public String getName() {
//	return name;
//  }
//  public void setName(String name) {
//	this.name = name;
//  }
//  public long getContact() {
//	return contact;
//  }
//  public void setContact(long contact) {
//	this.contact = contact;
//  }
//  @Override
//  public String toString() {
//	return "SaveDriverdto [name=" + name + ", contact=" + contact + "]";
//  }
// 
  
  
}
