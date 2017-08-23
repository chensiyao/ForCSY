// Download by http://keleyi.com
// 由 柯乐义 改进改插件，使插件适用于新版的jquery（比如1.10.1） 版本

// Visit http://keleyi.com/a/bjac/no0m3cb1.htm for more information
//
// Usage:
//     jAlert( message, [title, callback] )
//     jConfirm( message, [title, callback] )
//     jPrompt( message, [value, title, callback] )
// 
// History:
//
//     1.00 - Released (29 December 2008)
// 2013-7-8
(function($) {

$.alerts = {

// These properties can be read/written by accessing $.alerts.propertyName from your scripts at any time

verticalOffset: -75, // vertical offset of the dialog from center screen, in pixels
horizontalOffset: 0, // horizontal offset of the dialog from center screen, in pixels/
repositionOnResize: true, // re-centers the dialog on window resize
overlayOpacity: .6, // transparency level of overlay
overlayColor: '#FFF', // base color of overlay
draggable: true, // make the dialogs draggable (requires UI Draggables plugin)
okButton: '&nbsp;确&nbsp;定&nbsp;', // text for the OK button
cancelButton: '&nbsp;取&nbsp;消&nbsp;', // text for the Cancel button
dialogClass: null, // if specified, this class will be applied to all dialogs

// Public methods

alert: function(message, title, callback) {
			if (title == null)
				title = '提示信息';
$.alerts._show(title, message, null, 'alert', function(result) {
if( callback ) callback(result);
});
},

confirm: function(message, title, callback) {
if( title == null ) title = 'Confirm';
$.alerts._show(title, message, null, 'confirm', function(result) {
if( callback ) callback(result);
});
},

prompt: function(message, value, title, callback) {
if( title == null ) title = 'Prompt';
$.alerts._show(title, message, value, 'prompt', function(result) {
if( callback ) callback(result);
});
},

// Private methods

_show: function(title, msg, value, type, callback) {

$.alerts._hide();
$.alerts._overlay('show');

$("BODY").append(
'<div id="popup_container">' +
'<div id="popup_title" style=""></div>' +
'<div id="popup_content">' +
'<div id="popup_message"></div>' +
'</div><iframe id="iframe1" src="about:blank" frameBorder="0" marginHeight="0" marginWidth="0"  style="position:absolute; visibility:inherit; top:0px;left:0px;width:100%; height:100%;overflow-x:hidden;overflow-y:hidden;z-index:-1; filter:alpha(opacity=0);"></iframe>' +
'</div>');

if( $.alerts.dialogClass ) $("#popup_container").addClass($.alerts.dialogClass);

//IE6 Fixvar 
pos = ('undefined' == typeof (document.body.style.maxHeight)) ? 'absolute' : 'fixed';

$("#popup_container").css({
position: pos,
zIndex: 99999,
padding: 0,
margin: 0
});

$("#popup_title").text(title);
$("#popup_content").addClass(type);
$("#popup_message").text(msg);
$("#popup_message").html( $("#popup_message").text().replace(/\n/g, '<br />') );

$("#popup_container").css({
minWidth: $("#popup_container").outerWidth(),
maxWidth: $("#popup_container").outerWidth()
});

$.alerts._reposition();
$.alerts._maintainPosition(true);

switch( type ) {
case 'alert':
$("#popup_message").after('<div id="popup_panel"><span id="popup_ok" class="znjt-btn-small" >'+$.alerts.okButton+'</span></div>');
$("#popup_ok").click( function() {
$.alerts._hide();
callback(true);
});
$("#popup_ok").focus().keypress( function(e) {
if( e.keyCode == 13 || e.keyCode == 27 ) $("#popup_ok").trigger('click');
});
break;
case 'confirm':
	$("#popup_title").css({
		'background-color':'#FF5454'
	});
$("#popup_message").after('<div id="popup_panel"><span id="popup_ok" class="znjt-btn-small" >'+$.alerts.okButton+'</span>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="popup_cancel" class="znjt-btn-small" >'+$.alerts.cancelButton+'</span> </div>');
$("#popup_ok").click( function() {
$.alerts._hide();
if( callback ) callback(true);
});
$("#popup_cancel").click( function() {
$.alerts._hide();
if( callback ) callback(false);
});
$("#popup_ok").focus();
$("#popup_ok, #popup_cancel").keypress( function(e) {
if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
});
break;
case 'prompt':
$("#popup_message").append('<br /><input type="text" size="30" id="popup_prompt" />').after('<div id="popup_panel"><span id="popup_ok" class="znjt-btn-small" >'+$.alerts.okButton+'</span> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<span id="popup_cancel" class="znjt-btn-small" >'+$.alerts.cancelButton+'</span></div>');
$("#popup_prompt").width( $("#popup_message").width() );
$("#popup_ok").click( function() {
var val = $("#popup_prompt").val();
$.alerts._hide();
if( callback ) callback( val );
});
$("#popup_cancel").click( function() {
$.alerts._hide();
//if( callback ) callback( null );
});
$("#popup_prompt, #popup_ok, #popup_cancel").keypress( function(e) {
if( e.keyCode == 13 ) $("#popup_ok").trigger('click');
if( e.keyCode == 27 ) $("#popup_cancel").trigger('click');
});
if( value ) $("#popup_prompt").val(value);
$("#popup_prompt").focus().select();
break;
}

// Make draggable
if( $.alerts.draggable ) {
try {
$("#popup_container").draggable({ handle: $("#popup_title") });
$("#popup_title").css({ cursor: 'move' });
} catch(e) { /* requires jQuery UI draggables */ }
}
},

_hide: function() {
$("#popup_container").remove();
$.alerts._overlay('hide');
$.alerts._maintainPosition(false);
},

_overlay: function(status) {
switch( status ) {
case 'show':
$.alerts._overlay('hide');
$("BODY").append('<div id="popup_overlay"></div>');
$("#popup_overlay").css({
position: 'absolute',
zIndex: 99998,
top: '0px',
left: '0px',
width: '100%',
height: $(document).height(),
background: $.alerts.overlayColor,
opacity: $.alerts.overlayOpacity
});
break;
case 'hide':
$("#popup_overlay").remove();
break;
}
},

_reposition: function() {
var top = (($(window).height() / 2) - ($("#popup_container").outerHeight() / 2)) + $.alerts.verticalOffset;
var left = (($(window).width() / 2) - ($("#popup_container").outerWidth() / 2)) + $.alerts.horizontalOffset;
if( top < 0 ) top = 0;
if( left < 0 ) left = 0;

// IE6 fix
if ('undefined' == typeof (document.body.style.maxHeight)) top = top + $(window).scrollTop();

$("#popup_container").css({
top: top + 'px',
left: left + 'px'
});
$("#popup_overlay").height( $(document).height() );
},

_maintainPosition: function(status) {
if( $.alerts.repositionOnResize ) {
switch(status) {
case true:
$(window).bind('resize', function() {
$.alerts._reposition();
});
break;
case false:
$(window).unbind('resize');
break;
}
}
}

}

// Shortuct functions
jAlert = function(message, title, callback) {
$.alerts.alert(message, title, callback);
}

jConfirm = function(message, title, callback) {
		$.alerts.confirm(message, title, callback);
};

jPrompt = function(message, value, title, callback) {
$.alerts.prompt(message, value, title, callback);
};

})(jQuery);