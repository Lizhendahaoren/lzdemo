/**
 * @author Lex chen
 * @see 为表格添加高亮显示，依赖bootstrap css 3.0及以上；添加全选事件
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

	$.fn.tableUI=function(options){
		var defaults={
				checkAllId:"_selectAll",		//全选复选框的ID属性
				singleCheckboxClass:"ckSelect",//单条记录的复选框样式名
				sortColumns:false,			//false表示不使用排序，如果传递的是json的话，就表示排序
				selectRowClass:"success"	//选中后的样式
		};
		
		var options=$.extend(defaults,options);
		this.each(function(){
			var thisTable=$(this);
			//高亮显示选中行事件，并将选中tbody的行
			$(thisTable).children("tbody").on('click','tr',function(){
				//这个方法中的$(this)是指的选中行<tr>
				var classFlag=$(this).hasClass(options.selectRowClass);
				//单选框的样式要有为ckSelect的class
				var checkbox= $(this).find("."+options.singleCheckboxClass);
				if(classFlag){
					$(this).removeClass(options.selectRowClass);
				}else{
					$(this).addClass(options.selectRowClass);
				}
				if(checkbox.length>0){
					$(checkbox).prop({checked:!classFlag});
				}else{
					console.log("不包含class='"+singleCheckboxClass+"'的checkbox");
				} 
			});
			
			//点击全选复选框事件
			$(thisTable).children("thead").on('change','#'+_selectAll,function(){
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
//				var imgDesc="<image class='sorting_desc' src='js/table/images/sort_desc.png' align='right' style='cursor: pointer;' >";
				var thArray =$(thisTable).children("thead").find("th");
				var ascFlag=0;
				for(var i=0;i<options.sortColumns.length;i++){
					var oc = options.sortColumns[i];
					if(oc==null) continue;
					if(!oc.sortable) continue;
					if(ascFlag==0){						
						$(thArray[i]).append(imgAsc);
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
				});
				//点击desc图片的处理事件
				$(thisTable).on('click','.sorting_desc',function(){
					alert(2);
					$(this).attr("src","js/table/images/sort_asc.png");
					$(this).attr("class","sorting_asc");
				});
				//点击both图片的处理事件
				$(thisTable).on('click','.sorting_both',function(){
					alert(3);
					var parentThead=$(this).parent().parent();
					var imgs= parentThead.find("[class^=sorting_]");
					for(var j=0;j<imgs.length;j++){
						$(imgs[j]).attr("src","js/table/images/sort_both.png");
						$(imgs[j]).attr("class","sorting_both");
					}
					$(this).attr("src","js/table/images/sort_asc.png");
					$(this).attr("class","sorting_asc");
				});
				
			}
			
		});
	};

}));