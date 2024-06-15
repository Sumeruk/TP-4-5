import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '',
    timeout: 1000,
    headers: {
        "Content-type": "application/json"
    }
});


export default {
    getAllEmployers() {
        return axiosApi.get('/api/employee/allEmployers');
    },
    getEmployer(employerId){
        return axiosApi.get('/api/employee/edit/' + employerId);
    },
    searchEmployers(parameters) {
        return axiosApi.get('/api/employee/allEmployers/search', parameters)
    },
    createUser(user) {
        return axiosApi.post('/api/employee/create', user);
    },
    updateEmployer(employerId, employer) {
        return axiosApi.put('/api/employee/update/' + employerId, employer);
    },
    deleteEmployer(employerId) {
        return axiosApi.delete('/api/employee/delete/' + employerId);
    },
    getAllProducts() {
        return axiosApi.get('/api/products/allProducts');
    },
    getProduct(employerId){
        return axiosApi.get('/api/products/edit/' + employerId);
    },
    createProduct(product){
        return axiosApi.post('/api/products/create', product)
    },
    updateProduct(productId, product) {
        return axiosApi.post('/api/products/update/' + productId, product);
    },
    searchProducts(parameters) {
        return axiosApi.get('/api/products/allProducts/search', parameters)
    },
    deleteProduct(productId) {
        return axiosApi.delete('/api/products/delete/' + productId)
    },
    createOrder(shopId, order){
        return axiosApi.post('/api/order/newOrder/'+ shopId, order)
    },
    getAllOrdersFromShopWithShopId(shopId){
        return axiosApi.get('/api/order/getOrders/'+ shopId);
    },
    getProductsFromOrder(shopId, orderId) {
        return axiosApi.get('/api/order/getOrders/'+ shopId + '/' + orderId);
    },
    setProductFromDelivery(product) {
        return axiosApi.put('/api/products/setProducts', product);
    },
    getOrderForBoss(){
        return axiosApi.get('/api/order/getLastOrder/');
    },
    getJobForEmployer(orderId, employerId) {
        return axiosApi.post('/api/employer/getJobForEmployer/', orderId, employerId);
    },
    getEmployersForJob() {
        return axiosApi.get('/api/employee/getEmployersForJob')
    },
    setOrderFromEmployer(orderId){
        return axiosApi.put('/api/employee/setOrder', orderId)
    }
}