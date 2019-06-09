<template>
    <Row>
        <Col span="4">
            <Left></Left>
        </Col>
        <Col span="16">
            <Poster></Poster>
        </Col>
        <Col span="4">
            <Card></Card>
        </Col>
    </Row>
</template>

<script>
    import Card from '../components/PromotionCard.vue'
    import Poster from '../components/Poster.vue'
    import Left from '../components/LeftMenu.vue'

    export default {
        components: {
            Card,
            Poster,
            Left
        },
        name: "Home"
    }
</script>

<style scoped>

</style>