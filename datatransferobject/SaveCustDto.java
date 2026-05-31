package com.example.Ekart.datatransferobject;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCustDto 
{
	@NotBlank(message = "name sholud not be empty")
    private String name;
	
	 @Min(value = 6000000000L, message = "mobile number is invalid")
	 @Max(value = 9999999999L, message = "mobile number is invalid")
    private long mobno;
	
	 @NotBlank(message = "email not mentioned")
	 @Email(message = "email not acc to format")
    private String email;
	
	 @Min(value = 18, message = "age must be at least 18")
	 @Max(value = 100, message = "invalid age")
    private int age;
//	public SaveCustDto() {
//		super();
//	}
//	public SaveCustDto(String name, long mobno, String email, int age) {
//		super();
//		this.name = name;
//		this.mobno = mobno;
//		this.email = email;
//		this.age = age;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public long getMobno() {
//		return mobno;
//	}
//	public void setMobno(long mobno) {
//		this.mobno = mobno;
//	}
//	public String getEmail() {
//		return email;
//	}
//	public void setEmail(String email) {
//		this.email = email;
//	}
//	public int getAge() {
//		return age;
//	}
//	public void setAge(int age) {
//		this.age = age;
//	}
//	@Override
//	public String toString() {
//		return "SaveCustDto [name=" + name + ", mobno=" + mobno + ", email=" + email + ", age=" + age + "]";
//	}
    
}
