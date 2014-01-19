'use strict';

angular.module('anguAppApp')
  .controller('MainCtrl',['$scope','$http', function ($scope, $http) {
	  $scope.fetchEmployees = function() {
	        $http.get('emps').success(function(employees){
	            $scope.emps = employees;
	        });
	    }
  }]);
