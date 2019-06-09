<template>
    <ul>
        <li v-for="its in followList" style="margin: 5px; list-style-type: none">
            <Card>
                <Row>
                    <label>回复：{{its.to_user}}</label>
                </Row>
                <Row>
                    <p>{{its.content}}</p>
                </Row>
            </Card>
        </li>
    </ul>

</template>

<script>
    export default {
        name: "FollowComment",
        props: {
            comment_id: String,
        },
        data() {
            return {
                followList: [
                    {
                        to
                    }
                ],
            }
        }
    }
</script>

<style scoped>

</style>