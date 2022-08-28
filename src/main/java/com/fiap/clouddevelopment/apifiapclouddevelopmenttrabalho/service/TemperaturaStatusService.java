package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.service;

import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model.TemperaturaStatusModel;
import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.repository.TemperaturaStatusRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Slf4j
@Service
@RequiredArgsConstructor
public class TemperaturaStatusService {

    private final JmsTemplate jmsTemplate;
    private final TemperaturaStatusRepository temperaturaStatusRepository;

    public Collection<TemperaturaStatusModel> getTemperaturaStatusCollection() {
        return temperaturaStatusRepository.findAll();
    }

    public void sendTemperaturaStatus(TemperaturaStatusModel model) {
        jmsTemplate.convertAndSend("temperatura-status", model);
        log.info("Mensagem enviada: {}", model);
    }

    public void saveTemperaturaStatus(TemperaturaStatusModel model) {
        temperaturaStatusRepository.save(model);
    }

    public void deleteAllTemperaturaStatus() {
        temperaturaStatusRepository.deleteAll();
    }

}
