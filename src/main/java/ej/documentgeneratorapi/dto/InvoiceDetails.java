package ej.documentgeneratorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceDetails {

    @JsonProperty("invoiceNo")
    private String invoiceNo;
    @JsonProperty("customerNo")
    private String customerNo;
    @JsonProperty("vatIdNo")
    private String vatIdNo;
    @JsonProperty("date")
    private Date date;
    @JsonProperty("cars")
    private List<CarDetails> cars;

}
