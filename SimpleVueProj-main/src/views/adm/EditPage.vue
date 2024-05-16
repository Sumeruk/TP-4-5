<template>
  <div id="Edit">
    <HeadSiteForAdm/>

    <h2>Редактирование</h2>
    <form @submit.prevent="updateEmployer">
      <label for="username">Имя</label>
      <input type="text" id="username" v-model="currentUser.name">

      <label for="usersurname">Фамилия</label>
      <input type="text" id="usersurname" v-model="currentUser.surname">

      <label for="email">Почта</label>
      <input type="email" id="email" v-model="currentUser.email">

      <label for="phone">Номер телефона</label>
      <input type="tel" id="phone" v-model="currentUser.phone">

      <label for="birthdate">Дата Рождения</label>
      <input type="date" id="birthdate" v-model="currentUser.birthday">

      <label for="position">Должность</label>
      <input type="text" id="position" v-model="currentUser.role">

      <button type="submit" @click="updateEmployer">
        Редактирование
      </button>
    </form>
  </div>
</template>

<script>
import HeadSiteForAdm from "@/components/HeadSiteForAdm";
import api from '../../api/api.js';
import router from "@/router";

export default {
  components: {
    HeadSiteForAdm
  },
  data() {
    return {
      currentUser: {
        name: 'Имя',
        surname: 'Фамилия',
        email: 'dd@gmail.com',
        phone:'940',
        birthday:'',
        role:'role',
      },
      id: this.$route.params.id
    }
  },
  created() {
    this.getEmployer();
  },
  methods:{
    getEmployer(){
      api.getEmployer(this.id).then(entity => {
        this.currentUser = entity;
      })
          .catch(error => {
            console.error(error);
          });
    },

    updateEmployer(){
      api.updateEmployer(this.id, this.currentUser).then(response =>{
        console.log(response.data);
        router.push('/employee/allEmployers')
      })
          .catch(error => {
            console.error(error);
          });
    }
  }
}
;
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

form {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  position: relative;
}

h2 {
  margin-top: 50px;
  color: #7B5244;
}

form label {
  margin-bottom: 5px; /* добавляем небольшое расстояние между метками и полями ввода */
}

form input {
  margin-bottom: 10px; /* добавляем небольшое расстояние между полями ввода */
  padding: 8px;
  width: 300px;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
}

.action {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 10px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
