package ej.documentgeneratorapi.service;

import ej.documentgeneratorapi.domain.Invoice;
import ej.documentgeneratorapi.domain.document.Document;
import ej.documentgeneratorapi.domain.document.DocumentFactory;
import ej.documentgeneratorapi.domain.document.DocumentType;
import ej.documentgeneratorapi.dto.InvoiceDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import static ej.documentgeneratorapi.dto.InvoiceDetailsTest.createInvoiceDetails;
import static org.junit.Assert.assertNotNull;

@RunWith(MockitoJUnitRunner.class)
public class FileServiceTest {

    @InjectMocks
    private FileService fileService;


    @Test
    public void generatePdf_InvoiceDetails_ByteArray() {
        InvoiceDetails invoiceDetails = createInvoiceDetails();
        DocumentFactory documentFactory = new DocumentFactory();

        Document<Invoice> document = documentFactory.createDocument(invoiceDetails.getDocumentType(), invoiceDetails);

        byte[] content = fileService.generatePdf(document);

        assertNotNull(content);
    }

}
