/**
 * AJAX导航菜单插件
 */
(function($) {
	$.fn.extend({
		//左侧导航栏
		leftNavMenu: function(options) {
			//默认值
			var defaults = {
				title: null,
				single: false
			};
			//参数注入
			var opts = $.extend(defaults, options);
			
			//当前打开菜单
			var $open = null;
			
			//当前dom域
			var $this = $(this);
			
			$this.find(".nav-item1").click(function() {
				var icon = $(this).find(".nav-bar");
				if(icon.hasClass("glyphicon-chevron-left")) {
					//是否只能打开一个导航
					if(opts.single) {
						if($open) {
						    $open.next().slideUp();
							$open.find(".nav-bar").removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-left");
						}
						$open = $(this);
					}
					
					$(this).next().slideDown();
					icon.removeClass("glyphicon-chevron-left").addClass("glyphicon-chevron-down");
				}else {
					$(this).next().slideUp();
					icon.removeClass("glyphicon-chevron-down").addClass("glyphicon-chevron-left");
				}
			});
			
			var clickIfm = function(e) {
				/*************当重新进入这个页面后，清除掉之前session中的值 start*****************/
				sessionStorage.clear();
				/*************当重新进入这个页面后，清除掉之前session中的值 end*****************/
				$("#ti_main_frame").css("height", $(window).height() - 63).attr("src", $(this).attr("href"));
				closePanel();
				e.preventDefault();
			}
			
			$this.find(".nav-line").first().find("ul").show();
			
			$this.find("a[href]").click(clickIfm);
		}
	});
})(jQuery);

/**
 * 弹出div平板 
 * @param {Object} options
 */
function showPanel(options) {
	//默认值
	var defaults = {
		url: null,
		type: "get",
		data: null
	};
	//参数注入
	var opts = $.extend(defaults, options);
	
	var f_width = $("#ti_main_frame").width();
	var f_height = $("#ti_main_frame").height();
	
	$("#ti_panel_frame").attr("src", opts.url).css({
		width: f_width+"px",
		height: (f_height-36)+"px"
	});
	
	var panel = $("#ti_panel").css({
		width: f_width+"px",
		height: f_height+"px"
	}).show();
}
function closePanel() {
	$("#ti_panel").hide();
}

//页面按钮事件
$(document).ready(function() {
	$(".ti-pro-btn").click(function() {
		parent.showPanel({url: $(this).attr("url")});
	});
});