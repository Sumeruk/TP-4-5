import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '/stockTrack',
    timeout: 1000,
});


export default {
    getAllEmployers() {
        return axiosApi.get('/employee/allEmployers');
    },
    getEmployer(employerId){
        return axiosApi.get('/employee/edit/' + employerId);
    },
    createUser(firstName, lastName) {
        return axiosApi.post('/user/' + firstName + '/' + lastName);
    },
    updateEmployer(employerId, employer) {
        return axiosApi.post('/employee/edit/' + employerId, employer);
    }
}