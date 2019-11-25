<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Your Appointment Is Confirmed</title>
</head>
<body>
	<div class="formcontainer">
		<form>
			<div class="row">
				<label class="col-md-2 control-lable" for="appt_confirm">Your Appointment Is Confirmed</label>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-2 control-lable" for="uname">Name</label>
					<div class="col-md-7">
						<input type="text" ng-model="ctrl.user.username" id="uname"
							class="username form-control input-sm"
							placeholder="Enter your name" required ng-minlength="3" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-2 control-lable" for="date">Date</label>
					<div class="col-md-7">
						<input type="date" ng-model="ctrl.user.date" id="date"
							class="form-control input-sm" placeholder="Enter your Date"
							required />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-2 control-lable" for="time">Time</label>
					<div class="col-md-7">
						<input type="time" ng-model="ctrl.user.time" id="time"
							class="form-control input-sm" placeholder="Enter your Time"
							required />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-2 control-lable" for="email">Email</label>
					<div class="col-md-7">
						<input type="email" ng-model="ctrl.user.email" id="email"
							class="email form-control input-sm"
							placeholder="Enter your Email" required />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-group col-md-12">
					<label class="col-md-2 control-lable" for="comments">Comments</label>
					<div class="col-md-7">
						<input type="text" ng-model="ctrl.user.comments" id="comments"
							class="username form-control input-sm"
							placeholder="Enter your comments" />
					</div>
				</div>
			</div>

			<div class="row">
				<div class="form-actions floatRight">
					<input type="submit" value="Add" class="btn btn-primary btn-sm"
						ng-disabled="mySynchronousForm.$invalid">
					<button type="button" ng-click="ctrl.reset()"
						class="btn btn-warning btn-sm"
						ng-disabled="mySynchronousForm.$pristine">Reset Form</button>
				</div>
			</div>
		</form>
	</div>

<p><a href="appointment_scheduler.html">Click here to go back to the Appointment Scheduler</a></p>
</body>
</html>