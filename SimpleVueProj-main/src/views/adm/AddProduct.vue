<template>
  <div class="container">
    <HeadSite/>
    <h1>Добавить товар</h1>
    <form @submit.prevent="addProduct">
      <label for="articleNumber">Артикул</label>
      <input type="text" name="articleNumber" v-model="newProduct.id" required>

      <label for="name">Название</label>
      <input type="text" name="name" v-model="newProduct.name" required>

      <label for="price">Цена</label>
      <input type="number" id="price" name="price" min="0.01" step="0.01" v-model="newProduct.price" required>

      <label for="weight">Вес (г)</label>
      <input type="number" id="weight" name="weight" min="0.01" step="0.01" v-model="newProduct.weight">

      <label for="unit">Единица измерения</label>
      <select id="unit" name="unit" v-model="newProduct.unit">
        <option value="шт">шт</option>
        <option value="кг">кг</option>
        <option value="г">г</option>
        <option value="л">л</option>
        <option value="мл">мл</option>
      </select>

      <label for="supplier">Поставщик</label>
      <input type="text" id="supplier" name="supplier" v-model="newProduct.provider">

      <label for="description">Описание</label>
      <textarea name="description" v-model="newProduct.description"></textarea>

      <label for="quantity">Количество</label>
      <input type="number" id="quantity" name="quantity" min="1" required v-model="newProduct.number">

      <button type="submit" @click="addProduct">Добавить товар</button>
    </form>
  </div>
</template>

<script>
import HeadSite from "@/components/HeadSiteForAdm";
import api from '../../api/api.js';

export default {
  components: {
    HeadSite
  },
  data() {
    return {
      newProduct: {
        id: '',
        name: '',
        price: '',
        weight: '',
        unit: '',
        provider: '',
        description: '',
        number: ''
      }
    }
  },
  methods: {
    addProduct() {
      console.log(this.newProduct);
      api.createProduct(this.newProduct).then(response => {
        console.log(response.data);
      })
          .catch(error => {
            console.error(error);
          });
    }

  }
};
</script>

<style>

h1 {
  margin-top: 100px;
}

body {
  font-family: Arial, sans-serif;
  margin: 20px;
  padding: 20px;
  box-sizing: border-box;
}

.container {
  width: 30%;
  margin: 20px auto;
  margin-top: 200px;
}

form {
  border: 1px solid #fff;
  padding: 20px;
  border-radius: 5px;
}

h1 {
  position: absolute;
  top: 10px;
  left: 50%;
  transform: translateX(-50%);
  color: #7B5244;
}

label {
  display: block;
  margin-bottom: 10px;
}

input[type="text"],
input[type="number"] {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #F9F6DE;
  background-color: #F9F6DE;
  border-radius: 4px;
  box-sizing: border-box;
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
