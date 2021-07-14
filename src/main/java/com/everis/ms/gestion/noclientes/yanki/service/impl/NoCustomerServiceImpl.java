package com.everis.ms.gestion.noclientes.yanki.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;
import com.everis.ms.gestion.noclientes.yanki.entity.Wallet;
import com.everis.ms.gestion.noclientes.yanki.exception.NotDataFoundException;
import com.everis.ms.gestion.noclientes.yanki.kafka.producer.IKafkaProducer;
import com.everis.ms.gestion.noclientes.yanki.repository.NoCustomerRepository;
import com.everis.ms.gestion.noclientes.yanki.service.NoCustomerService;
import com.everis.ms.gestion.noclientes.yanki.utils.NoCustomerYankiUtils;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class NoCustomerServiceImpl implements NoCustomerService{

	@Autowired
	private NoCustomerRepository noCustomerRepository;

	@Autowired
	private IKafkaProducer kafkaProducer;
	
	@Override
	public Mono<NoCustomer> create(Mono<NoCustomer> customer) {
		log.info("NoCustomerServiceImpl.create is calling");
		return customer.flatMap(p->noCustomerRepository.save(p)
				.doOnSuccess(
						r->kafkaProducer.sendJson(NoCustomerYankiUtils.PRODUCER_TOPIC, 
								new Wallet(p.getPhoneNumber(), p.getIdentityNumber(), 0.0))));
	}

	@Override
	public Flux<NoCustomer> findAll() {
		log.info("NoCustomerServiceImpl.findAll is calling");
		return noCustomerRepository.findAll();
	}

	@Override
	public Mono<NoCustomer> findById(String id) {
		log.info("NoCustomerServiceImpl.findById has ID value -> "+id);
		return noCustomerRepository.findById(id);
	}

	@Override
	public Mono<NoCustomer> update(Mono<NoCustomer> customer) {
		log.info("NoCustomerServiceImpl.update is calling");
		return customer.flatMap(
				p->noCustomerRepository.findById(p.getId())
				.switchIfEmpty(Mono.error(new NotDataFoundException("No existe cliente")))
				.then(noCustomerRepository.save(p))
				.doOnError(e->{
					log.error("NoCustomerServiceImpl.update has error -> "+e);
					new Exception(e);
				})
				);
	}

	@Override
	public Mono<Void> delete(String id) {
		return noCustomerRepository.deleteById(id);
	}


	@Override
	public Mono<NoCustomer> findByIdentityNumber(String id) {
		return noCustomerRepository.findByIdentityNumber(id);
	}
}
