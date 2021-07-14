package com.everis.ms.gestion.noclientes.yanki.service.generic;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

//T = Any Object

public interface InterfaceCrudService<T> {

	Mono<T> create(Mono<T> noCcustomer);
	
	Flux<T> findAll();
	
	Mono<T> findById(String id);
	
	Mono<T> update(Mono<T> noCustomer);
	
	Mono<Void> delete(String id);
	
}
