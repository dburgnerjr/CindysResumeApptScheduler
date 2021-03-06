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
				<button class="tablink" onclick="goHome()">Home</button>
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
							<th>Date</th>
							<th>Email</th>
							<th>Comments</th>
							<th width="20%"></th>
						</tr>
					</thead>
					<tbody>
						<tr ng-repeat="appt in ctrl.appointments">
							<td><span ng-bind="appt.id"></span></td>
							<td><span ng-bind="appt.name"></span></td>
							<td><span ng-bind="appt.date | date:'MM/dd/yyyy'"></span></td>
							<td><span ng-bind="appt.email"></span></td>
							<td><button type="button" ng-click="ctrl.showComment(appt.id)"
									class="btn btn-success custom-width">Show</button></td>
							<td>
								<button type="button" ng-click="ctrl.edit(appt)"
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
					<input type="hidden" id="id" name="id" ng-model="ctrl.appointment.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="name">Name <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.appointment.name" id="name" name="name" class="name form-control input-sm" placeholder="Enter your name" onchange="ctrl.enable()" required ng-minlength="3" />
							</div>
						</div>
					</div>


					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="date">Date <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.appointment.date" id="date" name="date" class="date form-control input-sm" placeholder="mm/dd/yyyy" onchange="ctrl.enable()" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="time">Time <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="text" ng-model="ctrl.appointment.time" id="time" name="time" class="date form-control input-sm" placeholder="hh:mm a" onchange="ctrl.enable()" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable" for="email">Email <span class="required">*</span></label>
							<div class="col-md-7">
								<input type="email" ng-model="ctrl.appointment.email" id="email" name="email" class="email form-control input-sm" placeholder="Enter your Email" onchange="ctrl.enable()" required />
							</div>
						</div>
					</div>

					<div class="row">
						<div class="form-actions floatLeft">
							<input type="submit" id="submit" name="submit" value="{{!ctrl.appointment.id ? 'Add' : 'Update'}}" class="btn btn-success custom-width" ng-disabled="myForm.$invalid">
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
