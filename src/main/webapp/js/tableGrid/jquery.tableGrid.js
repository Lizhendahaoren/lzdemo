/**
 * @author Lex chen
 * @see 为表格添加高亮显示,分页器，单列排序，依赖bootstrap css 3.0及以上；添加全选事件
 * version 1.0  2014-07-25
 * @param factory
 */
(function (factory) {
	if (typeof define === 'function' && define.amd) {
		// AMD
		define(['jquery'], factory);
	} else if (typeof exports === 'object') {
		// CommonJS
		factory(require('jquery'));
	} else {
		// Browser globals
		factory(jQuery);
	}
}(function ($) {

	var firstFlag=0;			//标识，为0表示第一页 
	$.fn.tableGrid=function(options){
		var defaults={
				checkAllId:"_selectAll",		//全选复选框的ID属性
				singleCheckboxClass:"ckSelect",//单条记录的复选框样式名
				sortColumns:false,			//false表示不使用排序，如果传递的是json的话，就表示排序
				selectRowClass:"success",	//选中后的样式
				pageAjax:function(){},		//查询方法，需要调用的地方进行查询
				paging:false				//false表示不需要分页控件，如果需要分页控件，则传入分页控件的容器的ID，如层的ID
		};
		
		//第一次加载时执行
		if(firstFlag==0){
			options.pageAjax();
			firstFlag==1;
		}
		var options=$.extend(defaults,options);
		this.each(function(){
			var thisTable=$(this);				//当前的table容器
			//高亮显示选中行事件，并将选中tbody的行
			/*$(thisTable).children("tbody").on('click','tr',function(){
				//这个方法中的$(this)是指的选中行<tr>
				var classFlag=$(this).hasClass(options.selectRowClass);
				//单选框的样式要有为ckSelect的class
				var checkbox= $(this).find("."+options.singleCheckboxClass);
				if(classFlag){
					$(this).removeClass(options.selectRowClass);
				}else{
					$(this).addClass(options.selectRowClass);
				}
				if(checkbox && checkbox.length>0){
					$(checkbox).prop({checked:!classFlag});
				}else{
					console.log("不包含class='"+singleCheckboxClass+"'的checkbox");
					return;
				} 
			});*/
			
			//点击全选复选框事件
			$(thisTable).children("thead").on('change','#'+options.checkAllId,function(){
				var check=$(this).is(':checked');
				//所有的单选按钮
				var checkboxAll=$(thisTable).children("tbody").find("."+options.singleCheckboxClass);
				if(check==true){
					$(thisTable).children("tbody").find("tr").addClass(options.selectRowClass);
					if(checkboxAll.length>0){
						for(var i=0;i<checkboxAll.length;i++){
							$(checkboxAll[i]).prop({checked:true});
						}
					}
                }else{
                	$(thisTable).children("tbody").find("tr").removeClass(options.selectRowClass);
                	if(checkboxAll.length>0){
						for(var i=0;i<checkboxAll.length;i++){
							$(checkboxAll[i]).prop({checked:false});
						}
					}
                }
			});
			
			//初始化排序按钮
			if(options.sortColumns){
				var imgAsc="<image class='sorting_asc' src='js/table/images/sort_asc.png' align='right' style='cursor: pointer;' >";
				var imgDisabled="<image class='sorting_both' src='js/table/images/sort_both.png' align='right' style='cursor: pointer;' >";
				var thArray =$(thisTable).children("thead").find("th");
				var sortInput="<input type='hidden' id='_sort' />";
				var sortScInput="<input type='hidden' id='_ascOrdesc' />";
				$(thisTable).append(sortInput).append(sortScInput);			//添加排序相关字段
				var ascFlag=0;
				for(var i=0;i<options.sortColumns.length;i++){
					var oc = options.sortColumns[i];
					if(oc==null) continue;
					if(!oc.sortable) continue;
					if(ascFlag==0){						
						$(thArray[i]).append(imgAsc);
						var id =$(thArray[i]).attr("id");
						$("#_sort").val(id);
						$("#_ascOrdesc").val("asc");
						ascFlag=1;
					}else{
						$(thArray[i]).append(imgDisabled);
					}
				}
				
				//点击asc图片的处理事件
				$(thisTable).on('click','.sorting_asc',function(){
					//将图片换成imgDesc
					$(this).attr("src","js/table/images/sort_desc.png");
					$(this).attr("class","sorting_desc");
					var id =$(this).parent().attr("id");
					$("#_sort").val(id);
					$("#_ascOrdesc").val("desc");
					options.pageAjax();
				});
				//点击desc图片的处理事件
				$(thisTable).on('click','.sorting_desc',function(){
					$(this).attr("src","js/table/images/sort_asc.png");
					$(this).attr("class","sorting_asc");
					var id =$(this).parent().attr("id");
					$("#_sort").val(id);
					$("#_ascOrdesc").val("asc");
					options.pageAjax();
				});
				//点击both图片的处理事件
				$(thisTable).on('click','.sorting_both',function(){
					var parentThead=$(this).parent().parent();
					var imgs= parentThead.find("[class^=sorting_]");
					for(var j=0;j<imgs.length;j++){
						$(imgs[j]).attr("src","js/table/images/sort_both.png");
						$(imgs[j]).attr("class","sorting_both");
					}
					$(this).attr("src","js/table/images/sort_asc.png");
					$(this).attr("class","sorting_asc");
					var id =$(this).parent().attr("id");
					$("#_sort").val(id);
					$("#_ascOrdesc").val("asc");
					options.pageAjax();
				});
				
			}
			
			//分页功能
			if(options.paging){
				var thisPage=$("#"+options.paging);				//显示分页器的容器
				// 点击页码事件
				$(thisPage).on('click','.paginate_button',function(){
					var activeFlag=$(this).hasClass("active");
					var disableFlag=$(this).hasClass("disabled");
					var _checkAllLen=$("#"+options.checkAllId).length;
					if(!activeFlag && !disableFlag){
						var nextPage=$(this).attr("thispage");
						$("#_click_page").val(nextPage);
						var selectPageSize=$("#selectPageSize").val();
						var model = $("#currentModel").val();		//当前模块,重设当前model的页大小，下一页
						sessionStorage.setItem(model+".nextPage",nextPage);
						sessionStorage.setItem(model+".pageSize",selectPageSize);
						
						options.pageAjax();
						
						//将全选框的复选框设置为未选择
						if(_checkAllLen>0){
							$("#"+options.checkAllId).prop({checked:false});
						}
					}
				});
				// 更改每页显示数量事件
				$(thisPage).on('change','#selectPageSize',function(){
					var totalElements = $("#_page_totalElements").val();	//数据总数
					var selectPageSize=$("#selectPageSize").val();			//当前页大小
					var nextPage=$("#_click_page").val();					//当前页
					if(nextPage!=0){						
						if(totalElements<(selectPageSize*nextPage)){
							alert("你选择的页大小和页码的数据超出范围！");
							$("#selectPageSize").val($("#_page_size").val());
							return;
						}
					}
					
//					var model = $("#currentModel").val();		//当前模块,重设当前model的页大小，下一页
//					sessionStorage.setItem(model+".nextPage",nextPage);
//					sessionStorage.setItem(model+".pageSize",selectPageSize);
					
					
					options.pageAjax();
					var _checkAllLen=$("#"+options.checkAllId).length;
					//将全选框的复选框设置为未选择
					if(_checkAllLen>0){
						$("#"+options.checkAllId).prop({checked:false});
					}
				});
			}
		});
	};

}));