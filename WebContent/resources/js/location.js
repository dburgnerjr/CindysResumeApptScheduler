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
	appointmentData["name"] = $("#name").val();
	appointmentData["date"] = $("#date").val();
	appointmentData["email"] = $("#email").val();
	appointmentData["comments"] = $("#comments").val();

	alert(JSON.stringify(appointmentData));

	$.ajax({
		type : "POST",
		contentType : "application/json",
		url : "/CindysResumeApptScheduler/appointmentConfirmation",
		data : JSON.stringify(appointmentData),
		dataType : 'json',
		success : function(data) {
			//location.assign("appointmentConfirmation");
		}
	});
}
