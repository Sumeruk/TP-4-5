import { createRouter, createWebHashHistory } from 'vue-router'
import Registration from "@/views/RegistrationUser";
import HomeAdmin from "@/views/HomeAdmin";
import WelcomePage from "@/views/WelcomePage";
import LoginPage from "@/views/LoginPage";
import AddProduct from "@/views/AddProduct";
import PrivacyPolicy from "@/views/PrivacyPolicy";
import AllEmployees from "@/views/AllEmployees";

const routes = [
  {
    path: '/',
    name: 'welcome',
    component: WelcomePage
  },
  {
    path: '/login',
    name: 'login',
    component: LoginPage
  },
  {
    path: '/registration',
    name: 'registration',
    component: Registration
  },
  {
    path: '/product',
    name: 'product',
    component: AddProduct
  },
  {
    path: '/home',
    name: 'homeAdmin',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: HomeAdmin
  },
  {
    path: '/policy',
    name: 'policy',
    component: PrivacyPolicy
  },
  {
    path: '/employees',
    name: 'employees',
    component: AllEmployees
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
