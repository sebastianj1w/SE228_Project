<template>
    <div>
        <Table style="border: 0" width="100%" ref="table" :columns="columns1"
               :data="bookListShow"></Table>
        <Button type="primary" style="float: right; margin-right: 40px; margin-top: 20px" v-on:click="makeOrder()">立即下单</Button>
        <label style="float: right; margin-right: 30px;margin-top: 15px; color: red; font-size: 23px">{{ total }}</label>
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
                        key: 'amount'
                    },
                    {
                        title: '价格',
                        key: 'price',
                        width: 200,
                        sortable: true
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
                axios.get('http://localhost:8088/user/getcart?Uid='+that.logUser)
                    .then((response)=>{
                        this.cartStr = response.data;
                        this.cart = this.cartStr.split(";");
                        for (let i = 0;i<this.cart.length;i++) {
                            if (this.cart[i]==='') continue;
                            if (bookMap.get(this.cart[i]) === undefined){
                                bookMap.set(this.cart[i], 1);
                            } else {
                                bookMap.set(this.cart[i], bookMap.get(this.cart[i])+1);
                            }
                        }
                        bookMap.forEach(function(key, value){
                            axios.get('http://localhost:8088/book/information?ID='+value)
                                .then((response) => {
                                    response.data.amount = key;
                                    response.data.total = response.data.price * key;
                                    that.bookListShow.push(response.data);
                                })
                        })
                    });
            },
            makeOrder() {
                console.log("1232");
                let that = this;
                let orderStr = "";
                for (let i = 0; i < this.bookListShow.length; i++) {
                    orderStr += (this.bookListShow[i].id + ':' + this.bookListShow[i].amount + ";");
                }
                axios.post('http://localhost:8088/order/insert', {
                    'userid':this.logUser,
                    'itemStr':orderStr
                }).then((response)=>{
                    that.cartStr = "";
                    axios.get('http://localhost:8088/user/cleancart?Uid='+that.logUser)
                        .then((response)=>{
                            console.log(response);
                        });
                    console.log(response);
                    that.updateCart();
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
                },
                deep:true
            }
        }
    }
</script>

<style scoped>
    .ivu-table-body .ivu-table-overflowX {
        overflow-x: hidden;
    }
</style>