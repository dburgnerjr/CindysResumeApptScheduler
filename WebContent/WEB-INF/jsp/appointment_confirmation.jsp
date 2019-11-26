<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<head>
<meta charset="ISO-8859-1">
<title>Your Appointment Is Confirmed</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href="static/css/app.css" rel="stylesheet" />
</head>
<body>
    <h2>Submitted Appointment Information</h2>
    <table>
        <tr>
            <td>Name :</td>
            <td>${name}</td>
        </tr>
        <tr>
            <td>Date :</td>
            <td>${date}</td>
        </tr>
        <tr>
            <td>Time :</td>
            <td>${time}</td>
        </tr>
        <tr>
            <td>Email Address :</td>
            <td>${email}</td>
        </tr>
        <tr>
            <td>Comments :</td>
            <td>${comments}</td>
        </tr>
    </table>
<p><a href="appointment_scheduler.html">Click here to go back to the Appointment Scheduler</a></p>
</body>
</html>