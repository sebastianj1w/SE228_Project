<template>
    <div>
        <Table style="margin: 1px" width="100%" ref="table" :columns="columns1"
               :data="bookListShow"></Table>
        <Button type="primary" style="float: right; margin-right: 40px; margin-top: 20px" v-on:click="makeOrder()">
            立即下单
        </Button>
        <label style="float: right; margin-right: 30px;margin-top: 15px; color: red; font-size: 23px">{{ total
            }}</label>
        <label style="float: right;margin-top: 20px; font-size: 15px">总计：</label>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "Cart",
        data() {
            return {
                cartStr: "",
                cart: [],
                columns1: [
                    {
                        title: '标题',
                        key: 'title',
                        render: (h, params) => {
                            let url = '/books/' + params.row.id;
                            return h('router-link', {
                                attrs: {
                                    to: url,
                                    // target: '_black'
                                }
                            }, params.row.title)
                        }
                    },
                    {
                        title: '作者',
                        key: 'author'
                    },
                    {
                        title: '出版社',
                        key: 'publisher'
                    },
                    {
                        title: '数量',
                        key: 'amount',
                        render: (h, params) => {
                            let that = this;
                            let a = params.row.amount;
                            let display = "";
                            let display_n = "display: none";
                            return h('div', {
                                // attrs: {
                                //     to: url,
                                //     // target: '_black'
                                // }
                            }, [
                                h('label', {
                                    attrs: {
                                        style: !params.row.editting ? display + ";margin: 4px" : display_n
                                    }
                                }, params.row.amount),
                                h('Input', {
                                    attrs: {
                                        style: params.row.editting ? display + ";width: 25%" : display_n,
                                        value: a,
                                        size: 'small'
                                    },
                                    on: {
                                        input: function (event) {
                                            console.log(event);
                                            a = event;
                                        }
                                    }
                                },),
                                h('ButtonGroup', {
                                    attrs: {
                                        vertical: true,
                                        size: "small",
                                        style: params.row.editting ? display : display_n
                                    }
                                }, [
                                    h('Button', {attrs: {type: "text"}}, '+'), h('Button', {attrs: {type: "text"}}, '-')
                                ]),
                                h('Button', {
                                    attrs: {
                                        style: "margin: 4px",
                                        size: 'small'
                                    },
                                    on: {
                                        'click': function () {
                                            if (params.row.editting) {
                                                if (params.row.amount !== a)
                                                    axios.get('http://localhost:8088/cart/set', {
                                                        params: {
                                                            Uid: that.logUser,
                                                            Bid: params.row.id,
                                                            amount: a
                                                        }
                                                    })
                                                        .then((response) => {
                                                            console.log(response);
                                                            that.updateCart();
                                                            console.log("send add cart request");
                                                        });
                                            }

                                            params.row.editting = !params.row.editting;
                                        }
                                    }
                                }, !params.row.editting ? '编辑' : '保存'),
                            ])
                        }
                    },
                    {
                        title: '价格',
                        key: 'price',
                        width: 200,
                        sortable: true,
                        editable: true
                    },
                    {
                        title: '操作',
                        key: 'amount',
                        render: (h, params) => {
                            let that = this;
                            return h('Button', {
                                attrs: {
                                    type: 'warning',
                                    size: 'small'
                                },
                                on: {
                                    'click': function () {
                                        axios.get('http://localhost:8088/cart/delete', {
                                            params: {
                                                Uid: that.logUser,
                                                Bid: params.row.id,
                                            }
                                        })
                                            .then((response) => {
                                                console.log(response);
                                                that.updateCart();
                                                console.log("send delete cart request");
                                            });
                                    }
                                }
                            }, "删除")
                        },
                        width: 90
                    },
                ],
                bookList: [],
                bookListShow: [],
                // cart: [],
                total: 0,
                logUser: ''
            }
        },
        mounted: function () {
            let that = this;
            that.total = 0;
            that.logUser = sessionStorage.getItem("logUser");
            this.updateCart();
            this.total = this.total.toFixed(2);
        },
        methods: {
            updateCart() {
                let that = this;
                let bookMap = new Map();
                that.bookListShow = [];
                axios.get('http://localhost:8088/cart/get?Uid=' + that.logUser)
                    .then((response) => {
                        this.cart = response.data;
                        console.log(response.data);
                        // this.cart = this.cartStr.split(";");
                        for (let i = 0; i < this.cart.length; i++) {
                            // if (this.cart[i] === '') continue;
                            // let temp = this.cart[i].split(":");
                            bookMap.set(this.cart[i].bid, this.cart[i].amount);
                        }
                        bookMap.forEach(function (key, value) {
                            axios.get('http://localhost:8088/book/information?ID=' + value)
                                .then((response) => {
                                    response.data.amount = key;
                                    response.data.total = response.data.price * key;
                                    response.data.editting = false;
                                    that.bookListShow.push(response.data);
                                })
                        })
                    });
            },
            stringifyCart(params) {
                console.log(params);
            },
            makeOrder() {
                // console.log("1232");
                let that = this;
                let orderStr = "";
                for (let i = 0; i < this.bookListShow.length; i++) {
                    orderStr += (this.bookListShow[i].id + ':' + this.bookListShow[i].amount + ";");
                }
                axios.post('http://localhost:8088/order/insert', {
                    'userid': this.logUser,
                    'itemStr': orderStr
                }).then((response) => {
                    if (response.data === "success") {
                        console.log(123);
                        axios.get('http://localhost:8088/cart/clean?Uid=' + that.logUser)
                            .then((response) => {
                                // console.log(response);
                                that.updateCart();
                                that.cartStr = "";
                            });
                    } else {
                        console.log(1234);
                        // console.log(response);
                        alert(response.data);
                    }


                })
            }
        },
        watch: {
            bookListShow: {
                handler() {
                    let that = this;
                    this.total = 0;
                    for (let i = 0; i < this.bookListShow.length; i++) {
                        that.total += this.bookListShow[i].total;
                    }
                    this.total = this.total.toFixed(2);
                    this.cloneBookList = JSON.parse(JSON.stringify(this.bookList)).map(function (item) {
                        item.editting = false;
                        item.saving = false;
                        return item;
                    });
                    this.loading = false;
                },
                deep: true
            }
        }
    }
</script>

<style scoped>
    .ivu-table-body .ivu-table-overflowX {
        overflow-x: hidden;
    }
</style>