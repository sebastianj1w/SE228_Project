<style scoped>
    .expand-row{
        margin-bottom: 16px;
    }
</style>
<template>
    <div>
        <Table ref="table" :columns="columns1" :data="itemList"></Table>
    </div>
</template>
<script>
    export default {
        props: {
            itemList: Object
        },
        data() {
            return {
                // itemList: [],
                columns1: [
                    {
                        title: '所购书名',
                        key: 'bookid'
                    },
                    {
                        title: '单价',
                        key: 'value',
                        sortable: true
                    },
                    {
                        title: '数量',
                        key: 'amount',
                        sortable: true
                    },
                ],
            }
        }
    };
</script>