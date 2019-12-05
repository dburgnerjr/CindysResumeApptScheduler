'use strict';
 
angular.module('myApp').controller('resumeController', ['resumeService', function(resumeService) {
    var self = this;
    self.appointment = { id:null, name:'', date:'', email:'', comments:''};
    self.appointments = [];
 
    self.submit = submit;
    self.edit = edit;
 
    fetchAllAppts();
 
    function fetchAllAppts() {
        resumeService.fetchAllAppts().then(function(d) {
                self.appointments = d;
            }, function(errResponse) {
                console.error('Error while fetching Appointments');
            }
        );
    }
 
    function createAppointment(appointment) {
    	resumeService.createAppointment(appointment).then(fetchAllAppts, function(errResponse) {
                console.error('Error while creating Appointment');
            }
        );
    }
 
    function updateAppointment(appointment, id) {
    	resumeService.updateAppointment(appointment, id).then(fetchAllAppts, function(errResponse) {
                console.error('Error while updating Appointment');
            }
        );
    }
 
    function submit() {
        if (self.appointment.id === null) {
            createAppointment(self.appointment);
        } else {
            updateAppointment(self.appointment, self.appointment.id);
        }
    }
 
    function edit(id) {
        for (var i = 0; i < self.appointments.length; ++i) {
            if (self.appointments[i].id === id) {
                self.appointment = angular.copy(self.appointments[i]);
                self.appointment.date = new Date(self.appointment.date);
                break;
            }
        }
    }
}]);
