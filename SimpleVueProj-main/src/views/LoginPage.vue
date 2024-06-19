<template>
  <div class="login-page">
    <h2 class="auth-title">Авторизация</h2>
    <form @submit.prevent="login">
      <h1 class="welcome-text">Добро пожаловать</h1>
      <label for="email">Электронная почта</label>
      <input type="text" id="email" name="email" v-model="user.email" required>

      <label for="password">Пароль</label>
      <input type="password" id="password" name="password" v-model="user.password" required>

      <button type="submit">
        Авторизоваться
      </button>

    </form>

    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>

  </div>
</template>

<script>
import api from "@/api/api";
import router from "@/router";

export default {
  name: 'LoginPage',

  data() {
    return {
      user: {
        email: '',
        password: ''
      },
      errorMessage:'dfvdf',
    }
  },

  methods: {
    login() {
      api.login(this.user).then(response => {
            localStorage.setItem("jwtToken", response.data.token);
            localStorage.setItem("role", response.data.role);
            localStorage.setItem("id", response.data.id);

            localStorage.getItem("jwtToken")
            switch (response.data.role) {
              case "Кладовщик":
                router.push("/storekeeper")
                break;
              case "Начальник склада":
                router.push("/home");
                break;
              case "Администратор":
                router.push("/adm");
                break;
              case "Магазин":
                router.push("/shop");
                break;
              default:
                console.log("Неизвестная роль пользователя");
            }
          }
      ).catch(error => {
        if (error.response.status === 400){
          this.showErrorMessage();
          this.errorMessage = 'Неверное имя пользователя или пароль';
        }
        console.log(error);
      })
    },

    showErrorMessage() {
      const errorMessage = document.getElementById('error-message');
      errorMessage.classList.remove('hidden');
      errorMessage.classList.add('show');
    }
  }
}
;
</script>

<style scoped>
.hidden {
  display: none;
}
.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}
.login-page {
  max-width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ffffff;
  border-radius: 5px;
  background-color: #ffffff;
}

form {
  margin-left: 25%;
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #ffffff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  position: relative;
}

form input {
  border: 1px solid #ffffff;
  background-color: #F9F6DE;
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
  margin-left: -30px; /* Сдвигаем текст влево на 30px *!*/
}

.actions {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 10px;
  margin-left: -15%;
  padding: 10px;
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
