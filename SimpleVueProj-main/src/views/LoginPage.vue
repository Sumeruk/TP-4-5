<template>
  <div class="login-page">
    <form>
      <h2>Авторизация</h2>
      <h1>Добро пожаловать</h1>
      <label for="username">Электронная почта</label>
      <input type="text" id="username" name="username" required>

      <label for="password">Пароль</label>
      <input type="password" id="password" name="password" required>

      <button>
        <router-link to="/home">Авторизоваться</router-link>
      </button>
    </form>
  </div>
</template>

<script>
export default {
  name: 'LoginPage'
};
</script>

<style scoped>
/*.login-page {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 5px;
  background-color: #f9f9f9;
}*/

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

h1 {
  color: #7B5244;
}

label {
  margin-bottom: 5px;
}

input, button {
  margin-bottom: 10px;
  padding: 8px;
}

button {
  margin-top: 10px;
  padding: 10px 60px;
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