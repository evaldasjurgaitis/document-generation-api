package ej.documentgeneratorapi.domain.document;

import lombok.Getter;

@Getter
public enum DocumentType {

    INVOICE("Invoice");

    private String templateName;

    DocumentType(String templateName) {
        this.templateName = templateName;
    }

}
