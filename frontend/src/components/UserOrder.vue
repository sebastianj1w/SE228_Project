<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入来开始检索...">
        <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="orderListShow"></Table>
    </div>
</template>

<script>
    import axios from 'axios'
    import expandRow from './OrderExpand.vue'
    export default {
        name: "OrderManage",
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
                            return h(expandRow, {
                                props: {
                                    'v-bind:itemList=': params.row.items,
                                },
                            })
                        }
                    },
                    {
                        title: '所购书名',
                        key: 'title'
                    },
                    {
                        title: '总价',
                        key: 'total',
                        sortable: true
                    },
                    {
                        title: '订单号',
                        key: 'orderid',
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: 'primary',
                                        size: 'small'
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
                                }, '删除')
                            ]);
                        }
                    }
                ],
                orderList: [],
                orderListShow: [],
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
            handleSearch() {
                this.orderListShow = this.orderList;
                this.orderListShow = this.search(this.orderList, {title: this.searchConName1});
            },
        },
        mounted() {
            this.logUser = sessionStorage.getItem("logUser");
            let that = this;
            // let tempList = JSON.parse(sessionStorage.getItem("orderList"));
            // this.logUser = sessionStorage.getItem("logUser");
            // for (let i in tempList) {
            //     if (tempList[i].userID === this.logUser) {
            //         this.orderList.push(tempList[i]);
            //     }
            // }
            axios.get('http://localhost:8088/order/getByUser?Uid='+that.logUser)
                .then((response)=>{
                    let orderList = response.data;
                    that.orderListShow = orderList;
                    that.orderList = orderList;
                    for (let i in that.orderList) {
                        axios.get('http://localhost:8088/order/getItems?Oid='+that.orderList[i].orderid)
                            .then((response)=>{
                                that.orderList[i].items = response.data;
                            });
                    }
                });
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.orderListShow = this.orderList;
        },
    }
</script>

<style scoped>

</style>