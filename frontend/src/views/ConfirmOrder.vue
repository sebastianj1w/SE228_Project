<template>
    <div>
        <label style="font-size: 16px;margin: 20px;display: block;">订单详情</label>

        <ul style="margin: 20px; font-size: 14px;">
            <Row>
                <Col span="15">书名</Col>
                <Col span="3">单价</Col>
                <Col span="3">数量</Col>
                <Col span="3">总价</Col>
            </Row>
            <li v-for="item in bookListShow" style="margin: 5px">
                <Col span="15">{{item.title}}</Col>
                <Col span="3">{{item.price}}</Col>
                <Col span="3">{{item.amount}}</Col>
                <Col span="3">{{item.total}}</Col>
            </li>
        </ul>
        <Button type="primary" style="float: right; margin-right: 40px; margin-top: 20px" v-on:click="makeOrder()">
            确定
        </Button>
        <label style="float: right; margin-right: 30px;margin-top: 15px; color: red; font-size: 23px">{{ total
            }}</label>
        <label style="float: right;margin-top: 20px; font-size: 15px">总计：</label>
    </div>
</template>

<script>
    import axios from 'axios/index'

    export default {
        name: "ConfirmOrder",
        data() {
            return {
                cartStr: "",
                cart: [],
                bookList: [],
                bookListShow: [],
                // cart: [],
                total: 0,
                logUser: '',
                ID: "initial",
                immediate: false
            }
        },
        mounted: function () {
            // console.log(this.$route.params);
            // console.log(this.$route);
            // console.log(this.$route.params.ID);
            if (this.$route.params.ID !== undefined) {
                this.ID = this.$route.params.ID;
                this.immediate = true;
            }
            let that = this;
            that.total = 0;
            that.logUser = sessionStorage.getItem("logUser");
            console.log("before" + this.ID);
            if (this.ID === "initial")
                this.updateCart();
            else
                this.getBook();
            this.total = this.total.toFixed(2);
        },
        methods: {
            getBook() {
                console.log("getbook" + this.ID);
                let that = this;
                axios.get('http://localhost:8088/book/title?ID=' + that.ID)
                    .then((response) => {
                        let temp = {
                            title: response.data,
                            price: "",
                            amount: 0,
                            total: 0,
                        };
                        axios.get('http://localhost:8088/book/getprice?id=' + that.ID)
                            .then((response) => {
                                temp.price = response.data;
                                temp.amount = 1;
                                temp.total = response.data;
                                that.bookListShow.push(temp);
                            })
                    });
            },
            updateCart() {
                console.log("updatecart" + this.ID);
                if (this.ID !== "initial") return;
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
                                    response.data.old_amount = key;
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
                if (that.immediate) {
                    orderStr += (this.ID + ':' + this.bookListShow[0].amount + ";")
                } else {
                    for (let i = 0; i < this.bookListShow.length; i++) {
                        orderStr += (this.bookListShow[i].id + ':' + this.bookListShow[i].amount + ";");
                    }
                }
                if (orderStr === "") return;
                console.log({
                    'userid': this.logUser,
                    'itemStr': orderStr
                });
                axios.post('http://localhost:8088/order/insert', {
                    'userid': this.logUser,
                    'itemStr': orderStr
                }).then((response) => {
                    if (response.data === "success") {
                        console.log(123);
                        if (that.immediate)
                            axios.get('http://localhost:8088/cart/clean?Uid=' + that.logUser)
                                .then((response) => {
                                    // console.log(response);
                                    that.updateCart();
                                    that.cartStr = "";
                                });
                        this.$router.push('/');
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

</style>