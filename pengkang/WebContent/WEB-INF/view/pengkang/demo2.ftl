<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="/pengkang/js/echarts.js"></script>
    <script src="/pengkang/js/jquery.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:600px;"></div>
    <script type="text/javascript">
    	$.get('/pengkang/js/china.json', function (chinaJson) {
			    echarts.registerMap('china', chinaJson);
			    function randomData() {
    				return Math.round(Math.random()*100);
				}
			    var chart = echarts.init(document.getElementById('main'));
			    option = {
		    title: {
		        text: '彭康书院学生平均成绩各地区分布',
		        subtext: '彭康书院',
		        left: 'center'
		    },
		    tooltip: {
		        trigger: 'item'
		    },
		    legend: {
		        orient: 'vertical',
		        left: 'left',
		        data:['机械','材料','英语']
		    },
		    visualMap: {
		        min: 0,
		        max: 100,
		        left: 'left',
		        top: 'bottom',
		        text: ['高','低'],           // 文本，默认为数值文本
		        calculable: true
		    },
		    toolbox: {
		        show: true,
		        orient: 'vertical',
		        left: 'right',
		        top: 'center',
		        feature: {
		            dataView: {readOnly: false},
		            restore: {},
		            saveAsImage: {}
		        }
		    },
		    series: [
		        {
		            name: '机械',
		            type: 'map',
		            mapType: 'china',
		            roam: false,
		            label: {
		                normal: {
		                    show: true
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            data:[
		                {name: '北京',value: randomData() },
		                {name: '天津',value: randomData() },
		                {name: '上海',value: randomData() },
		                {name: '重庆',value: randomData() },
		                {name: '河北',value: randomData() },
		                {name: '河南',value: randomData() },
		                {name: '云南',value: randomData() },
		                {name: '辽宁',value: randomData() },
		                {name: '黑龙江',value: randomData() },
		                {name: '湖南',value: randomData() },
		                {name: '安徽',value: randomData() },
		                {name: '山东',value: randomData() },
		                {name: '新疆',value: randomData() },
		                {name: '江苏',value: randomData() },
		                {name: '浙江',value: randomData() },
		                {name: '江西',value: randomData() },
		                {name: '湖北',value: randomData() },
		                {name: '广西',value: randomData() },
		                {name: '甘肃',value: randomData() },
		                {name: '山西',value: randomData() },
		                {name: '内蒙古',value: randomData() },
		                {name: '陕西',value: randomData() },
		                {name: '吉林',value: randomData() },
		                {name: '福建',value: randomData() },
		                {name: '贵州',value: randomData() },
		                {name: '广东',value: randomData() },
		                {name: '青海',value: randomData() },
		                {name: '西藏',value: randomData() },
		                {name: '四川',value: randomData() },
		                {name: '宁夏',value: randomData() },
		                {name: '海南',value: randomData() },
		                {name: '台湾',value: randomData() },
		                {name: '香港',value: randomData() },
		                {name: '澳门',value: randomData() }
		            ]
		        },
		        {
		            name: '材料',
		            type: 'map',
		            mapType: 'china',
		            label: {
		                normal: {
		                    show: true
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            data:[
		                {name: '北京',value: randomData() },
		                {name: '天津',value: randomData() },
		                {name: '上海',value: randomData() },
		                {name: '重庆',value: randomData() },
		                {name: '河北',value: randomData() },
		                {name: '安徽',value: randomData() },
		                {name: '新疆',value: randomData() },
		                {name: '浙江',value: randomData() },
		                {name: '江西',value: randomData() },
		                {name: '山西',value: randomData() },
		                {name: '内蒙古',value: randomData() },
		                {name: '吉林',value: randomData() },
		                {name: '福建',value: randomData() },
		                {name: '广东',value: randomData() },
		                {name: '西藏',value: randomData() },
		                {name: '四川',value: randomData() },
		                {name: '宁夏',value: randomData() },
		                {name: '香港',value: randomData() },
		                {name: '澳门',value: randomData() }
		            ]
		        },
		        {
		            name: '英语',
		            type: 'map',
		            mapType: 'china',
		            label: {
		                normal: {
		                    show: true
		                },
		                emphasis: {
		                    show: true
		                }
		            },
		            data:[
		                {name: '北京',value: randomData() },
		                {name: '天津',value: randomData() },
		                {name: '上海',value: randomData() },
		                {name: '广东',value: randomData() },
		                {name: '台湾',value: randomData() },
		                {name: '香港',value: randomData() },
		                {name: '澳门',value: randomData() }
		            ]
		        }
		    ]
			};
			    chart.setOption(option);
			});
    </script>
    
</body>
</html>