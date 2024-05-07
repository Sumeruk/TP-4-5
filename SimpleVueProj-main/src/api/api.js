import axios from 'axios';

const axiosApi = axios.create({
    baseURL: '/api',
    timeout: 1000,
    headers: { 'Content-Type': 'application/json' }
});

class User {
    constructor(id, firstName, lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}

export default {
    hello() {
        return axiosApi.get('/hello');
    },
    getUser(userId) {
        return axiosApi.get('/user/' + userId)
            .then(response => {
                const userData = response.data;
                return new User(userData.id, userData.firstName, userData.lastName);
            });
    },
    createUser(firstName, lastName) {
        return axiosApi.post('/user/' + firstName + '/' + lastName);
    },
}