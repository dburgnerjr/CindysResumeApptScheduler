<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>Cindy's Resume Appointment Schedule Page</title>
<link href="resources/css/app.css" rel="stylesheet" />
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body ng-app="myApp">
	<div class="generic-container" ng-controller="resumeController as ctrl">
		<div class="panel panel-default">
			<div class="row">
				<button class="tablink" onclick="openSubmission('home')">Home</button>
				<button class="tablink" onclick="openSubmission('synchronous')">Synchronous Submission</button>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Resume Appointment Schedule</span>
			</div>
			<div class="tablecontainer">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>ID</th>
							<th>Name</th>
							<th>Date/Time</th>
							<th>Email</th>
							<th>Comments</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="appt in ctrl.appointments">
							<td><span ng-bind="appt.id"></span></td>
							<td><span ng-bind="appt.name"></span></td>
							<td><span ng-bind="appt.date | date:'MM/dd/yyyy h:mm a'"></span></td>
							<td><span ng-bind="appt.email"></span></td>
							<td><span ng-bind="appt.comments"></span></td>
							<td>
								<button type="button" ng-click="ctrl.edit(appt.id)"
									class="btn btn-success custom-width">Edit</button>
								<button type="button" ng-click="ctrl.remove(appt.id)"
									class="btn btn-success custom-width">Remove</button>
							</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Resume Appointment Scheduler Form</span>
			</div>
			<div class="formcontainer">
				<form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
					<input type="hidden" ng-model="ctrl.appointment.id" />
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
						<div class="form-actions floatLeft">
							<input type="submit" id="submit" name="submit" value="{{!ctrl.appointment.id ? 'Add' : 'Update'}}" class="btn btn-success custom-width" ng-disabled="myForm.$invalid">
<!-- 							<button type="button" ng-click="ctrl.reset()" class="btn btn-success custom-width" ng-disabled="myForm.$pristine">Reset Form</button> -->
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src="<c:url value='/resources/js/location.js' />"></script>
	<script src="<c:url value='/resources/js/app.js' />"></script>
    <script src="<c:url value='/resources/js/service/resumeService.js' />"></script>
    <script src="<c:url value='/resources/js/controller/resumeController.js' />"></script>
</body>
</html>
