package com.everis.ms.gestion.noclientes.yanki.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;

import reactor.core.publisher.Mono;

@Repository
public interface NoCustomerRepository extends ReactiveMongoRepository<NoCustomer, String>{
	Mono<NoCustomer> findByIdentityNumber(String identityNumber);
}