<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Comment Has Been Updated</title>
<link href="resources/css/app.css" rel="stylesheet" />
<link href="resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Comment Has Been Updated</span>
			</div>
			<div class="formcontainer">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Name:</label>
						<div class="col-md-7">
							<label class="col-md-7 control-lable">${name}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Date:</label>
						<div class="col-md-7">
							<label class="col-md-7 control-lable">${date}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Time: </label>
						<div class="col-md-7">
							<label class="col-md-7 control-lable">${time}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Email Address:</label>
						<div class="col-md-7">
							<label class="col-md-7 control-lable">${email}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Comments:</label>
						<div class="col-md-7">
							<label class="col-md-7 control-lable">${comments}</label>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<input type="button" onclick="appointmentScheduler()"
							class="btn btn-success custom-width" value="Back" /> <input
							type="button" onclick="goHome()"
							class="btn btn-success custom-width" value="Home" />
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="resources/js/location.js"></script>
</body>
</html>
