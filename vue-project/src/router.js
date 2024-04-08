import Vue from 'vue';
import Router from 'vue-router';
import HomeAdmin from './components/HomeAdmin.vue';
import AddProduct from './components/AddProduct.vue';
import Registration from './components/Registration.vue';

Vue.use(Router);

export default new Router({
  routes: [
    {
      path: '/',
      name: 'HomeAdmin',
      component: HomeAdmin
    },
    {
      path: '/AddProduct',
      name: 'AddProduct',
      component: AddProduct
    },
    {
      path: '/Registration',
      name: 'Registration',
      component: Registration
    }
  ]
});
