package com.everis.ms.gestion.noclientes.yanki.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;
import com.everis.ms.gestion.noclientes.yanki.service.NoCustomerService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping("/noCustomer")
public class CustomerRest {
	
	@Autowired
	private NoCustomerService noCustomerService;
	
	@GetMapping
	public Flux<NoCustomer> findAll(){
		log.info("CustomerController.findAll, calling");
		return noCustomerService.findAll();
	}
	
	@GetMapping("/findById")
	public Mono<NoCustomer> findById(@RequestParam String id){
		log.info("CustomerController.findById, id value has -> "+id);
		return noCustomerService.findById(id);
	}
	
	@GetMapping("/findByIdentityNumber")
	public Mono<NoCustomer> findByIdentityNumber(@RequestParam String identityNumber){
		log.info("CustomerController.findByIdentityNumber, id value has -> "+identityNumber);
		return noCustomerService.findByIdentityNumber(identityNumber);
	}	
	
	@PostMapping
	public Mono<NoCustomer> insert(@RequestBody Mono<NoCustomer> noCustomer){
		log.info("CustomerController.insert is calling");
		return noCustomerService.create(noCustomer);
	}  
	
	@PutMapping
	public Mono<NoCustomer> update(@RequestBody Mono<NoCustomer> noCustomer){
		log.info("CustomerController.update is calling");
		return noCustomerService.update(noCustomer);
	}
	
	@DeleteMapping
	public Mono<Void> delete(@RequestParam String id){
		log.info("CustomerController.delete is calling");
		return noCustomerService.delete(id);
	}
	
}
