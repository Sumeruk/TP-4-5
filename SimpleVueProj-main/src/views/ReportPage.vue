<template>
  <div id="Report">
    <HeadSiteForBoss />

    <h2>Отчет</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Тип</label>
      <input type="text" id="username" v-model="username">

      <label for="usersurname">Период</label>
      <input type="password" id="usersurname" v-model="usersurname">

    </form>
    <button>
      <router-link to="/password" class="actions">Создать</router-link>
    </button>
  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
export default {
  components:{
    HeadSiteForBoss
  }
};
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

.actions{
  display: block;
  padding: 10px;
  border-radius: 40px;
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

button {
  margin-top: 10px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 90%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
