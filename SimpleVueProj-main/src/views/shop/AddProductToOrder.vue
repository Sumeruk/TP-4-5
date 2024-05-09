<template>
  <div id="Registration">
    <HeadSiteForShop/>

    <h2>Добавить товар к заказу</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Название</label>
      <input type="text" id="nameOfProduct" v-model="nameOfArrivedProduct">

      <label for="usersurname">Количество</label>
      <input type="number" id="amount" v-model="amountArrived">

      <input type="submit" value="Добавить товар">

    </form>
  </div>
</template>

<script>
import HeadSiteForShop from "@/components/HeadSiteForShop";
export default {
  components:{
    HeadSiteForShop
  },
  name: "AddProductToOrder"
};
</script>

<style>

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
}

h2 {
  margin-top: 50px;
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
  width: 100%;
  font-size: 18px;
}
input[type="submit"]:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
