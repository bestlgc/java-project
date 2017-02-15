<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- 引入 echarts.js -->
    <script src="/pengkang/js/echarts.js"></script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
        // 基于准备好的dom，初始化echarts实例
        var myChart = echarts.init(document.getElementById('main'));

        // 指定图表的配置项和数据
        var option = {
            title: {
                text: '彭康书院成绩分析'
            },
            tooltip: {},
            legend: {
                data:['平均成绩']
            },
            xAxis: {
                data: ["机械","材料","马原","热力学","流体热力学","英语"]
            },
            yAxis: {},
            series: [{
                name: '平均成绩',
                type: 'bar',
                data: [68.3, 77.1, 81.1, 70.1, 77.8, 76.6]
            }]
        };

        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    </script>
</body>
</html>