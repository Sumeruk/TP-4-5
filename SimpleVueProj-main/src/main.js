import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import VueSelect from "vue-select";

createApp(App).use(router).use(VueSelect).mount('#app')
