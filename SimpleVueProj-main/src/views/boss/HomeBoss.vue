<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSite />

    <div class="homeBoss">
      <div>
        <h1>Мой профиль</h1>
        <form @submit.prevent="submitForm">
          <img src="../assect/Face.jpg" alt="StockTrack Pro Logo" class="avatar">
          <label for="username">Начальник склада</label>
          <div class="info-row">
            <img src="../assect/Lock.jpg" alt="StockTrack Pro Logo" class="logo">
            <router-link to="/policy">Политика конфидициальности</router-link>
            <img src="../assect/Arrow.jpg" alt="StockTrack Pro Logo" class="logo">
          </div>

        </form>
      </div>

      <div class="butts">
        <button>
          <router-link to="/orders/getOrders" class="actions">Выдача заданий</router-link>
        </button>
        <button>
          <router-link to="/product/setProducts" class="actions">Принять товар</router-link>
        </button>
        <button>
          <router-link to="/product/allProducts" class="actions">Остатки товара</router-link>
        </button>
        <button>
          <router-link to="/analytics" class="actions">Cоставить отчет</router-link>
        </button>
      </div>

    </div>
  </div>
</template>

<script>

import HeadSite from "@/components/HeadSiteForBoss";

export default {
  components: {
    HeadSite
  }
};
</script>

<style scoped>

#home {
  flex-direction: column;
  align-items: center;
  height: 100vh;
  width: 80%;
}

h1{
  margin-top: 100px;
}
/* Стили для формы */
form {
  width: 100%;
  max-width: 600px;
  max-height: 600px;
  border: 1px ;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  display: flex;
}

.homeBoss{
  margin-top: 18%;
  display: flex;
  width: 80%;
  margin-left: 8%;
}

.butts{
  width: 40%;
  align-items: center;
  margin-left: 7%;
  margin-top: 3%;
}

h2 {
  color: #7B5244;
  margin-bottom: 20px;
}

.info-row {
  display: flex;
  align-items: center;
}

.logo {
  width: 50px;
  height: auto;
  margin-right: 10px;
}

.avatar {
  width: 200px;
  height: 200px; /* Устанавливаем размеры */
  border-radius: 20%; /* Добавляем скругление */
  margin-bottom: 10px;
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
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

.actions{
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}

</style>
