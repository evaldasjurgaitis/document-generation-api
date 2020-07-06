package ej.documentgeneratorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class CarDetails {

    @JsonProperty("kz")
    private String kz;
    @JsonProperty("referenceNo")
    private String referenceNo;
    @JsonProperty("vin")
    private String vin;
    @JsonProperty("count")
    private Long count;
    @JsonProperty("monotonic")
    private String monotonic;
    @JsonProperty("vat")
    private Double vat;
    @JsonProperty("priceWithoutVat")
    private BigDecimal priceWithoutVat;
    @JsonProperty("priceWithVat")
    private BigDecimal priceWithVat;

}
