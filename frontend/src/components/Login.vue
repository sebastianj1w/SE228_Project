<template>
    <div>
        <Form v-if="!success" ref="formInline" :model="formInline" :rules="ruleInline" inline>
            <FormItem prop="user">
                <Input type="text" v-model="formInline.user" placeholder="Username">
                    <Icon type="ios-person-outline" slot="prepend"></Icon>
                </Input>
            </FormItem>
            <FormItem prop="password">
                <Input type="password" v-model="formInline.password" placeholder="Password">
                    <Icon type="ios-lock-outline" slot="prepend"></Icon>
                </Input>
            </FormItem>
            <FormItem>
                <Button type="primary" @click="handleLogin()">登录</Button>
                <label style="margin: 5px;" v-if="tried===true">{{msg}}</label>
            </FormItem>
        </Form>
        <p v-if="success">登录成功，点击其他部分继续浏览</p>
    </div>
</template>
<script>
    import axios from 'axios'
    import qs from 'qs'

    export default {
        data() {
            return {
                userList: [],
                success: false,
                msg: "",
                tried: false,
                formInline: {
                    user: '',
                    password: ''
                },
                ruleInline: {
                    user: [
                        {required: true, message: 'Please fill in the user name', trigger: 'blur'}
                    ],
                    password: [
                        {required: true, message: 'Please fill in the password.', trigger: 'blur'},
                        {
                            type: 'string',
                            min: 3,
                            message: 'The password length cannot be less than 6 bits',
                            trigger: 'blur'
                        }
                    ]
                }
            }
        },
        methods: {
            handleLogin() {
                this.tried = true;
                axios.post('http://localhost:8088/api/login', {
                    "id": this.formInline.user,
                    "password": this.formInline.password
                }).then((response) => {
                    let status = response.data;
                    if (status === 'successful') {
                        this.success = true;
                        this.banned = false;
                        this.$emit('success',false);
                    } else if (status === 'banned') {
                        this.banned = true;
                        this.msg = '用户已被禁用！';
                    } else {
                        this.msg = '用户名和密码不匹配！';
                    }
                }).catch((error) => {
                    console.log(error);
                });
            }
        },
        updated: function () {
            if (!this.success) return;
            console.log("1");
            sessionStorage.setItem("logUser", this.formInline.user);
            sessionStorage.setItem("login", "true");
        }
    }
</script>
