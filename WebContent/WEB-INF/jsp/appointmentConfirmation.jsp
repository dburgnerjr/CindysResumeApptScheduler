<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Your Appointment Is Confirmed</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="static/css/app.css" rel="stylesheet" />
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
						<label class="col-md-2 control-lable">Date :</label>
						<div class="col-md-7">${date}</div>
					</div>
				</div>
				<div class="row">
					<div class="form-group col-md-12">
						<label class="col-md-2 control-lable">Time :</label>
						<div class="col-md-7">${time}</div>
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
						<input type="button" onclick="location.href='appointmentScheduler';" class="btn btn-primary btn-sm"value="Back" />
						<input type="button" onclick="location.href='index';" class="btn btn-primary btn-sm"value="Home" />				
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
