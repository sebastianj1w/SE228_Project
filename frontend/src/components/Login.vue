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
                <Button type="primary" @click="handleLogin()">Sign_in</Button>
            </FormItem>
        </Form>
        <p v-if="success">登录成功，点击确定</p>
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
            // handleSubmit(name) {
            //     this.$refs[name].validate((valid) => {
            //         if (valid) {
            //             // this.$Message.success('Success!');
            //             this.userList = JSON.parse(sessionStorage.getItem("userList"));
            //             for (let i in this.userList) {
            //                 if (this.userList[i].ID === this.formInline.user) {
            //                     if (this.userList[i].ban)
            //                     {
            //                         this.$Message.error('账号已被禁用！');
            //                         break;
            //                     }
            //                     this.success = true;
            //                     sessionStorage.setItem("logUser", this.userList[i].ID);
            //                     sessionStorage.setItem("login", "true");
            //                     break;
            //                 }
            //             }
            //             if (this.success === false) this.$Message.error('登陆失败！');
            //         } else {
            //             this.$Message.error('登陆失败！');
            //         }
            //     })
            // },
            handleLogin() {
                axios.post('http://localhost:8088/api/login',qs.stringify({
                    'username': this.formInline.user,
                    'password': this.formInline.password
                })).then((response) => {
                    let status = response.data;
                    if(status === 'successful') {
                        this.$router.push('/information');
                    } else {
                        alert(response.data);
                    }
                    console.log(response);
                }).catch((error) => {
                    // console.log(response);
                });
            }
        }
    }
</script>
