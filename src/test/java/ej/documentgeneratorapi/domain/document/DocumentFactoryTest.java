package ej.documentgeneratorapi.domain.document;

import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import static ej.documentgeneratorapi.dto.InvoiceDetailsTest.createInvoiceDetails;
import static org.mockito.Mockito.mock;
import static org.springframework.util.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class DocumentFactoryTest {

    @Test
    public void getDocument_InvoiceDocumentType_InvoiceDocument() {
        DocumentFactory documentFactory = new DocumentFactory();
        InvoiceDetails invoiceDetails = createInvoiceDetails();

        Document document = documentFactory.createDocument(invoiceDetails.getDocumentType(), invoiceDetails);

        isInstanceOf(InvoiceDocument.class, document);
    }

    @Test(expected = RuntimeException.class)
    public void getDocument_InvalidDocumentType_ThrowRuntimeException() {
        DocumentType documentType = mock(DocumentType.class);
        DocumentFactory documentFactory = new DocumentFactory();
        documentFactory.createDocument(documentType, null);
    }

}
