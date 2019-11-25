<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!doctype html>
<head>
	<title>Cindy's Resume Appointment Schedule Page</title>
	<style>
      .username.ng-valid {
          background-color: lightgreen;
      }
      .username.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .username.ng-dirty.ng-invalid-minlength {
          background-color: yellow;
      }
 
      .email.ng-valid {
          background-color: lightgreen;
      }
      .email.ng-dirty.ng-invalid-required {
          background-color: red;
      }
      .email.ng-dirty.ng-invalid-email {
          background-color: yellow;
      }
 
    </style>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
    <link href="static/css/app.css" rel="stylesheet" />

</head>
<body ng-app="myApp" class="ng-cloak">
      <div class="generic-container" ng-controller="ResumeController as ctrl">
          <div class="panel panel-default">
              <div class="panel-heading"><span class="lead">Resume Appointment Scheduler Form </span></div>
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="mySynchronousForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <label class="col-md-2 control-lable" for="uname">Synchronous Submission</label>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                              </div>
                          </div>
                      </div>                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="date">Date</label>
                              <div class="col-md-7">
                                  <input type="date" ng-model="ctrl.user.date" id="date" class="form-control input-sm" placeholder="Enter your Date" required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="time">Time</label>
                              <div class="col-md-7">
                                  <input type="time" ng-model="ctrl.user.time" id="time" class="form-control input-sm" placeholder="Enter your Time" required/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="comments">Comments</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.comments" id="comments" class="username form-control input-sm" placeholder="Enter your comments"/>
                              </div>
                          </div>
                      </div>                         
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="Add" class="btn btn-primary btn-sm" ng-disabled="mySynchronousForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="mySynchronousForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
              
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <label class="col-md-2 control-lable" for="uname">Asynchronous Submission</label>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="uname">Name</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.username" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                              </div>
                          </div>
                      </div>
                         
                       
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="date">Date</label>
                              <div class="col-md-7">
                                  <input type="datetime" ng-model="ctrl.user.date" id="date" class="form-control input-sm" placeholder="Enter your Date" required/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="time">Time</label>
                              <div class="col-md-7">
                                  <input type="time" ng-model="ctrl.user.time" id="time" class="form-control input-sm" placeholder="Enter your Time" required/>
                              </div>
                          </div>
                      </div>
 
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="email">Email</label>
                              <div class="col-md-7">
                                  <input type="email" ng-model="ctrl.user.email" id="email" class="email form-control input-sm" placeholder="Enter your Email" required/>
                              </div>
                          </div>
                      </div>
 
                       <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="comments">Comments</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.comments" id="comments" class="username form-control input-sm" placeholder="Enter your comments"/>
                              </div>
                          </div>
                      </div>                         
 
                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">List of Users </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID</th>
                              <th>Name</th>
                              <th>Date</th>
                              <th>Time</th>
                              <th>Email</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody>
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.username"></span></td>
                              <td><span ng-bind="u.date"></span></td>
                              <td><span ng-bind="u.time"></span></td>
                              <td><span ng-bind="u.email"></span></td>
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
       
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js" />
      <script src="static/js/app.js" />
      <script src="static/js/service/resume_service.js" />
      <script src="static/js/controller/resume_controller.js" />
  </body>
  </html>
  