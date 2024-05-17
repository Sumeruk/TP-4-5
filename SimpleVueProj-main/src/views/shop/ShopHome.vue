<template>
  <div id="home">
  <HeadSiteForShop/>

    <div class="homeShop">
      <div>
        <h1>Мой профиль</h1>
        <form @submit.prevent="submitForm">
          <img src="../assect/Shop.jpg" alt="StockTrack Pro Logo" class="avatar">
          <label for="username">Магазин</label>
          <div class="info-row">
            <img src="../assect/Lock.jpg" alt="StockTrack Pro Logo" class="logo">
            <router-link to="/policy">Политика конфидициальности</router-link>
            <img src="../assect/Arrow.jpg" alt="StockTrack Pro Logo" class="logo">
          </div>
        </form>
      </div>

      <!--    ЗДЕСЬ КНОПКИ-->
      <div class="butts">
        <button>
          <router-link :to="{name : 'newOrder', params :{shopId : 2} }" class="actions">Сделать заказ</router-link>
        </button>
        <button>
          <router-link :to="{name : 'recentOrders', params :{shopId : 2} }" class="actions">Предыдущие заказы</router-link>
        </button>


      </div>
    </div>
  </div>
</template>

<script>
import HeadSiteForShop from "@/components/HeadSiteForShop";
export default {
  components:{
    HeadSiteForShop
  },
  name: "ShopHome",
}
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: row;
  align-items: center;
  height: 100vh;
  width: 80%;
  overflow-y: visible;
}

.homeShop {
  display: flex;
  width: 80%;
  margin-left: 8%;
}

.butts {
  padding-top: 5%;
  width: 40%;
  margin-left: 6%;
  align-items: center;
}

.actions{
  display: block;
  padding: 10px;
  border-radius: 40px;

}
h1 {
  margin-top: 100px;
}

/* Стили для формы */
form {
  width: 100%;
  max-width: 600px;
  max-height: 600px;
  border: 0 solid #ffffff;
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
  width: 250px;
  height: 250px; /* Устанавливаем размеры */
  border-radius: 20%; /* Добавляем скругление */
  margin-bottom: 10px;
}

.logo {
  width: 50px;
  height: auto;
  /*margin-right: 10px;*/
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

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>