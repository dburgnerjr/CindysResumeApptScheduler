<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<title>Schedule a New Appointment</title>
<style type="text/css">
body {
	background-image: url('resources/images/bg.png');
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="resources/css/app.css" rel="stylesheet" />
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Resume Appointment Scheduler Form </span>
			</div>
			<div class="formcontainer">	        
				<form:form method="POST" action="/CindysResumeApptScheduler/appointmentConfirmation" modelAttribute="appointment">
					<div class="row">
						<label class="col-md-2 control-lable" for="sync_submit">Synchronous Submission</label>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="name">Name <span class="required">*</span></form:label>
							<div class="col-md-7">
								<form:input type="text" id="name" name="name" path="name" class="name form-control input-sm" required="required" /> 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="date">Date/Time <span class="required">*</span></form:label>
							<div class="col-md-7">
								<form:input type="datetime-local" id="date" name="date" path="date" class="date form-control input-sm" required="required" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="email">Email Address <span class="required">*</span></form:label>
							<div class="col-md-7">
								<form:input type="email" id="email" name="email" path="email" class="email form-control input-sm" required="required" />
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
							<input type="submit" value="Add" class="btn btn-primary btn-sm">
							<input type="button" onclick="goHome()" class="btn btn-primary btn-sm" value="Home" />
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
