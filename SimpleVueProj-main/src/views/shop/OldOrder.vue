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
  flex-direction: column;
  /*position: fixed;*/
}
.addProductForOrder{
  margin-left: -12.5%;
  width: 125%;
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

</style>