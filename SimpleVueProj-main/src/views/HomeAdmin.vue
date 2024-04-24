<template>
  <div id="home">
    <!-- Шапка с кнопками -->
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

    <h1>Мой профиль</h1>
    <form @submit.prevent="submitForm">
      <img src="./assect/Face.jpg" alt="StockTrack Pro Logo" class="avatar">
      <label for="username">Джон Доу</label>
      <div class="info-row">
        <img src="./assect/Lock.jpg" alt="StockTrack Pro Logo" class="logo">
        <router-link to="/policy">Политика конфидициальности</router-link>
        <img src="./assect/Arrow.jpg" alt="StockTrack Pro Logo" class="logo">
      </div>


      <button>
        <router-link to="/">Выйти</router-link>
      </button>
    </form>
  </div>
</template>

<script>
export default {
  methods: {
    submitForm() {
      // Логика обработки отправки формы
    },
    logout() {
      // Логика выхода пользователя
    }
  }
};
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
  overflow-y: visible;
}

/* Стили для шапки */
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
  z-index: 1;
}

.header router-link {
  margin-right: 10px; /* Добавляем отступ между элементами */
}

.header router-link, .header button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #D3AFAA;
  color: #7B5244;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.header router-link:hover, .header button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
h1{
  margin-top: 100px;
}
/* Стили для формы */
form {
  width: 100%;
  max-width: 600px;
  max-height: 600px;
  margin-top: 150px; /* Отступ сверху для формы */
  padding: 20px;
  border: 1px solid #ffffff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  display: flex;
}

h2 {
  color: #7B5244;
  margin-bottom: 20px;
}

.info-row {
  display: flex;
  align-items: center;
}

.avatar {
  width: 200px;
  height: 200px; /* Устанавливаем размеры */
  border-radius: 20%; /* Добавляем скругление */
  margin-bottom: 10px;
}

.logo {
  width: 50px;
  height: auto;
  margin-right: 10px;
}

label {
  margin-bottom: 10px;
}

input {
  padding: 8px;
  width: 100%;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
