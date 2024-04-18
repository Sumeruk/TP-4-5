import { createRouter, createWebHashHistory } from 'vue-router'
import Registration from "@/views/RegistrationUser";
import HomeAdmin from "@/views/HomeAdmin";
import WelcomePage from "@/views/WelcomePage";
import LoginPage from "@/views/LoginPage";

const routes = [
  {
    path: '/welcome',
    name: 'welcome',
    component: WelcomePage
  },
  {
    path: '/login',
    name: 'login',
    component: LoginPage
  },
  {
    path: '/',
    name: 'registration',
    component: Registration
  },
  {
    path: '/home',
    name: 'homeAdmin',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: HomeAdmin
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
