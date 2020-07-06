'use strict'
const autoInvoiceGeneratorApp = angular.module('autoInvoiceGenerator', ['ui.bootstrap', 'DocumentController']);
autoInvoiceGeneratorApp.constant("CONSTANTS", {
    generateInvoiceDocument: "api/document/generate"
});