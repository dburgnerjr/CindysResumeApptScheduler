/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('ResumeController', ['$scope', 'ResumeService', function($scope, ResumeService) {
    var self = this;
    self.appointment = { id:null, name:'', date:'', time:'', email:'', comments:''};
    self.appointments = [];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllAppts();
 
    function fetchAllAppts() {
    	console.log("resumeController - fetchAllAppts start");
        ResumeService.fetchAllAppts()
            .then(
            function(d) {
                self.appointments = d;
                console.log("sizex = " + self.appointments.size());
            },
            function(errResponse) {
                console.error('Error while fetching Appointments');
            }
        );
    }
 
    function createAppointment(appointment) {
    	ResumeService.createAppointment(appointment)
            .then(
            fetchAllAppts,
            function(errResponse){
                console.error('Error while creating Appointment');
            }
        );
    }
 
    function updateAppointment(appointment, id) {
    	ResumeService.updateAppointment(appointment, id)
            .then(
            fetchAllAppts,
            function(errResponse) {
                console.error('Error while updating Appointment');
            }
        );
    }
 
    function deleteAppointment(id) {
    	ResumeService.deleteAppointment(id)
            .then(
            fetchAllAppts,
            function(errResponse) {
                console.error('Error while deleting Appointment');
            }
        );
    }
 
    function submit() {
        if (self.appointment.id === null) {
            console.log('Saving New Appointment', self.appointment);
            createAppointment(self.appointment);
        } else {
            updateAppointment(self.appointment, self.appointment.id);
            console.log('Appointment updated with id ', self.appointment.id);
        }
        reset();
    }
 
    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.appointments.length; ++i) {
            if (self.appointments[i].id === id) {
                self.appointment = angular.copy(self.appointments[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if (self.appointment.id === id) {//clean form if the Appointment to be deleted is shown there.
            reset();
        }
        deleteAppointment(id);
    }
 
 
    function reset(){
        self.appointment = { id:null, name:'', date:'', time:'', email:'', comments:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);
