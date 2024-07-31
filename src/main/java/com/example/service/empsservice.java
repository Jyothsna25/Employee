package com.example.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.controller.utils.AddressVo;
import com.example.entity.Employee;
import com.example.model.Addressdetails;
import com.example.model.empsdetails;
import com.example.repository.empsrepository;

@Service
public class empsservice 
{
@Autowired
private empsrepository empsrepository;
@Autowired
private RestTemplate restTemplate;

// For REST Template...

private String address_servicePathURL ="http://localhost:8082/add/";

//save employee(create)

public Employee saveemployee(Employee empsdetails)
{
	
	Employee employee=new Employee();
	
	employee.setEname(empsdetails.getEname());
	employee.setDesignation(empsdetails.getDesignation());
	employee.setAddressId(empsdetails.getAddressId());
	
	//Employee savedEmployee=empsrepository.save(employee);
	Employee savedEmployeeDetails =  empsrepository.save(employee);
	return savedEmployeeDetails;
	
}

// get employees 

public empsdetails getEmployee(int id)
{
	Optional<Employee>optionalEmployee=empsrepository.findById(id);
	if(optionalEmployee.isPresent())
	{
		
		Employee emp=optionalEmployee.get();
		//convert Employee to empsdetails
		//using RestTEmplate
	    Addressdetails addressdetails = restTemplate.getForObject(
				this.address_servicePathURL+id,Addressdetails.class);
				
	 empsdetails details = new empsdetails();
		details.setEname(emp.getEname()); 
        details.setDesignation(emp.getDesignation());
        details.setAddress(addressdetails);
			return details;
	}
	else
	{
		return null;
	}
}

//Delete employees by id

public void deleteById(int id)
{
 empsrepository.deleteById(id);
}
//save all employees

public List<Employee > saveallemployees(List<empsdetails> details)
{
	List<Employee> employees=new ArrayList<>();
	for(empsdetails empsdetails : details) {
		Employee employee = new Employee();
		employee.setEname(empsdetails.getEname());
		employee.setDesignation(empsdetails.getDesignation());
		employee.setAddressId(empsdetails.getAddressId());
		employees.add(employee);
	}
	return empsrepository.saveAll(employees);
	
	}


// update employee

public Employee updateEmployee(int id, Employee employee)
{
	Employee existingEmployee = empsrepository.findById(employee.getEid())
	                                                            .orElse(null);
	System.out.println("the employee object is"+ existingEmployee);
		         existingEmployee.setEname(employee.getEname());
return empsrepository.save(existingEmployee);
	
}
}


