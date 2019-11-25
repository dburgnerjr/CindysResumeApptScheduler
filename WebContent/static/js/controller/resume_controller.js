/**
 * 
 */
'use strict';
 
angular.module('myApp').controller('ResumeController', ['$scope', 'ResumeService', function($scope, ResumeService) {
    var self = this;
    self.user={id:null,username:'',date:'',time:'',email:'',comments:''};
    self.users=[];
 
    self.submit = submit;
    self.edit = edit;
    self.remove = remove;
    self.reset = reset;
 
 
    fetchAllUsers();
 
    function fetchAllUsers(){
        ResumeService.fetchAllUsers()
            .then(
            function(d) {
                self.users = d;
            },
            function(errResponse){
                console.error('Error while fetching Users');
            }
        );
    }
 
    function createUser(user){
    	ResumeService.createUser(user)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while creating User');
            }
        );
    }
 
    function updateUser(user, id){
    	ResumeService.updateUser(user, id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while updating User');
            }
        );
    }
 
    function deleteUser(id){
    	ResumeService.deleteUser(id)
            .then(
            fetchAllUsers,
            function(errResponse){
                console.error('Error while deleting User');
            }
        );
    }
 
    function submit() {
        if(self.user.id===null){
            console.log('Saving New User', self.user);
            createUser(self.user);
        }else{
            updateUser(self.user, self.user.id);
            console.log('User updated with id ', self.user.id);
        }
        reset();
    }
 
    function edit(id){
        console.log('id to be edited', id);
        for(var i = 0; i < self.users.length; i++){
            if(self.users[i].id === id) {
                self.user = angular.copy(self.users[i]);
                break;
            }
        }
    }
 
    function remove(id){
        console.log('id to be deleted', id);
        if(self.user.id === id) {//clean form if the user to be deleted is shown there.
            reset();
        }
        deleteUser(id);
    }
 
 
    function reset(){
        self.user={id:null,username:'',date:'',time:'',email:'',comments:''};
        $scope.myForm.$setPristine(); //reset Form
    }
 
}]);