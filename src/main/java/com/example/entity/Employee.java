package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
//@Table(name = "EmployeeData")
public class Employee 
{
@Id


	private int eid;
	private  String ename;
	private String designation;
	private long addressId;
	
	
}
