<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Your Appointment Is Confirmed</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="resources/css/app.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Submitted Appointment Information</span>
			</div>
			<div class="formcontainer">
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Name :</label>
						<div class="col-md-7">${name}</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Date/Time :</label>
						<div class="col-md-7">${date}</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Email Address :</label>
						<div class="col-md-7">${email}</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Comments :</label>
						<div class="col-md-7">${comments}</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<input type="button" onclick="appointmentScheduler()" class="btn btn-primary btn-sm"value="Back" />
						<input type="button" onclick="goHome()" class="btn btn-primary btn-sm"value="Home" />				
					</div>
				</div>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="resources/js/location.js"></script>
</body>
</html>
