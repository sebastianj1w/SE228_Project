<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入来开始检索...">
        <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="orderListShow"></Table>
    </div>
</template>

<script>

    export default {
        name: "OrderManage",
        components: {
        },
        data() {
            return {
                searchConName1: '',
                tableHeight: 450,
                columns1: [
                    {
                        title: '订单号',
                        key: 'order_no',
                    },
                    {
                        title: '用户',
                        key: 'userID'
                    },
                    {
                        title: '所购书名',
                        key: 'title'
                    },
                    {
                        title: 'ISBN',
                        key: 'ISBN'
                    },
                    {
                        title: '价格',
                        key: 'price',
                        sortable: true
                    },
                    {
                        title: '数量',
                        key: 'amount',
                        sortable: true
                    },
                    {
                        title: '总价',
                        key: 'total',
                        sortable: true
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
                orderListShow: [
                ]
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
            this.orderList = JSON.parse(sessionStorage.getItem("orderList"));
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.orderListShow = this.orderList;
        },
    }
</script>

<style scoped>

</style>