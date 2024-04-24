<template>
  <div id="WelcomePage">
    <form @submit.prevent="submitForm" class="login-form">
      <img src="./assect/Logo.jpg" alt="StockTrack Pro Logo" class="logo">
      <h1>StockTrack Pro</h1>
      <button class="login-button">
        <router-link to="/login">Войти</router-link>
      </button>
    </form>
  </div>
</template>

<style scoped>

.login-form {
  text-align: center;
}

.logo {
  width: 150px;
  height: auto;
  margin-bottom: 10px;
  margin-left: 10%; /* Сдвигаем картинку вправо на 20% относительно ширины родительского элемента */
}

h1 {
  font-family: 'Segoe UI Light', sans-serif;
  align-items: center;
  color: #7B5244;
  margin-top: 140px;
}

.login-button {
  margin-top: 80px; /* Отступ сверху для кнопки */
}

</style>

<script>
export default {
  name: "WelcomePage",
  methods: {
    submitForm() {
      // Логика отправки формы
    }
  }
}
</script>
