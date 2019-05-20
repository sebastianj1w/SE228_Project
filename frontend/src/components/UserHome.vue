<template>
    <div style="z-index: 0">
        <Row v-if="login">
            <Col span="5">
                <Menu theme="light" :active-name="a_page" style="z-index: 0;width: 100%;">
                    <MenuGroup title="系统管理" v-if="adminMode">
                        <router-link :to="'/user/'+userID+'/book-manage'">
                            <MenuItem name="11">
                                <Icon type="md-document"/>
                                库存管理
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/order-manage'">
                            <MenuItem name="12">
                                <Icon type="md-cash"/>
                                订单管理
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/promotion-manage'">
                            <MenuItem name="13">
                                <Icon type="md-chatbubbles"/>
                                促销管理
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/user-manage'">
                            <MenuItem name="14">
                                <Icon type="md-checkbox"/>
                                用户管理
                            </MenuItem>
                        </router-link>
                    </MenuGroup>
                    <MenuGroup title="我的订单" v-if="!adminMode">
                        <router-link :to="'/user/'+userID+'/orders/-1'" @click.native="changeState(15)">
                            <MenuItem name="1" @click.native="changeState(15)">
                                <Icon type="md-document"/>
                                全部订单
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/orders/0'" @click.native="changeState(0)">
                            <MenuItem name="2" @click.native="changeState(0)">
                                <Icon type="md-cash"/>
                                待付款
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/orders/1'" @click.native="changeState(1)">
                            <MenuItem name="3"  @click.native="changeState(1)">
                                <Icon type="md-chatbubbles"/>
                                待评价
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/orders/2'" @click.native="changeState(2)">
                            <MenuItem name="4" @click.native="changeState(2)">
                                <Icon type="md-checkbox"/>
                                已完成
                            </MenuItem>
                        </router-link>
                    </MenuGroup>
                    <MenuGroup title="统计分析">
                        <router-link :to="'/user/'+userID+'/my-favorite'">
                            <MenuItem name="5">
                                <Icon type="md-heart"/>
                                我的收藏
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/statistics'">
                            <MenuItem name="6">
                                <Icon type="ios-analytics"/>
                                购书统计
                            </MenuItem>
                        </router-link>
                    </MenuGroup>
                    <MenuGroup title="个人设置">
                        <router-link :to="'/user/'+userID+'/settings'">
                            <MenuItem name="7">
                                <Icon type="ios-information-circle"/>
                                个人信息
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/safety'">
                            <MenuItem name="8">
                                <Icon type="md-lock"/>
                                安全中心
                            </MenuItem>
                        </router-link>
                        <router-link :to="'/user/'+userID+'/mail'">
                            <MenuItem name="9">
                                <Icon type="md-mail"/>
                                收货地址
                            </MenuItem>
                        </router-link>
                    </MenuGroup>
                    <MenuGroup title="售后服务">
                        <router-link :to="'/user/'+userID+'/services'">
                            <MenuItem name="10">
                                <Icon type="md-person"/>
                                联系客服
                            </MenuItem>
                        </router-link>
                    </MenuGroup>
                </Menu>
            </Col>
            <Col span="19">
                <RouterView v-bind:username="userID" v-bind:orderState="orderState" v-bind:userID="userID" v-bind:adminMode="adminMode"></RouterView>
            </Col>
        </Row>
        <p v-if="!login">请登录！</p>
    </div>
</template>

<script>
    import axios from "axios";

    export default {
        name: "UserHome",
        data() {
            return {
                orderState: 0,
                adminMode: false,
                // userList: [],
                // userID: '',
                a_page: '1',
                userInfo: {},
                login: false,
                userID: ''
            }
        },
        methods: {
            changeState(s) {
                this.orderState = s;
                console.log(123456);
            }
        },
        mounted: function () {
            this.userID = this.$route.params.ID;
            this.login = JSON.parse(sessionStorage.getItem("login"));
            let id = sessionStorage.getItem("logUser");
            console.log(id);
            axios.get('http://localhost:8088/user/detail?id='+id)
                .then((response) => {
                this.userInfo = response.data;
                console.log(this.userInfo);
                if(this.userInfo.iden === 'admin') {
                    this.adminMode = true;
                    this.a_page = '11';
                }
                // console.log(response);
            }).catch((error) => {
                console.log(error);
            });
        },
        watch: {
            a_page: {
                handler() {
                    console.log(4444);
                }
            }
        }
    }
</script>

<style scoped>
    a {
        color: dimgray;
    }
</style>