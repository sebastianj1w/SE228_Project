<template>
    <Row style="margin-top: 50px" type="flex" justify="center">
        <Col span="16">
            <label style="width: 100%; display: block; font-size: 40px;text-align: center; margin-bottom: 30px">注册您的账号</label>
            <Signup></Signup>
        </Col>
    </Row>
</template>

<script>
    import Signup from '../components/Signup.vue'

    export default {
        name: "SignupPage",
        components: {
            Signup,
        },
    }
</script>

<style scoped>

</style>