package com.example.Ekart.exception;

public class AddressAlreadyExistsException extends RuntimeException
{

	public AddressAlreadyExistsException() {
		super("Address already exist");
	}
   
}
