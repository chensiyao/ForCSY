/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */
var app = angular.module("myApp", ["ngTouch","ui.router","validation.rule","validation"]);

app.config(function($validationProvider){
	//成功时,不需要显示信息
	$validationProvider.showSuccessMessage = false;
	
	//失焦时验证
	$validationProvider.setValidMethod("watch");
	
	$validationProvider.validCallback = function(element) {
		$(element[0]).parents(".weui-cell").removeClass('weui-cell_warn');
	};
	$validationProvider.invalidCallback = function(element) {
		$(element[0]).parents(".weui-cell").addClass('weui-cell_warn');
	};
	
    $validationProvider.getMsgElement = function(element) {
    	return angular.element($("div#formInValidErrorMsg"));
    };

});

app.config(function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/');
	
	$stateProvider.state('examplePic', {
		url: '/examplePic',
    	replace: true,
		templateUrl: 'examplePic.html',
    	controller: function(){
    		$("form[name='registerForm']").hide();
    	}
    }).state('toast_ok', {
		url: '/toast_ok',
    	replace: true,
		templateUrl: 'toast_ok.html'
    }).state('toast_voice', {
    	url: '/toast_voice',
    	params : {
    		'fail': undefined
    	},
    	reload: true,
    	replace: true,
    	templateUrl: 'toast_voice.html',
    	controller: 'toastVoiceController'
    }).state('formRst',{
    	url: '/forRst',
    	params : {
    		'errMsg': undefined
    	},
    	replace: true,
    	transclude: true,
    	templateUrl: 'formRst.html',
    	controller: 'formRstController'
    }).state('/',{
    	url: '/',
    	template: '',
    	controller: function(){
    		$("form[name='registerForm']").show();
    	}
    });
});

app.controller("toastVoiceController", function($scope, $stateParams, $location) {
	$scope.fail = $stateParams.fail;
});

app.controller("formRstController", function($scope, $stateParams, $state, $location) {
	$scope.errMsg = $stateParams.errMsg;
	$location.path("").replace();
//	//提交反馈页面禁止刷新
//	if($scope.errMsg === undefined){
//		$state.go("/");
//	}
//	$scope.rtnForm = function(){
//		$state.go("/");
//	};
	
//	$scope.errMsg = $stateParams.errMsg;
	//提交反馈页面禁止刷新
	if($scope.errMsg === undefined){
		$state.go("/");
	}else{
		$("form[name='registerForm']").hide();
	}
	$scope.rtnForm = function(){
		$state.go("/");
	};
});

app.controller("myCtrl", function($scope, $state, $timeout, $interval, $http, $injector) {
	
	//$validationProvider验证对象
	var $validationProvider = $injector.get("$validation");
	
	//根据localID, 获取xxtp的json数据
	var getXxtpIndexByLocalId = function(localId){
		//获取总的列表
		var xxtps = [];
		for(var i in $scope.xxtps){
			xxtps.push($scope.xxtps[i].uploadUrl);
		}
		//获取当前上传的json
		return $.inArray(localId, xxtps);
	};

	//根据localID, 获取voice的json数据
	var getVoiceIndexByLocalId = function(localId){
		//获取总的列表
		var voices = [];
		for(var i in $scope.voices){
			voices.push($scope.voices[i].uploadUrl);
		}
		//获取当前上传的json
		return $.inArray(localId, voices);
	};
	
	var uploadSingleImage = function(localId, callback){
		
		var index1 = getXxtpIndexByLocalId(localId);
    	if(index1 == -1) return;
    	
    	//开始上传的基本设置
		$scope.xxtps[index1].uploadWaiting = true;
		$scope.xxtps[index1].uploading = true;
		
		
		wx.uploadImage({
    	    localId: localId, 			// 需要上传的图片的本地ID，由chooseImage接口获得
    	    isShowProgressTips: 0, 				// 默认为1，显示进度提示
    	    success: function (res) {
    	    	var index = getXxtpIndexByLocalId(localId);
    	    	if(index>-1){
    	    		$scope.$apply(function(){
        	    		$scope.xxtps[index].uploadSuccess = true;
        	    		$scope.xxtps[index].uploadError = 0;
        	    		$scope.xxtps[index].uploadWaiting = false;
        	    		$scope.xxtps[index].uploading = false;
        	    		$scope.xxtps[index].serverId = res.serverId;
        	    		
        	    		//需要重新克隆一个对象, 否则uploadSuccess无法在li上生效,原因不明
        	    		var json = $scope.xxtps[index];
        	    		var json1 = {};
        	    		for(var i in json){
        	    			if(i != '$$hashKey'){
            	    			json1[i] = json[i];
        	    			}
        	    		}
        	    		$scope.xxtps[index] = json1;
	        		},true);
    	    	}
    	    },
    	    fail: function(res){
    	    	var index = getXxtpIndexByLocalId(localId);
    	    	if(index>-1){
    	    		$scope.$apply(function(){
        	    		$scope.xxtps[index].uploadSuccess = false;
        	    		$scope.xxtps[index].uploadError++;
        	    		$scope.xxtps[index].uploadWaiting = false;
        	    		$scope.xxtps[index].uploading = false;
        	    		$scope.xxtps[index].serverId = undefined;	// 返回图片的服务器端ID
        	    		
        	    		var json = $scope.xxtps[index];
        	    		var json1 = {};
        	    		for(var i in json){
        	    			if(i != '$$hashKey'){
        	    				json1[i] = json[i];
        	    			}
        	    		}
        	    		$scope.xxtps[index] = json1;
	        		});
        	    	alert("上传失败: "+res.errMsg);
        	    	if($scope.xxtps[index].uploadError >= 3){
        	    		alert("失败次数过多,请删除并更换新的图片");
        	    	}
    	    	}
    	    },
    	    complete: function(){
    	    	if($.isFunction(callback)){
    	    		callback();
    	    	}
    	    }
    	});
	};
	
    //本地图片上传列表
    var uploadImageList = function(localIds, index){
    	if(!index) index = 0;
    	//本地选中元素还有
    	if(index <= localIds.length-1){
    		uploadSingleImage(localIds[index], function(localIds, newIndex){
    	    	return function(){
    	    		uploadImageList(localIds, newIndex);
    	    	};
    		}(localIds, ++index));
    	}
    };
	
    //语音只能单个上传,暂时不用list
    var uploadVoice = function(localId){
    	var index = getVoiceIndexByLocalId(localId);
    	//如果录音已经不存在,直接返回
    	if(index < 0) return;
    	
    	//上传结束时,重新获取index,防止 在音频上传结束前用户删除录音导致序号紊乱
    	wx.uploadVoice({
    	    localId: localId, 	// 需要上传的音频的本地ID，由stopRecord接口获得
    	    isShowProgressTips: 0, // 默认为1，显示进度提示
    	    success: function (res) {
    	    	var index = getVoiceIndexByLocalId(localId);
    	    	if(index>-1){
    	    		$scope.$apply(function(){
        	    		$scope.voices[index].uploadSuccess = true;
        	    		$scope.voices[index].uploadError = 0;
        	    		$scope.voices[index].uploadWaiting = false;
        	    		$scope.voices[index].uploading = false;
        	    		$scope.voices[index].serverId = res.serverId;
        	    		
        	    		//需要重新克隆一个对象, 否则uploadSuccess无法在li上生效,原因不明
        	    		var json = $scope.voices[index];
        	    		var json1 = {};
        	    		for(var i in json){
        	    			if(i != '$$hashKey'){
            	    			json1[i] = json[i];
        	    			}
        	    		}
        	    		$scope.voices[index] = json1;
	        		},true);
    	    	}
    	    },
    	    fail: function(res){
    	    	var index = getVoiceIndexByLocalId(localId);
    	    	if(index>-1){
    	    		$scope.$apply(function(){
        	    		$scope.voices[index].uploadSuccess = false;
        	    		$scope.voices[index].uploadError++;
        	    		$scope.voices[index].uploadWaiting = false;
        	    		$scope.voices[index].uploading = false;
        	    		$scope.voices[index].serverId = undefined;	// 返回图片的服务器端ID
        	    		
        	    		var json = $scope.voices[index];
        	    		var json1 = {};
        	    		for(var i in json){
        	    			if(i != '$$hashKey'){
        	    				json1[i] = json[i];
        	    			}
        	    		}
        	    		$scope.voices[index] = json1;
	        		});
        	    	alert("上传失败: "+res.errMsg);
        	    	if($scope.voices[index].uploadError >= 3){
        	    		alert("失败次数过多,请删除并更换新的语音重试");
        	    	}
    	    	}
    	    }
    	});
    };
    
    //事故信息
    $scope.info = {};
    
    //事故发生时间信息默认
	$scope.info.occurrenceTime = new Date();
	
	$scope.openLocation = function(longitude, latitude){
		if(!!wx.initOk){
			if(latitude>0 || longitude>0){
		    	//请求成功的状态
		    	var geocoder = new qq.maps.Geocoder();
	    		var latLng = new qq.maps.LatLng(latitude, longitude);
	    		geocoder.getAddress(latLng);//对指定经纬度进行解析
	    		geocoder.setComplete(function(result) {
	    			$scope.$apply(function(){
	    				var address = result.detail.addressComponents;
	    				wx.openLocation({
	    				    latitude: $scope.info.latitude, // 纬度，浮点数，范围为90 ~ -90
	    				    longitude: $scope.info.longitude, // 经度，浮点数，范围为180 ~ -180。
	    				    name: address.city + address.district, // 位置名
	    				    address: result.detail.address, // 地址详情说明
	    				    scale: 16, // 地图缩放级别,整形值,范围从1~28。默认为最大
	    				    infoUrl: '' // 在查看位置界面底部显示的超链接,可点击跳转
	    				});
	    			});
	    		});
			}
		}
	};
	
	$scope.getPosition = function(){
		
		//首先获取用户地理位置信息
		wx.getLocation({
		    type: 'gcj02', // 默认为wgs84的gps坐标，如果要返回直接给openLocation用的火星坐标，可传入'gcj02'
		    success: function (res) {
		    	$scope.$apply(function(){
			    	$scope.info.longitude = res.longitude;
			    	$scope.info.latitude = res.latitude;
			    	
			    	//请求成功的状态
			    	var geocoder = new qq.maps.Geocoder();
		    		var latLng = new qq.maps.LatLng($scope.info.latitude, $scope.info.longitude);
		    		geocoder.getAddress(latLng);//对指定经纬度进行解析
		    		geocoder.setComplete(function(result) {
		    			$scope.$apply(function(){
		    				if(!!result.detail.address){
		    					var address = result.detail.addressComponents;
		    					$scope.position = address.city+address.district+address.streetNumber;
		    				}else{
						    	$scope.position = "经度:" + res.longitude + ",纬度:" + res.latitude;
		    				}
		    			});
		    		});
		    		//若服务请求失败，则运行以下函数
		    		geocoder.setError(function() {
		    			$scope.$apply(function(){
		    				$scope.position = "经度:"+info.longitude+",纬度:"+info.latitude;
		    			});
		    		});
		    	});
		    	$scope.positionFail = false;
		    },
		    fail: function (res){
		    	$scope.$apply(function(){
					$scope.position = "GPS定位失败，点我重试";
					$scope.positionFail = true;
					alert("GPS定位失败，请确认定位是否开启并允许本站访问");
		    	});
		    }
		});
	};
	
	$scope.positionInterval = $interval(function(){
		//如果微信初始化成功
		if(!!wx.initOk){
			//停止定时器
			$interval.cancel($scope.positionInterval);
			
			//默认加载完成时获取一次定位
			$scope.getPosition();
			//接下来去绑定wx.onVoiceRecordEnd回调函数
			wx.onVoicePlayEnd({
			    success: function (res) {
			        var stopLocalID = res.localId; // 返回音频的本地ID
			        var index = getVoiceIndexByLocalId(stopLocalID);
			        //语音仍然在
			        if(index > -1){
			        	$scope.$apply(function(){
			        		var voice = {};
			        		angular.copy($scope.voices[index],voice);
			        		voice.voicing = false;
			        		$scope.voices[index]=voice;
			        	});
			        }
			        $scope.voicingID = undefined;
			    }
			});
		}else if(!!wx.initFail){
			//微信控件加载失败
			$interval.cancel($scope.positionInterval);
		}
	}, 1000, 20);
	
	//驾驶员信息索引预定
	$scope.jsyxxIndex = function(number){
		return String.fromCharCode(number+65);
	};
	
	//新增驾驶员事件绑定
	$scope.addJsy = function(){
		$scope.info.jsyxxs.push({name:"",hphm:"",contact:""});
		
		if($scope.info.jsyxxs.length >= 3){
			$scope.disableAddJsy = false;
		}else{
			$scope.disableAddJsy = true;
		}
	};
	
	//驾驶员删除操作
	$scope.deleteJsy = function(index){
		$scope.info.jsyxxs.splice(index, 1);

		if($scope.info.jsyxxs.length >= 3){
			$scope.disableAddJsy = false;
		}else{
			$scope.disableAddJsy = true;
		}
	};
	
	//驾驶员加载信息
	$scope.info.jsyxxs = [
	                 {name:"",hphm:"",contact:""},
	                 {name:"",hphm:"",contact:""}
	                 ];
	
	//示例图绑定
	$scope.examplePic = function(){
		$state.go("examplePic");
	};
	
	//事故描述字段及时提醒绑定
	$scope.getSgfsmsLenght = function() {
		if(!$scope.info.description){
			return 0;
		}else{
			return $scope.info.description.length;
		}
	};
	
	//图片上传操作初始化数据
	$scope.xxtps = [];
	//删除已经上传的图片
	$scope.deletePic = function($event, index){
		var rst = window.confirm("确定要删除该图片吗?");
		if(rst){
			$scope.xxtps.splice(index, 1);
		}
		$event.stopPropagation();
	};
	
	//上传元素点击事件(如果是已上传成功的图片,则打开预览界面,如果是上传失败的图片,点击重传)
	$scope.picClick = function(index){
		
		var xxtpJSON = $scope.xxtps[index];
		
		//在非编辑状态的前提下，上传失败且未还不在上传队列中的需要重新上传，
		if(!$scope.editUploder && xxtpJSON.uploadError > 0 && !xxtpJSON.uploadWaiting){
			uploadSingleImage(xxtpJSON.uploadUrl);
		}
		//其他元素直接预览即可
		else{
			var urls = [];
			for(var i in $scope.xxtps){
				urls.push($scope.xxtps[i].uploadUrl);
			}
			wx.previewImage({
			    current: $scope.xxtps[index].uploadUrl, 
			    urls: urls // 需要预览的图片http链接列表
			});
		}
	};
	
	//图片上传到本地
	$scope.uploadImgLocal = function(){
		wx.chooseImage({
		    count: 9, 
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        for(var i=0; i<localIds.length; i++){
		        	if($scope.xxtps.length >= 10){
		        		alert("最多可上传十张图片!");
		        		break;
		        	}
		        	$scope.$apply(function(i){
		        		return function(){
			        		if(window.__wxjs_is_wkwebview){
			        			wx.getLocalImgData({
			        				localId: localIds[i], // 图片的localID
			        				success: function (res) {
			        					$scope.$apply(function(){
				        					var localData = res.localData; // localData是图片的base64数据，可以用img标签显示
				        					$scope.xxtps.push({
				        						iosUploadUrl: localData,
								        		uploadUrl: localIds[i],
								        		uploadSuccess: false,
								        		uploadError: 0,
								        		uploadWaiting: true,
								        		uploading: false
								        	});
							        		if(i==localIds.length-1){
							    		        uploadImageList(localIds);
							        		}
			        					});
			        				}
			        			});
			        		}else{
				        		$scope.xxtps.push({
					        		uploadUrl: localIds[i],
					        		uploadSuccess: false,
					        		uploadError: 0,
					        		uploadWaiting: true,
					        		uploading: false
					        	});
				        		if(i==localIds.length-1){
				    		        uploadImageList(localIds);
				        		}
			        		}
		        		};
		        	}(i));
		        }
		    }
		});
	};
	
	$scope.onTouchMove = function(event){
		if(!!$scope.inVoice){
			event = event || window.event;
			event.preventDefault();
			return false;
		}
	};
	
	$scope.voices=[];
	
	//删除已经上传的语音操作
	$scope.deleteVoice = function($event, index){
		var rst = window.confirm("确定要删除该语音消息吗?");
		if(rst){
			//如果正在播放，先停止其播放
			if(!!$scope.voices[index].voicing){
				$scope.stopVoice($scope.voices[index].uploadUrl);
			}
			$scope.voices.splice(index, 1);
		}
		$event.stopPropagation();
	};
	
	$scope.stopVoice = function(stopLocalID, newStart){
		//如果是新开启一个语音
		if(!newStart){
			wx.stopVoice({
			    localId: stopLocalID
			});
		}
		
        var index = getVoiceIndexByLocalId(stopLocalID);
        //语音仍然在
        if(index > -1){
    		$scope.voices[index].voicing = false;
        }
        $scope.voicingID = undefined;
	};
	
	//本地播放功能 
	$scope.playVoice = function(index){
		
		var voiceJson = $scope.voices[index];
		
		//在非编辑状态的前提下，上传失败且未还不在上传队列中的需要重新上传，
		if(!$scope.editUploderVoice && voiceJson.uploadError > 0 && !voiceJson.uploadWaiting){
			
		}else{
			var callBack = function(paramJson){
	        	return function(){
	        		wx.playVoice({
	        			localId: paramJson.uploadUrl
	        		});
	        		$scope.voicingID = paramJson.uploadUrl;
	        		paramJson.voicing = true;
	        	};
	        }(voiceJson);
	        
	        //如果当前没在播放的录音
	        if($scope.voicingID == undefined){
	        	callBack();
			}
	        //如果是同一个录音多次点击
	        else if($scope.voicingID == voiceJson.uploadUrl){
				$scope.stopVoice(voiceJson.uploadUrl);
			}
	        //如果在播放其他录音
	        else{
	        	$scope.stopVoice($scope.voicingID);
	        	callBack();
			}
		}
	};
	
	//开始录音
	$scope.startRecord = function(){
		$scope.inVoice = !$scope.inVoice;
		$timeout(function(){
			if(!!$scope.inVoice){
				$scope.inVoicing = true;
				$scope.inVoicingTime = new Date().getTime();
				wx.startRecord();
				//录音中弹出框
				$state.go("toast_voice",{fail:false});
			}
		}, 500, true);
	};
	
	$scope.stopRecord = function(){
		//如果没在录音
		if(!$scope.inVoicing){
			$scope.inVoice = false;
			return;
		}
		
		//正在录音，情况下，极短的时间内触发stopRecord，可能会存在收不到任何回调的情况;
		var curTime = new Date().getTime();
		var startTime = $scope.inVoicingTime;
		
		//录制时间少于0.5秒, 则startRecord开启0.5毫秒之后再触发stopRecord
		if(curTime - startTime < 1000){
    		$state.go("toast_voice",{fail:"时间太短"});
			$timeout(function(){
				wx.stopRecord();
				$timeout(function(){
		    		$state.go("/");
		    		$scope.inVoice = !$scope.inVoice;
		    		$scope.inVoicing = false;
	    		}, 1000, true);
			}, 1000-(curTime-startTime), true);
		}
		//正常录音情况
		else{
			var rst = false;
			wx.stopRecord({
			    success: function (res) {
			    	rst = true;
			    	//录制成功关闭弹框
		    		$state.go("/");
		    		$scope.$apply(function(){
			    		$scope.voices.push({
							uploadUrl: res.localId,
							uploadSuccess: false,
							uploadError: 0,
							uploadWaiting: true,
							uploading: false,
							voicing: false,
							serverId: undefined
			    		});
			    		uploadVoice(res.localId);
		    		});
			    },
			    fail: function(res){
			    	//录制失败,开启弹框
			    	if(res.errMsg.indexOf("tooshort")){
			    		$state.go("toast_voice",{fail:"时间太短"});
			    	}else{
			    		$state.go("toast_voice",{fail:"未知错误"});
			    	}
			    },
			    complete: function(res){
			    	$scope.$apply(function(){
			    		//有异常
			    		if(!rst){
				    		$timeout(function(){
					    		$state.go("/");
					    		$scope.inVoice = !$scope.inVoice;
				    		}, 1000, true);
			    		}else{
			    			$scope.inVoice = !$scope.inVoice;
			    		}
			    		$scope.inVoicing = false;
			    	});
			    }
			});
		}
	};
	
	$scope.form = {
		checkValid: function(form){
			return $validationProvider.checkValid(!!form?form:undefined);
		},
		submit: function(info){
			//禁止重复提交
			if($scope.submitted || $scope.submitting) return;
			
			var submitInfo = {};
			angular.copy(info,submitInfo);
			
			var xxtpsUrl = function(){
				var xxtpsUrl = [];
				for(var i=0; i<$scope.xxtps.length; i++){
					xxtpsUrl.push($scope.xxtps[i].serverId);
				}
				return xxtpsUrl;
			}();
			
			var voicesUrl = function(){
				var voicesUrl = [];
				for(var i=0; i<$scope.voices.length; i++){
					voicesUrl.push($scope.voices[i].serverId);
				}
				return voicesUrl;
			}();

			//数据提交前的封装
			submitInfo.liveImage = xxtpsUrl.join(",");
			submitInfo.liveVoice = voicesUrl.join(",");
			submitInfo.occurrenceTime = submitInfo.occurrenceTime.getTime();
			if($validationProvider.checkValid($scope.registerForm)){
				//记录开始提交
				$scope.submitting = true;
				$http({
					method: "post",
					url: rootPath + "/wx/addKckpInfo",
					data: submitInfo
				}).success(function(data,status,config,headers){
					$scope.submitting = false;
					if(!!data && !data.errMsg){
						$scope.submitted = true;
					}
					$state.go("formRst", data);
					console.log(data);
				}).error(function(data,status,hedaers,config){
					$scope.submitting = false;
					$state.go("formRst",{errMsg:"系统异常! 错误代码:"+status});
					console.log(data);
				});
			}else{
				$validationProvider.validate($scope.registerForm);
			}
		}
	};
});


$(function(){
	
	$("body").css("display","block");
	
	$.getJSON(rootPath+"/wx/sign?url=" + encodeURIComponent(location.href.split('#')[0]), function (res) {
        wx.config({
            debug: false,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            jsApiList: [
				"getLocation",
				"openLocation",
				"chooseImage",
				"previewImage",
				"uploadImage",
				"startRecord",
				"stopRecord",
				"onVoiceRecordEnd",
				"playVoice",
				"stopVoice",
				"onVoicePlayEnd",
				"uploadVoice"
            ]
        });
        
        wx.ready(function(rst){
        	wx.initOk = true;
        });
        wx.error(function(rst){
        	wx.initFail = true;
        });
    });
});
