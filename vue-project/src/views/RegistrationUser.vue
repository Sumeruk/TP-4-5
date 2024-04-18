<template>
  <div id="Registration">
    <form @submit.prevent="submitForm">
      <h2>Новый аккаунт</h2>
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
        <router-link to="/home">Зарегистрироваться</router-link>
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
  position: absolute; /* Сделать заголовок абсолютно позиционированным */
  top: -40px; /* Расположить его сверху */
  left: 50%; /* Разместить в середине горизонтально */
  transform: translateX(-50%); /* Центрировать относительно себя */
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
