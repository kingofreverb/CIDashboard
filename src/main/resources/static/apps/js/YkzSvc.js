var service = angular.module('ykzSvc', ['ngResource']);

service.factory('YkzHttp', ['$http',
function($http) {
  function doGet(url, params) {
    $http({
      method: 'GET',
      url: url,
      params: params
    }).success(function(data, status, header, config) {

    }).error(function(data, status, header, config) {

    });
  }

  function doPost(url, params) {
	$http({
	  method: 'POST',
      url: url,
      data: params
    }).success(function(data, status, header, config) {

    }).error(function(data, status, header, config) {

    });
  }

  return {
    doGet: doGet,
    doPost: doPost
  };
}
]);

service.factory('YkzApi', ['$q', '$resource',
function($q, $resource) {
  function doGet(url, params, isArray, isCache) {
    var deferred = $q.defer();
    var resource = getResource(url, params, isArray, isCache);
    resource.get(
      function(result, response) {
        deferred.resolve(result);
      },
      function(msg, error) {
        deferred.reject(msg);
      }
    );
    return deferred.promise;
  }

  function doPost(url, params, isArray, isCache) {
    var deferred = $q.defer();
    var resource = getResource(url, params, isArray, isCache);
    resource.get(
      function(result, response) {
        deferred.resolve(result);
      },
      function(msg, error) {
        deferred.reject(msg);
      }
    );
    return deferred.promise;
  }

  function getResource(url, params, isArray, isCache) {
    var resource = $resource(url, {}, {
		get: {method: 'GET', params: {'params': JSON.stringify(params)}, isArray: isArray? isArray : false, cache: isCache? isCache : true},
		post: {method: 'POST', params: {'params': JSON.stringify(params)}}
    });
    return resource;
  }

  return {
    doGet: doGet,
    doPost: doPost
  };
}
]);