package com.example.Ekart.entity;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Orders
{
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Id
  private int id;
  private LocalDateTime orderdate;
  private String status;
  private Double cost;
  
  @OneToOne(cascade = CascadeType.ALL)
  private Cargo cargo;
  @ManyToOne
  private Carrier carrier;
  @OneToOne(cascade = CascadeType.ALL)
  private Loading loading;
  @OneToOne(cascade = CascadeType.ALL)
  private Unloading unloading;
  
  /*
  public Orders() {
	super();
  }
  public Orders(LocalDateTime orderdate, String status, Double cost, Cargo cargo, Carrier carrier, Loading loading,
		Unloading unloading) {
	super();
	this.orderdate = orderdate;
	this.status = status;
	this.cost = cost;
	this.cargo = cargo;
	this.carrier = carrier;
	this.loading = loading;
	this.unloading = unloading;
  }
  public int getId() {
	return id;
  }
  public void setId(int id) {
	this.id = id;
  }
  public void setOrderdate(LocalDateTime orderdate) {
      this.orderdate = orderdate;
  }

  public LocalDateTime getOrderdate() {
      return orderdate;
  }
  public String getStatus() {
	return status;
  }
  public void setStatus(String status) {
	this.status = status;
  }
  public Double getCost() {
	return cost;
  }
  public void setCost(Double cost) {
	this.cost = cost;
  }
  public Cargo getCargo() {
	return cargo;
  }
  public void setCargo(Cargo cargo) {
	this.cargo = cargo;
  }
  public Carrier getCarrier() {
	return carrier;
  }
  public void setCarrier(Carrier carrier) {
	this.carrier = carrier;
  }
  public Loading getLoading() {
	return loading;
  }
  public void setLoading(Loading loading) {
	this.loading = loading;
  }
  public Unloading getUnloading() {
	return unloading;
  }
  public void setUnloading(Unloading unloading) {
	this.unloading = unloading;
  }
  @Override
  public String toString() {
	return "Orders [id=" + id + ", orderdate=" + orderdate + ", status=" + status + ", cost=" + cost + ", cargo="
			+ cargo + ", carrier=" + carrier + ", loading=" + loading + ", unloading=" + unloading + "]";
  }
  */
}