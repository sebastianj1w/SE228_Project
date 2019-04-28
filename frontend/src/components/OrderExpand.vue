<style scoped>
    .expand-row {
        margin-bottom: 6px;
    }
</style>
<template>
    <div>
        <label style="margin: 5px; font-size: 15px;color: #2baee9;">订单详情</label>
        <Row style="margin: 5px;font-size: 13px">
            <Col span="19">书名</Col>
            <Col span="3">单价</Col>
            <Col span="1">数量</Col>
        </Row>
        <ul id="example-1">
            <li v-for="item in itemList" style="margin: 5px">
                    <Col span="19" >{{item.title}}</Col>
                    <Col span="3">{{item.value}}</Col>
                    <Col span="1">{{item.amount}}</Col>
            </li>
        </ul>
<!--        <Table ref="table" :columns="columns1" :data="itemList"></Table>-->
    </div>
</template>
<script>
    import axios from 'axios'
    // import * as Vue from "vue";

    export default {
        props: {
            orderid: String
        },
        data() {
            return {
                itemList: [
                    {
                        'title': "1",
                        "value": 0,
                        "amount": 0
                    }
                ],
            }
        },
        mounted() {
            let that = this;
            // console.log(this.orderid);
            axios.get('http://localhost:8088/order/getItems?Oid=' + that.orderid)
                .then((response) => {
                    that.itemList = response.data;
                    for (let i = 0; i < that.itemList.length; i++) {
                        axios.get('http://localhost:8088/book/title?ID=' + that.itemList[i].bookid)
                            .then((response) => {
                                that.itemList[i].title = response.data;
                                that.itemList[i].orderid += "1";
                                this.$forceUpdate();
                                // OrderExpand.set(this.itemList,i,{title:response.data})
                            })
                            .catch((error) => {
                                console.log(error);
                            })
                    }
                }).catch((error) => {
                console.log(error);
            });
        },
    };
</script>