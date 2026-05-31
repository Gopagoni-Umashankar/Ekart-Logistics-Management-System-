package com.example.Ekart.exception;

public class TruckAlreadyExistsException extends RuntimeException
{

	public TruckAlreadyExistsException() {
		super("Truck Alreday Exist");
	}
    
}
