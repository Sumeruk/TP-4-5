<template>
  <div id="Registration">
    <HeadSiteForShop/>

    <div>

      <h2>Добавить товар к заказу</h2>
      <form @submit.prevent="setProduct">
        <label for="username">Название</label>
        <input type="text" id="nameOfProduct" v-model="product.name">

        <label for="amount">Количество</label>
        <input type="number" id="amount" v-model="product.amount">

        <button type="submit">Добавить товар</button>


      </form>
    </div>
    <button class="action" @click="createOrder">Сделать заказ</button>
    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>
    <div>
      <table>
        <thead>
        <tr>
          <th>Название</th>
          <th>Количество</th>
          <th></th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(product, index) in order" :key="index">
          <td>{{ product.name }}</td>
          <td>{{ product.amount }}</td>
          <td>
            <button @click="deleteProductFromOrder(index)">Удалить</button>
            <!--          <button @click="deleteProduct(product.id)">Удалить</button>-->
          </td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import HeadSiteForShop from "@/components/HeadSiteForShop";
import api from "@/api/api";

export default {
  components: {
    HeadSiteForShop
  },
  name: "AddProductToOrder",
  data() {
    return {
      order: [],
      product: {
        name: '',
        amount: ''
      },
      errorMessage:'dfvdf',
      shopId: this.$route.params.id
    }
  },
  methods: {
    setProduct() {

      let productCopy = Object.assign({}, this.product);
      if(productCopy.name !== '' && productCopy.amount !== '') {
        this.order.push(productCopy);
        this.product.name = '';
        this.product.amount = '';
      }
    },
    deleteProductFromOrder(index) {
      this.order.splice(index, 1);
    },
    createOrder(){
      api.createOrder(this.shopId, this.order).then(response =>{
        console.log(response.status);
      }).catch(error => {
        console.error(error);
        this.showErrorMessage();
        this.errorMessage = 'Невозможно сделать заказ!';
      });
    },
    showErrorMessage() {
      const errorMessage = document.getElementById('error-message');
      errorMessage.classList.remove('hidden');
      errorMessage.classList.add('show');
    }
  }
};
</script>

<style>
/*div {*/
/*  border: 1px solid black;*/
/*}*/

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

#Registration {
  flex-direction: column;
  position: fixed;
}
.hidden {
  display: none;
}

.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
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
.action {
  margin-left: 10%;
  margin-bottom: 10%;
  display: block;
  padding: 10px;
  border-radius: 40px;
  width: 80%;
}
form {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  position: fixed;
}

#Registration h2 {
  margin-top: -100%;
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

table {
  width: 100%;
  border-collapse: collapse;
  margin: auto;
  align-items: flex-start;
  position: absolute;
}

th, td {
  border: 1px solid #7B5244; /* Изменил цвет границ ячеек на черный */
  padding: 8px;
  text-align: center;
  color: #7B5244;
}

th {
  background-color: #D3AFAA;
}
</style>
