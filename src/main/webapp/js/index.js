$(function() {

		});
function show() {
	var str = ["衬衫", "羊毛衫", "雪纺衫", "裤子", "高跟鞋", "袜子"];
	var value = [5, 20, 36, 10, 110, 20];
	showEchart(str, value);
}

function showEchart(stringData, valueData) {
	// 基于准备好的dom，初始化echarts实例
	var myChart = echarts.init(document.getElementById('ech'));
	// 指定图表的配置项和数据
	var option = {
		title : {
			text : 'ECharts 入门示例'
		},
		tooltip : {},
		legend : {
			data : ['销量']
		},
		xAxis : {
			data : stringData
		},
		yAxis : {},
		series : [{
					name : '销量',
					type : 'bar',
					data : valueData
				}]
	};

	// 使用刚指定的配置项和数据显示图表。
	myChart.setOption(option);
}