<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html ng-app="myApp">
<head>
<title>Cindy's Resume Appointment Schedule Page</title>
<style>
.name.ng-valid {
	background-color: lightgreen;
}

.name.ng-dirty.ng-invalid-required {
	background-color: red;
}

.name.ng-dirty.ng-invalid-minlength {
	background-color: yellow;
}

.email.ng-valid {
	background-color: lightgreen;
}

.email.ng-dirty.ng-invalid-required {
	background-color: red;
}

.email.ng-dirty.ng-invalid-email {
	background-color: yellow;
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="static/css/app.css" rel="stylesheet" />
</head>
<body class="ng-cloak">
	<div class="generic-container" ng-controller="resumeController as ctrl">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Resume Appointment Scheduler Form </span>
			</div>
<!-- 			<div class="formcontainer">	         -->
<%-- 				<form:form method="POST" action="/CindysResumeApptScheduler/appointmentConfirmation" modelAttribute="appointment"> --%>
<!-- 					<div class="row"> -->
<!-- 						<label class="col-md-2 control-lable" for="sync_submit">Synchronous Submission</label> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-12"> -->
<%-- 							<form:label class="col-md-2 control-lable" path="name">Name</form:label> --%>
<!-- 							<div class="col-md-7"> -->
<%-- 								<form:input type="text" id="name" name="name" path="name" class="name form-control input-sm" required="required" />  --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-12"> -->
<%-- 							<form:label class="col-md-2 control-lable" path="date">Date</form:label> --%>
<!-- 							<div class="col-md-7"> -->
<%-- 								<form:input type="date" id="date" name="date" path="date" class="date form-control input-sm" required="required" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-12"> -->
<%-- 							<form:label class="col-md-2 control-lable" path="time">Time</form:label> --%>
<!-- 							<div class="col-md-7"> -->
<%-- 								<form:input type="time" id="time" name="time" path="time" class="time form-control input-sm" required="required" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-12"> -->
<%-- 							<form:label class="col-md-2 control-lable" path="email">Email Address</form:label> --%>
<!-- 							<div class="col-md-7"> -->
<%-- 								<form:input type="email" id="email" name="email" path="email" class="email form-control input-sm" required="required" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-group col-md-12"> -->
<%-- 							<form:label class="col-md-2 control-lable" path="comments">Comments</form:label> --%>
<!-- 							<div class="col-md-7"> -->
<%-- 								<form:input type="text" id="comments" name="comments" path="comments" class="comments form-control input-sm" /> --%>
<!-- 							</div> -->
<!-- 						</div> -->
<!-- 					</div> -->
<!-- 					<div class="row"> -->
<!-- 						<div class="form-actions floatLeft"> -->
<!-- 							<input type="submit" value="Add" class="btn btn-primary btn-sm"> -->
<!-- 						</div> -->
<!-- 					</div> -->
<%-- 				</form:form> --%>
<!-- 			</div> -->

			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm"
					class="form-horizontal">
					<input type="hidden" ng-model="ctrl.appointment.id" />
					<div class="row">
						<label class="col-md-2 control-lable" for="async_submit">Asynchronous
							Submission</label>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="name">Name <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.appointment.name" id="name" name="name" class="name form-control input-sm" placeholder="Enter your name" required ng-minlength="3" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="date">Date/Time <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="datetime-local" ng-model="ctrl.appointment.date" id="date" name="date" class="date form-control input-sm" placeholder="Enter your Date/Time" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email">Email <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.appointment.email" id="email" name="email" class="email form-control input-sm" placeholder="Enter your Email" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="comments">Comments</label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.appointment.comments" id="comments" name="comments" class="comments form-control input-sm" placeholder="Enter your comments" />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatRight">
							<input type="submit" value="{{!ctrl.appointment.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
							<button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
						</div>
					</div>
				</form>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">List of Appointments </span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Date/Time</th>
							<th>Email</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="u in ctrl.appointments">
							<td><span ng-bind="u.id"></span></td>
							<td><span ng-bind="u.name"></span></td>
							<td><span ng-bind="u.date | date:'MM/dd/yyyy h:mm a'"></span></td>
							<td><span ng-bind="u.email"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(u.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(u.id)"
									class="btn btn-danger custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
			<div>
				<input type="button" onclick="location.href='newAppointment';" class="btn btn-primary btn-sm"value="New Appointment" />
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/static/js/app.js' />"></script>
    <script src="<c:url value='/static/js/service/resumeService.js' />"></script>
    <script src="<c:url value='/static/js/controller/resumeController.js' />"></script>
</body>
</html>
