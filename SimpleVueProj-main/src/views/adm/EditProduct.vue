<template>
  <div id="Edit">
    <HeadSiteForAdm/>

    <h2>Редактирование</h2>
    <form @submit.prevent="updateProduct">
      <label for="articleNumber">Артикул</label>
      <input type="text" name="articleNumber" v-model="currentProduct.id" required>

      <label for="name">Название</label>
      <input type="text" name="name" v-model="currentProduct.name" required>

      <label for="price">Цена</label>
      <input type="number" id="price" name="price" min="0.01" step="0.01" v-model="currentProduct.price" required>

      <label for="weight">Вес (г)</label>
      <input type="number" id="weight" name="weight" min="0.01" step="0.01" v-model="currentProduct.weight">

      <label for="unit">Единица измерения</label>
      <select id="unit" name="unit" v-model="currentProduct.unit">
        <option value="шт">шт</option>
        <option value="кг">кг</option>
        <option value="г">г</option>
        <option value="л">л</option>
        <option value="мл">мл</option>
      </select>

      <label for="supplier">Поставщик</label>
      <input type="text" id="supplier" name="supplier" v-model="currentProduct.provider">

      <label for="description">Описание</label>
      <textarea name="description" v-model="currentProduct.description"></textarea>

      <button type="submit">
        Редактирование
      </button>
    </form>
  </div>
</template>

<script>
import HeadSiteForAdm from "@/components/HeadSiteForAdm";
import api from '../../api/api.js';
import router from "@/router";

export default {
  components: {
    HeadSiteForAdm,
  },
  data() {
    return {
      currentProduct: {
        id: this.$route.params.id,
        name: '',
        price: '',
        weight: '',
        unit: '',
        provider: '',
        description: ''
      },
    }
  },
  created() {
    this.getProduct();
  },
  methods:{
    getProduct(){
      api.getProduct(this.currentProduct.id).then(entity => {
        this.currentProduct = entity.data;
        console.log(entity.status);
      })
          .catch(error => {
            console.error(error);
          });
    },

    updateProduct(){
      console.log(this.id);
      api.updateProduct(this.id, this.currentProduct).then(response =>{
        console.log(response.status);
        router.push('/adminProduct');
      })
          .catch(error => {
            console.log(this.id);
            console.error(error);
          });
    }
  }
}
;
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
  margin-left: 37%;
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

.action {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 10px;
  border-radius: 40px;
  padding: 10px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 40%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
