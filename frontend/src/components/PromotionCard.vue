<template>
    <Card style="width:auto; height: 400px;">
        <p slot="title">
            <!--<Icon type="ios-flame"></Icon>-->
            热门活动
        </p>
        <a href="#" slot="extra" @click.prevent="changeLimit">
            <Icon type="ios-loop-strong"></Icon>
            换一批
        </a>
        <ul style="padding-left: 5px; padding-bottom: 10px">
            <li v-for="item in randomPromotionList">
                <a :href="item.url" target="_blank" style="color: #055776" class="links">{{ item.name }}</a>
            </li>
        </ul>
    </Card>
</template>
<script>
    export default {
        data() {
            return {
                promotionList: [
                    {
                        name: '测试版E-book系统',
                        url: 'https://movie.douban.com/subject/1292052/',
                    },
                    {
                        name: '这个地方来展示',
                        url: 'https://movie.douban.com/subject/1295644/',
                    },
                    {
                        name: '展示活动推广内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '有随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击 换一批 即可',
                        url: 'https://movie.douban.com/subject/1292063/',
                    },
                    {
                        name: '展示推广的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '它的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点换一批',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示活动内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '它拥有功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击右上角',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示活动推广的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '有随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击右上角',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示活动推广的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击右上角',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示活动推广的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '有随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击 换一批 即可',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: '点击 换一批 即可',
                        url: 'https://movie.douban.com/subject/1292063/',
                    }, {
                        name: '展示活动推广的内容',
                        url: 'https://movie.douban.com/subject/1291546/',
                    },
                    {
                        name: '随机替换的功能',
                        url: 'https://movie.douban.com/subject/1292720/',
                    },
                    {
                        name: ' 换一批 即可',
                        url: 'https://movie.douban.com/subject/1292063/',
                    },
                    {
                        name: '编不出活动名字',
                        url: 'https://movie.douban.com/subject/1291561/',
                    },
                    {
                        name: '写一下看看效果',
                        url: 'https://movie.douban.com/subject/1295124/',
                    },
                    {
                        name: '这里面的链接',
                        url: 'https://movie.douban.com/subject/1292001/',
                    },
                    {
                        name: '点进去有惊喜',
                        url: 'https://movie.douban.com/subject/2131459/',
                    },
                    {
                        name: '哈哈哈哈哈哈哈哈',
                        url: 'https://movie.douban.com/subject/3541415/',
                    }
                ],
                randomPromotionList: []
            }
        },
        methods: {
            changeLimit() {
                function getArrayItems(arr, num) {
                    const temp_array = [];
                    for (let index in arr) {
                        temp_array.push(arr[index]);
                    }
                    const return_array = [];
                    for (let i = 0; i < num; i++) {
                        if (temp_array.length > 0) {
                            const arrIndex = Math.floor(Math.random() * temp_array.length);
                            return_array[i] = temp_array[arrIndex];
                            temp_array.splice(arrIndex, 1);
                        } else {
                            break;
                        }
                    }
                    // console.log(return_array);
                    return return_array;
                }

                this.randomPromotionList = getArrayItems(this.promotionList, 15);
            }
        },
        mounted() {
            this.changeLimit();
        }
    }
</script>
<style>
    @import "../assets/css/Adjustment.css";
    /*.links {*/
        /*margin-top: 10px;*/
    /*}*/
</style>