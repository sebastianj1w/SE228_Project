<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入以开始搜索...">
            <Select v-model="key" slot="prepend" style="width: 80px">
                <Option value="title">书名</Option>
                <Option value="author">作者</Option>
                <Option value="publisher">出版社</Option>
                <!--<Option value="ISBN">ISBN</Option>-->
                <Option value="poly">聚合</Option>
            </Select>
            <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table"  :columns="columns1" :data="bookListShow"></Table>
    </div>
</template>

<script>
    // import Abstract from './BookDetail.vue'
    import axios from 'axios'

    export default {
        name: "Books",
        components: {
            // Abstract
        },
        data() {
            return {
                key: "title",
                searchConName1: '',
                tableHeight: 450,
                columns1: [
                    {
                        title: '封面',
                        render: (h, params) => {
                            let url = '/books/' + params.row.id;
                            let src = require("../assets/" + params.row.id + "_ii_cover.jpg");
                            // console.log(src);
                            return h('img', {
                                    attrs: {
                                        src: src,
                                        height: 100,
                                        width: 70,
                                        style: "margin-top: 3px;"
                                    }
                                }
                            )
                        },
                        width: 93,
                    },
                    {
                        title: '标题',
                        key: 'title',
                        render: (h, params) => {
                            let url = '/books/' + params.row.id;
                            // let src = require("../assets/" + params.row.id + "_ii_cover.jpg");
                            // console.log(src);
                            return h('router-link', {
                                attrs: {
                                    to: url,
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
                        title: 'ISBN',
                        key: 'isbn'
                    },
                    {
                        title: '价格',
                        key: 'price',
                        sortable: true,
                        width: 120,
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 250,
                        align: 'center',
                        render: (h, params) => {
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
                                            this.addToCart(params.row.id);
                                        }
                                    }
                                }, '加入购物车'),
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
                                }, '立即购买')
                            ]);
                        }
                    }
                ],
                bookList: [],
                bookListShow: []
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
                this.bookListShow = this.bookList;
                if (this.key === "title")
                    this.bookListShow = this.search(this.bookList, {title: this.searchConName1});
                else if (this.key === "author")
                    this.bookListShow = this.search(this.bookList, {author: this.searchConName1});
                else if (this.key === "publisher")
                    this.bookListShow = this.search(this.bookList, {publisher: this.searchConName1});
                else if (this.key === "poly") {
                    this.bookListShow = this.search(this.bookList, {title: this.searchConName1});

                    let temp = this.search(this.bookList, {author: this.searchConName1});
                    if (temp != null)
                        this.bookListShow = this.bookListShow.concat(temp);

                    temp = this.search(this.bookList, {publisher: this.searchConName1});
                    if (temp != null)
                        this.bookListShow = this.bookListShow.concat(temp);

                    temp = []; //一个新的临时数组
                    for (let i = 0; i < this.bookListShow.length; i++) {
                        if (temp.indexOf(this.bookListShow[i]) === -1) {
                            temp.push(this.bookListShow[i]);
                        }
                    }

                    this.bookListShow = temp;
                }
            },
            addToCart(ID) {
                if (!JSON.parse(sessionStorage.getItem("login"))) {
                    alert("请登录！");
                    return;
                }
                let uid = sessionStorage.getItem("logUser");
                axios.get('http://localhost:8088/user/addcart?Uid='+uid+"&Bid="+ID)
                    .then((response) => {
                        console.log("send add cart request");
                    });
            }
        },
        mounted() {
            axios.get('http://localhost:8088/book/all')
                .then((response) => {
                    this.bookList = response.data;
                    this.bookListShow = this.bookList;

                }).catch((error) => {
                console.log(error);
            });
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.bookListShow = this.bookList;
            // console.log(this.bookListShow);
        },
    }
</script>

<style scoped>

</style>