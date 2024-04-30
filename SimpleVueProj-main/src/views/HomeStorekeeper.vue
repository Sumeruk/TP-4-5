<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSiteForStorekeep />
    <div class="homeBoss">
      <div>
        <h1>Мой профиль</h1>
        <form @submit.prevent="submitForm">
          <img src="./assect/Face.jpg" alt="StockTrack Pro Logo" class="avatar">
          <label for="username">Кладовщик</label>
          <div class="info-row">
            <img src="./assect/Lock.jpg" alt="StockTrack Pro Logo" class="logo">
            <router-link to="/policy">Политика конфидициальности</router-link>
            <img src="./assect/Arrow.jpg" alt="StockTrack Pro Logo" class="logo">
          </div>
        </form>
      </div>

      <div class="butts">
        <button>
          <router-link to="/work" class="action">Работа</router-link>
        </button>
      </div>


    </div>
  </div>
</template>

<script>
import HeadSiteForStorekeep from "@/components/HeadSiteForStorekeep";
export default {
  components:{
    HeadSiteForStorekeep
  },
  name: "HomeStorekeeper"
}
</script>

<style scoped>
#home {
  flex-direction: row;
  align-items: center;
  height: 100vh;
}

/* Стили для шапки */

h1{
  margin-top: 10%;
}
/* Стили для формы */
form {

  width: 100%;
  max-width: 600px;
  max-height: 600px;
  margin-top: 150px; /* Отступ сверху для формы */
  padding: 20px;
  border: 1px ;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  display: flex;
}

.homeBoss{
  display: flex;
}

.butts{
  margin-top: 180px;
  width: 40%;
  align-items: center;

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
.butts .action{
  display: block;
  padding: 10px;
  border-radius: 40px;
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

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>