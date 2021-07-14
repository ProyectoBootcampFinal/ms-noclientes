package com.everis.ms.gestion.noclientes.yanki.kafka.producer;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.everis.ms.gestion.noclientes.yanki.entity.Wallet;

public interface IKafkaProducer{
	
	ListenableFuture<SendResult<String, Wallet>> sendJson(String topic, Wallet wallet);	
}
