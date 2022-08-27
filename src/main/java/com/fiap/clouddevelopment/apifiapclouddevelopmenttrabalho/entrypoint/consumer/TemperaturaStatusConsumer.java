package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.entrypoint.consumer;

import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model.TemperaturaStatusModel;
import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.service.TemperaturaStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;

@Service
@RequiredArgsConstructor
public class TemperaturaStatusConsumer {

    private final TemperaturaStatusService temperaturaStatusService;

    @JmsListener(destination = "temperatura-status", containerFactory = "jmsListenerContainerFactory")
    public void receive(TemperaturaStatusModel model) throws JMSException {
        temperaturaStatusService.saveTemperaturaStatus(model);
    }

}
