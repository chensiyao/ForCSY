/**
 * 快处快赔流程
 * @author wangqiang
 * @description
 */
var app = angular.module("myApp", ["ui.router"]);

app.config(function ($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('');
	
	$stateProvider.state('detail', {
		url: '/detail',
    	params: {data: undefined},
		templateUrl: 'detail.html',
		controller: 'detail'
    }).state('/',{
    	url: '/',
    	template: ''
    });
});

app.controller("detail", function($scope, $stateParams, $state, $http, $sce){
	if(!$stateParams.data){
		$state.go("/");
		return;
	}
	
	var info = $stateParams.data;
	var resoure_prev = $("#wxResource").val() + "/" + new Date(info.occurrenceTime.time)
			.format("yyyy-MM-dd")+"/"+ info.fkWxOpenid + "/";
	//无法直接绑定audio元素问题
	$scope.sce = $sce.trustAsResourceUrl;
	
	$scope.info = info;
	
	$http({
		method: "post",
		url: rootPath + "/getDriverByEventID",
		params: {
			id: info.id
		}
	}).success(function(data,status,config,headers){
		$scope.info.jsyxxs = data;
	});
	
	//日期格式化
	$scope.formatterTime = function(date){
		return new Date(date.time).format("yyyy-MM-dd hh:mm:ss");
	};
	
	//驾驶员信息索引预定
	$scope.jsyxxIndex = function(number){
		return String.fromCharCode(number+65);
	};
	
	//图片资源转换
	$scope.xxtps = !info.liveImage?[]:info.liveImage.split(",");
	$scope.imgreuploads =!info.imgreuploadIndex?[]:info.imgreuploadIndex.split(",");
	$scope.imgreuploadeds =!info.imgreuploadedIndex?[]:info.imgreuploadedIndex.split(",");
	
	//新增图片上传参数
	$scope.addImgCnt = 0;
	$scope.addImgUrl = [];
	
	$.each($scope.xxtps, function(index,item){
		var imgUrl = resoure_prev + item;
		//是否是错误图片标志
		var errPic = $.inArray(item, $scope.imgreuploads)>=0;
		if(errPic){
			//是否需要重传标志
			if($.inArray(item, $scope.imgreuploadeds)==-1){
				$scope.addImgCnt++;
			}
		}
		
		$scope.xxtps[index] = {
			uploadUrl: imgUrl, 
    		uploadSuccess: false, 
    		uploadError: 0, 
    		uploadWaiting: true, 
    		uploading: true, 
    		serverId: undefined, 
			errPic: errPic,
			newUpload: false
		};
	});
	
	$.each($scope.xxtps, function(index){
		var img = new Image();
		img.src = this.uploadUrl;
		img.onload = function(){
			$scope.$apply(function(){
				$scope.xxtps[index].uploadSuccess = true;
				$scope.xxtps[index].uploading = false;
				$scope.xxtps[index].uploadWaiting = false;
			});
		};
		img.onerror = function(){
			$scope.$apply(function(){
				$scope.xxtps[index].uploadError++;
				$scope.xxtps[index].uploading = false;
				$scope.xxtps[index].uploadWaiting = false;
			});
		};
	});

    var uploadSingleImage = function(localId, callback){
    	
    	var getXxtpIndexByLocalId = function(localId){
    		//获取总的列表
    		var xxtps = [];
    		for(var i=0; i<$scope.xxtps.length; i++){
    			xxtps.push($scope.xxtps[i].uploadUrl);
    		}
    		//获取当前上传的json
    		return $.inArray(localId, xxtps);
    	};
    	
		var index1 = getXxtpIndexByLocalId(localId);
    	if(index1 == -1) return;
    	
    	//开始上传的基本设置
		$scope.xxtps[index1].uploadWaiting = true;
		$scope.xxtps[index1].uploading = true;
		
		wx.uploadImage({
    	    localId: localId, 			// 需要上传的图片的本地ID，由chooseImage接口获得
    	    isShowProgressTips: 0, 		// 默认为1，显示进度提示
    	    success: function (res) {
    	    	var index = getXxtpIndexByLocalId(localId);
    	    	
    	    	var imgUrl2Index = index - ($scope.xxtps.length - $scope.addImgUrl.length);
        		$scope.addImgUrl[imgUrl2Index] = res.serverId;
        		
    	    	if(index>-1){
    	    		$scope.$apply(function(){
        	    		$scope.xxtps[index].uploadSuccess = true;
        	    		$scope.xxtps[index].uploadError = 0;
        	    		$scope.xxtps[index].uploadWaiting = false;
        	    		$scope.xxtps[index].uploading = false;
        	    		$scope.xxtps[index].serverId = res.serverId;
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
	
    //删除已经上传的图片
	$scope.deletePic = function($event, index){
		var rst = window.confirm("确定要删除该图片吗?");
		if(rst){
			//先删除图片数组
			var imgUrl2Index = index - ($scope.xxtps.length - $scope.addImgUrl.length);
			alert(imgUrl2Index);
			$scope.addImgUrl.splice(imgUrl2Index, 1);
			
			$scope.xxtps.splice(index, 1);
		}
		$event.stopPropagation();
	};
	
	//上传元素点击事件(如果是未加载成功图片，点击进行重新加载，如果是已加载图片，点击进行列表状态，如果是上传失败图片，点击进行重传)
	$scope.picClick = function(index){
		var xxtpJSON = $scope.xxtps[index];
		//在非编辑状态的前提下，上传失败且未还不在上传队列中的需要重新上传，
		if(!$scope.editUploder && xxtpJSON.uploadError > 0 && !xxtpJSON.uploadWaiting){
			//新上传的图片，则进行新增
			if(xxtpJSON.newUpload){
				uploadSingleImage(xxtpJSON.uploadUrl);
			}
			//老的图片，则进行图片重新加载
			else{
				var img = new Image();
				img.src = xxtpJSON.uploadUrl;
				$scope.xxtps[index].uploadWaiting = true;
				$scope.xxtps[index].uploading = true;
				img.onload = function(){
					$scope.$apply(function(){
						$scope.xxtps[index].uploadSuccess = true;
						$scope.xxtps[index].uploading = false;
						$scope.xxtps[index].uploadWaiting = false;
						$scope.xxtps[index].uploadError = 0; 
						$scope.xxtps[index].uploadUrl = xxtpJSON.uploadUrl+"?a="+Math.random();
					});
				};
				img.onerror = function(){
					$scope.$apply(function(){
						$scope.xxtps[index].uploadError++;
						$scope.xxtps[index].uploading = false;
						$scope.xxtps[index].uploadWaiting = false;
					});
				};
			}
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
		    count: $scope.addImgCnt - $scope.addImgUrl.length, 
		    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
		    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
		    success: function (res) {
		        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
		        for(var i=0; i<localIds.length; i++){
		        	$scope.$apply(function(i){
		        		return function(){
		        			$scope.addImgUrl.push(localIds[i]);
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
								        		uploading: false,
								        		serverId: undefined,
								    			errPic: false,
								    			newUpload: true
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
					        		uploading: false,
					        		serverId: undefined,
					    			errPic: false,
					    			newUpload: true
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
	
	$scope.imgClick = function(src){
		var srcArray = [];
		for(var i=0;i<$scope.xxtps.length;i++){
			srcArray.push($scope.xxtps[i].src);
		}
		wx.previewImage('imagePreview', {    
			'current': src,    
            'urls': srcArray
		});
	};
	
	//语音资源转换
	$scope.voiceUrls = !info.liveVoice?[]:info.liveVoice.split(",");
	$.each($scope.voiceUrls, function(index,item){
		var voiceUrl = resoure_prev + item;
		$scope.voiceUrls[index] = {
			voiceUrl: voiceUrl,
			playing: false,
			duration: 0,
			cache: false
		};
	});
	
	$scope.voiceClick = function(domId){
		var dom = $("#"+domId)[0];
		if(dom.paused){
			dom.play();
		}else{
			dom.pause();
		}
	};
	
	$scope.voiceStyle = function(length){
		var width = 0;
		if(length>=60){
			width = 2*10+8*5+50*0.5;
		}else if(length>=10){
			width = 2*10+8*5+(length-10)*1;
		}else if(length>=2){
			width = 2*10+(length-2)*3;
		}else if(length>0){
			width = (length-2)*5;
		}else{
			width = 10;
		}
		return {width:width+"%"};
	};
	
	$scope.loadingVoice = function(voice, domId){
		//微信内置浏览器
		$("#"+domId).unbind("canplay").bind("canplay",function(){
			var $this = $(this);
			$scope.$apply(function(){
				voice.duration = Math.ceil($this[0].duration);
				voice.cache = true;
			});
		});

		$("#"+domId).unbind("play").bind("play",function(){
			$scope.$apply(function(){
				voice.playing = true;
			});
			
			$(this).parent(".voice").siblings(".voice").children("audio").each(function(){
				this.pause();
			});
		});
		
		$("#"+domId).unbind("ended").bind("ended",function(){
			$scope.$apply(function(){
				voice.playing = false;
			});
		});
		
		$("#"+domId).unbind("pause").bind("pause",function(){
			$(this)[0].load();
			$scope.$apply(function(){
				voice.playing = false;
			});
		});
	};
	
	$scope.submit = function(){
		//未完全上传,则禁止点击
		if($scope.addImgUrl.length < $scope.addImgCnt
				|| $scope.submitting || $scope.submitted){
			return false;
		}
		
		$http({
			method: "post",
			url: rootPath + "/wx/updateKckpInfo",
			params: {
				id: info.id,
				wxIds: $scope.addImgUrl.join(",")
			}
		}).success(function(data,status,config,headers){
			$scope.submitting = false;
			if(!!data && !data.errMsg){
				$scope.submitted = true;
				alert("操作成功!");
				window.location.reload(); 
			}else{
				alert("系统异常! 错误信息:" + data.errMsg);
			}
		}).error(function(data,status,hedaers,config){
			$scope.submitting = false;
			alert("系统异常! 错误代码:"+status);
		});
	};
});

app.controller("myCtrl", function($scope, $http, $state){
	
	$scope.hidden = false;
	$scope.pages = [];
	$scope.pageNum = 1;
	$scope.noMoreData = false;
	
	/*图片加载类*/
	$scope.loadPage = function(pageIndex){
		$scope.infosLoading = true;
		$http({
			method: "post",
			url: rootPath + "/wx/getKckpPageInfo",
			params: {
				pageNum: pageIndex
			}
		}).success(function(data,status,config,headers){
			$scope.infosLoading = false;
			//有数据的时候才进行填充
			if(data.list.length>0){
				$scope.pages[data.pageNum-1] = data;
				if(data.endRow<data.total){
					$scope.pageNum++;
				}else{
					$scope.noMoreData = true;
				}
			}
		}).error(function(data,status,hedaers,config){
			$scope.infosLoading = false;
			console.log(data);
		});
	};
	//默认加载一页
	$scope.loadPage(1);
	
	$scope.formatterTime = function(date){
		return new Date(date.time).format("yyyy年MM月dd日");
	};

	$scope.formatterPosition = function(info){
		var geocoder = new qq.maps.Geocoder();
		var latLng = new qq.maps.LatLng(info.latitude, info.longitude);
		geocoder.getAddress(latLng);//对指定经纬度进行解析
		geocoder.setComplete(function(result) {
			$scope.$apply(function(){
				if(!!result.detail.address){
					var address = result.detail.addressComponents;
					info.position = address.city+address.district+address.streetNumber;
				}else{
					info.position = "经度:"+info.longitude+",纬度:"+info.latitude;
				}
				console.log(result);
			});
		});
		//若服务请求失败，则运行以下函数
		geocoder.setError(function() {
			$scope.$apply(function(){
				info.position = "经度:"+info.longitude+",纬度:"+info.latitude;
			});
		});
	};
	
	$scope.detail = function(info){
		$state.go("detail", {data:info});
	};
});


$(function(){
	
	$.getJSON(rootPath+"/wx/sign?url=" + encodeURIComponent(location.href.split('#')[0]), function (res) {
        wx.config({
            debug: false,
            appId: res.appid,
            timestamp: res.timestamp,
            nonceStr: res.nonceStr,
            signature: res.signature,
            jsApiList: [
				"chooseImage",
				"previewImage",
				"uploadImage"
            ]
        });
        
        wx.ready(function(){
        	wx.initOk = true;
        });
        wx.error(function(rst){
        	wx.initFail = true;
        	alert(JSON.stringify(rst));
        });
    });
});

//浏览器返回事件
window.addEventListener("hashchange", function(e) {
	if(location.hash.indexOf("detail")>0){
		$("div.myCtrl").css("display", "none");
		$("div.detailDiv").removeClass("hidden");
	}else{
		$("div.myCtrl").css("display", "block");
		$("div.detailDiv").addClass("hidden");
	}
}, false);

