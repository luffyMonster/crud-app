<!DOCTYPE html>

<html lang="en" ng-app="student-managament-app">
<head>
    <title>${title}</title>
    <link href="css/bootstrap.css" rel="stylesheet"/>
    <link href="css/app.css" rel="stylesheet"/>
</head>
<body>

    <div ui-view>Loading...</div>

    <script src="js/lib/angular.min.js" ></script>
    <script src="js/lib/angular-ui-router.min.js" ></script>
    <script src="js/lib/localforage.min.js" ></script>
    <script src="js/lib/ngStorage.min.js"></script>
    <script src="js/app/app.js"></script>
    <script src="js/app/StudentService.js"></script>
    <script src="js/app/StudentController.js"></script>
</body>
</html>