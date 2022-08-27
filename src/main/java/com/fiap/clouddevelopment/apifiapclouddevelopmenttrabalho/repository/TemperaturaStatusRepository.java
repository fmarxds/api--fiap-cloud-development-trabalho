package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.repository;

import com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model.TemperaturaStatusModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TemperaturaStatusRepository extends MongoRepository<TemperaturaStatusModel, String> {
}
