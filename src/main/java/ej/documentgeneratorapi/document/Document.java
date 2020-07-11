package ej.documentgeneratorapi.document;

public interface Document {
    Object createDocumentContext(Object data);
    DocumentType getDocumentType();
}

