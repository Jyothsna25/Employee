package com.example.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class empsdetails 
{

	private String ename;
	private String designation;
	private long addressId;
	private Addressdetails address;
	
	}
