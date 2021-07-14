package com.everis.ms.gestion.noclientes.yanki.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "noclientes")
@JsonInclude(value = Include.NON_NULL)
public class NoCustomer {

	@Id
	private String id;
	private String name;
	@Indexed(name = "uniqueIdentityNumber", direction = IndexDirection.ASCENDING)
	private String identityNumber;
	private String customerType;
	private String address;
	@Indexed(name = "phoneNumber", direction = IndexDirection.ASCENDING)
	private String phoneNumber;
	@Indexed(name = "imeiNumber", direction = IndexDirection.ASCENDING)
	private String imeiNumber;
	@Indexed(name = "email", direction = IndexDirection.ASCENDING)
	private String email;

}
