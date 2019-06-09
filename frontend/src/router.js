import Vue from "vue";
import VueRouter from "vue-router";
// 引入组件
import Home from "./views/Home.vue";
import Books from "./views/Books.vue";
import BookManage from "./components/BookManage.vue";
import UserManage from "./components/UserManage.vue"
import BookDetail from "./views/BookDetail.vue";
import Signup from "./views/SignupPage.vue";
import Cart from "./views/Cart.vue";
import UserHome from "./views/UserHome.vue";
import NonePage from "./components/NonePage.vue";
import UserHello from "./components/UserHello.vue";
import Statistics from "./components/Statistics.vue";
import OrderManager from "./views/OrderManage.vue";
import UserOrder from "./components/UserOrder.vue";
import MakeOrder from "./views/MakeOrder.vue";
import UserInfo from "./components/UserInfo";
import temp from "./components/temp";
import ConfirmOrder from "./views/ConfirmOrder"

// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

const routes = [
    {
        path: "/home",
        component: Home
    },
    {
        path: "/test",
        component: temp
    },
    {
        path: "/books",
        component: Books
    },
    {
        path: "/books/:ID",
        component: BookDetail
    },
    {
        path: "/user/:ID",
        component: UserHome,
        children: [
            {
                path: '/',
                component: UserHello,
            },
            {
                path: 'book-manage',
                component: BookManage,
            },
            {
                path: 'user-manage',
                component: UserManage,
            },
            {
                path: 'promotion-manage',
                component: NonePage,
            },
            {
                path: 'order-manage',
                component: OrderManager,
            },
            {
                path: 'orders/:state',
                component: UserOrder,
            },
            {
                path: 'my-favorite',
                component: NonePage,
            },
            {
                path: 'statistics',
                component: Statistics,
            },
            {
                path: 'settings',
                component: UserInfo,
            },
            {
                path: 'safety',
                component: NonePage,
            },
            {
                path: 'mail',
                component: NonePage,
            },
            {
                path: 'services',
                component: NonePage,
            },
        ]
    },
    {
        path: "/:page/login",
        component: Home
    },
    {
        path: "/signup",
        component: Signup
    },
    {
        path: "/cart",
        component: Cart
    },
    {
        path: "/doOrder",
        component: MakeOrder
    },
    {
        path: '/',
        redirect: '/home'
    },
    {
        path: '/confirm',
        component: ConfirmOrder
    },
    {
        path: "/confirmB/:ID",
        component: ConfirmOrder
    },
];

let router = new VueRouter({
    routes
});
export default router;
