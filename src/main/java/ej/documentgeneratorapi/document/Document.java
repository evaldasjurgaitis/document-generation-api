package ej.documentgeneratorapi.document;

public interface Document {
    Object createDocument(Object data);
    DocumentType getDocumentType();
}

