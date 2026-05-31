package com.example.Ekart.datatransferobject;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveCargodto 
{
	@NotBlank(message = "name sholud not be empty")
	private String name;
	
	@NotBlank(message = "description sholud not be empty")
	private String description;
	
	@NotNull(message = "weight is mandatory")
	@Positive(message = "weight must be greater than 0")
	private Double weight;
	
	@NotNull(message = "count is mandatory")
	@Min(value = 1, message = "count must be at least 1")
	private Integer count;
//	public SaveCargodto() {
//		super();
//	}
//	public SaveCargodto(String name, String description, Double weight, Integer count) {
//		super();
//		this.name = name;
//		this.description = description;
//		this.weight = weight;
//		this.count = count;
//	}
//	public String getName() {
//		return name;
//	}
//	public void setName(String name) {
//		this.name = name;
//	}
//	public String getDescription() {
//		return description;
//	}
//	public void setDescription(String description) {
//		this.description = description;
//	}
//	public Double getWeight() {
//		return weight;
//	}
//	public void setWeight(Double weight) {
//		this.weight = weight;
//	}
//	public Integer getCount() {
//		return count;
//	}
//	public void setCount(Integer count) {
//		this.count = count;
//	}
//	@Override
//	public String toString() {
//		return "SaveCargodto [name=" + name + ", description=" + description + ", weight=" + weight + ", count=" + count
//				+ "]";
//	}
}