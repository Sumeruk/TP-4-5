import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '/stockTrack',
    timeout: 1000,
    headers: {
        "Content-type": "application/json"
    }
});


export default {
    getAllEmployers() {
        return axiosApi.get('/employee/allEmployers');
    },
    getEmployer(employerId){
        return axiosApi.get('/employee/edit/' + employerId);
    },
    searchEmployers(parameters) {
        return axiosApi.get('/employee/allEmployers', parameters)
    },
    createUser(user) {
        return axiosApi.post("/employee/edit/", user);
    },
    updateEmployer(employerId, employer) {
        return axiosApi.post('/employee/edit/' + employerId, employer);
    },
    deleteEmployer(employerId) {
        return axiosApi.delete('/employee/edit/' + employerId);
    },
    getAllProducts() {
        return axiosApi.get('/products/allProducts');
    },
    getProduct(employerId){
        return axiosApi.get('/product/edit/' + employerId);
    },
    createProduct(product){
        return axiosApi.post("/products/edit/", product)
    },
    updateProduct(employerId, employer) {
        return axiosApi.post('/products/edit/' + employerId, employer);
    },
    searchProducts(parameters) {
        return axiosApi.get('/products/allProducts', parameters)
    },
    deleteProduct(productId) {
        return axiosApi.delete('/product/edit/' + productId)
    }
}