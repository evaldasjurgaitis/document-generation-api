'use strict';
const module = angular.module('DocumentController', ['DocumentService']);
module.controller('DocumentController', [
  '$scope',
  '$timeout',
  '$document',
  '$rootScope',
  'DocumentService',
  'GridSvc',
  function($scope, $timeout, $document, $rootScope, DocumentService, GridSvc) {
    $scope.invoice = {};
    $scope.isGenerated = false;
    $scope.loading = false;
    $scope.error = false;

    $scope.cars = GridSvc.cars;
    $scope.isContextMenuVisible = false;
    $scope.contextmenuRowIndex = -1;
    $scope.openContextMenu = function($event, $index) {
      $event.preventDefault();
      if ($event.button === 0) {
        $scope.isContextMenuVisible = false;
        return;
      }

      $scope.contextmenuRowIndex = $index;
      $scope.contextMenuStyle = {
        top: $event.clientY + 'px',
        left: $event.clientX + 'px',
      };
      $scope.isContextMenuVisible = true;
    };

    $scope.addRow = function() {
      var index = $scope.contextmenuRowIndex;
      $scope.cars.splice(index, 0, {});
      $scope.isContextMenuVisible = false;
    };

    $scope.removeRow = function() {
      var index = $scope.contextmenuRowIndex;
      $scope.cars.splice(index, 1);
      $scope.isContextMenuVisible = false;
    };

    $scope.generateInvoiceDocument = function() {
      $scope.invoice.cars = $scope.cars;
      $scope.isGenerated = false;
      $scope.loading = true;
      $scope.error = false;

      DocumentService.generateInvoiceDocument($scope.invoice).then(function(response) {
          const file = new Blob([response.data], {type: 'application/pdf'});
          const fileURL = URL.createObjectURL(file);
          const link = document.getElementById('download');
          link.href = fileURL;
          link.download = "invoice.pdf";
          $scope.isGenerated = true;
          $scope.loading = false;
      }, function() {
          $scope.loading = false;
          $scope.error = true;
      });
    };
  },
]);

module.factory('GridSvc', function() {
  var factory = {}, i;
  factory.cars = [];
  for(i = 0; i < factory.cars.length; i++){
    factory.cars[i].edit = {};
  }
  return factory;
});