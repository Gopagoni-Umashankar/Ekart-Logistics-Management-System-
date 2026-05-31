package com.example.Ekart.entity;

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
public class Cargo
{
@GeneratedValue(strategy = GenerationType.AUTO)
@Id
private int id;
private String name;
private String description;
private Double weight;
private Integer count;

/*
public Cargo() {
	super();
}

public Cargo(String name, String description, Double weight, Integer count) {
	super();
	this.name = name;
	this.description = description;
	this.weight = weight;
	this.count = count;
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

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public Double getWeight() {
	return weight;
}

public void setWeight(Double weight) {
	this.weight = weight;
}

public Integer getCount() {
	return count;
}

public void setCount(Integer count) {
	this.count = count;
}

@Override
public String toString() {
	return "Cargo [id=" + id + ", name=" + name + ", description=" + description + ", weight=" + weight + ", count="
			+ count + "]";
*/
}