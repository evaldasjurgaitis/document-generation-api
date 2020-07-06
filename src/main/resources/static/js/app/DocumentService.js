'use strict'
angular.module('DocumentService', []).factory('DocumentService', ["$http", "CONSTANTS", function ($http, CONSTANTS) {
    const service = {};

    service.generateInvoiceDocument = function (invoice) {
        const url = CONSTANTS.generateInvoiceDocument
        return $http.post(url, JSON.stringify(invoice), {responseType: 'arraybuffer'});
    };
    return service;
}]);
