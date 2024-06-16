<template>
  <div id="Registration">
    <HeadSiteForBoss/>

    <h2>Принять товар</h2>
    <form @submit.prevent="setProductFromDelivery">
      <label for="nameOfProduct">Название</label>
      <input type="text" id="nameOfProduct" v-model="addedProducts.id">

      <label for="amount">Количество</label>
      <input type="number" id="amount" v-model="addedProducts.amount">

      <input type="submit" value="Добавить товар">

    </form>
  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from "@/api/api";
export default {
  components:{
    HeadSiteForBoss
  },
  data(){
    return{
    addedProducts:
      {
        id:'',
        amount: 0
      }
    }
  },
  methods:{
    setProductFromDelivery(){
      api.setProductFromDelivery(this.addedProducts).then(response => {
        console.log(response.status);
        this.addedProducts.id = '';
        this.addedProducts.amount = 0;
      })
          .catch(error => {
            console.error(error);
            this.addedProducts.id = '';
            this.addedProducts.amount = 0;
          });
    }
  }

};
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

form {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  position: relative;
  margin-left: 38%;
}

h2 {
  margin-top: 7%;
  color: #7B5244;
}

form label {
  margin-bottom: 5px; /* добавляем небольшое расстояние между метками и полями ввода */
}

form input {
  margin-bottom: 10px; /* добавляем небольшое расстояние между полями ввода */
  padding: 8px;
  width: 300px;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
}

input[type="submit"] {
  margin-top: 10px;
  padding: 10px 60px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 36%;
  font-size: 18px;
}
input[type="submit"]:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
