package com.example.Ekart.datatransferobject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCarrierdto 
{
      @NotBlank(message = "name sholud not be empty")
	  private String name;
      
      @NotBlank(message = "email have not enter")
      @Email(message = "email is not in correct format")
	  private String mail;
      
      
      @Min(value = 6000000000L, message = "mobile number is invalid")
      @Max(value = 9999999999L, message = "mobile number is invalid")
	  private long mobno;
	  
//	  public SaveCarrierdto() {
//		super();
//	}
//
//	  public SaveCarrierdto(String name, String mail, long mobno) {
//		super();
//		this.name = name;
//		this.mail = mail;
//		this.mobno = mobno;
//	  }
//
//	  public String getName() {
//		  return name;
//	  }
//
//	  public void setName(String name) {
//		  this.name = name;
//	  }
//
//	  public String getMail() {
//		  return mail;
//	  }
//
//	  public void setMail(String mail) {
//		  this.mail = mail;
//	  }
//
//	  public long getMobno() {
//		  return mobno;
//	  }
//
//	  public void setMobno(long mobno) {
//		  this.mobno = mobno;
//	  }
//
//	  @Override
//	  public String toString() {
//		return "SaveCarrierdto [name=" + name + ", mail=" + mail + ", mobno=" + mobno + "]";
//	  }
//	  
}
