<template>
  <div id="RegistrationProduct">
    <HeadSiteForShop/>
    <div>
      <h2>Добавить товар к заказу</h2>
      <label for="search">
        Название товара
      </label>

      <input
          type="text"
          id="search"
          v-model="searchTerm"
          placeholder="Поиск товара...">

      <ul
          v-if="searchProducts.length"
      >
        <li
            v-for="product in searchProducts"
            :key="product.name"
            @click="selectProduct(product)"
        >
          {{ product.name }}
        </li>
      </ul>

      <p
          v-if="selectedProduct">
        Последний выбранный товар: <span class="font-semibold">
        Артикул {{ selectedProduct.id }} Название {{ selectedProduct.name }}</span>
      </p>

      <form @submit.prevent="setProduct">

        <label for="amount">Количество</label>
        <input type="number" id="amount" v-model="product.amount">

        <button class="addButton" type="submit">Добавить товар</button>
      </form>
    </div>

    <div>
      <button class="action" @click="createOrder">Сделать заказ</button>
      <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>
    </div>


    <div class="productTable">
      <table class="productTable">
        <thead>
        <tr>
          <th>Артикул</th>
          <th>Название</th>
          <th>Количество</th>
          <th>Действие</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(product, index) in order" :key="index">
          <td>{{ product.id }}</td>
          <td>{{ product.name }}</td>
          <td>{{ product.amount }}</td>
          <td>
            <button @click="deleteProductFromOrder(index)">Удалить</button>
            <!--          <button @click="deleteProduct(product.id)">Удалить</button>-->
          </td>
        </tr>
        </tbody>
      </table>
      <!--      <ul>-->
      <!--        <li v-for="(item, index) in order" :key="index">-->
      <!--          <p>{{ item.name }}  {{item.amount}}</p>-->
      <!--        </li>-->
      <!--      </ul>-->
    </div>


  </div>
</template>

<script>
import HeadSiteForShop from "@/components/HeadSiteForShop";
import api from "@/api/api";
import {ref, computed} from 'vue'
import router from "@/router";

let products = [
  {"id": "1213","name": "Åland Islands"},
  {"id": "1214","name": "Algeria"},
  {"id": "1215","name": "American Samoa"},
  {"id": "1216","name": "Andorra"},
  {"id": "1217","name": "Angola"},
  {"id": "1218","name": "Anguilla"},
  {"id": "1219","name": "Antarctica"}
]

let findProduct = {
  id: '',
  name: '',
  amount: ''
};
export default {
  components: {
    HeadSiteForShop
  },
  name: "AddProductToOrder",
  data() {
    return {
      order: [],
      product: {
        id: '',
        name: '',
        amount: ''
      },
      errorMessage:'dfvdf',
      shopId: this.$route.params.shopId
    }
  },

  setup() {
    let searchTerm = ref('')

    const searchProducts = computed(() => {
      if (searchTerm.value === '') {
        return []
      }

      let matches = 0

      return products.filter(product => {
        if (product.name.toLowerCase().includes(searchTerm.value.toLowerCase()) && matches < 10) {
          matches++
          return product
        }
      })
    });

    const selectProduct = (product) => {
      selectedProduct.value = product
      searchTerm.value = ''
      findProduct = selectedProduct.value;
    }

    let selectedProduct = ref('')

    return {
      products,
      searchTerm,
      searchProducts,
      selectProduct,
      selectedProduct
    }
  },

  created() {
    this.getProductsForSearch();
  },

  methods: {

    getProductsForSearch(){
      api.getAllProductsForSearch().then(response => {
        products = response.data;
        console.log(response.status);
      })
          .catch(error => {
            console.log(error);
          })
    },

    setProduct() {
      findProduct.amount = this.product.amount;
      this.product.id = findProduct.id;
      let productCopy = Object.assign({}, findProduct);
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
      if(this.order.length > 0) {
        api.createOrder(this.shopId, this.order).then(response => {
          console.log(response.status);
          router.push("/shop");
        }).catch(error => {
          console.error(error);
          this.showErrorMessage();
          this.errorMessage = 'Невозможно сделать заказ!';
        });
      } else {
        this.showErrorMessage();
        this.errorMessage = 'Невозможно сделать пустой заказ!';
      }
    },
    showErrorMessage() {
      const errorMessage = document.getElementById('error-message');
      errorMessage.classList.remove('hidden');
      errorMessage.classList.add('show');
    }
  }
};
</script>

<style scoped>
/*div {*/
/*  border: 1px solid black;*/
/*}*/

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

#RegistrationProduct {
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
.addButton{
  margin-left: 21%;
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
  margin-left: 32%;
  /*text-align: start;*/
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
  margin-bottom: 5px;
  margin-left: 40%/* добавляем небольшое расстояние между метками и полями ввода */
}

form input {
  margin-bottom: 10px;
  margin-left: 21.5%;
  /* добавляем небольшое расстояние между полями ввода */
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
  width: 800px;
  border-collapse: collapse;
  margin: auto;
  align-items: flex-start;
  position: absolute;
}

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

ul {
  position: absolute;
  margin-left: 35%;
  z-index: 10;
  width: 30%;
  border-radius: 0.25rem;
  background-color: #fff;
  border: 1px solid #e5e7eb;
  padding: 0.5rem;
}

ul li {
  margin: 0 0 0.25rem;
  list-style: none;
}

ul li:last-child {
  margin-bottom: 0;
}

li{
  cursor: pointer;
}
li:hover {
  background-color: #f3f4f6;
}
</style>
