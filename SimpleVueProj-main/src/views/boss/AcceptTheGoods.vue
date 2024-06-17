<template>
  <div id="Registration">
    <HeadSiteForBoss/>

    <h2>Принять товар</h2>
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
    <form @submit.prevent="setProductFromDelivery">
<!--      <label for="nameOfProduct">Название</label>-->
<!--      <input type="text" id="nameOfProduct" v-model="addedProducts.id">-->

      <label for="amount">Количество</label>
      <input type="number" id="amount" v-model="addedProducts.amount">

      <input type="submit" value="Добавить товар">

    </form>
  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from "@/api/api";
import {ref, computed} from 'vue'

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
  amount: 0,
};
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

  methods:{
    getProductsForSearch(){
      api.getAllProductsForSearch().then(response => {
        products = response.data;
        console.log(response.status);
      })
          .catch(error => {
            console.log(error);
          })
    },

    setProductFromDelivery(){
      this.addedProducts.id = findProduct.id;
      this.addedProducts.amount = findProduct.amount;
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
