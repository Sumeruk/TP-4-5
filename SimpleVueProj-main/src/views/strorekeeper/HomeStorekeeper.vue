<template>
  <div id="homeStorekeeper">
    <HeadSiteForStorekeep />
    <h1>Мой профиль</h1>

    <div class="homeBoss">
      <div>
        <div class="face">
          <img src="../assect/Face.jpg" alt="StockTrack Pro Logo" class="avatar">
          <label for="username">Кладовщик</label>
          <div class="info-row">
            <img src="../assect/Lock.jpg" alt="StockTrack Pro Logo" class="logo">
            <router-link to="/policy">Политика конфидициальности</router-link>
            <img src="../assect/Arrow.jpg" alt="StockTrack Pro Logo" class="logo">
          </div>
        </div>
      </div>

      <div class="butts">
        <button class="action" @click="goToJob">
          Работа
        </button>
      </div>


    </div>
  </div>
</template>

<script>
import HeadSiteForStorekeep from "@/components/HeadSiteForStorekeep";
import router from "@/router";
export default {
  components:{
    HeadSiteForStorekeep
  },
  name: "HomeStorekeeper",
  methods:{
    goToJob(){
      router.push('/orders/toDo');
    }
  }
}
</script>

<style scoped>
/*div{*/
/*  border: 1px solid black;*/
/*}*/
#homeStorekeeper {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100vh;
}

/* Стили для шапки */

h1{
  margin-top: 6%;

}
/* Стили для формы */
.face {
  width: 100%;
  max-width: 600px;
  max-height: 600px;
  margin-top: 30%; /* Отступ сверху для формы */
  padding: 20px;
  border: 1px ;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  display: flex;
  flex-direction: column;
  align-items: flex-start;
}

.homeBoss{
  display: flex;
}

.butts{
  margin-top: 30%;
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