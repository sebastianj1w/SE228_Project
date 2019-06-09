<template>
    <div>
        <ul v-if="notNull" style="margin: 20px; font-size: 14px;">
            <li v-for="item in commentList" style="margin: 5px; list-style-type: none">
                <Card>
                    <Row style="font-size: 14px">
                        <Col span="20">用户名： {{item.userid}}</Col>
                        <Col span="4">字数： {{item.size}}</Col>
                    </Row>
                    <Divider/>
                    <Row>
                        <p>{{item.content}}</p>
                    </Row>

                </Card>
            </li>
        </ul>
        <Card v-if="!notNull">
            <p>暂无评价</p>
        </Card>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "BookComment",
        props: {
            'Bid': String,
        },
        data() {
            return {
                commentList: [],
                notNull: true,
            }
        },
        mounted: function () {
            console.log("bid" + this.Bid);
            axios.get("http://localhost:8088/comment/getByBook?Bid=" + this.Bid)
                .then((response) => {
                    console.log(response);
                    this.commentList = response.data;
                    if (this.commentList.length === 0) this.notNull = false;
                })
        },
        methods: {
            getComment() {
                console.log("bid" + this.Bid);
                axios.get("http://localhost:8088/comment/getByBook?Bid=" + this.Bid)
                    .then((response) => {
                        console.log(response);
                        this.commentList = response.data;
                    })
            }
        },
        watch: {
            Bid: {
                handler() {
                    this.getComment();
                }
            }
        }
    }
</script>

<style scoped>

</style>