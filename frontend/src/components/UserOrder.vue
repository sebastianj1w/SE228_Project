<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入来开始检索...">
            <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :columns="columns1" :data="orderListShow"></Table>
        <Modal
                v-model="commentModal"
                :title="'评价订单'+title"
                @on-ok="ok"
                @on-cancel="cancel">
            <ul>
                <li v-for="item in itemList" style="list-style-type: none">
                    <label style="font-size:15px;line-height: 30px">{{item.title}}</label>
                    <Input v-model="item.comment" type="textarea" :rows="6"></Input>
                </li>
            </ul>
        </Modal>
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
                        title: '所购书名',
                        key: 'titleToShow'
                    },
                    {
                        title: '日期',
                        key: 'time'
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
                        width: 70
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
                        render: (h, params) => {
                            let that = this;
                            if (params.row.state === 0)
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
                                                axios.get('http://localhost:8088/order/pay_success', {
                                                    params: {
                                                        Oid: params.row.orderid
                                                    }
                                                }).then((response) => {
                                                    that.getList();
                                                })
                                            }
                                        }
                                    }, '付款'),
                                    h('Button', {
                                        props: {
                                            type: 'error',
                                            size: 'small'
                                        },
                                        on: {
                                            click: () => {
                                                axios.get('http://localhost:8088/order/delete', {
                                                    params: {
                                                        Oid: params.row.orderid
                                                    }
                                                }).then((response) => {
                                                    that.getList();
                                                })
                                            }
                                        }
                                    }, '取消')
                                ]);
                            else if (params.row.state === 1)
                                return h('div', [
                                    h('Button', {
                                        props: {
                                            type: 'primary',
                                            size: 'small',
                                            // disabled: '',
                                        },
                                        style: {
                                            marginRight: '5px'
                                        },
                                        on: {
                                            click: () => {
                                                that.doComment(params.row.orderid);
                                            }
                                        }
                                    }, '评价'),
                                    h('Button', {
                                        props: {
                                            type: 'error',
                                            size: 'small'
                                        },
                                        on: {
                                            click: () => {
                                                // this.$Message.success('请求已发送!');
                                                axios.get('http://localhost:8088/order/un_show', {
                                                    params: {
                                                        Oid: params.row.orderid
                                                    }
                                                })
                                                    .then((response) => {
                                                        // console.log(params.row.orderid);
                                                        that.getList();
                                                    })
                                            }
                                        }
                                    }, '删除')
                                ]);
                            else
                                return h('div', [
                                    h('Button', {
                                        props: {
                                            type: 'primary',
                                            size: 'small',
                                            disabled: '',
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
                                                // this.$Message.success('请求已发送!');
                                                axios.get('http://localhost:8088/order/un_show', {
                                                    params: {
                                                        Oid: params.row.orderid
                                                    }
                                                })
                                                    .then((response) => {
                                                        // console.log(params.row.orderid);
                                                        that.getList();
                                                    })
                                            }
                                        }
                                    }, '删除')
                                ]);
                        }
                    }
                ],
                orderList: [],
                orderListShow: [],
                orderListStore: [],
                logUser: "",
                title: "",
                commentModal: false,
                itemList: [],
                getItemsOk: false,
                currentID: '',
            }
        },
        methods: {
            getList() {
                this.state = this.$route.params.state;
                this.logUser = sessionStorage.getItem("logUser");
                let that = this;
                axios.get('http://localhost:8088/order/getByUser?Uid=' + that.logUser)
                    .then((response) => {
                        that.orderList = response.data;
                        for (let i = 0; i < that.orderList.length; i++) {
                            that.orderList[i].time = that.timestampToTime(that.orderList[i].date);
                            that.orderList[i].titleToShow = that.titleToShow(that.orderList[i].title);
                        }
                        that.orderListShow = that.orderList;
                        that.orderListShow[0].titleToShow += " ";
                        this.orderListStore = this.orderList;
                        // console.log(that.orderList);
                        this.changeList();
                    });
            },
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
                // console.log(this.orderState);
                for (let i = 0; i < this.orderListStore.length; i++) {
                    if (this.orderListStore[i].state === this.orderState) {
                        temp.push(this.orderListStore[i]);
                    }
                }
                this.orderList = temp;
                this.orderListShow = this.orderList;
                // console.log(333321);
            },
            doComment(id) {
                console.log("doc");
                this.title = id;
                this.commentModal = true;
                let that = this;
                axios.get('http://localhost:8088/order/getItems?Oid=' + id)
                    .then((response) => {
                        that.itemList = response.data;
                        for (let i = 0; i < that.itemList.length; i++) {
                            axios.get('http://localhost:8088/book/title?ID=' + that.itemList[i].bookid)
                                .then((response) => {
                                    that.itemList[i].title = response.data;
                                    that.itemList[i].comment = '';
                                    this.$forceUpdate();
                                })
                                .catch((error) => {
                                    console.log(error);
                                })
                        }
                    }).catch((error) => {
                    console.log(error);
                });
            },
            ok() {
                for (let i = 0; i < this.itemList.length; i++) {
                    console.log(this.itemList[i].comment);
                    axios.post("http://localhost:8088/comment/setToBook?Bid=" + this.itemList[i].bookid,
                        {
                            "userid": this.logUser,
                            "toid": this.itemList[i].bookid,
                            "content": this.itemList[i].comment,
                        }).then((response) => {
                            console.log(response);
                    })
                }
                axios.get("http://localhost:8088/order/comment_success?Oid=" + this.title)
                    .then((response) => {
                        this.getList();
                    });
            },
            cancel() {
            },
        },
        mounted() {
            this.state = this.$route.params.state;
            this.logUser = sessionStorage.getItem("logUser");
            let that = this;
            axios.get('http://localhost:8088/order/getByUser?Uid=' + that.logUser)
                .then((response) => {
                    that.orderList = response.data;
                    for (let i = 0; i < that.orderList.length; i++) {
                        that.orderList[i].time = that.timestampToTime(that.orderList[i].date);
                        that.orderList[i].titleToShow = that.titleToShow(that.orderList[i].title);
                    }
                    that.orderListShow = that.orderList;
                    that.orderListShow[0].titleToShow += " ";
                    this.orderListStore = this.orderList;
                    // console.log(that.orderList);
                    this.changeList();
                });
            // this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            // this.orderListShow = this.orderList;
        },
        watch: {
            orderState: {
                handler() {
                    console.log(321);
                    this.changeList();
                }
            },
            getItemsOk: {
                handler() {
                    console.log("watched");
                }
            }
        }
    }
</script>

<style scoped>

</style>