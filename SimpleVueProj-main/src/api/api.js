import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '/stockTrack',
    timeout: 1000,
});


export default {
    getAllEmployers() {
        return axiosApi.get('/employee/allEmployers');
    },
    createUser(firstName, lastName) {
        return axiosApi.post('/user/' + firstName + '/' + lastName);
    },
}