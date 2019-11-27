/**
 * 
 */
'use strict';
 
angular.module('myApp').factory('ResumeService', ['$http', '$q', function($http, $q) {
 
    var REST_SERVICE_URI = "http://localhost:8080/CindysResumeApptScheduler/appointment_scheduler";
 
    var factory = {
    	fetchAllAppts: fetchAllAppts,
        createAppointment: createAppointment,
        updateAppointment: updateAppointment,
        deleteAppointment: deleteAppointment
    };
 
    return factory;
 
    function fetchAllAppts() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while fetching Appointments');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createAppointment(appointment) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI, appointment)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while creating Appointment');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function updateAppointment(appointment, id) {
        var deferred = $q.defer();
        $http.put(REST_SERVICE_URI + id, appointment)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while updating Appointment');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function deleteAppointment(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI + id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse) {
                console.error('Error while deleting Appointment');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
}]);