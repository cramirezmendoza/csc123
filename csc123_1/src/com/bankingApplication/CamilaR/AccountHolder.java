package com.bankingApplication.CamilaR;

import java.time.LocalDate;
import java.time.Period;

public class AccountHolder {
	private String firstName;
	private String lastName;
	private LocalDate dateofBirth;
	private String SSN;
	private String address;
	
	
	//Constructor
	public AccountHolder(String firstName, String lastName, LocalDate dateOfBirth, String SSN, String address)
	{
		this.firstName = firstName; 
		this.lastName = lastName; 
		this.dateofBirth = dateOfBirth;
		this.SSN = SSN;
		this.address = address;
	}
	//getters
	public String getFirstName() 
	{
		return firstName;
	}
	
	public String getLastName() 
	{
		return lastName;
	}

	public LocalDate getDateofBirth() 
	{
		return dateofBirth;
	}

	public String getSSN() 
	{
		return SSN;
	}


	public String getAddress() 
	{
		return address;
	}
	
	public int getAgeInYears()
	{
		return Period.between(dateofBirth, LocalDate.now()).getYears();
	}
	
	public String toString() {
		return firstName + " : " + lastName + " : " + SSN;
	}
}
