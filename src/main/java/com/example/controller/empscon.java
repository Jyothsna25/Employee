package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Employee;
import com.example.model.empsdetails;
import com.example.service.empsservice;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;




@RestController
public class empscon
{
	@Autowired
	 private empsservice empsservice;
	 
@PostMapping("/save")
		public ResponseEntity<Employee>  saveemployee(@RequestBody empsdetails empsdetails)
		{
			Employee savedEmployee =  empsservice.saveemployee(empsdetails);
			return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
			
		}
		
		
//get by id

@GetMapping("/{id}")
		public Employee getEmployee(@PathVariable int id)
		{
			return empsservice.getEmployee(id);
		}

//delete by id 


@DeleteMapping("/{id}")
public void deleteEmployeeById(@PathVariable int id)		
{
    empsservice.deleteById(id) ;
}

//save all employees

@PostMapping("/saveall")
public List<Employee>  saveallemployee(@RequestBody List<empsdetails> empsdetails)
{
	return empsservice.saveallemployees(empsdetails);
}

//update by name

@PutMapping("/{id}")
	    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @RequestBody Employee employee) 
{
	      
	            Employee updatedEmployee = empsservice.updateEmployee(id, employee);
	            return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
	        } 
}