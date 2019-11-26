/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('ResumeController', ['$scope', 'ResumeService', function($scope, ResumeService) {
    var self = this;
    self.Appointment = { id:null, name:'', date:'', time:'', email:'', comments:''};
    self.Appointments = [];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllAppointments();
 
    function fetchAllAppointments() {
        ResumeService.fetchAllAppointments()
            .then(
            function(d) {
                self.Appointments = d;
            },
            function(errResponse){
                console.error('Error while fetching Appointments');
            }
        );
    }
 
    function createAppointment(Appointment){
    	ResumeService.createAppointment(Appointment)
            .then(
            fetchAllAppointments,
            function(errResponse){
                console.error('Error while creating Appointment');
            }
        );
    }
 
    function updateAppointment(Appointment, id) {
    	ResumeService.updateAppointment(Appointment, id)
            .then(
            fetchAllAppointments,
            function(errResponse) {
                console.error('Error while updating Appointment');
            }
        );
    }
 
    function deleteAppointment(id) {
    	ResumeService.deleteAppointment(id)
            .then(
            fetchAllAppointments,
            function(errResponse) {
                console.error('Error while deleting Appointment');
            }
        );
    }
 
    function submit() {
        if (self.Appointment.id === null) {
            console.log('Saving New Appointment', self.Appointment);
            createAppointment(self.Appointment);
        } else {
            updateAppointment(self.Appointment, self.Appointment.id);
            console.log('Appointment updated with id ', self.Appointment.id);
        }
        reset();
    }
 
    function edit(id) {
        console.log('id to be edited', id);
        for (var i = 0; i < self.Appointments.length; ++i) {
            if (self.Appointments[i].id === id) {
                self.Appointment = angular.copy(self.Appointments[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if (self.Appointment.id === id) {//clean form if the Appointment to be deleted is shown there.
            reset();
        }
        deleteAppointment(id);
    }
 
 
    function reset(){
        self.Appointment = { id:null, name:'', date:'', time:'', email:'', comments:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);