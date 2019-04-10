<template>
    <!--<Card style="width:100%; height: 400px">-->
        <!--<div style="text-align:center">-->
            <!--<img src="../assets/poster-ex.jpg" style="max-width: 100%; max-height: 100%;">-->
        <!--</div>-->
    <!--</Card>-->
    <Card style="width:100%; height: 400px">
        <p slot="title">
            <Icon type="ios-flame"></Icon>
            最热推荐
        </p>
        <Carousel autoplay v-model="value2" loop dots="outside" class="carouse_out">
        <CarouselItem>
            <div class="demo-carousel">
                <img src="../assets/poster-ex.jpg" class="carouse_img">
            </div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">
                <img src="../assets/poster-ex1.jpg" class="carouse_img">
            </div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">
                <img src="../assets/poster-ex2.jpg" class="carouse_img">
            </div>
        </CarouselItem>
        <CarouselItem>
            <div class="demo-carousel">
                <img src="../assets/poster-ex3.jpg" class="carouse_img">
            </div>
        </CarouselItem>
    </Carousel></Card>
</template>
<script>
    export default {
        data () {
            return {
                value2: 0
            }
        }
    }
</script>
<style scoped>
    .carouse_img {
        width: 100%;
        height: 100%;
        max-height: 300px
    }
    .carouse_out {
        margin-top: 10px;
        width: 100%;
        height: 100%;
    }
</style>
