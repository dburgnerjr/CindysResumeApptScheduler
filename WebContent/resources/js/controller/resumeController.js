'use strict';
 
angular.module('myApp').controller('resumeController', ['resumeService', function(resumeService) {
    var self = this;
    self.appointment = { id:null, name:'', date:'', email:'', comments:''};
    self.appointments = [];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
    self.showComment = showComment;
 
    fetchAllAppts();
 
    function fetchAllAppts() {
        resumeService.fetchAllAppts().then(function(appts) {
                self.appointments = appts;
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
 
    function deleteAppointment(id) {
    	resumeService.deleteAppointment(id).then(fetchAllAppts, function(errResponse) {
                console.error('Error while deleting Appointment');
            }
        );
    }
    
    function submit() {
        if (self.appointment.id === null) {
            createAppointment(self.appointment);
        } else {
            updateAppointment(self.appointment, self.appointment.id);
        }
        reset();
    }
 
    function edit(id) {
    	var left = 0;
    	var right = self.appointments.length - 1;
    	while (left <= right) {
        	const mid = left + Math.floor((right - left) / 2);
    		if (self.appointments[mid].id === id) {
                self.appointment = angular.copy(self.appointments[mid]);
                self.appointment.date = new Date(self.appointment.date);
    		}
    		if (self.appointments[mid].id < id)
    			left = mid + 1;
    		else
    			right = mid - 1;
    	}
    }
    
    function remove(id) {
        if (self.appointment.id === id) { //clean form if the Appointment to be deleted is shown there.
            reset();
        }
        deleteAppointment(id);
    }
    
    function enable() {
      	document.getElementById('submit').disabled = false;
    }

    function showComment(id) {
    	location.assign("updateComment/" + id);
    }

    function reset() {
    	var frm = document.getElementsByName('myForm')[0];
  	    frm.reset();  // Reset all form data
  	    document.getElementById('submit').disabled = true;
  	    document.getElementById('submit').value = 'Add';
  	    self.appointment.id = null;
        return false; // Prevent page refresh 
    }    
}]);
