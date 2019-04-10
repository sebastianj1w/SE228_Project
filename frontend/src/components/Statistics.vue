<template>
    <Card align="center">
        <div :class="className" :id="id" :style="{height:height,width:width}" ref="myEchart">
        </div>
        <label>选择时间跨度：</label><Slider style="width: 50%;" v-model="selector.value" :min="selector.min" :max="selector.max"></Slider>
        <Button type="primary">查看</Button>
    </Card>
</template>
<script>
    import echarts from 'echarts'

    export default {
        props: {
            className: {
                type: String,
                default: 'yourClassName'
            },
            id: {
                type: String,
                default: 'yourID'
            },
            width: {
                type: String,
                default: '500px'
            },
            height: {
                type: String,
                default: '600px'
            }
        },
        data() {
            return {
                selector: {
                    value: 7,
                    min: 3,
                    max: 12,
                },
                chart: null
            }
        },
        mounted() {
            this.initChart();
        },
        beforeDestroy() {
            if (!this.chart) {
                return
            }
            this.chart.dispose();
            this.chart = null;
        },
        methods: {
            initChart() {
                this.chart = echarts.init(this.$refs.myEchart);
                // 把配置和数据放这里
                this.chart.setOption({
                    color: ['#3398DB'],
                    tooltip: {
                        trigger: 'axis',
                        axisPointer: { // 坐标轴指示器，坐标轴触发有效
                            type: 'shadow' // 默认为直线，可选为：'line' | 'shadow'
                        }
                    },
                    grid: {
                        left: '3%',
                        right: '4%',
                        bottom: '3%',
                        containLabel: true
                    },
                    title: {
                        left: 'center',
                        text: '近7个月购书统计',
                    },
                    xAxis: [{
                        type: 'category',
                        data: ['九月', '十月', '十一月', '十二月', '一月', '二月', '三月'],
                        axisTick: {
                            alignWithLabel: true
                        }
                    }],
                    yAxis: [{
                        type: 'value'
                    }],
                    series: [{
                        name: '直接访问',
                        type: 'bar',
                        barWidth: '60%',
                        data: [10, 2, 22, 8, 4, 11, 9]
                    }]
                })
            }
        }
    }
</script>