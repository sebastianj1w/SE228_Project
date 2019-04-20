<template>
    <Form :model="form" label-position="left" :label-width="100">
        <FormItem label="标题" v-if="!showDetail">
            <Input v-model="form.title"></Input>
        </FormItem>
        <FormItem label="价格" v-if="!showDetail">
            <Input v-model="form.price"></Input>
        </FormItem>
<!--        <FormItem label="ID">-->
<!--            <Input v-model="form.input3"></Input>-->
<!--        </FormItem>-->
        <FormItem label="库存" v-if="!showDetail">
            <Input v-model="form.stock"></Input>
        </FormItem>
        <FormItem label="ISBN" v-if="!showDetail">
            <Input v-model="form.isbn"></Input>
        </FormItem>
        <FormItem label="字数" v-if="!showDetail">
            <Input v-model="form.word"></Input>
        </FormItem>
        <FormItem label="作者" v-if="showDetail">
            <Input v-model="form.author"></Input>
        </FormItem>
        <FormItem label="出版社" v-if="showDetail">
            <Input v-model="form.publisher"></Input>
        </FormItem>
        <FormItem label="出版日期" v-if="showDetail">
            <Input v-model="form.publishdate"></Input>
        </FormItem>
        <FormItem label="摘要" v-if="showDetail">
            <Input v-model="form.abstraction"></Input>
        </FormItem>
        <FormItem label="目录" v-if="showDetail">
            <Input v-model="form.catalogue"></Input>
        </FormItem>
        <Button type="primary" @click="changeShow()" v-if="!showDetail">编辑详细信息</Button>
        <Button type="primary" @click="changeShow()" v-if="showDetail">编辑基本信息</Button>
    </Form>
</template>
<script>
    import axios from 'axios'
    export default {
        name: 'BookUpdate',
        props: ['do_submit'],
        data () {
            return {
                // do_submit:0,
                form: {
                    title: '',
                    price: null,
                    author: '',
                    publisher: '',
                    stock: null,
                    isbn: '',
                    words: null,
                    publishdate: '',
                    abstraction: '',
                    catalogue: ''
                },
                showDetail: false,
            }
        },
        mounted: function(){},
        methods: {
            changeShow() {
                this.showDetail = !this.showDetail;
            },
            submitUpdate() {
                // console.log(this.form);
                console.log("submit_update");
                axios.post('http://localhost:8088/book/update',{
                    "id":this.do_submit,
                    "title": (this.form.title!=='')?this.form.title:null,
                    "price": (this.form.price!==null)?this.form.price:null,
                    "author": (this.form.author!=='')?this.form.author:null,
                    "publisher": (this.form.publisher!=='')?this.form.publisher:null,
                    "stock": (this.form.stock!==null)?this.form.stock:null,
                    "isbn": (this.form.isbn!=='')?this.form.isbn:null,
                    "words": (this.form.words!==null)?this.form.words:null,
                    "publishdate": (this.form.publishdate!==0)?this.form.publishdate:null,
                    "abstraction": (this.form.abstraction!=='')?this.form.abstraction:null,
                    "catalogue": (this.form.catalogue!=='')?this.form.catalogue:null,
                }).then((response) => {
                    this.$emit("updated","updated");
                    console.log(response);
                    this.clean_up();
                }).catch((error) => {
                   console.log(error);
                });
            },
            submitInsert() {
                console.log("submit_insert");
                if (this.form.title === "" || this.form.title === null){
                    alert("标题不能为空");
                    return;
                }
                if (this.form.price === 0 || this.form.price === null){
                    alert("价格不能为空");
                    return;
                }
                axios.post('http://localhost:8088/book/new',{
                    "title": (this.form.title!=='')?this.form.title:"null",
                    "price": (this.form.price!==null)?this.form.price:0,
                    "author": (this.form.author!=='')?this.form.author:"null",
                    "publisher": (this.form.publisher!=='')?this.form.publisher:"null",
                    "stock": (this.form.stock!==null)?this.form.stock:null,
                    "isbn": (this.form.isbn!=='')?this.form.isbn:"null",
                    "words": (this.form.words!==null)?this.form.words:null,
                    "publishdate": (this.form.publishdate!==0)?this.form.publishdate:null,
                    "abstraction": (this.form.abstraction!=='')?this.form.abstraction:"null",
                    "catalogue": (this.form.catalogue!=='')?this.form.catalogue:"null",
                }).then((response) => {
                    this.$emit("updated","updated");
                    console.log(response);
                    this.clean_up();
                }).catch((error) => {
                    console.log(error);
                });
            },
            clean_up() {
                this.form.title = '';
                this.form.price = null;
                this.form.author = '';
                this.form.publisher = '';
                this.form.stock = null;
                this.form.isbn = '';
                this.form.words = null;
                this.form.publishdate = '';
                this.form.abstraction = '';
                this.form.catalogue= '';
                this.showDetail = false;
            }
        },
        watch: {
            do_submit: {
                handler() {
                    // console.log(this.do_submit);
                    if (this.do_submit === "cancel") {
                        console.log("do_submit_handler---cleanup");
                        this.clean_up();
                    } else if (this.do_submit === "insert"){
                        console.log("do_submit_handler---insert");
                        this.submitInsert(this.do_submit);
                    } else if (this.do_submit !== "") {
                        console.log("do_submit_handler---update");
                        this.submitUpdate(this.do_submit);
                    }
                }
            }
        }
    }
</script>