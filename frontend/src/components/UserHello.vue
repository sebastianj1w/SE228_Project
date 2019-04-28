<template>
    <div style="margin: 20px; font-size: 20px">
        <p>{{ username }}, 您好！</p>
        <p>欢迎来到E-book个人中心！</p>
        <p>点击左侧选项以开始</p>
    </div>

</template>

<script>
    export default {
        name: "UserHello",
        props: ['username']
    }
</script>

<style scoped>

</style>