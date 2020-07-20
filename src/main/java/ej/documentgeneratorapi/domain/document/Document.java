package ej.documentgeneratorapi.domain.document;

public interface Document<T> {
    T getDocumentContext();

    DocumentType getDocumentType();
}

