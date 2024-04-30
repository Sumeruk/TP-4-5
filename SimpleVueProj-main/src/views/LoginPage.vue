<template>
  <div class="login-page">
    <form>
      <h2 class="auth-title">Авторизация</h2>
      <h1 class="welcome-text">Добро пожаловать</h1>
      <label for="username">Электронная почта</label>
      <input type="text" id="username" name="username" required>

      <label for="password">Пароль</label>
      <input type="password" id="password" name="password" required>

    </form>
    <button>
      <router-link to="/boss" class="actions">Авторизоваться</router-link>
    </button>
  </div>
</template>

<script>
export default {
  name: 'LoginPage'
};
</script>

<style scoped>
  .login-page {
    max-width: 400px;
    margin: 0 auto;
    padding: 20px;
    border: 1px solid #ffffff;
    border-radius: 5px;
    background-color: #ffffff;
  }

  form {
    display: flex;
    flex-direction: column;
    align-items: flex-start; /* располагаем элементы слева */
    padding: 20px;
    border: 1px solid #ffffff;
    border-radius: 5px;
    font-family: 'Roboto', sans-serif;
    position: relative;
  }

  form input{
    border: 1px solid #ffffff;

  }

  .auth-title {
    color: #7B5244;
    margin: 0 auto; /* Центрируем по горизонтали */
  }

  label {
    margin-bottom: 5px;
  }

  input, button {
    margin-bottom: 10px;
  }

  .welcome-text {
    position: relative;
    z-index: 2; /* Поднимаем надпись над остальными элементами */
    font-size: 24px; /* Уменьшаем размер шрифта */
    margin-left: -50px; /* Сдвигаем текст влево на 30px */
  }
  .actions{
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
