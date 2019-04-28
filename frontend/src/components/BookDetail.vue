<template>
    <Card :bordered="false" style="margin: 3px">
        <Row type="flex" justify="center">
            <Col span="20">
                <Row :gutter="16">
                    <Col span="7" style="height: 340px; border: 1px gray dashed">
                        <div align="center" style="height: 80%;  margin-top: 12%">
                            <img style="height: 100%;" :src="cover" />
                        </div>
                    </Col>
                    <Col span="13">
                        <label class="label1" style="font-size: 30px"> {{item.title}} </label><br>
                        <div>
                            <label class="label1" style="float: left; margin-top: 6px">评分： </label>
                            <Rate style="float: left" allow-half disabled v-model="item.rate" />
                        </div><br><br>
                        <label class="label1">售价： </label><label class="label2" style="color: red; line-height: 100%;">¥{{item.price}}</label>
                        <br>
                        <label class="label1">作者： </label><label class="label2"> {{item.author}}</label>
                        <br>
                        <label class="label1">出版社： </label><label class="label2"> {{item.publisher}}</label>
                        <br>
                        <label class="label1">出版日期： </label><label class="label2"> {{item.publishDate}}</label>
                        <br>
                        <label class="label1">字数： </label><label class="label2"> {{item.words}} 万</label>
                        <br>
                        <div style="margin-top: 20px;">
                            <Button class="button1" size="large" type="primary" @click="addCart">加入购物车</Button>
                            <Button class="button1" size="large" type="error">立即购买</Button>
                        </div>
                    </Col>
                </Row>
                <Row style="margin-top: 60px">
                    <Tabs value="name1">
                        <TabPane label="读书简介" name="name1"><p style="white-space: pre-line;">{{item.abstraction}}</p></TabPane>
                        <TabPane label="目录" name="name2"><p style="white-space: pre-line;">{{item.catalogue}}</p></TabPane>
                        <TabPane label="累计评价" name="name3">评价功能暂未开发</TabPane>
                    </Tabs>
                </Row>
            </Col>
            <Col span="4">
                <Card :bordered="false">
                    <p slot="title">相似好书推荐</p>
                    <p>这个地方还没做<br>其实蛮简单的<br>但是自己编数据很麻烦<br>所以先放放
                    </p>
                </Card>
            </Col>
        </Row>
    </Card>
</template>

<script>

    import axios from 'axios'

    export default {
        name: "BookAbstract",
        props: {
            title: String,
            author: String,
            price: Number,
        },
        data () {
            return {
                ID: '',
                cover: '',
                item: {
                    "abstraction": "",
                    "catalogue": ""
                },
                basic: {}
            }
        },
        methods: {
            addCart() {
                // console.log(111);
                let amount= JSON.parse(sessionStorage.getItem(this.ID));
                if (amount !== null) {
                    amount = parseInt(amount) + 1;
                    sessionStorage.setItem(this.ID, amount.toString());
                }else
                sessionStorage.setItem(this.ID, '1');
            }
        },
        mounted: function () {
            this.ID = this.$route.params.ID;
            axios.get('http://localhost:8088/book/information?ID='+this.ID.toString())
                .then((response) => {
                    this.item = response.data;
                    this.item.abstraction = this.item.abstraction.replace(/\\n/g, "\n");
                    this.item.catalogue = this.item.catalogue.replace(/\\n/g, "\n");
                }).catch((error) => {
                console.log(error);
            });

            this.cover = require('../assets/'+this.ID+'_ii_cover.jpg')
        }
    }
</script>

<style scoped>
    @import "../assets/css/Adjustment.css";

</style>