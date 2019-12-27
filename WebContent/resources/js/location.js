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

function submitInfo() {
	var appointmentData = {};
	if (!$("#name").val()) {
		alert("Please enter the name.");
	}
	if (!$("#date").val()) {
		alert("Please enter the date.");
	}
	if (!$("#email").val()) {
		alert("Please enter the email.");
	}
	if ((typeof $("#name").val() != 'undefined' && $("#name").val()) &&
		(typeof $("#date").val() != 'undefined' && $("#date").val()) &&
		(typeof $("#email").val() != 'undefined' && $("#email").val())) {
		appointmentData["name"] = $("#name").val();
		appointmentData["date"] = $("#date").val();
		appointmentData["email"] = $("#email").val();
		appointmentData["comments"] = $("#comments").val();

		alert(JSON.stringify(appointmentData));

		$.post(
			"/CindysResumeApptScheduler/appointmentConfirmation", 
			{"data" : JSON.stringify(appointmentData) }, 
			function(response) {
				appointmentConfirmation();
			}, 
			"json"
		);		
	}
}
