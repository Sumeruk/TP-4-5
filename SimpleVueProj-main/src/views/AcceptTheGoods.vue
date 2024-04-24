<template>
  <div id="Registration">
    <div class="header">
      <router-link to="/home">
        <img src="./assect/Home.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/registration">
        <img src="./assect/Profile.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/product">
        <img src="./assect/Add.jpg" alt="StockTrack Pro Logo">
      </router-link>
    </div>

    <h2>Принять товар</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Название</label>
      <input type="text" id="username" v-model="username">

      <label for="usersurname">Количество</label>
      <input type="password" id="usersurname" v-model="usersurname">


      <input type="submit" value="Добавить товар">

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

input[type="submit"] {
  margin-top: 10px;
  padding: 10px 60px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
input[type="submit"]:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
