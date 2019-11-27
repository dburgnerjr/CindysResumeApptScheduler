<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<title>Schedule a New Appointment</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="static/css/app.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Resume Appointment Scheduler Form </span>
			</div>
			<div class="formcontainer">	��������
				<form:form method="POST" action="/CindysResumeApptScheduler/appointmentConfirmation" modelAttribute="appointment">
					<div class="row">
						<label class="col-md-2 control-lable" for="sync_submit">Synchronous Submission</label>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="name">Name</form:label>
							<div class="col-md-7">
								<form:input type="text" path="name" class="name form-control input-sm" /> 
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="date">Date</form:label>
							<div class="col-md-7">
								<form:input type="date" path="date" class="date form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="time">Time</form:label>
							<div class="col-md-7">
								<form:input type="time" path="time" class="time form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="email">Email Address</form:label>
							<div class="col-md-7">
								<form:input type="email" path="email" class="email form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<form:label class="col-md-2 control-lable" path="comments">Comments</form:label>
							<div class="col-md-7">
								<form:input type="text" path="comments" class="comments form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatLeft">
							<input type="submit" value="Add" class="btn btn-primary btn-sm">
						</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
	<div>
		<a href="index">Home</a>
	</div>
</body>
</html>