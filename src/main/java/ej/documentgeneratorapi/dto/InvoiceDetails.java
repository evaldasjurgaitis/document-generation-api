package ej.documentgeneratorapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import ej.documentgeneratorapi.domain.document.DocumentType;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class InvoiceDetails {
    @JsonProperty("city")
    private String city;
    @JsonProperty("street")
    private String street;
    @JsonProperty("postCode")
    private String postCode;
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
    private DocumentType documentType = DocumentType.INVOICE;

}
