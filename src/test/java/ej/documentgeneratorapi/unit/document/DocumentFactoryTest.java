package ej.documentgeneratorapi.unit.document;

import ej.documentgeneratorapi.document.Document;
import ej.documentgeneratorapi.document.DocumentFactory;
import ej.documentgeneratorapi.document.InvoiceDocument;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.unit.dto.InvoiceDetailsTest.createInvoiceDetails;
import static org.springframework.util.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DocumentFactoryTest {

    @Test
    public void getDocument_InvoiceDetailsInstanceClass_InvoiceDocument() {
        DocumentFactory documentFactory = new DocumentFactory();
        InvoiceDetails invoiceDetails = createInvoiceDetails();

        Document document = documentFactory.getDocument(invoiceDetails);

        isInstanceOf(InvoiceDocument.class, document);
    }

    @Test(expected = RuntimeException.class)
    public void getDocument_InvalidInstanceClass_ThrowRuntimeException() {
        DocumentFactory documentFactory = new DocumentFactory();
        documentFactory.getDocument(Mock.class);
    }

}
