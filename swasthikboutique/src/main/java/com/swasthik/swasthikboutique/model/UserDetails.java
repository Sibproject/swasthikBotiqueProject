package com.swasthik.swasthikboutique.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "CUSTOMER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	private String lastName;
	private String fullName;
	private String phoneNumber;
	private String address;
    private String emailAddress;
	 
}
