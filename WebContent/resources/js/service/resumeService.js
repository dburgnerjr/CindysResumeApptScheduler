'use strict';
 
angular.module('myApp').factory('resumeService', resumeService);

resumeService.$inject = ['$http'];

	function resumeService($http) {
		var REST_SERVICE_URI = "/CindysResumeApptScheduler/";
    
    var factory = {
    	fetchAllAppts: fetchAllAppts,
        createAppointment: createAppointment,
        updateAppointment: updateAppointment
    };
 
    return factory;
 
    function fetchAllAppts() {
    	return $http.get(REST_SERVICE_URI + 'appointments').then(function (response) {
    		return response.data;
        })
    }
 
    function createAppointment(appointment) {
        return $http.post(REST_SERVICE_URI + 'appointments/appointment', appointment);
    }
  
    function updateAppointment(appointment, id) {
        return $http.put(REST_SERVICE_URI + 'appointment/' + id, appointment);
    } 
};
