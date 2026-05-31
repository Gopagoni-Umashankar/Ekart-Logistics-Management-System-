package com.example.Ekart.datatransferobject;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResponseStructure<T>
{
	
	   private int statusCode;
	   private String message;
	   private T data;
	 /*  public ResponseStructure() {
		super();
	   }
	   public ResponseStructure(int StatusCode, String message, T data) {
		super();
		this.StatusCode = StatusCode;
		Message = message;
		this.data = data;
	   }
	   public int getStatusCode() {
		   return StatusCode;
	   }
	   public void StatusCode(int StatusCode) {
		   this.StatusCode = StatusCode;
	   }
	   public String getMessage() {
		   return Message;
	   }
	   public void setMessage(String message) {
		   Message = message;
	   }
	   public T getData() {
		   return data;
	   }
	   public void setData(T data) {
		   this.data = data;
	   }
	   @Override
	   public String toString() {
		return "ResponceStructure [setStatusCode=" + StatusCode + ", Message=" + Message + ", data=" + data + "]";
	   }
	   
	 */  
	   
}
