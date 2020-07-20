package ej.documentgeneratorapi.domain.document;

import ej.documentgeneratorapi.dto.InvoiceDetails;

public class DocumentFactory {

    public <T> Document createDocument(DocumentType documentType, T data) {

        switch (documentType) {
            case INVOICE:
                return new InvoiceDocument((InvoiceDetails) data);
            default:
                throw new IllegalArgumentException("No document type: "+ documentType);
        }
    }

}
