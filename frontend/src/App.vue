<template>
    <layout></layout>
</template>

<script>
    import layout from './Layout.vue'
    export default {
        name: 'app',
        components: {
            layout,
        },
        data() {
            return {
                // cart: [],
            }
        }
    }
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
