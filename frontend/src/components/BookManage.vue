<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入书籍标题来开始检索...">
        <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="bookListShow"></Table>
    </div>
</template>

<script>

    export default {
        name: "Books",
        components: {
        },
        data() {
            return {
                searchConName1: '',
                tableHeight: 450,
                columns1: [
                    {
                        title: '标题',
                        key: 'title',
                        render: (h, params) => {
                            let url = '/books/' + params.row.ID;
                            let src = require("../assets/"+params.row.ID + "_ii_cover.jpg");
                            return h('Poptip', {
                                    attrs: {
                                        trigger: "hover",
                                        content: "content"
                                    }
                                },
                                [h('router-link', {
                                    attrs: {
                                        to: url,
                                    }
                                }, params.row.title),h('img', {
                                    attrs: {
                                        src: src,
                                        height: 200,
                                    },
                                    slot: "content",
                                })]
                            )
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
                        key: 'ISBN'
                    },
                    {
                        title: '价格',
                        key: 'price',
                        sortable: true
                    },
                    {
                        title: '当前库存',
                        key: 'stock',
                        width: 120,
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
                bookListShow: [
                    {
                        title: '三体1：地球往事',
                        author: '刘慈欣',
                        price: 16.99
                    },
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
                this.bookListShow = this.bookList;
                this.bookListShow = this.search(this.bookList, {title: this.searchConName1});
            },
        },
        mounted() {
            this.bookList = JSON.parse(sessionStorage.getItem("bookList"));
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.bookListShow = this.bookList;
        },
    }
</script>

<style scoped>

</style>