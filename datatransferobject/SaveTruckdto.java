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
public class SaveTruckdto 
{
	@NotBlank(message = "truck name is not filled")
	private String name;
	
	
	private String number;
	
	private double capacity;
	
	private String status;
	
//	public SaveTruckdto() {
//		super();
//	}
//
//	public SaveTruckdto(String name, String number, double capacity, String status) {
//		super();
//		this.name = name;
//		this.number = number;
//		this.capacity = capacity;
//		this.status = status;
//	}
//
//	
//
//	public String getName() {
//		return name;
//	}
//
//	public void setName(String name) {
//		this.name = name;
//	}
//
//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}
//
//	public double getCapacity() {
//		return capacity;
//	}
//
//	public void setCapacity(double capacity) {
//		this.capacity = capacity;
//	}
//
//	public String getStatus() {
//		return status;
//	}
//
//	public void setStatus(String status) {
//		this.status = status;
//	}
//
//	@Override
//	public String toString() {
//		return "SaveTruckdto [name=" + name + ", number=" + number + ", capacity=" + capacity
//				+ ", status=" + status + "]";
//	}
   
}
