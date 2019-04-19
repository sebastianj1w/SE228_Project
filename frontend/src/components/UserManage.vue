<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入用户名以开始检索...">
        <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="userListShow"></Table>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "Books",
        components: {
            // Abstract
        },
        data() {
            return {
                searchConName1: '',
                tableHeight: 450,
                columns1: [
                    {
                        title: '用户名',
                        key: 'id',
                    },
                    {
                        title: '邮箱',
                        key: 'mail'
                    },
                    {
                        title: '身份',
                        key: 'iden'
                    },
                    {
                        title: '是否被禁用',
                        key: 'ban',
                        width:100,
                    },
                    {
                        title: '操作',
                        key: 'action',
                        width: 150,
                        align: 'center',
                        render: (h, params) => {
                            return h('div', [
                                h('Button', {
                                    props: {
                                        type: (params.row.ban)?'primary':'error',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.$Message.success((params.row.ban)?'已解除禁用!':'已禁止使用！');
                                            let ID = params.row.id;
                                            // console.log('http://localhost:8088/user/ban?id='+ID+'&op='+params.row.ban===1)
                                            axios.get('http://localhost:8088/user/ban?id='+ID+'&op='+((params.row.ban)?'0':'1'))
                                                .then((response) => {
                                                    this.updateInfo();
                                                })
                                                .catch((error) => {
                                                console.log(error);
                                            });
                                        }
                                    }
                                }, (params.row.ban)?'解禁':'禁用')
                            ]);
                        }
                    }
                ],
                userList: [],
                userListShow: []
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
                this.userListShow = this.userList;
                this.userListShow = this.search(this.userList, {ID: this.searchConName1});
            },
            updateInfo() {
                axios.get('http://localhost:8088/user/list')
                    .then((response) => {
                        this.userList = response.data;
                        this.userListShow = this.userList;
                    }).catch((error) => {
                    console.log(error);
                });
            }
        },
        mounted() {
            axios.get('http://localhost:8088/user/list')
                .then((response) => {
                    this.userList = response.data;
                    this.userListShow = this.userList;
                }).catch((error) => {
                console.log(error);
            });
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
        },
    }
</script>

<style scoped>

</style>