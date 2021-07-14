package com.everis.ms.gestion.noclientes.yanki.kafka.consumer;

import com.everis.ms.gestion.noclientes.yanki.entity.NoCustomer;

public interface IKafkaConsumer {

    public void consumeJson(NoCustomer noCustomer);
}
