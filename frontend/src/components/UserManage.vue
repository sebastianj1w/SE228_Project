<template>
    <div style="min-height: 500px;">
        <Input size="large" v-model="searchConName1" placeholder="输入用户名以开始检索...">
        <Button slot="append" icon="ios-search" @click.prevent="handleSearch"></Button>
        </Input>
        <Table ref="table" :height="tableHeight" :columns="columns1" :data="userListShow"></Table>
    </div>
</template>

<script>
    // import Abstract from './BookDetail.vue'

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
                        key: 'ID',
                    },
                    {
                        title: '邮箱',
                        key: 'mail'
                    },
                    {
                        title: '身份',
                        key: 'identity'
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
                                        type: 'primary',
                                        size: 'small'
                                    },
                                    style: {
                                        marginRight: '5px'
                                    },
                                    on: {
                                        click: () => {
                                            this.$Message.success('已解除禁用!');
                                            let ID = params.row.ID;
                                            for (let i in this.userList){
                                                if (this.userList[i].ID === ID){
                                                    this.userList[i].ban = false;
                                                    sessionStorage.setItem('userList', JSON.stringify(this.userList));
                                                }
                                            }
                                        }
                                    }
                                }, '解禁'),
                                h('Button', {
                                    props: {
                                        type: 'error',
                                        size: 'small'
                                    },
                                    on: {
                                        click: () => {
                                            this.$Message.success('已禁止使用!');
                                            let ID = params.row.ID;
                                            for (let i in this.userList){
                                                if (this.userList[i].ID === ID){
                                                    this.userList[i].ban = true;
                                                    sessionStorage.setItem('userList', JSON.stringify(this.userList));
                                                }
                                            }
                                        }
                                    }
                                }, '禁用')
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
            }
        },
        mounted() {
            this.userList = JSON.parse(sessionStorage.getItem("userList"));
            this.tableHeight = window.innerHeight - this.$refs.table.$el.offsetTop - 100;
            this.userListShow = this.userList;
        },
    }
</script>

<style scoped>

</style>