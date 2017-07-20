var app = angular.module('student-managament-app',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8080/',
    STUDENT_SERVICE_API : 'http://localhost:8080/api/user/student/'
});
 
app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {
 
        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'StudentController',
                controllerAs:'ctrl',
                resolve: {
                    students: function ($q, StudentService) {
                        console.log('Load all students');
                        var deferred = $q.defer();
                        StudentService.loadAllStudents().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            })
             .state('test', {
                url: '/test',
                templateUrl: 'partials/test',
                controller: function($scope){
                    $scope.message = "Duy nghia handsome";
                    this.me = "ME ";
                },
                controllerAs: 'ctrl'
            });
        $urlRouterProvider.otherwise('/');
    }]);