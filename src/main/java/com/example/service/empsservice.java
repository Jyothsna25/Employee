package com.example.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Employee;
import com.example.model.empsdetails;
import com.example.repository.empsrepository;

@Service
public class empsservice 
{
@Autowired
private empsrepository empsrepository;

//save employee(create)

public Employee saveemployee(empsdetails empsdetails)
{
	
	Employee employee=new Employee();
	
	employee.setEname(empsdetails.getEname());
	employee.setDesignation(empsdetails.getDesignation());
	
	//Employee savedEmployee=empsrepository.save(employee);
	Employee savedEmployeeDetails =  empsrepository.save(employee);
	return savedEmployeeDetails;
	
}

// get employees 

public Employee getEmployee(int id)
{
	Optional<Employee>optionalEmployee=empsrepository.findById(id);
	if(optionalEmployee.isPresent())
	{
		return optionalEmployee.get();
		
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


