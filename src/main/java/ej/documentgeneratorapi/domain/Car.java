package ej.documentgeneratorapi.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

import static ej.documentgeneratorapi.util.NumberFormatter.formatCurrencyBySlovakia;
import static ej.documentgeneratorapi.util.NumberFormatter.formatDecimalWithReplace;

@XmlRootElement(name = "car")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Car {

    private String kz;
    private String referenceNo;
    private String vin;
    private Long count;
    private String monotonic;
    private Double vat;
    private BigDecimal priceWithoutVat;
    private BigDecimal priceWithVat;

    @XmlElement(name = "formattedVat")
    public String getFormattedVat() {
        return formatDecimalWithReplace(vat);
    }

    @XmlElement(name = "formattedPriceWithoutVat")
    public String getFormattedPriceWithoutVat() {
        return formatCurrencyBySlovakia(priceWithoutVat);
    }

    @XmlElement(name = "formattedPriceWithVat")
    public String getFormattedPriceWithVat() {
        return formatCurrencyBySlovakia(priceWithVat);
    }

}
