package com.everis.ms.gestion.noclientes.yanki.service;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;
import com.everis.ms.gestion.noclientes.yanki.service.generic.InterfaceCrudService;

import reactor.core.publisher.Mono;

/**
 * Interface del Service con metodos externos al crud.
 */
public interface NoCustomerService extends InterfaceCrudService<NoCustomer>{

	Mono<NoCustomer> findByIdentityNumber(String id);
}
