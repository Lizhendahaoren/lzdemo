$(document).ready(function () {
	var picWidth = $('#floor-pic-img').width();
	var picHeight = $('#floor-pic-img').height();
	$('#floor-pic').width(picWidth);
	$('#floor-pic').height(picHeight);

	var Point = function(x, y) {
		this.x = x;
		this.y = y;
	}

	var points = new Array();

	var x1, y1, x2, y2;

	$("#floor-pic").mousemove(function(e) {
		x1 = e.pageX;
		y1 = e.pageY;
		x2 = e.pageX;
		y2 = e.pageY;

		if (points.length == 0) {
			if (!$('.point1').hasClass('fixed')) {
				$('.point1').show().css({
					'top' : y1 - 5,
					'left' : x1 - 5
				});
				$('.rect1').show().width(x1);
				$('.rect1').show().height(y1);
				$('.showXY1').show().css({
					'top' : y1 + 5,
					'left' : x1 + 5
				}).text('(x:' + x1 + ', y:' + y1 + ')');
				$('#x1').val(x1);
				$('#y1').val(y1);
			}
		} else if (points.length == 1) {
			if (!$('.point2').hasClass('fixed')) {
				$('.point2').show().css({
					'top' : y2 - 5,
					'left' : x2 - 5
				});
				$('.rect2').show().width(x2);
				$('.rect2').show().height(y2);
				$('.showXY2').show().css({
					'top' : y2 + 5,
					'left' : x2 + 5
				}).text('(x:' + x2 + ', y:' + y2 + ')');
				$('#x2').val(x2);
				$('#y2').val(y2);
			}
		}
	}).click(function(e) {
		x1 = e.pageX;
		y1 = e.pageY;
		x2 = e.pageX;
		y2 = e.pageY;

		if (points.length == 0) {
			$('.point1').css({
				'top' : y1 - 5,
				'left' : x1 - 5
			}).addClass('fixed');
			points.push(new Point(x1, y1));
		} else if (points.length == 1) {
			$('.point2').css({
				'top' : y2 - 5,
				'left' : x2 - 5
			}).addClass('fixed');
			points.push(new Point(x2, y2));
		}
	});

	$('#clearPoint').click(function() {
		var s=$('#imageUrl').val();
		if (points.length > 0) {
			points.splice(0);
			$('.point1, .point2').hide().css({
				'top' : 0,
				'left' : 0
			}).removeClass('fixed');
			$('.rect1, .rect2').hide().width(0).height(0);
			$('.showXY1, .showXY2').hide();
		}
		if(s=="N2"){
			$('select option:last').attr('selected','selected');
		}
	});
});

function submitpoint() {
	var topX=document.getElementById("x1").value;
	var topY=document.getElementById("y1").value;
	var bottomX=document.getElementById("x2").value;
	var bottomY=document.getElementById("y2").value;
	window.parent.document.getElementById("topX").value = topX;
	window.parent.document.getElementById("topY").value = topY;
	window.parent.document.getElementById("bottomX").value = bottomX;
	window.parent.document.getElementById("bottomY").value = bottomY;
	window.parent.document.getElementById("booth").value=document.getElementById("imageUrl").value;
	alert("提交成功");
}
function imgChange(filename){
	var img=document.getElementById("imageUrl").value;
	var imgurl="../imageUpload"+img;//服务器路径
	//var imgurl="imageUpload"+img;//本地路径
	document.getElementById("floor-pic-img").src=imgurl;
}
//自定义ajax
function getAjax(options, callback, errCallback) {
    var settings = {
        type: 'get',
        contentType: 'application/json; charset=utf-8'
    };

    if (options) {
        jQuery.extend(settings, options);
    };
    baseAjax(settings, callback, errCallback);

}
//自定义ajax
function baseAjax(settings, callback, errCallback) {
    $.ajax({
        url: settings.url,
        type: settings.type,
        dataType: "json",
        data: settings.data,
        contentType: settings.contentType,
        processData: settings.processData,
        timeout: 1000,
        cache: false,
        success: function (json) {
            if (jQuery.isFunction(callback)) {
                callback(json);
            }
        },
        error: function (jqXHR, textStatus, errorThrown) {
        	console.log(errorThrown);
            if (jQuery.isFunction(errCallback)) {
                errCallback();
            }
        }
    }); //$.ajax

}
function map_show(filename){
	var server = "r/c/find"; //查找
	//var server = "http://61.155.169.168:8088/r/c/find"; //查找
	//var cname=filename+'.coordinate';
	//var cname=filename+'.map';
	var cname=filename+'.floorplan';
	getAjax({
		url:server,
		/*data:{'cnt.name':cname,
			'cnt.filter.nin.flag':'delete',
			'cnt.filters.1.and':'cnt.filter.nin.flag'}*/
		data:{'cnt.name':cname
//			'cnt.filter.eq.order':0,
//			'cnt.filters.1.and':'cnt.filter.eq.order'
		}
	},function(data){
		$('#imageUrl').empty();
		$.each(data.data[0],function(k,v){
			$('#imageUrl').append('<option value="'+v.iconUrl+'">'+v.title+'</option>');
			//$('#imageUrl').append('<option value="'+v.mapUrl+'">'+v.title+'</option>');
			//if(k==0){$('#floor-pic-img').attr('src','../imageUpload/'+filename+'/'+v.imageUrl);}
			if(k==0){$('#floor-pic-img').attr('src','../imageUpload'+v.mapUrl);}//服务器路径
			//if(k==0){$('#floor-pic-img').attr('src','imageUpload'+v.iconUrl);}//本地路径
		});
	});
}
