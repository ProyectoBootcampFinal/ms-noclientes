package com.everis.ms.gestion.noclientes.yanki.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "monedero")
public class Wallet{

	@Id
	private String id;
	@Indexed(name = "phoneNumberWallet", direction = IndexDirection.ASCENDING)
	private String phoneNumber;
	@Indexed(name = "identityNumberWallet", direction = IndexDirection.ASCENDING)
	private String identityNumber;
	private Double balance;
	public Wallet(String phoneNumber, String identityNumber, Double balance) {
		super();
		this.phoneNumber = phoneNumber;
		this.identityNumber = identityNumber;
		this.balance = balance;
	}

	
	
}
