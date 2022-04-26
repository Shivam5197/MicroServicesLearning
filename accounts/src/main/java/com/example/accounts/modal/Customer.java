package com.example.accounts.modal;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {


@Id
@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer customerId;

	private String name;
	private String email;
	private String mobileNumber;
	private LocalDate createDt;
	             
}
