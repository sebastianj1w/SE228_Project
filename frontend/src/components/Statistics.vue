<template>
    <Card align="center">

        <div :class="className" :id="id" :style="{height:height,width:width}" ref="myEchart">
        </div>
        <label>选择时间跨度：</label>
        <Slider style="width: 50%;" v-model="selector.value" :min="selector.min" :max="selector.max"></Slider>
        <Button type="primary">查看</Button>
    </Card>
</template>
<script>
    import echarts from 'echarts'
    import axios from 'axios'
    import  'echarts/theme/macarons.js'
    export default {
        props: {
            userID: {type: String},
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
                default: '700px'
            },
            height: {
                type: String,
                default: '600px'
            },
        },
        data() {
            return {
                ok: 0,
                selector: {
                    value: 7,
                    min: 3,
                    max: 12,
                },
                month: '',
                year: '',
                chart: null,
                // amountData: [1, 5, 0, 0, 7, 3, 0, 0, 0, 0, 0, 0],
                amountData: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                adjustedAmountData: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                // valueData: [9.49, 47.45, 0, 0, 101.83, 41.12, 0, 0, 0, 0,0, 0],
                valueData: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                adjustedValueData: [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
                xStrings: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                adjustedXStrings: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月']
            }
        },
        mounted() {
            let date = new Date();
            let month = date.getMonth() + 1;
            this.year = date.getFullYear();
            // console.log(date1);
            // console.log(99999999);
            let that = this;
            let date0 = this.genDateStr(this.year, month, date.getDate() + 1);
            let date1 = this.genDateStr(this.year, month, 1);
            let date2 = '';
            axios.get('http://localhost:8088/order/getByUserAndDate?Uid=' + that.userID + '&date1=' + date1 + '&date2=' + date0)
                .then((response) => {
                    console.log(response);
                    let orderList = response.data;
                    let amount = orderList.length;
                    let total = 0;
                    for (let m = 0; m < amount; m++) {
                        total += orderList[m].total;
                    }
                    that.valueData[0] = total;
                    that.amountData[0] = amount;
                    // console.log(total);
                    that.$forceUpdate();
                    // console.log(this.valueData);
                    for (let i = 1; i < 12; i++) {
                        if (i > 1)
                            date1 = date2;
                        if (month - i > 0)
                            date2 = this.genDateStr(this.year, month - i, 1);
                        else
                            date2 = this.genDateStr(this.year - 1, month - i + 12, 1);
                        axios.get('http://localhost:8088/order/getByUserAndDate?Uid=' + that.userID + '&date1=' + date2 + '&date2=' + date1)
                            .then((response) => {
                                let orderList = response.data;
                                let amount = orderList.length;
                                let total = 0;
                                for (let m = 0; m < amount; m++) {
                                    total += orderList[m].total;
                                }
                                that.valueData[i] = total;
                                that.amountData[i] = amount;
                                // console.log(total);
                                that.$forceUpdate();
                                // console.log(this.valueData);
                                if (i === 11)
                                    that.ok += 1;
                            });

                    }
                });

            // this.adjustX(this.month);
            // this.initChart();
        },
        beforeDestroy() {
            if (!this.chart) {
                return;
            }
            this.chart.dispose();
            this.chart = null;
        },
        watch: {
            ok: {
                handler() {
                    this.adjustX(this.month);
                    this.initChart();
                }
            }
        },
        methods: {
            initChart() {
                this.chart = echarts.init(this.$refs.myEchart,'macarons');
                // 把配置和数据放这里
                this.chart.setOption({
                    title: {
                        text: '订单量、花费统计',
                        subtext: '纯属虚构'
                    },
                    tooltip: {
                        trigger: 'axis'
                    },
                    legend: {
                        data: ['订单量', '花费']
                    },
                    toolbox: {
                        show: true,
                        feature: {
                            mark: {show: true},
                            dataView: {show: true, readOnly: false},
                            magicType: {show: true, type: ['line', 'bar']},
                            restore: {show: true},
                            saveAsImage: {show: true}
                        }
                    },
                    calculable: true,
                    xAxis: [
                        {
                            type: 'category',
                            data: this.adjustedXStrings,
                        }
                    ],
                    yAxis: [
                        {
                            type: 'value'
                        }
                    ],
                    series: [
                        {
                            name: '购买量',
                            type: 'bar',
                            data: this.adjustedAmountData,
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'}
                                ]
                            }
                        },
                        {
                            name: '资金',
                            type: 'bar',
                            data: this.adjustedValueData,
                            markLine: {
                                data: [
                                    {type: 'average', name: '平均值'}
                                ]
                            }
                        }
                    ]
                })
            },
            adjustX(m) {
                for (let i = 11; i >= 0; i--) {
                    this.adjustedXStrings[i] = this.xStrings[(i + m + 1) % 12];
                    this.adjustedAmountData[i] = this.amountData[11 - i];
                    this.adjustedValueData[i] = this.valueData[11 - i];
                }
            },
            genDateStr(year, month, day) {
                let m = '';
                let y = '';
                let d = '';
                if (month < 10) {
                    m = '0' + (month).toString();
                } else {
                    m = (month).toString();
                }
                if (day < 10) {
                    d = '0' + (day).toString();
                } else {
                    d = (day).toString();
                }
                y = year.toString();
                return y + '-' + m + '-' + d;
            }
        }
    }
</script>