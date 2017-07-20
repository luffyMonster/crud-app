
<div class="generic-container">
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">Specific Student </span></div>
        <div class="panel-body">
            <div class="formcontainer">
                <div class="alert alert-success" role="alert" ng-if="ctrl.successMessage">{{ctrl.successMessage}}</div>
                <div class="alert alert-danger" role="alert" ng-if="ctrl.errorMessage">{{ctrl.errorMessage}}</div>
                <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                    <input type="hidden" ng-model="ctrl.student.id" />
                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="uname">Name</label>
                            <div class="col-md-7">
                                <input type="text" name="name" ng-model="ctrl.student.name" id="uname" class="username form-control input-sm" placeholder="Enter your name" required ng-minlength="3"/>
                            </div>
                            <div class="col-md-3">
                                <span ng-show="!myForm.name.$pristine && myForm.name.$error.required" class="help-block">Required. </span>
                                <span ng-show="!myForm.name.$pristine && myForm.name.$error.minlength" class="help-block">Must more 3 characters.</span>
                            </div>
                        </div>

                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="birthday">Birthday</label>
                            <div class="col-md-7">
                                <input type="text" name="birthday" ng-model="ctrl.student.birthday" id="birthday" class="form-control input-sm" placeholder="Enter your Birthday: dd/mm/yyyy." required ng-pattern="ctrl.onlyDates"/>
                            </div>
                            <div class="col-md-3">
                                <span ng-show="!myForm.birthday.$pristine && myForm.birthday.$error.required" class="help-block">Required. </span>
                                <span ng-show="!myForm.birthday.$pristine && myForm.birthday.$error.pattern" class="help-block">Invalid Date Format.</span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="id-number">Identification Number</label>
                            <div class="col-md-7">
                                <input type="text" name="idnumber" ng-model="ctrl.student.idNumber" id="id-number" class="form-control input-sm" placeholder="Enter your ID number." required ng-pattern="ctrl.onlyIntegers"/>
                            </div>
                            <div class="col-md-3">
                                <span ng-show="!myForm.idnumber.$pristine && myForm.idnumber.$error.required" class="help-block">Required. </span>
                                <span ng-show="!myForm.idnumber.$pristine && myForm.idnumber.$error.pattern" class="help-block">Must an Integer.</span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="adress">Adress</label>
                            <div class="col-md-7">
                                <input type="text" name="adress" ng-model="ctrl.student.adress" id="adress" class="form-control input-sm" placeholder="Enter your Adress." required />
                            </div>
                            <div class="col-md-3">
                                <span ng-show="!myForm.adress.$pristine && myForm.adress.$error.required" class="help-block">Required. </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-group col-md-12">
                            <label class="col-md-2 control-lable" for="student-code">Student Code</label>
                            <div class="col-md-7">
                                <input type="text" name="code" ng-model="ctrl.student.studentCode" id="student-code" class="form-control input-sm" placeholder="Enter your Student Code." required />
                            </div>
                            <div class="col-md-3">
                                <span ng-show="!myForm.code.$pristine && myForm.code.$error.required" class="help-block">Required. </span>
                            </div>
                        </div>
                    </div>

                    <div class="row">
                        <div class="form-actions floatRight">
                            <input type="submit"  value="{{!ctrl.student.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid || myForm.$pristine">
                            <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <!-- Default panel contents -->
        <div class="panel-heading"><span class="lead">List of Students </span></div>
        <div class="panel-body">
            <div class="table-responsive">
                <table class="table table-hover">
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>NAME</th>
                        <th>BIRTHDAY</th>
                        <th>ID NUMBER</th>
                        <th>ADRESS</th>
                        <th>STUDENT CODE</th>
                        <th width="100"></th>
                        <th width="100"></th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr ng-repeat="u in ctrl.getAllStudents()">
                        <td>{{u.id}}</td>
                        <td>{{u.name}}</td>
                        <td>{{u.birthday}}</td>
                        <td>{{u.idNumber}}</td>
                        <td>{{u.adress}}</td>
                        <td>{{u.studentCode}}</td>
                        <td><button type="button" ng-click="ctrl.editStudent(u.id)" class="btn btn-success custom-width">Edit</button></td>
                        <td><button type="button" ng-click="ctrl.removeStudent(u.id)" class="btn btn-danger custom-width">Remove</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
Static resources