<template>
    <div>
        <label>用户名 </label><label>{{userInfo.id}}</label><br>
        <label>用户身份 </label><label>{{(userInfo.iden==='user')?'用户':'管理员'}}</label><br>
        <label>邮箱 </label><label>{{userInfo.mail}}</label><br>
        <label>用户状态 </label><label>{{!userInfo.ban?('正常'):('已禁用')}}</label><br>
    </div>
</template>

<script>
    import axios from 'axios'

    export default {
        name: "UserInfo",
        props: ['username'],
        data() {
            return {
                userInfo: {
                    id: '',
                    iden: '',
                    mail: '',
                    ban: false,
                },
            }
        },
        mounted() {
            console.log(12321432);
            axios.get('http://localhost:8088/user/detail?id='+this.username)
                .then((response) => {
                    // console.log(response);
                    this.userInfo = response.data;
                    // this.$forceUpdate();
                }).catch((error) => {
                console.log(error);
            });
        }
    }
</script>

<style scoped>

</style>