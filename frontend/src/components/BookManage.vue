<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入书籍标题来开始检索...">
            <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="bookListShow"></Table>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "Books",
        components: {},
        data() {
            return {
                searchConName1: '',
                // tableHeight: 450,
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
                            let src = require("../assets/" + params.row.id + "_ii_cover.jpg");
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
                    // {
                    //     title: '出版社',
                    //     key: 'publisher'
                    // },
                    {
                        title: 'ISBN',
                        key: 'isbn'
                    },
                    {
                        title: '价格',
                        key: 'price',
                        width: 80,
                        sortable: true
                    },
                    {
                        title: '库存',
                        key: 'stock',
                        width: 80,
                        sortable: true
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 145,
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
                                }, '修改库存'),
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
                this.bookListShow = this.search(this.bookList, {title: this.searchConName1});
            },
        },
        mounted() {
            axios.get('http://localhost:8088/book/all')
                .then((response) => {
                    this.bookList = response.data;
                    this.bookListShow = this.bookList;
                }).catch((error) => {
                console.log(error);
            });
            // this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.bookListShow = this.bookList;
        },
    }
</script>

<style scoped>

</style>