<!DOCTYPE html>
<html>
<head>
<title>Update Appointment with a Comment</title>
<link href="../resources/css/app.css" rel="stylesheet" />
<link href="../resources/css/bootstrap.css" rel="stylesheet" />
</head>
<body>
	<div class="generic-container">
		<div class="panel panel-default">
			<div class="panel-heading">
				<span class="lead">Update Appointment with a Comment</span>
			</div>
			<div class="formcontainer">
				<form method="POST" action="/CindysResumeApptScheduler/submitUpdatedComment">
					<input type="hidden" id="id" name="id" value="${id}" />
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Name: </label>
							<div class="col-md-7">
								<input type="hidden" id="name" name="name" value="${name}" />
								<label class="col-md-7 control-lable">${name}</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Date: </label>
							<div class="col-md-7">
								<input type="hidden" id="date" name="date" value="${date}" />
								<label class="col-md-7 control-lable">${date}</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Time: </label>
							<div class="col-md-7">
								<input type="hidden" id="time" name="time" value="${time}" />
								<label class="col-md-7 control-lable">${time}</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Email Address: </label>
							<div class="col-md-7">
								<input type="hidden" id="email" name="email" value="${email}" />
								<label class="col-md-7 control-lable">${email}</label>
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-group col-md-12">
							<label class="col-md-2 control-lable">Comments: </label>
							<div class="col-md-7">
								<input type="text" id="comments" name="comments" value="${comments}" class="comments form-control input-sm" />
							</div>
						</div>
					</div>
					<div class="row">
						<div class="form-actions floatLeft">
							<input type="submit" value="Submit" class="btn btn-success custom-width">
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js"></script>
	<script src="../resources/js/location.js"></script>
</body>
</html>
