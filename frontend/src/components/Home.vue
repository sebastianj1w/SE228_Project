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
    import Card from './PromotionCard.vue'
    import Poster from './Poster.vue'
    import Left from './LeftMenu.vue'

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