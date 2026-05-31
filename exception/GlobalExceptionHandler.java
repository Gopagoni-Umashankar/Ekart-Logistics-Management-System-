package com.example.Ekart.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.example.Ekart.datatransferobject.ResponseStructure;

@RestControllerAdvice
public class GlobalExceptionHandler {

    // 409 CONFLICT — already exists
    @ExceptionHandler({
        DriverAlreadyExistsException.class,
        TruckAlreadyExistsException.class,
        CarrierAlreadyExistsException.class,
        AddressAlreadyExistsException.class
    })
    public ResponseEntity<ResponseStructure<String>> handleAlreadyExists(Exception ex) {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(409);
        rs.setMessage(ex.getMessage());
        rs.setData(null);
        return ResponseEntity.status(409).body(rs);
    }

    // 404 NOT FOUND
    @ExceptionHandler({
        DriverNotFoundException.class,
        TruckNotFoundException.class,
        CarrierNotFoundException.class,
        AddressNotFoundException.class,
        CustomerNotFoundException.class,
        OrderNotFoundException.class
    })
    public ResponseEntity<ResponseStructure<String>> handleNotFound(Exception ex) {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(404);
        rs.setMessage(ex.getMessage());
        rs.setData(null);
        return ResponseEntity.status(404).body(rs);
    }

    // 400 BAD REQUEST
    @ExceptionHandler({GeneralException.class,OrderProcessingException.class})
    public ResponseEntity<ResponseStructure<String>> handleBadRequest(Exception ex) {
        ResponseStructure<String> rs = new ResponseStructure<>();
        rs.setStatusCode(400);
        rs.setMessage(ex.getMessage());
        rs.setData(null);
        return ResponseEntity.status(400).body(rs);
    }
    
    //validation exception handling
   @ExceptionHandler(MethodArgumentNotValidException.class)
   public ResponseEntity<ResponseStructure<Map<String, String>>> MethodArgumentNotValidExceptionHandling( MethodArgumentNotValidException ex)
   {
	   ResponseStructure<Map<String,String>>rs=new ResponseStructure<Map<String,String>>();
	   rs.setMessage("invalid data");
	   rs.setStatusCode(HttpStatus.BAD_REQUEST.value());
	   Map<String,String>map=new HashMap<>();
	   List<ObjectError >obj=ex.getAllErrors();
	   for(ObjectError error:obj)
	   {
		   String fieldname=((FieldError)error).getField();
		   String message=error.getDefaultMessage();
		   map.put(fieldname, message);
	   }
	   rs.setData(map);
	   return ResponseEntity.status(400).body(rs);
   }
}

