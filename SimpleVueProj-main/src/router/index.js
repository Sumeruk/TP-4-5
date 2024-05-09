import { createRouter, createWebHashHistory } from 'vue-router'
import Registration from "@/views/RegistrationUser";
//import HomeAdmin from "@/views/HomeAdmin";
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
import HomeAdmin from "@/views/HomeAdmin";
import GetJob from "@/views/GetJob";
import ShopHome from "@/views/ShopHome";

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
    path: '/employee/newEmployee',
    name: 'registration',
    component: Registration
  },
  {
    path: '/product',
    name: 'product',
    component: AddProduct
  },
  {
    path: '/adm',
    name: 'adm',
    component: HomeAdmin
  },
  {
    path: '/home',
    name: 'homeBoss',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: HomeBoss
  },
  {
    path: '/policy',
    name: 'policy',
    component: PrivacyPolicy
  },
  {
    path: '/employee/allEmployers',
    name: 'employees',
    component: AllEmployees
  },
  {
    path: '/password',
    name: 'password',
    component: AddPassword
  },
  {
    path: '/employee/edit/:id',
    name: 'editEmpl',
    component: EditPage
  },
  {
    //-----ATTENTION-WRONG-COMPONENT---------
    //-----SHOULD-BE-REDIRECT-TO-AllEmployees---------
    path: '/employee/delete/:id',
    name: 'deleteEmpl',
    component: DeletePage
  },
  {
    path: '/product/setProducts',
    name: 'accept',
    component: AcceptTheGoods
  },
  {
    path: '/analytics',
    name: 'report',
    component: ReportPage
  },
  {
    path: '/product',
    name: 'products',
    component: ProductPage
  },
  {
    path: '/boss',
    name: 'boss',
    component: HomeBoss
  },
  {
    path: '/product/allProducts',
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
    path: '/orders/toDo',
    name: 'work',
    component: WorkPage
  },
  {
    path: '/orders/getOrders',
    name: 'getJob',
    component: GetJob
  },
  {
    path: '/shop',
    name: 'shop',
    component: ShopHome
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
