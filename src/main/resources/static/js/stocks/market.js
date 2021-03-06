$(function(){
	var dom = document.getElementById("echarts-day");
	var myChart = echarts.init(dom);
	var upColor = '#FFFFFF';
	var upBorderColor = '#FF0000';
	var downColor = '#00CC00';
	var downBorderColor = '#00CC00';
	var buid = null;
	
	function splitData(rawData) {
	    var categoryData = [];
	    var values = [];
	    var volumes = [];
	    for (var i=0; i<rawData.length;i++) {
	        categoryData.push(rawData[i].splice(0, 1)[0]);
	        volumes.push([i, parseFloat(rawData[i].splice(4, 1)[0]), parseFloat(rawData[i][0]) > parseFloat(rawData[i][1]) ? 1 : -1]);
	        values.push(rawData[i]);
	    }
	    return {
	        categoryData: categoryData,
	        values: values,
	        volumes: volumes
	    };
	}
	function calculateMA(dayCount,data) {
	    var result = [];
	    for (var i = 0, len = data.values.length; i < len; i++) {
	        if (i < dayCount) {
	            result.push('-');
	            continue;
	        }
	        var sum = 0;
	        for (var j = 0; j < dayCount; j++) {
	            sum += parseFloat(data.values[i - j][1]);
	        }
	        result.push((sum / dayCount).toFixed(2));
	    }
	    return result;
	}
	function initData(buid){
		$.ajax({
			url:'day/getByBuid/'+buid,
			async:false,
			success:function(data){
				if(data){
					getData(buid);
				}
			}
		});
	}
	function getData(buid){
		$.ajax({
			url:'../data/'+buid+'.json',
			async:false,
			error: function (jqXHR, textStatus, errorThrown) {
	            initData(buid);
	        },
			success:function(data){
				console.log(data)
				data0 = splitData(data)
				console.log(data0)
			    myChart.setOption(option = {
					    title: {
					        //text: '600588 用友软件',
							top:'1%',
							left: '2.5%',
							textStyle:{
								fontFamily:'monospace',
					    		fontSize:13
					    	}
					},
					animation:false,
					backgroundColor: '#fff',
					legend: {
							textStyle:{
								fontSize:10
							},
					    	top: '0%',
					    	left: '20%',
							data: ['日K','MA5','MA10','MA20','MA30', 'MA60', 'MA120', 'MA250'],
							selected: {
							    'MA5': false,
								'MA10': false,
								'MA20': false,
								'MA30': false,
								'MA60': true, 
								'MA120': true,
								'MA250': true
							},
					 selectedMode:'multiple'
					 },
					 tooltip: {
					     	trigger: 'item',
					     	axisPointer: {
						   		 			type: 'cross',
						 				},
						 	backgroundColor: 'rgba(245, 245, 245, 0.8)',
							borderWidth: 1,
							borderColor: '#ccc',
							padding: 10,
							textStyle: {
						    	color: '#000'
						    },
					 },
					 visualMap: {
					    		show: false,
					    		seriesIndex: 8,
					    		dimension: 2,
					    		pieces: [{
					       		 			value: 1,
					        				color: downColor
					    				 }, {
									        value: -1,
									        color: 'red'
									    }]
					 },
					 grid: [
					    	{
					    		top: '7%',
								left: '3%',
								right: '4%',
								height: '65%'
							},
							{
							    left: '3%',
								right: '4%',
								top: '70%',
								height: '25%'
							},
					],
					xAxis: [
					    {
					        type: 'category',
							data: data0.categoryData,
							scale: true,
							boundaryGap : false,
							axisLine: {onZero: false},
							splitLine: {show: false},
							splitNumber: 20,
							min: 'dataMin',
							max: 'dataMax',
							axisPointer: {
							        z: 100
							}
					},
					{
					    type: 'category',
						gridIndex: 1,
						data: data0.categoryData,
						scale: true,
						boundaryGap : false,
						axisLine: {onZero: false},
						axisTick: {show: false},
						splitLine: {show: false},
						axisLabel: {show: false},
						splitNumber: 20,
						min: 'dataMin',
						max: 'dataMax'
					    }
					],
					yAxis: [
					    {
					        scale: true,
					        splitArea: {
					            show: true
					        }
					    },
					    {
					        scale: true,
					        gridIndex: 1,
					        splitNumber: 2,
					        axisLabel: {show: false},
					        axisLine: {show: false},
					        axisTick: {show: false},
					        splitLine: {show: false}
					    }
					],
					dataZoom: [
					    {
					        type: 'inside',
							xAxisIndex: [0, 1],
							top: '96%',
						    start: 90,
					    	end: 100
						},
						{
						    show: true,
						    xAxisIndex: [0, 1],
						    type: 'slider',
							top: '96%',
					        start: 90,
					        end: 100
					    }
					],
					series: [
					         //1
							{
					    		name: '日K',
								type: 'candlestick',
								data: data0.values,
								itemStyle: {
					    				normal: {
									        color: upColor,
									        color0: downColor,
									        borderColor: upBorderColor,
									        borderColor0: downBorderColor,
					    				}
								},
								tooltip: {
					    				formatter: function (param) {
					    					console.log(data)
							    			var changePercent = 0;
							    			var openText = '';
											var closeText = '';
											var highText = '';
											var lowText = '';
											var changeText = '';
											$.each(data0.categoryData,function(idx,val){
											    if(val == param.name){
											         var yesClosePrice = parseFloat(data0.values[idx-1][1])
											         var openPrice = parseFloat(data0.values[idx][0])
											         var closePrice = parseFloat(data0.values[idx][1])
											         var lowPrice = parseFloat(data0.values[idx][2])
											         var topPrice = parseFloat(data0.values[idx][3])
											         openPercent =  ((openPrice - yesClosePrice)/yesClosePrice*100).toFixed(2)
											         changePercent = ((closePrice - yesClosePrice)/yesClosePrice*100).toFixed(2)
											         if(changePercent>0){
											        	 changeText = '<span style="color:red">涨跌幅: ' + changePercent + '%</span><br/>' 
											 }else if(changePercent==0){
												 changeText = '<span style="color:black">涨跌幅: ' + changePercent + '%</span><br/>'
											 }else if(changePercent<0){
												 changeText = '<span style="color:#00CC00">涨跌幅: ' + changePercent + '%</span><br/>'
											 }
											 if(openPercent>0){
												 openText = '<span style="color:red">开盘价: ' + param.data[1] + '('+ openPercent + '%)</span><br/>' 
											 }else if(openPercent==0){
												 openText = '<span style="color:black">开盘价: ' + param.data[1] + '('+ openPercent + '%)</span><br/>'
											 }else if(openPercent<0){
												 openText = '<span style="color:#00CC00">开盘价: ' + param.data[1] + '('+ openPercent + '%)</span><br/>'
											 }
											 if(topPrice>yesClosePrice){
												 highText = '<span style="color:red">最高价: ' + param.data[4] + '</span><br/>'
											 }else if(topPrice==yesClosePrice){
												 highText = '<span style="color:black">最高价: ' + param.data[4] + '</span><br/>'
											 }else if(topPrice<yesClosePrice){
												 highText = '<span style="color:#00CC00">最高价: ' + param.data[4] + '</span><br/>'
											 }
											 if(lowPrice>yesClosePrice){
												 lowText = '<span style="color:red">最低价: ' + param.data[3] + '</span><br/>' 
											 }else if(lowPrice==yesClosePrice){
												 lowText = '<span style="color:black">最高价: ' + param.data[3] + '</span><br/>'
											 }else if(lowPrice<yesClosePrice){
												 lowText = '<span style="color:#00CC00">最高价: ' + param.data[3] + '</span><br/>'
											 }
											 if(closePrice>yesClosePrice){
												 closeText = '<span style="color:red">收盘价: ' + param.data[2] + '</span><br/>' 
											 }else if(closePrice==yesClosePrice){
												 closeText = '<span style="color:black">收盘价: ' + param.data[2] + '</span><br/>'
											 }else if(closePrice<yesClosePrice){
												 closeText = '<span style="color:#00CC00">收盘价: ' + param.data[2] + '</span><br/>'
											         }
											    }
											});
											return [
											    '日期: ' + param.name + '<hr size=1 style="margin: 3px 0">',
											     openText,
											     highText,
											     lowText,
											     closeText,
											     changeText
											].join('');
									}
							},
							markLine: {
								lineStyle:{
									color:'red'
						    	},
					    		symbol: ['none', 'none'],
					    		data: [[
						        		{
						            		name: 'from lowest to highest',
											type: 'min',
											valueDim: 'lowest',
											symbol: 'circle',
											symbolSize: 5,
							    			label: {
							       		 			normal: {show: false},
							        				emphasis: {show: false}
							    			}
										},
										{
									    	type: 'max',
											valueDim: 'highest',
											symbol: 'circle',
									        symbolSize: 5,
									        label: {
									            normal: {show: false},
									            emphasis: {show: false}
									        }
									    }
									    ],
										{
										    name: 'min line on close',
											type: 'min',
											valueDim: 'close'
										},
										{
										    name: 'max line on close',
											type: 'max',
											valueDim: 'close'
										 }
										 ]
									}
										    
								},
					//2
								{
								    name: 'MA5',
									type: 'line',
									data: calculateMA(5,data0),
									symbolSize:0,
									smooth: true,
									lineStyle: {
								    	normal: {opacity: 0.5}
									},
									itemStyle:{
										color:'#0099FF'
								    }
									},
					//3
									{
									    name: 'MA10',
										type: 'line',
										data: calculateMA(10,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#3300CC'
									    }
									},
					//4
									{
									    name: 'MA20',
										type: 'line',
										data: calculateMA(20,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#CCCC33'
									    }
									},
					//5
									{
									    name: 'MA30',
										type: 'line',
										data: calculateMA(30,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#FF9933'
									    }
									},
					//6
									{
									    name: 'MA60',
										type: 'line',
										data: calculateMA(60,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#FF6600'
									    }
									},
					//7
									{
									    name: 'MA120',
										type: 'line',
										data: calculateMA(120,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#FF0099'
									    }
									},
					//8
									{
									    name: 'MA250',
										type: 'line',
										data: calculateMA(250,data0),
										symbolSize:0,
										smooth: true,
										lineStyle: {
										    normal: {opacity: 0.5}
										},
										itemStyle:{
											color:'#330033'
									    }
									},
					//9
									{
									    name: 'Volume',
										type: 'bar',
						                xAxisIndex: 1,
						                yAxisIndex: 1,
						                data: data0.volumes
						            }
							        ]
							    },true);					    
			}
		});
		// 使用刚指定的配置项和数据显示图表。
	}
	
	$.ajax({
		url:"../stock/getAll",
		async:false,
		success:function(data){
			$.each(data,function(index,value){
				$("#browsers").append("<option data-buid="+value.buid+" value="+value.stockNo+">"+value.stockCnName+"</option>");
				$("#browsers").append("<option data-buid="+value.buid+" value="+value.stockCnName+">"+value.stockEngName+"</option>");
			});
		}
	});
	
	layui.use('element', function(){
		var element = layui.element;
	});
	
	layui.use('form', function(){
		  var form = layui.form;
		  //监听提交
		  form.on('submit(formDemo)', function(data){
		    var result =  $("#inputSearch").val();
		    var buid = $("[value="+result+"]").attr("data-buid");
		    getData(buid);
		    return false;
		  });
		});
	
	
	
	
})