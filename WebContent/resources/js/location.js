/*
 * resumeScheduler.js
 * 
 * author:  Daniel Burgner
 * purpose: this file services the navigation and front-end
 *          of the resume appointment scheduling service
 *          
 */
function newAppointment() {
    location.assign("newAppointment");
}

function appointmentConfirmation() {
    location.assign("appointmentConfirmation");
}

function appointmentScheduler() {
    location.assign("appointmentScheduler");
}

function goHome() {
    location.assign("index");
}

function openSubmission(submission) {	
	if (submission == "synchronous")
		newAppointment();
	else if (submission == "home")
		goHome();
}
