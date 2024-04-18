<template>
  <div id="home">
    <form @submit.prevent="submitForm">
      <h2>Мой профиль</h2>
      <label for="username">Джон Доу</label>

      <label for="email">Политика конфиденциальности</label>

      <label for="phone">Помощь</label>

      <label for="birthdate">Выйти</label>

      <router-link to="/home">Зарегистрироваться</router-link>
    </form>
  </div>
</template>

<script>
export default {
  methods: {
    submitForm() {
      // Логика обработки отправки формы
    }
  }
};
</script>

<style scoped>
  #home {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
  }

  form {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    padding: 20px;
    border: 1px solid #fff;
    border-radius: 5px;
    font-family: 'Roboto', sans-serif;
    position: relative;
  }

  h2 {
    position: absolute;
    top: -40px;
    left: 50%;
    transform: translateX(-50%);
    color: #7B5244;
  }

  form label {
    margin-bottom: 5px;
  }

  form input {
    margin-bottom: 10px;
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
    width: 100%;
    font-size: 18px;
  }

  form button:hover {
    background-color: #7B5244;
    color: #D3AFAA;
  }
</style>
