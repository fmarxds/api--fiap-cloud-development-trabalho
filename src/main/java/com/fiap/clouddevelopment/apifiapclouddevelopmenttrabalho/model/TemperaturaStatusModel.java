package com.fiap.clouddevelopment.apifiapclouddevelopmenttrabalho.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Document(collection = "temperatura-status")
public class TemperaturaStatusModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String local;
    private BigDecimal temperatura;
    private LocalDateTime timestamp = LocalDateTime.now();

}
