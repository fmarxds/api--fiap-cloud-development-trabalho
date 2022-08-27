package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.entrypoint.controller;

import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.ApiFiapCloudDevelopmentTrabalhoApplication;
import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model.TemperaturaStatusModel;
import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.service.TemperaturaStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/temperatura")
public class TemperaturaStatusController {

    private final TemperaturaStatusService temperaturaStatusService;

    @GetMapping
    public ResponseEntity<Collection<TemperaturaStatusModel>> getTemperaturaStatusCollection() {
        return ResponseEntity.ok(temperaturaStatusService.getTemperaturaStatusCollection());
    }

    @PostMapping
    public void saveTemperaturaStatus(@RequestBody TemperaturaStatusModel model) {
        temperaturaStatusService.sendTemperaturaStatus(model);
    }

    @PostMapping("/loop")
    public ResponseEntity<Map<String, Object>> temperaturaStatusLoop() {
        ApiFiapCloudDevelopmentTrabalhoApplication.SEND_TEMPERATURA_STATUS_LOOP = !ApiFiapCloudDevelopmentTrabalhoApplication.SEND_TEMPERATURA_STATUS_LOOP;
        return ResponseEntity.ok(Map.of("loop_status", ApiFiapCloudDevelopmentTrabalhoApplication.SEND_TEMPERATURA_STATUS_LOOP));
    }

}
