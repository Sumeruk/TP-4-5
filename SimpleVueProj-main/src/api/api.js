import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '',
    timeout: 5000,
    headers: {
        "Content-type": "application/json"
    }
});

//const token = localStorage.getItem("jwtToken");
//const token = 1212;
// window.localStorage.removeItem("jwtToken");
//console.log(token);

axiosApi.interceptors.request.use(
    (config) => {
        console.log("Request config:", config);
        // Если токен существует, добавляем его в заголовок авторизации
        if (localStorage.getItem("jwtToken")) {
            config.headers.Authorization = `Bearer ${localStorage.getItem("jwtToken")}`;
        }
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

export default {
    login(user){
        return axiosApi.post("/api/auth/login", user)
    },
    logout(userId){
        return axiosApi.post("/api/auth/logout", userId)
    },
    getAllEmployers() {
        return axiosApi.get('/api/employee/adm/allEmployers');
    },
    getEmployer(employerId) {
        return axiosApi.get('/api/employee/adm/edit/' + employerId);
    },
    searchEmployers(parameters) {
        return axiosApi.get('/api/employee/adm/allEmployers/search?parameters=' + parameters);
    },
    createUser(user) {
        return axiosApi.post('/api/employee/adm/create', user);
    },
    updateEmployer(employerId, employer) {
        return axiosApi.put('/api/employee/adm/update/' + employerId, employer);
    },
    deleteEmployer(employerId) {
        return axiosApi.delete('/api/employee/adm/delete/' + employerId);
    },
    getAllProducts() {
        return axiosApi.get('/api/products/allProducts');
    },
    getAllProductsForSearch() {
        return axiosApi.get('/api/products/allProducts/searchAllProducts');
    },
    getProduct(employerId) {
        return axiosApi.get('/api/products/adm/edit/' + employerId);
    },
    createProduct(product) {
        return axiosApi.post('/api/products/adm/create', product)
    },
    updateProduct(productId, product) {
        return axiosApi.put('/api/products/adm/update/' + productId, product);
    },
    searchProducts(search) {
        return axiosApi.get('/api/products/allProducts/search?search=' + search)
    },
    deleteProduct(productId) {
        return axiosApi.delete('/api/products/adm/delete/' + productId)
    },
    createOrder(shopId, order) {
        return axiosApi.post('/api/order/shop/newOrder/' + shopId, order)
    },
    getAllOrdersFromShopWithShopId(shopId) {
        return axiosApi.get('/api/order/shop/getOrders/' + shopId);
    },
    getProductsFromOrder(shopId, orderId) {
        return axiosApi.get('/api/order/getOrders/' + shopId + '/' + orderId);
    },
    setProductFromDelivery(product) {
        return axiosApi.put('/api/products/boss/setProducts', product);
    },
    getOrderForBoss() {
        return axiosApi.get('/api/order/boss/getLastOrder');
    },
    getJobForEmployer(employerId) {
        return axiosApi.put('/api/employee/boss/makeEmployerWorking/' + employerId);
    },
    setEmployerToOrder(orderId, employerId) {
        return axiosApi.put('/api/order/boss/setEmployerToOrder/' + orderId + '/' + employerId);
    },
    getEmployersForJob() {
        return axiosApi.get('/api/employee/boss/getEmployersForJob')
    },
    setOrderFromEmployer(orderId) {
        return axiosApi.put('/api/employee/setOrder', orderId)
    }
}