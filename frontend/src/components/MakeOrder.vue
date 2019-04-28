<template>
    <div>
        <Table style="border: 0" width="100%" ref="table" :columns="columns1"
               :data="bookListShow"></Table>
        <Button type="primary" style="float: right; margin-right: 40px; margin-top: 20px">确认订单</Button>
        <label style="float: right; margin-right: 30px;margin-top: 15px; color: red; font-size: 23px">{{ total }}</label>
        <label style="float: right;margin-top: 20px; font-size: 15px">总计：</label>
    </div>
</template>

<script>
    export default {
        name: "MakeOrder",
        data() {
            return {
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
                        width: 200
                        // sortable: true
                    },
                ],
                bookList: [],
                total: 0,
            }
        },
        mounted: function () {
            this.bookList = JSON.parse(sessionStorage.getItem("bookList"));
            Array.prototype.contains = function (needle) {
                for (let i in this) {
                    if (this[i] === needle) return true;
                }
                return false;
            };
            // this.cart = [];
            // for (let i = 0; i < 100; i++) {
            //     if (sessionStorage.getItem("0000" + i.toString()) === '1') {
            //         this.cart.push("0000" + i.toString());
            //     }
            // }
            // console.log(1);
            let amount = 0;
            for (let arg in this.bookList) {
                // console.log(this.bookList[arg]);
                if ((amount = JSON.parse(sessionStorage.getItem(this.bookList[arg].id))) !== null) {
                    let length = this.bookListShow.push(this.bookList[arg]);
                    this.bookListShow[length-1].amount = amount;
                    this.total += this.bookList[arg].price*amount;
                    // dataClone = res;
                }
            }
            this.total = this.total.toFixed(2);
        }
    }
</script>

<style scoped>

</style>