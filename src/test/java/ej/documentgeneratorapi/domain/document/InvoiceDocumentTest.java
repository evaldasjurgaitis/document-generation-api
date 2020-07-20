package ej.documentgeneratorapi.domain.document;

import ej.documentgeneratorapi.domain.Invoice;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.dto.InvoiceDetailsTest.createInvoiceDetails;
import static ej.documentgeneratorapi.util.NumberFormatter.formatCurrencyBySlovakia;
import static ej.documentgeneratorapi.util.NumberFormatter.formatDecimalWithReplace;
import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceDocumentTest {

    @Test
    public void createDocumentContext_InvoiceDetails_Invoice() {
        InvoiceDetails invoiceDetails = createInvoiceDetails();
        DocumentFactory documentFactory = new DocumentFactory();
        Document<Invoice> document = documentFactory.createDocument(invoiceDetails.getDocumentType(), invoiceDetails);
        Invoice invoice = document.getDocumentContext();

        assertNotNull(invoice);
        assertEquals(invoice.getVatIdNo(), invoiceDetails.getVatIdNo());
        assertEquals(invoice.getCustomerNo(), invoiceDetails.getCustomerNo());
        assertEquals(invoice.getInvoiceNo(), invoiceDetails.getInvoiceNo());
        assertEquals(invoice.getCount(), String.valueOf(invoiceDetails.getCars().size()));
        assertEquals(invoice.getCars().get(0).getKz(), invoiceDetails.getCars().get(0).getKz());
        assertEquals(invoice.getCars().get(0).getCount(), invoiceDetails.getCars().get(0).getCount());
        assertEquals(invoice.getCars().get(0).getPriceWithoutVat(), invoiceDetails.getCars().get(0).getPriceWithoutVat());
        assertEquals(invoice.getCars().get(0).getPriceWithVat(), invoiceDetails.getCars().get(0).getPriceWithVat());
        assertEquals(invoice.getCars().get(0).getVat(), invoiceDetails.getCars().get(0).getVat());
        assertEquals(invoice.getCars().get(0).getReferenceNo(), invoiceDetails.getCars().get(0).getReferenceNo());
        assertEquals(invoice.getCars().get(0).getVin(), invoiceDetails.getCars().get(0).getVin());
        assertEquals(invoice.getCars().get(0).getMonotonic(), invoiceDetails.getCars().get(0).getMonotonic());
        assertEquals(invoice.getCars().get(0).getFormattedPriceWithoutVat(), formatCurrencyBySlovakia(invoiceDetails.getCars().get(0).getPriceWithoutVat()));
        assertEquals(invoice.getCars().get(0).getFormattedPriceWithVat(), formatCurrencyBySlovakia(invoiceDetails.getCars().get(0).getPriceWithVat()));
        assertEquals(invoice.getCars().get(0).getFormattedVat(), formatDecimalWithReplace(invoiceDetails.getCars().get(0).getVat()));
    }

}
