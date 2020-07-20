package ej.documentgeneratorapi.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CarDetailsTest {

    private static Long COUNT = 1L;
    private static BigDecimal PRICE_WITHOUT_VAT = BigDecimal.TEN;
    private static BigDecimal PRICE_WITH_VAT = BigDecimal.TEN;
    private static Double VAT = Double.valueOf(0.00);
    private static String KZ = "KZ";
    private static String MONOTONIC = "MONOTONIC";
    private static String REFERENCE_NO = "REFERENCE_NO";
    private static String VIN_NUMBER = "VIN_NUMBER";

    @Test
    public void mapCarDetails_Data_CarDetails() {
        CarDetails carDetails = createCarDetails();
        assertEquals(COUNT, carDetails.getCount());
        assertEquals(KZ, carDetails.getKz());
        assertEquals(MONOTONIC, carDetails.getMonotonic());
        assertEquals(PRICE_WITHOUT_VAT, carDetails.getPriceWithoutVat());
        assertEquals(PRICE_WITH_VAT, carDetails.getPriceWithVat());
        assertEquals(REFERENCE_NO, carDetails.getReferenceNo());
        assertEquals(VAT, carDetails.getVat());
        assertEquals(VIN_NUMBER, carDetails.getVin());
    }

    public static CarDetails createCarDetails() {
        CarDetails carDetails = new CarDetails();
        carDetails.setCount(COUNT);
        carDetails.setKz(KZ);
        carDetails.setMonotonic(MONOTONIC);
        carDetails.setPriceWithoutVat(PRICE_WITHOUT_VAT);
        carDetails.setPriceWithVat(PRICE_WITH_VAT);
        carDetails.setReferenceNo(REFERENCE_NO);
        carDetails.setVat(VAT);
        carDetails.setVin(VIN_NUMBER);
        return carDetails;
    }

}
