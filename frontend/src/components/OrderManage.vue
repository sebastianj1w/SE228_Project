<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入来开始检索...">
            <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table"  :columns="columns1" :data="orderListShow"></Table>
    </div>
</template>

<script>
    import axios from 'axios'
    import expandRow from './OrderExpand.vue'

    export default {
        name: "OrderManage",
        props: ['orderState'],
        components: {
            expandRow: expandRow,
        },
        data() {
            return {
                searchConName1: '',
                tableHeight: 450,
                columns1: [
                    {
                        type: 'expand',
                        width: 30,
                        render: (h, params) => {
                            // console.log(params.row.items);
                            return h(expandRow, {
                                props: {
                                    orderid: params.row.orderid,
                                },
                            })
                        }
                    },
                    {
                        title: '用户名',
                        key: 'userid'
                    },
                    {
                        title: '所购书名',
                        key: 'titleToShow',
                    },
                    {
                        title: '日期',
                        key: 'time',
                        width: 99
                    },
                    {
                        title: '总价',
                        key: 'total',
                        sortable: true,
                        width: 100
                    },
                    {
                        title: '状态',
                        key: 'state',
                        width: 60
                    },
                    // {
                    //     title: '订单号',
                    //     key: 'orderid',
                    //     width: 100
                    // },
                    {
                        title: '操作',
                        key: 'action',
                        width: 140,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small',

                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.$Message.success('请求已发送!');
                                        }
                                    }
                                }, '修改'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.$Message.success('请求已发送!');
                                        }
                                    }
                                }, '取消')
                            ]);
                        }
                    }
                ],
                orderList: [],
                orderListShow: [],
                orderListStore: [],
                logUser: ""
            }
        },
        methods: {
            search(data, argumentObj) {
                let res = data;
                let dataClone = data;
                for (let argu in argumentObj) {
                    if (argumentObj[argu].length > 0) {
                        res = dataClone.filter(d => {
                            return d[argu].indexOf(argumentObj[argu]) > -1;
                        });
                        dataClone = res;
                    }
                }
                return res;
            },
            timestampToTime(timestamp) {
                let date = new Date(timestamp);
                let Y = date.getFullYear() + '-';
                let M = (date.getMonth() + 1 < 10 ? '0' + (date.getMonth() + 1) : date.getMonth() + 1) + '-';
                let D = date.getDate() + ' ';
                let h = date.getHours() + ':';
                let m = date.getMinutes() + ':';
                let s = date.getSeconds();
                return Y + M + D + h + m + s;
            },
            titleToShow(title) {
                let index = 0;
                if ((index = title.indexOf("、")) >= 0) {
                    return "《" + title.substr(0, index) + "》" + "等";
                } else
                    return title;
            },
            handleSearch() {
                this.orderListShow = this.orderList;
                this.orderListShow = this.search(this.orderList, {title: this.searchConName1});
                console.log(this.orderList);
            },
            changeList() {
                if (this.orderState > 10) {
                    this.orderList = this.orderListStore;
                    this.orderListShow = this.orderList;
                    return;
                }
                let temp = [];
                console.log(this.orderState);
                for (let i = 0; i < this.orderListStore.length; i++) {
                    if (this.orderListStore[i].state === this.orderState) {
                        temp.push(this.orderListStore[i]);
                    }
                }
                this.orderList = temp;
                this.orderListShow = this.orderList;
                console.log(333321);
            }
        },
        mounted() {
            this.state = this.$route.params.state;
            this.logUser = sessionStorage.getItem("logUser");
            let that = this;
            axios.get('http://localhost:8088/order/getAll')
                .then((response) => {
                    that.orderList = response.data;
                    for (let i = 0; i < that.orderList.length; i++) {
                        if (that.orderList[i].state !== this.state) {
                            that.orderList[i].time = that.timestampToTime(that.orderList[i].date);
                            that.orderList[i].titleToShow = that.titleToShow(that.orderList[i].title);
                        }
                    }
                    that.orderListShow = that.orderList;
                    that.orderListShow[0].titleToShow += " ";
                    this.orderListStore = this.orderList;
                    console.log(that.orderList);
                    // this.changeList();
                });
            // this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            // this.orderListShow = this.orderList;
        },
        watch: {
            orderState: {
                handler() {
                    // console.log(321);
                    // this.changeList();
                }
            }
        }
    }
</script>

<style scoped>

</style>