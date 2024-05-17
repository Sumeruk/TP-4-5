import { createRouter, createWebHashHistory } from 'vue-router'
import Registration from "@/views/adm/RegistrationUser";
//import HomeAdmin from "@/views/HomeAdmin";
import WelcomePage from "@/views/WelcomePage";
import LoginPage from "@/views/LoginPage";
import AddProduct from "@/views/adm/AddProduct";
import PrivacyPolicy from "@/views/PrivacyPolicy";
import AllEmployees from "@/views/adm/AllEmployees";
import AddPassword from "@/views/adm/AddPassword";
import EditPage from "@/views/adm/EditPage";
import DeletePage from "@/views/adm/DeletePage";
import AcceptTheGoods from "@/views/boss/AcceptTheGoods";
import ReportPage from "@/views/boss/ReportPage";
import ProductPage from "@/views/adm/ProductPage";
import HomeBoss from "@/views/boss/HomeBoss";
import LeftoversPage from "@/views/boss/LeftoversPage";
import OrderList from "@/views/adm/OrderList";
import HomeStorekeeper from "@/views/strorekeeper/HomeStorekeeper";
import WorkPage from "@/views/strorekeeper/WorkPage";
import HomeAdmin from "@/views/adm/HomeAdmin";
import GetJob from "@/views/boss/GetJob";
import ShopHome from "@/views/shop/ShopHome";
import AddProductToOrder from "@/views/shop/AddProductToOrder";
import RecentOrders from "@/views/shop/RecentOrders";
import EditProduct from "@/views/adm/EditProduct";
import OldOrder from "@/views/shop/OldOrder";

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
    path: '/employee/newUser',
    name: 'registration',
    component: Registration
  },
  {
    path: '/product/addProduct',
    name: 'product',
    component: AddProduct
  },
    //todo создать страницу обновления товара
  {
    path: '/product/edit/:id',
    name: 'editProduct',
    component: EditProduct
  },
  {
    path: '/adminProduct',
    name: 'admProd',
    component: ProductPage
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
    path: '/order/newOrder/:shopId',
    name: 'newOrder',
    component: AddProductToOrder
  },
  {
    path: '/shop/oldOrder/:shopId/:orderId',
    name: 'oldOrder',
    component: OldOrder
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
    path: '/orders/recentOrders/:shopId',
    name: 'recentOrders',
    component: RecentOrders
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
