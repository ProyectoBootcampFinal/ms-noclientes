package com.everis.ms.gestion.noclientes.yanki.kafka.consumer.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;
import com.everis.ms.gestion.noclientes.yanki.kafka.consumer.IKafkaConsumer;
import com.everis.ms.gestion.noclientes.yanki.kafka.producer.IKafkaProducer;
import com.everis.ms.gestion.noclientes.yanki.service.NoCustomerService;
import com.everis.ms.gestion.noclientes.yanki.utils.NoCustomerYankiUtils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class KafkaConsumerImpl implements IKafkaConsumer{

	@Autowired
	private NoCustomerService noCustomerService;

	@Autowired
	private IKafkaProducer kafkaProducer;
	
    @KafkaListener(topics = NoCustomerYankiUtils.CONSUMER_TOPIC, groupId = NoCustomerYankiUtils.CONSUMER_GROUP,
            containerFactory = NoCustomerYankiUtils.CONTAINER_FACTORY)
    public void consumeJson(NoCustomer noCustomer) {
        System.out.println("Consumed JSON Message: " + noCustomer);
    }
}
