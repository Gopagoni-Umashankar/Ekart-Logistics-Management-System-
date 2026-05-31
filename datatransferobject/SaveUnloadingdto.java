package com.example.Ekart.datatransferobject;

import java.time.LocalDate;
import java.time.LocalTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaveUnloadingdto 
{
	private LocalDate date;
	  private LocalTime time;
	  
	/*  public SaveUnloadingdto() {
		super();
	}

	  public SaveUnloadingdto(LocalDate date, LocalTime time) {
		super();
		this.date = date;
		this.time = time;
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

	  @Override
	  public String toString() {
		return "SaveUnloadingdto [date=" + date + ", time=" + time + "]";
	  }

	*/ 
}
