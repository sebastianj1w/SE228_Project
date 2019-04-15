/* eslint-disable */
<style scoped>
    @import "../assets/css/Adjustment.css";
</style>
<template>
    <div class="layout">
        <Layout>
            <Header :style="{position: 'fixed', width: '100%'}" style="z-index: 100">
                <Menu mode="horizontal" theme="dark" active-name="1" @on-select="TryLogin">
                    <img class="layout-logo" src="../assets/logo.png"/>
                    <div class="layout-nav">
                        <router-link to="/home">
                            <MenuItem name="1">
                                <Icon type="ios-navigate"></Icon>
                                主页
                            </MenuItem>
                        </router-link>
                        <router-link to="/books">
                            <MenuItem name="2">
                                <Icon type="ios-keypad"></Icon>
                                图书目录
                            </MenuItem>
                        </router-link>
                        <router-link to="/cart">
                            <MenuItem name="7">
                                <Icon type="md-cart"></Icon>
                                购物车
                            </MenuItem>
                        </router-link>
                        <router-link to="/signup">
                            <MenuItem name="3" v-if="!login">
                                <Icon type="ios-analytics"></Icon>
                                注册
                            </MenuItem>
                        </router-link>
                            <MenuItem name="4" v-if="!login">
                                <Icon type="ios-paper"></Icon>
                                登录
                            </MenuItem>
                        <router-link :to="'/user/'+this.logUser">
                            <MenuItem name="5" v-if="login">
                                <Icon type="md-home"></Icon>
                                我的主页
                            </MenuItem>
                        </router-link>
                        <router-link to="/home">
                            <MenuItem name="6" v-if="login">
                                <Icon type="ios-paper"></Icon>
                                退出
                            </MenuItem>
                        </router-link>
                    </div>
                </Menu>
            </Header>
            <!-- router-link 定义点击后导航到哪个路径下 -->
            <router-link to="/hello">Hello</router-link>
            <!-- 对应的组件内容渲染到router-view中 -->

            <Content :style="{margin: '88px 20px 0',  minHeight: '500px', }">
                <Row type="flex" justify="center" style="min-height: 500px;margin-top: 20px">
                    <Col span="20" style="background: #ffffff; max-width: 1600px">
                        <router-view style="min-height: 500px;z-index: 0">
                            <!--main page-->
                            <!--books view-->
                            <!--sign up-->
                        </router-view>
                    </Col>
                </Row>
                <Drawer title="登录" :closable="false" v-model="loginDrawer">
                    <Login ref="Login"></Login>
                </Drawer>
            </Content>
            <Footer class="layout-footer-center">2019-2020 &copy; Sebastianj1w</Footer>
        </Layout>
    </div>
</template>
<script>
    import Login from './Login.vue'
    import axios from 'axios'
    // import Books from './Books.vue'

    export default {
        components: {
            Login,
            // Books
        },
        data() {
            return {
                login: false,
                loginDrawer: false,
                cart: [],
                logUser: "",
                orderList: [
                    {
                        order_no: "A3772",
                        userID: "Auser",
                        title: "尼采哲学经典(套装共5册)",
                        ISBN: 9787548420460,
                        price: 9.99,
                        amount: 2,
                        total: 19.98,
                    }
                ]
            }
        },
        methods: {
            TryLogin(name) {
                if (name === '4')
                    this.loginDrawer = true;
                if (name === '6') {
                    this.login = false;
                    sessionStorage.setItem("login","false");
                    this.$refs.Login.success = false;
                }
            },
        },
        mounted: function () {
            axios.get('http://localhost:8088/getBook/all')
                .then((response) => {
                    this.bookList = response.data;
                    sessionStorage.setItem("bookList", JSON.stringify(this.bookList));
                    console.log(response);
                }).catch((error) => {
                console.log(error);
            });
            sessionStorage.setItem("login","false");
            // sessionStorage.setItem("userList", JSON.stringify(this.userList));
            // sessionStorage.setItem("orderList", JSON.stringify(this.orderList));
            // console.log(this.cart);
        },
        updated: function () {
            if((this.login = JSON.parse(sessionStorage.getItem("login"))))
                this.logUser = sessionStorage.getItem("logUser");
            // console.log(this.login);
            // console.log(this.logUser);
        }
    }
</script>
