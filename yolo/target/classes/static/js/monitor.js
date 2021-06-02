
function renderLayer04Left(){
	var myChart = echarts.init(document.getElementById("layer04_left_chart"));
	var ydata=$("#layer04").attr("data-ydata");
	var yarrs=ydata.split(",");
	var x=new Array();
	var y=new Array();
	for (var i=0;i<15;i++) {
		x.push(i);
		y.push(Number(yarrs[i]));
	}
	myChart.setOption(
		{
			title: {
				text: ''
			},
			tooltip : {
				trigger: 'axis'
			},
			legend: {
				data:[]
			},
			grid: {
				left: '3%',  //生成图形的左边距
				right: '4%',
				bottom: '5%',
				top:'4%',
				containLabel: true
			},
			xAxis :
				{
					type : 'category',
					boundaryGap : false,
					data : x,  //x轴的数据
					axisLabel:{
						textStyle:{
							color:"white", //x轴字体颜色
							fontSize:8  //x轴字体大小
						},
						rotate:0, //x轴字体旋转角度
						//	interval:1 //x轴数据相隔刻度
					},
					axisTick:{show:false},
					axisLine:{
						show:true,  //是否显示x轴的底线
						lineStyle:{
							color: 'rgba(255,255,255,0.1)',//x轴底线的颜色
							width: 0.6,   //x轴底线的粗细
							type: 'solid'  //x轴底线的样式，为实线
						}
					},
					splitLine:{
						show:true,  //是否显示x轴的线
						lineStyle:{
							color: '#0B3148',
							width: 1,
							type: 'solid'
						}
					}
				},
			yAxis :
				{
					type : 'value',
					axisTick:{show:false},
					axisLabel:{
						show:true,  //是否显示y轴的值
						textStyle:{
							color:"white", //y轴字体颜色
							fontSize:8  //y轴字体大小
						}
					},
					axisLine:{
						show:true,  //是否显示y轴底线
						lineStyle:{
							color: '#0B3148',   //y轴底线的颜色
							width: 1,  //y轴底线的粗细
							type: 'solid' //y轴底线的样式，为实线
						}
					},
					splitLine:{
						show:true, //是否显示y轴的线
						lineStyle:{
							color: '#0B3148',
							width: 1,
							type: 'solid'
						}
					}
				},
			tooltip:{
				formatter:'{c}',
				backgroundColor:'#FE8501'
			},
			series : [
				{
					name:'',
					type:'line',
					smooth:false,  //是否为曲线true，否则为直线false
					areaStyle:{
						normal:{
							color:new echarts.graphic.LinearGradient(0, 0, 0, 1, [{offset: 0, color: 'red'}, {offset: 1, color: 'blue' }], false),  //线内内容的颜色渐变
							opacity:0.2  //颜色的透明度
						}
					},
					itemStyle : {
						normal : {
							color:'#009991'
						},
						lineStyle:{
							normal:{
								color:'#009895',
								opacity:1
							}
						}
					},
					symbol:'none',
					data:y  //y轴的数据
				}
			]
		}

	);
}

function get10MinutesScale()
{
	var currDate = new Date();
	var odd = currDate.getMinutes()%10;
	var returnArr = new Array();
	currDate.setMinutes(currDate.getMinutes()-odd);
	for(var i = 0; i <7; i++){
		returnArr.push(currDate.getHours()+":"+(currDate.getMinutes()<10?("0"+currDate.getMinutes()):currDate.getMinutes()));
		currDate.setMinutes(currDate.getMinutes()-10);
	}
	return returnArr;
}


function getLatestDays(num)
{
	var currentDay = new Date();
	var returnDays = [];
	for (var i = 0 ; i < num ; i++)
	{
		currentDay.setDate(currentDay.getDate() - 1);
		returnDays.push((currentDay.getMonth()+1)+"/"+currentDay.getDate());
	}
	return returnDays;
}