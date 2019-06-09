/* eslint-disable */
<style scoped>
    @import "assets/css/Adjustment.css";
</style>
<template>
    <Layout>
        <Header :style="{position: 'fixed', width: '100%'}" style="z-index: 100">
            <Menu mode="horizontal" theme="dark" active-name="1" @on-select="TryLogin">
                <img class="layout-logo" src="http://192.168.198.1:8088/image/5cfca553283fe74050128984"/>
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

        <Content :style="{margin: '88px 20px 0',  minHeight: '500px', }">
            <Row type="flex" justify="center" style="min-height: 500px;margin-top: 20px">
                <Col span="20" style="background: #ffffff; max-width: 1600px">
                    <router-view style="min-height: 500px;z-index: 0">
                    </router-view>
                </Col>
            </Row>
        </Content>

        <Drawer title="登录" :closable="false" v-on:success="success(res)" v-model="loginDrawer">
            <Login ref="Login"></Login>
        </Drawer>

        <Footer class="layout-footer-center">2019-2020 &copy; Sebastianj1w</Footer>
    </Layout>
</template>
<script>
    import Login from './components/Login.vue'
    import axios from 'axios/index'
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
            }
        },
        methods: {
            TryLogin(name) {
                if (name === '4')
                    this.loginDrawer = true;
                if (name === '6') {
                    this.login = false;
                    sessionStorage.setItem("login", "false");
                    this.$refs.Login.success = false;
                    this.$router.push('/');
                }
            },
        },
        mounted: function () {
            sessionStorage.setItem("login", "false");
            sessionStorage.setItem("logUser", "");
        },
        updated: function () {
            if ((this.login = JSON.parse(sessionStorage.getItem("login"))))
                this.logUser = sessionStorage.getItem("logUser");
        },
        success(res) {
            console.log(101);
            this.loginDrawer = false;
        }
    }
</script>
