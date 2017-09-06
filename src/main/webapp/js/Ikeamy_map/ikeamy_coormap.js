
	window.onload = function() {
		// 图片地址 后面加时间戳是为了避免缓存
		var img_url = $("#floor-pic-img").attr("src");
		 
		// 创建对象
		var img = new Image();
		 
		// 改变图片的src
		img.src = img_url;
		var picWidth = 0;
		var picHeight = 0;
		// 加载完成执行
		img.onload = function(){
		    // 打印
		  //  alert('width:'+img.width+',height:'+img.height);
			 $('#floor-pic').width(img.width);
			 $('#floor-pic').height(img.height);
			 picWidth=img.width;
			 picHeight=img.height;
		};
	
		//$('#floor-pic').width(picWidth);
		//$('#floor-pic').height(picHeight);

		var Point = function(x, y) {
			this.x = x;
			this.y = y;
		}

		var points = new Array();

		var x1, y1, x2, y2, x3, y3, x4, y4;

		$("#floor-pic").mousemove(function(e) {
			var position = $('#floor-pic').position();
			if(parseInt(e.pageX-position.left)<0||parseInt(e.pageY-position.top)<0)
			{
				return false;
			}
			
			x1 =parseInt(e.pageX-position.left);
			y1 = parseInt(e.pageY-position.top);
			x2 =parseInt(e.pageX-position.left);
			y2 =parseInt(e.pageY-position.top);
			x3 = parseInt(e.pageX-position.left);
			y3 =parseInt(e.pageY-position.top);
			x4 =parseInt(e.pageX-position.left);
			y4 =parseInt(e.pageY-position.top);

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
			} else if (points.length == 2) {
				if (!$('.point3').hasClass('fixed')) {
					$('.point3').show().css({
						'top' : y3 - 5,
						'left' : x3 - 5
					});
					$('.rect3').show().width(x3);
					$('.rect3').show().height(y3);
					$('.showXY3').show().css({
						'top' : y3 + 5,
						'left' : x3 + 5
					}).text('(x:' + x3 + ', y:' + y3 + ')');
					$('#x3').val(x3);
					$('#y3').val(y3);
				}
			}else if (points.length == 3) {
				if (!$('.point4').hasClass('fixed')) {
					$('.point4').show().css({
						'top' : y4 - 5,
						'left' : x4 - 5
					});
					$('.rect4').show().width(x4);
					$('.rect4').show().height(y4);
					$('.showXY4').show().css({
						'top' : y4 + 5,
						'left' : x4 + 5
					}).text('(x:' + x4 + ', y:' + y4 + ')');
					$('#x4').val(x4);
					$('#y4').val(y4);
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
			} else if (points.length == 2) {
				$('.point3').css({
					'top' : y3 - 5,
					'left' : x3 - 5
				}).addClass('fixed');
				points.push(new Point(x3, y3));
			} else if (points.length == 3) {
				$('.point4').css({
					'top' : y4 - 5,
					'left' : x4 - 5
				}).addClass('fixed');
				points.push(new Point(x4, y4));
			}
		});

		$('#clearPoint').click(function() {
			var s=$('#imageUrl').val();
			if (points.length > 0) {
				points.splice(0);
				$('.point1, .point2, .point3, .point4').hide().css({
					'top' : 0,
					'left' : 0
				}).removeClass('fixed');
				$('.rect1, .rect2, .rect3, .rect4').hide().width(0).height(0);
				$('.showXY1, .showXY2, .showXY3, .showXY4').hide();
			}
			if(s=="N2"){
				$('select option:last').attr('selected','selected');
			}
		});
	}
 