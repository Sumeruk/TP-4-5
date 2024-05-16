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
    createUser(user) {
        return axiosApi.post("/employee/edit/", user);
    },
    updateEmployer(employerId, employer) {
        return axiosApi.post('/employee/edit/' + employerId, employer);
    },
    deleteEmployer(employerId) {
        return axiosApi.delete('/employee/edit/' + employerId);
    }
}