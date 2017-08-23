(function() {
  angular
    .module('validation.rule', ['validation'])
    .config(['$validationProvider', function($validationProvider) {
      var expression = {
        required: function(value) {
          return !!value;
        },
        phone: /^1(3|4|5|7|8)[0-9]\d{8}$/,
        hphm: /^[\u4e00-\u9fa5]{1}[A-Z_a-z]{1}[A-Z_a-z_0-9]{5,6}$/,
        url: /((([A-Za-z]{3,9}:(?:\/\/)?)(?:[-;:&=\+\$,\w]+@)?[A-Za-z0-9.-]+|(?:www.|[-;:&=\+\$,\w]+@)[A-Za-z0-9.-]+)((?:\/[\+~%\/.\w-_]*)?\??(?:[-\+=&;%@.\w_]*)#?(?:[\w]*))?)/,
        email: /^([\w-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([\w-]+\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\]?)$/,
        number: /^\d+$/,
        minlength: function(value, scope, element, attrs, param) {
          return value && value.length >= param;
        },
        maxlength: function(value, scope, element, attrs, param) {
          return !value || value.length <= param;
        },
        rangerLength: function(value, scope, element, attrs, param) {
          if(!!value){
            var array = eval(param.replace(/-/g,','));
            if(array instanceof Array){
            	if(value.length >= array[0] && value.length <= array[1]){
            		return true;
            	}
            }
            return false;
          }else{
            return false;
          }
        }, 
        min: function(value, scope, element, attrs, param){
          return parseInt(value) >= parseInt(param);
        },
        max: function(value, scope, element, attrs, param){
          return parseInt(value) <= parseInt(param);
        },
        ranger: function(value, scope, element, attrs, param) {
            if(!!value){
              var array = eval(param.replace(/-/g,','));
              if(array instanceof Array){
              	if(value >= parseInt(array[0]) && value <= parseInt(array[1])){
              		return true;
              	}
              }
              return false;
            }else{
              return false;
            }
          },
         IdCard: /^(^[1-9]\d{7}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])\d{3}$)|(^[1-9]\d{5}[1-9]\d{3}((0\d)|(1[0-2]))(([0|1|2]\d)|3[0-1])((\d{4})|\d{3}[Xx])$)$/
      };

      var defaultMsg = {
        required: {
          error: '该字段不可为空！',
          success: 'It\'s Required'
        },
        phone: {
          error: '手机号码格式不正确！',
          success: 'It\'s phone'
        },
        hphm: {
          error: '数据格式不正确！',
          success: 'It\'s hphm'
        },
        url: {
          error: 'URL格式不正确！',
          success: 'It\'s Url'
        },
        email: {
          error: 'EMAIL格式不正确！',
          success: 'It\'s Email'
        },
        number: {
          error: '数字格式不正确！',
          success: 'It\'s Number'
        },
        minlength: {
          error: '字符至少{0}位！',
          success: 'Long enough!'
        },
        maxlength: {
          error: '字符至多{0}位！',
          success: 'Short enough!'
        },
        rangerLength: {
          error: '字符有效区间介于{0}和{1}位！',
          success: 'RangerLength enough!'
        },
        min: {
          error: '数值不能小于最小值{0}！',
          success: 'MAX enough!'
        },
        max: {
          error: '数值不能大于最大值{0}！',
          success: 'MIN enough!'
		},
		ranger: {
	      error: '数值有效区间介于{0}和{1}之间！',
	      success: 'Ranger enough!'
		},
		IdCard: {
		  error: '身份证号无效！',
		  success: 'It\'s IdCard!'
		}
      };
      $validationProvider.setExpression(expression).setDefaultMsg(defaultMsg);
    }]);
}).call(this);
