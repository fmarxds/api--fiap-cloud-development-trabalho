package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho;

import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model.TemperaturaStatusModel;
import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.service.TemperaturaStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootApplication
public class ApiFiapCloudDevelopmentTrabalhoApplication {

	public static Boolean SEND_TEMPERATURA_STATUS_LOOP = false;

	@Autowired
	private TemperaturaStatusService temperaturaStatusService;

	public static void main(String[] args) {
		SpringApplication.run(ApiFiapCloudDevelopmentTrabalhoApplication.class, args);
	}

	@PostConstruct
	public void sendTemperaturaStatusLoop() {

		Runnable loop = () -> {
			while (true) {
				if (SEND_TEMPERATURA_STATUS_LOOP) {
					TemperaturaStatusModel temperaturaStatusModel = TemperaturaStatusModel.builder()
							.local("sala")
							.temperatura(BigDecimal.valueOf(new Random().nextDouble(0.0, 40.0)).setScale(2, RoundingMode.HALF_UP))
							.timestamp(LocalDateTime.now())
							.build();
					temperaturaStatusService.sendTemperaturaStatus(temperaturaStatusModel);
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		};

		Thread thread = new Thread(loop);
		thread.start();

	}

}
