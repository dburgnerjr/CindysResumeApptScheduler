<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Add A Comment</title>
<link href="resources/css/app.css" rel="stylesheet" />
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">New Comment Form</span>
			</div>
			<div class="formcontainer">
				<form:form method="POST" action="/CindysResumeApptScheduler/appointmentConfirmation" modelAttribute="appointment">
					<form:input type="hidden" id="id" name="id" ng-model="ctrl.appointment.id" />
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="name">Name</form:label>
							<div class="col-md-7">
								<form:input type="text" id="name" name="name" path="name" class="name form-control input-sm" disabled /> 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="date">Date/Time</form:label>
							<div class="col-md-7">
								<form:input type="datetime-local" id="date" name="date" path="date" class="date form-control input-sm" disabled />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="email">Email Address</form:label>
							<div class="col-md-7">
								<form:input type="email" id="email" name="email" path="email" class="email form-control input-sm" disabled />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="comments">Comments</form:label>
							<div class="col-md-7">
								<form:input type="text" id="comments" name="comments" path="comments" class="comments form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatLeft">
							<input type="submit" value="Add" class="btn btn-success custom-width">
							<input type="button" onclick="goHome()" value="Home" class="btn btn-success custom-width">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="resources/js/location.js"></script>
</body>
</html>
