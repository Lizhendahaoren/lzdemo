//获取项目根路径
function getRootPath(){ 
     var pathName = window.location.pathname.substring(1); 
     var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
     return window.location.protocol + '//' + window.location.host + '/'+ webName + '/'; 
}
//获取上传根路径
function getFileRootPath(){ 
	var pathName = window.location.pathname.substring(1); 
	var webName = pathName == '' ? '' : pathName.substring(0, pathName.indexOf('/')); 
	return window.location.protocol + '//' + window.location.host + '/'; 
}
var fileRoot = getFileRootPath();

var root=getRootPath();		// 全局根路径

// 获取浏览器参数
function getUrlParam(name){
	var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
	var r = window.location.search.substr(1).match(reg);  // 匹配目标参数
	if (r!=null) return unescape(r[2]); return null; // 返回参数值
}
//去掉字符串两边的空格并去掉双引号，如:"    dd" aa  ",格式化后"dd aa";
function trimAndDelQuotation(str){
	if(str==""){
		return str;
	}
	var _temp=str.replace(/\"*/g,"");
	_temp = $.trim(_temp);
	return _temp;
}
$.views.converters("getSubStr", function(str, len) {
	if(str==undefined || str==null){
		return "";
	}
	if(str.length>len){
		 return str.substr(0,len)+"...";
	}
	return str;
});

$.views.converters("pageSizeSelected",function(first,last){
	if(first==null) return "";
	return first==last? "selected=selected":"";
});
//以指定字符串结尾
String.prototype.endWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length)
     return false;
  if(this.substring(this.length-s.length)==s)
     return true;
  else
     return false;
  return true;
 };
 //以指定字符串打头
String.prototype.startWith=function(s){
  if(s==null||s==""||this.length==0||s.length>this.length)
   return false;
  if(this.substr(0,s.length)==s)
     return true;
  else
     return false;
  return true;
 };
 
 //判断当前登录用户的权限
function isRole() {
	$.ajax({
		url: 'xaCmsRole/isRole',
		type: 'post',
		dataType: 'json',
		success: function(data){
			if(data.code==0){//无权限操作（设置为隐藏）
				 $("#wxsb").hide();
				
			}
		}
    });
}
//获得当前登录用户角色（1，维护人员   2.一级管理员   5.二级管理员   6.三级管理员）
function isRoleNum() {
	var roleNum = "0";
	$.ajax({
		url: 'xaCmsRole/isRole',
		type: 'post',
		async:false,
		dataType: 'json',
		success: function(data){
			if(data.object != null && data.object != "" && data.object != undefined){
				roleNum = data.object;
			}
		}
	});
	
	return roleNum;
}
/**根据用户角色获取他的权限id*/
function findRoleByUser(userId) {
	var role="";
	$.ajax({
		url:root+"xaCmsRole/findRoleByUser",
		type:'POST',
		data:{
			userId:userId
		},
		async: false,
		dataType:'json',
		success:function(data){
			role = data.object;
		}
    });
	return role;
}

function findThisUser(){
	var uid ="";
	$.ajax({
		url:root+"xaCmsUser/findThisUser",
		type:'POST',
		async: false,
		dataType:'json',
		success:function(data){
			uid = data.object;
		}
    });
	return uid;
}
