package ej.documentgeneratorapi.dto;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static ej.documentgeneratorapi.dto.CarDetailsTest.createCarDetails;
import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDetailsTest {

    private final static String CUSTOMER_NO = "CUSTOMER_NO";
    private final static String INVOICE_NO = "INVOICE_NO";
    private final static String VAT_ID_NO = "VAT_ID_NO";
    private final static Date DATE = new Date();
    private final static List<CarDetails> CARS = Arrays.asList(createCarDetails(), createCarDetails());

    @Test
    public void mapInvoiceDetails_Data_InvoiceDetails() {
        InvoiceDetails invoiceDetails = createInvoiceDetails();
        assertEquals(CUSTOMER_NO, invoiceDetails.getCustomerNo());
        assertEquals(INVOICE_NO, invoiceDetails.getInvoiceNo());
        assertEquals(VAT_ID_NO, invoiceDetails.getVatIdNo());
        assertEquals(DATE, invoiceDetails.getDate());
        assertEquals(CARS, invoiceDetails.getCars());
    }

    public static InvoiceDetails createInvoiceDetails() {
        InvoiceDetails invoiceDetails = new InvoiceDetails();
        invoiceDetails.setCars(CARS);
        invoiceDetails.setCustomerNo(CUSTOMER_NO);
        invoiceDetails.setDate(DATE);
        invoiceDetails.setInvoiceNo(INVOICE_NO);
        invoiceDetails.setVatIdNo(VAT_ID_NO);
        return invoiceDetails;
    }

}
