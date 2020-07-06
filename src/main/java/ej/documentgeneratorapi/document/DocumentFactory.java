package ej.documentgeneratorapi.document;

import ej.documentgeneratorapi.dto.InvoiceDetails;

public class DocumentFactory {

    public Document getDocument(Object data) {
        if (data instanceof InvoiceDetails) {
            return new InvoiceDocument();
        }

        throw new IllegalArgumentException();
    }
}
