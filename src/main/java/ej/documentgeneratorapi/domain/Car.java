package ej.documentgeneratorapi.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;

import static ej.documentgeneratorapi.util.Money.formatCurrencyBySlovakia;
import static ej.documentgeneratorapi.util.Money.formatDecimalWithReplace;

@XmlRootElement(name = "cars")
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
        if (vat == null) {
            return formatDecimalWithReplace(Long.valueOf(0L));
        }

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
