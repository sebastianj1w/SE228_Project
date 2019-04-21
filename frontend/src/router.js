import Vue from "vue";
import VueRouter from "vue-router";
// 引入组件
import Home from "./components/Home.vue";
import Books from "./components/Books.vue";
import BookManage from "./components/BookManage.vue";
import UserManage from "./components/UserManage.vue"
import BookDetail from "./components/BookDetail.vue";
import Signup from "./components/SignupPage.vue";
import Cart from "./components/Cart.vue";
import UserHome from "./components/UserHome.vue";
import NonePage from "./components/NonePage.vue";
import UserHello from "./components/UserHello.vue";
import Statistics from "./components/Statistics.vue";
import OrderManager from "./components/OrderManage.vue";
import UserOrder from "./components/UserOrder.vue";
import MakeOrder from "./components/MakeOrder.vue";

// 要告诉 vue 使用 vueRouter
Vue.use(VueRouter);

const routes = [
    {
        path: "/home",
        component: Home
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
                component: NonePage,
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
    }
];

let router = new VueRouter({
    routes
});
export default router;
