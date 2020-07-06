package ej.documentgeneratorapi.domain;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import static ej.documentgeneratorapi.util.Money.*;

@XmlRootElement(name = "invoice")
@XmlAccessorType(XmlAccessType.FIELD)
@Data
public class Invoice {

    private String invoiceNo;
    private String customerNo;
    private String vatIdNo;
    private String date;
    private List<Car> cars;

    @XmlElement(name = "count")
    public String getCount() {
        if (cars == null) {
            return formatDecimal(Long.valueOf(0L));
        }

        return formatDecimal(cars.stream()
                .filter(car -> car.getCount() != null)
                .map(car -> car.getCount())
                .collect(Collectors.summingLong(Long::longValue)));
    }

    @XmlElement(name = "amountVat")
    public String getAmountVat() {
        if (cars == null) {
            return formatDecimalWithReplace(Double.valueOf(0));
        }

        return formatDecimalWithReplace(cars.stream()
                .filter(car -> car.getVat() != null && car.getCount() != null)
                .map(car -> car.getVat() * car.getCount())
                .collect(Collectors.summingDouble(Double::doubleValue)));
    }

    @XmlElement(name = "amountWithVat")
    public String getAmountWithVat() {
        if (cars == null) {
            return formatCurrencyByGermany(BigDecimal.ZERO);
        }

        return formatCurrencyByGermany(cars.stream()
                .filter(car -> car.getPriceWithVat() != null && car.getCount() != null)
                .map(car -> car.getPriceWithVat().multiply(BigDecimal.valueOf(car.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

    @XmlElement(name = "amountWithoutVat")
    public String getAmountWithoutVat() {
        if (cars == null) {
            return formatCurrencyByGermany(BigDecimal.ZERO);
        }

        return formatCurrencyByGermany(cars.stream()
                .filter(car -> car.getPriceWithoutVat() != null && car.getCount() != null)
                .map(car -> car.getPriceWithoutVat().multiply(BigDecimal.valueOf(car.getCount())))
                .reduce(BigDecimal.ZERO, BigDecimal::add)
        );
    }

}
