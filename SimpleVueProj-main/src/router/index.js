import { createRouter, createWebHashHistory } from 'vue-router'
import Registration from "@/views/RegistrationUser";
import HomeAdmin from "@/views/HomeAdmin";
import WelcomePage from "@/views/WelcomePage";
import LoginPage from "@/views/LoginPage";
import AddProduct from "@/views/AddProduct";
import PrivacyPolicy from "@/views/PrivacyPolicy";
import AllEmployees from "@/views/AllEmployees";
import AddPassword from "@/views/AddPassword";
import EditPage from "@/views/EditPage";
import DeletePage from "@/views/DeletePage";
import AcceptTheGoods from "@/views/AcceptTheGoods";
import ReportPage from "@/views/ReportPage";
import ProductPage from "@/views/ProductPage";
import HomeBoss from "@/views/HomeBoss";
import LeftoversPage from "@/views/LeftoversPage";
import OrderList from "@/views/OrderList";
import HomeStorekeeper from "@/views/HomeStorekeeper";
import WorkPage from "@/views/WorkPage";

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
  },
  {
    path: '/password',
    name: 'password',
    component: AddPassword
  },
  {
    path: '/edit',
    name: 'edit',
    component: EditPage
  },
  {
    path: '/delete',
    name: 'delete',
    component: DeletePage
  },
  {
    path: '/accept',
    name: 'accept',
    component: AcceptTheGoods
  },
  {
    path: '/report',
    name: 'report',
    component: ReportPage
  },
  {
    path: '/products',
    name: 'products',
    component: ProductPage
  },
  {
    path: '/boss',
    name: 'boss',
    component: HomeBoss
  },
  {
    path: '/let',
    name: 'let',
    component: LeftoversPage
  },
  {
    path: '/order',
    name: 'order',
    component: OrderList
  },
  {
    path: '/storekeeper',
    name: 'storekeeper',
    component: HomeStorekeeper
  },
  {
    path: '/work',
    name: 'work',
    component: WorkPage
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
