<template>
    <Form ref="formValidate" :model="formValidate" :rules="ruleValidate" :label-width="80">
        <FormItem label="用户名" prop="name">
            <Input v-model="formValidate.name" placeholder="输入您的用户名"></Input>
        </FormItem>
        <FormItem label="E-mail" prop="mail">
            <Input v-model="formValidate.mail" placeholder="输入您的电子邮件地址"></Input>
        </FormItem>
        <FormItem label="密码" prop="passwd">
            <Input v-model="formValidate.passwd" placeholder="输入密码" type="password"></Input>
        </FormItem>
        <FormItem label="确认密码" prop="passwdCheck">
            <Input v-model="formValidate.passwdCheck" placeholder="再次输入密码" type="password"></Input>
        </FormItem>
        <!--        <FormItem label="生日">-->
        <!--            <Row>-->
        <!--                <Col span="11">-->
        <!--                    <FormItem prop="date">-->
        <!--                        <DatePicker type="date" placeholder="Select date" v-model="formValidate.date"></DatePicker>-->
        <!--                    </FormItem>-->
        <!--                </Col>-->
        <!--                <Col span="2" style="text-align: center"></Col>-->
        <!--                <Col span="11">-->
        <!--                    &lt;!&ndash;<FormItem prop="time">&ndash;&gt;-->
        <!--                    &lt;!&ndash;<TimePicker type="time" placeholder="Select time" v-model="formValidate.time"></TimePicker>&ndash;&gt;-->
        <!--                    &lt;!&ndash;</FormItem>&ndash;&gt;-->
        <!--                </Col>-->
        <!--            </Row>-->
        <!--        </FormItem>-->
        <!--        <FormItem label="性别" prop="gender">-->
        <!--            <RadioGroup v-model="formValidate.gender">-->
        <!--                <Radio label="male">男</Radio>-->
        <!--                <Radio label="female">女</Radio>-->
        <!--            </RadioGroup>-->
        <!--        </FormItem>-->
        <!--        <FormItem label="兴趣" prop="interest">-->
        <!--            <CheckboxGroup v-model="formValidate.interest">-->
        <!--                <Checkbox label="文学著作"></Checkbox>-->
        <!--                <Checkbox label="科学技术"></Checkbox>-->
        <!--                <Checkbox label="教材教辅"></Checkbox>-->
        <!--                <Checkbox label="报纸期刊"></Checkbox>-->
        <!--            </CheckboxGroup>-->
        <!--        </FormItem>-->
        <FormItem>
            <Button type="primary" @click="handleSubmit('formValidate')">Submit</Button>
            <Button @click="handleReset('formValidate')" style="margin-left: 8px">Reset</Button>
        </FormItem>
    </Form>
</template>
<script>
    import axios from 'axios'

    export default {
        data() {
            const validateID = (rule, value, callback) => {
                axios.get('http://localhost:8088/user/conflict?id=' + value)
                    .then((response) => {
                        if (response.data === 'conflict') {
                            callback(new Error('用户名已被占用'));
                            // console.log(response.data);
                            // console.log(response.data==='conflict');
                        }else if (value.length < 4) {
                            callback(new Error('用户名太短'));
                        } else {
                            callback();
                        }
                    }).catch((error) => {
                    console.log(error);
                });
            };
            const validatePass = (rule, value, callback) => {
                if (value.length < 6) {
                    callback(new Error('密码太短'));
                } else {
                    callback();
                }
            };
            const validatePassCheck = (rule, value, callback) => {
                if (value !== this.formValidate.passwd) {
                    callback(new Error('两次输入密码不一致'));
                } else {
                    callback();
                }
            };
            return {
                formValidate: {
                    name: '',
                    mail: '',
                    passwd: '',
                    passwdCheck: '',
                    gender: '',
                    interest: [],
                    date: '',
                },
                ruleValidate: {
                    name: [
                        {required: true, message: '用户名不能为空', trigger: 'blur'},
                        {validator: validateID, trigger: 'blur'}
                    ],
                    mail: [
                        {required: true, message: '邮箱不能为空', trigger: 'blur'},
                        {type: 'email', message: '错误的邮箱地址格式', trigger: 'blur'}
                    ],
                    passwd: [
                        {required: true, message: '密码不能为空', trigger: 'blur'},
                        {validator: validatePass, trigger: 'blur'}
                    ],
                    passwdCheck: [
                        {required: true, message: '请确认密码', trigger: 'blur'},
                        {validator: validatePassCheck, trigger: 'blur'}
                    ],
                    interest: [
                        {required: true, type: 'array', min: 1, message: '最少选择一个', trigger: 'change'},
                        {type: 'array', max: 2, message: '最多选择两个', trigger: 'change'}
                    ],
                }
            }
        },
        methods: {
            handleSubmit(name) {
                this.$refs[name].validate((valid) => {
                    if (valid) {
                        this.$Message.success('注册请求已发送!');
                    } else {
                        this.$Message.error('信息存在错误!');
                    }
                });
                axios.post('http://localhost:8088/user/sign_up', {
                    "id": this.formValidate.name,
                    "mail": this.formValidate.mail,
                    "password": this.formValidate.passwd,
                    "ban": false
                }).then((response) => {
                    console.log(response);
                }).catch((error) => {

                })
            },
            handleReset(name) {
                this.$refs[name].resetFields();
            }
        },
        mounted() {}
    }
</script>
