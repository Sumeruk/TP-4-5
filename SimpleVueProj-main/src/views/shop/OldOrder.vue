<template>
  <div id="OldOrder">
    <HeadSiteForShop/>

    <div class="addProductForOrder">
      <h2>Заказ {{this.orderId}}</h2>
      <form @submit.prevent="setProduct">
        <label for="username">Название</label>
        <input type="text" id="nameOfProduct" v-model="product.name">
        <label for="amount">Количество</label>
        <input type="number" id="amount" v-model="product.amount">

        <button type="submit">Добавить товар</button>
      </form>
    </div>

    <button class="action" @click="createOrder">Повторить заказ</button>
    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>
    <div class="productTable">
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
  name: "OldOrder",
  components: {HeadSiteForShop},
  data() {
    return {
      order: [
        {name: 'Первый товар', amount: '33'},
        {name: 'Второй товар', amount: '10'},
        {name: 'Третрий товар', amount: '99'},
      ],
      product: {
        name: '',
        amount: ''
      },
      errorMessage:'dfvdf',
      shopId: this.$route.params.id,
      orderId: this.$route.params.orderId
    }
  },
  created() {
    this.getProductsFromOrder()
  },
  methods: {
    getProductsFromOrder(){
      api.getProductsFromOrder(this.shopId, this.order).then(response =>{
        this.order = response.data;
        console.log(response.status);
      }).catch(error => {
        console.error(error);
      });
    },
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
}
</script>

<style scoped>
/*div{*/
/*  border: 1px solid black;*/
/*}*/
#OldOrder {
  /*display: flex;*/
  /*justify-content: space-between;*/
  flex-direction: column;
  text-align: center;
  /*position: fixed;*/
  margin-top: 8%;
}
.hidden {
  display: none;
}
.productTable {
  width: 100%;
}

.productTable table {
  margin-left: 22%;
  width:200%;
  border-collapse: collapse;
  /*position: absolute;*/
  max-width: 800px;
}

.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}
button {
  margin-top: 10px;
  margin-bottom: 10px;
  border-radius: 40px;
  padding: 10px;
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
  margin-left: 34%;
  margin-bottom: 2%;
  display: block;
  padding: 10px;
  border-radius: 40px;
  width: 30%;
}
form {
  display: flex;
  margin-left: 37%;
  text-align: start;
  flex-direction: column; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  /*position: fixed;*/
  width: 21.5%;
}
h2 {
  margin-top: 0;
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

/*table {*/
/*  width: 800px;*/
/*  border-collapse: collapse;*/
/*  margin: auto;*/
/*  align-items: flex-start;*/
/*  position: absolute;*/
/*}*/

th, tr, td {
  max-width: 50%;
  min-width: 100px;
  border: 1px solid #7B5244; /* Изменил цвет границ ячеек на черный */
  padding: 8px;
  text-align: center;
  color: #7B5244;
  word-wrap: anywhere;
}

th {
  background-color: #D3AFAA;
}

</style>