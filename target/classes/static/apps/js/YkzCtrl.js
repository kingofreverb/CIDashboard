var ykzCtrl = angular.module('ykzCtrl', []);

ykzCtrl.controller('YkzCtrl', ['$scope', 'YkzApi', 'uiGridConstants',
  function($scope, YkzApi, uiGridConstants) {
		// 申請一覧（自分の申請分）
		$scope.gridMyAppliedOpt = {
  		id: 'myApplyDataGrid',
  		enableFiltering: true,	
  	  columnDefs: [
        {name: 'ID', field: 'appId', width: 70,
        	cellTemplate: '<div><a class="link-center" href="/apply/{{COL_FIELD}}"><span class="link-center">{{COL_FIELD}}</span></a></div>'
        },
        {name: 'Title', field: 'appTitle', width: 300},
        {name: 'Type', field: 'appTypeCode', width: 110, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Applier', field: 'appUserNm', width: 200},
        {name: 'Status', field: 'appStsName', width: 110, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Apply Charge', field: 'appChargeUserNm', width: 200},
        {name: 'Apply Date', field: 'appTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150},
        {name: 'Update Date', field: 'appTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150},
        {name: 'Command', field: 'cmd', width: 100, enableFiltering: false, 
        	cellTemplate: '<div ng-if="row.entity.appStsCode == \'STS001\'"><a href="/apply/remove/{{row.entity.appId}}"><button type="button" class="btn btn-sm btn-info">Delete</button></a></div>'
        }
      ],
      data: []
  	};
		// CI用申請一覧(未対応分)
  	$scope.gridAppliedOpt = {
  		id: 'appliedDataGrid',
  		enableFiltering: true,
  	  columnDefs: [
        {name: 'ID', field: 'appId', width: 100,
        	cellTemplate: '<div><a href="/apply/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'
        },
        {name: 'Title', field: 'appTitle', width: 300},
        {name: 'Type', field: 'appTypeCode', width: 120, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Applier', field: 'appUserNm', width: 200},
        {name: 'Status', field: 'appStsName', width: 120, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Apply Charge', field: 'appChargeUserNm', width: 200},
        {name: 'Apply Date', field: 'appTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150},
        {name: 'Update Date', field: 'updTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150}
      ],
      data: []
  	};
		// CI用対応済一覧
  	$scope.gridApplyDoneOpt = {
  		id: 'appliedDoneGrid',
  		enableFiltering: true,
  	  columnDefs: [
        {name: 'ID', field: 'appId', width: 100,
        	cellTemplate: '<div><a href="/apply/{{COL_FIELD}}">{{COL_FIELD}}</a></div>'
        },
        {name: 'Title', field: 'appTitle', width: 300},
        {name: 'Type', field: 'appTypeCode', width: 120, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Applier', field: 'appUserNm', width: 200},
        {name: 'Status', field: 'appStsName', width: 120, filter: {
      	  type: uiGridConstants.filter.SELECT,
      	  selectOptions: []
        }},
        {name: 'Apply Charge', field: 'appChargeUserNm', width: 200},
        {name: 'Apply Date', field: 'appTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150},
        {name: 'Update Date', field: 'updTime', cellFilter: 'date:\'yyyy/MM/dd HH:mm:ss\'', enableFiltering: false, width: 150}
      ],
      data: []
  	};
		
		$scope.getAppTypeMst = function() {
			YkzApi.doGet('/apptype', {}, true, false).then(
				function(result) {
					$scope.appTypeList = result;
					$scope.gridMyAppliedOpt.columnDefs[2].filter.selectOptions = result;
					$scope.gridAppliedOpt.columnDefs[2].filter.selectOptions = result;
				},
				function(errMsg) {}
			);
		};
		$scope.getAppStsMst = function() {
			YkzApi.doGet('/appsts', {}, true, false).then(
				function(result) {
					$scope.appStsList = result;
					$scope.gridMyAppliedOpt.columnDefs[4].filter.selectOptions = result;
					$scope.gridAppliedOpt.columnDefs[4].filter.selectOptions = result;
				},
				function(errMsg) {}
			);
		};
		$scope.getVersion = function() {
			YkzApi.doGet('/version', {}, true, false).then(
				function(result) {
					$scope.versionList = result;
				},
				function(errMsg) {}
			);
		};
		$scope.getPrjTypeMst = function() {
			YkzApi.doGet('/prjtype', {}, true, false).then(
				function(result) {
					$scope.prjTypeList = result;
				},
				function(errMsg) {}
			);
		};
		$scope.getDependencyMst = function() {
			YkzApi.doGet('/dependency', {}, true, false).then(
				function(result) {
					$scope.dependencyList = result;
				},
				function(errMsg) {}
			);
		};
		$scope.getMstData = function() {
			$scope.getAppTypeMst();
			$scope.getAppStsMst();
			$scope.getVersion();
			$scope.getPrjTypeMst();
			$scope.getDependencyMst();
		}
	}
]);

ykzCtrl.controller('DevCtrl', ['$scope', '$controller', 'YkzApi', 'uiGridConstants',
  function($scope, $controller, YkzApi, uiGridConstants) {
		$controller('YkzCtrl', {$scope: $scope});
		
		$scope.getAppData = function() {
			YkzApi.doGet('/myappdata', {}, true, false).then(
				function(result) {
					$scope.gridMyAppliedOpt.data = result;
				},
				function(errMsg) {}
			);
		}

    $scope.init = function() {
	  	$scope.getMstData();
    	$scope.getAppData();
    };
    $scope.init();
  }
]);

ykzCtrl.controller('CiCtrl', ['$scope', '$controller', 'YkzApi', 'uiGridConstants',
  function($scope, $controller, YkzApi, uiGridConstants) {
		$controller('YkzCtrl', {$scope: $scope});
		
		$scope.getAppData = function() {
			YkzApi.doGet('/appdata', {}, true, false).then(
				function(result) {
					$scope.gridAppliedOpt.data = result;
				},
				function(errMsg) {}
			);
		};
		
		$scope.getAppDoneData = function() {
			YkzApi.doGet('/appfindata', {}, true, false).then(
				function(result) {
					$scope.gridApplyDoneOpt.data = result;
				},
				function(errMsg) {}
			);
		};

	  $scope.init = function() {
	  	$scope.getMstData();
	  	$scope.getAppData();
	  	$scope.getAppDoneData();
	  };
	  $scope.init();
	}
]);

