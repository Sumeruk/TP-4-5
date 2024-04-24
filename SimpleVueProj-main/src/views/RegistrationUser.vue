<template>
  <div id="Registration">
    <div class="header">
      <router-link to="/home">
        <img src="./assect/Home.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/employees">
        <img src="./assect/Profile.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/products">
        <img src="./assect/Add.jpg" alt="StockTrack Pro Logo">
      </router-link>
    </div>

    <h2>Новый аккаунт</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Имя</label>
      <input type="text" id="username" v-model="username">

      <label for="usersurname">Фамилия</label>
      <input type="text" id="usersurname" v-model="usersurname">

      <label for="email">Почта</label>
      <input type="email" id="email" v-model="email">

      <label for="phone">Номер телефона</label>
      <input type="tel" id="phone" v-model="phone">

      <label for="birthdate">Дата Рождения</label>
      <input type="date" id="birthdate" v-model="birthdate">

      <label for="position">Должность</label>
      <input type="text" id="position" v-model="position">

      <button>
        <router-link to="/password">Зарегистрироваться</router-link>
      </button>

    </form>
  </div>
</template>

<script>
export default {
  // Логика компонента
};
</script>

<style>

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

#app {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
}

.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  padding: 5px 10px;
  background-color: #D3AFAA;
  border-bottom: 1px solid #ccc;
}

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

form button {
  margin-top: 10px;
  padding: 10px 60px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;

  /*padding: 10px 20px;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
  width: 100%;*/

}

form button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
