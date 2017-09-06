function initFileInput(initPreview) {
	$("#uploadfile").fileinput({
        language: 'zh', //设置语言
        uploadUrl:"reportrelease/uploadFlagFile", //上传的地址
       allowedFileExtensions: ['jpg', 'jpeg', 'png'],//接收的文件后缀
       //uploadExtraData:{"id": 1, "fileName":'123.mp3'},
        uploadAsync: true, //默认异步上传
        showUpload:false, //是否显示上传按钮
        //showRemove :true, //显示移除按钮
        //showPreview :true, //是否显示预览
        showCaption:false,//是否显示标题
        browseClass:"btn btn-primary", //按钮样式    
       dropZoneEnabled: false,//是否显示拖拽区域
       //minImageWidth: 50, //图片的最小宽度
       //minImageHeight: 50,//图片的最小高度
       //maxImageWidth: 500,//图片的最大宽度
       //maxImageHeight: 500,//图片的最大高度
       autoReplace:false,
        //maxFileSize:0,//单位为kb，如果为0表示不限制文件大小
       //minFileCount: 0,
        maxFileCount:1, //表示允许同时上传的最大文件个数
       // msgFilesTooMany:5,
        enctype:'multipart/form-data',
       
       validateInitialCount:true,
        previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
       msgFilesTooMany: "选择上传的文件数量({n}) 单次只允许上传{m}张图片！",
       //initialPreviewAsData:true,
      initialPreview: initPreview,//初始化数据
      //overwriteInitial:false,
   }).on("filebatchselected", function(event, files) {
       $(this).fileinput("upload");
   }) .on("fileuploaded", function(event, data) {
       if(data.response)
       {
          // alert('处理成功');
       }
   });
}

function back(url) {
	if(confirm("是否放弃保存修改？")){
   	    location.href=url;
	}
}

//查询事件
function findallEventOne(){
	 $.ajax({
			url:"reportRecord/findallEventOne",
			type:'POST',
			dataType:'json',
			async:false, 
			success:function(data){
				if(data.code == 1){
					$("#One").empty();	
					$("#One").append("<option value=''>请选择</option>");
	            	$.each(data.object,function(i,item){
	            		$("#One").append("<option value="+item.eventone_id+">"+item.eventone_name+"</option>");
	            	});
				}
			}
	});
}

function findallEventTwo(OneId) {
	$.ajax({
		url:"reportRecord/findallEventTwo",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{OneId:OneId},
		success:function(data){
			if(data.code == 1){
				$("#Two").empty();	
				$("#Two").append("<option value=''>请选择</option>");
            	$.each(data.object,function(i,item){
            		$("#Two").append("<option value="+item.eventtwo_id+">"+item.eventtwo_name+"</option>");
            	});
			}
		}
	});
}

function findallEventThree(TwoId) {
	$.ajax({
		url:"reportRecord/findallEventThree",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{TwoId:TwoId},
		success:function(data){
			if(data.code == 1){
				$("#Three").empty();	
				$("#Three").append("<option value=''>请选择</option>");
            	$.each(data.object,function(i,item){
            		$("#Three").append("<option value="+item.eventthree_id+">"+item.eventthree_name+"</option>");
            	});
			}
		}
	});
}

function  findEventThreeById(ThreeId) {
	$.ajax({
		url:"reportRecord/findEventThreeById",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{ThreeId:ThreeId},
		success:function(data){
			if(data.code == 1){
				if (data.object.reportDepartment_main != null && data.object.reportDepartment_main !=undefined && typeof(data.object.reportDepartment_main)!="undefined") {
					$("#d_main").val(data.object.reportDepartment_main.departmentType);
				}
				if (data.object.reportDepartment_synergy != null && data.object.reportDepartment_synergy !=undefined && typeof(data.object.reportDepartment_synergy)!="undefined") {
					$("#d_synergy").val(data.object.reportDepartment_synergy.departmentType);
				}
				
			}
		}
	});
}

//查询部件
function findallParttOne(){
	 $.ajax({
			url:"reportRecord/findallParttOne",
			type:'POST',
			dataType:'json',
			async:false, 
			success:function(data){
				if(data.code == 1){
					$("#One").empty();	
					$("#One").append("<option value=''>请选择</option>");
	            	$.each(data.object,function(i,item){
	            		$("#One").append("<option value="+item.pone_id+">"+item.pone_name+"</option>");
	            	});
				}
			}
	});
}

function findallParttTwo(OneId) {
	$.ajax({
		url:"reportRecord/findallParttTwo",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{OneId:OneId},
		success:function(data){
			if(data.code == 1){
				$("#Two").empty();	
				$("#Two").append("<option value=''>请选择</option>");
            	$.each(data.object,function(i,item){
            		$("#Two").append("<option value="+item.ptwo_id+">"+item.ptwo_name+"</option>");
            	});
			}
		}
	});
}

function findallParttThree(TwoId) {
	$.ajax({
		url:"reportRecord/findallParttThree",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{TwoId:TwoId},
		success:function(data){
			if(data.code == 1){
				$("#Three").empty();	
				$("#Three").append("<option value=''>请选择</option>");
            	$.each(data.object,function(i,item){
            		$("#Three").append("<option value="+item.pth_id+">"+item.pth_name+"</option>");
            	});
			}
		}
	});
}

function  findParttThreeById(ThreeId) {
	$.ajax({
		url:"reportRecord/findParttThreeById",
		type:'POST',
		dataType:'json',
		async:false, 
		data:{ThreeId:ThreeId},
		success:function(data){
			if(data.code == 1){
				var red_main=data.object.red_main;
				if (red_main != null && red_main !=undefined && typeof(red_main)!="undefined") {
					$("#d_main").val(data.object.red_main.departmentType);
				}
				var red_synergy=data.object.red_synergy;
				if (red_synergy != null && red_synergy !=undefined && typeof(red_synergy)!="undefined") {
					$("#d_synergy").val(data.object.red_synergy.departmentType);
				}
				
			}
		}
	});
}

