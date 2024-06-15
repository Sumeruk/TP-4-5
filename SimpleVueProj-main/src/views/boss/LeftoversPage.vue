<template>
  <div class="prodPageBoss">
    <HeadSiteForBoss/>

    <div>
      <h2 class="page-title">Остатки товаров</h2>
      <div class="searchDiv">
        <input type="text" v-model="search" placeholder="Поиск...">
        <button class="actions" @click="searchProduct(search)">Найти</button>
      </div>
    </div>


    <div class="table">
      <table class="table">
        <thead>
        <tr>
          <th>Артикул</th>
          <th>Название продукта</th>
          <th>Цена</th>
          <th>Вес</th>
          <th>Мера измерения</th>
          <th>Поставщик</th>
          <th>Описание</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="product in products" :key="product.id">
          <td>{{ product.id }}</td>
          <td>{{ product.name }}</td>
          <td>{{ product.price }}</td>
          <td>{{ product.weight }}</td>
          <td>{{ product.units }}</td>
          <td>{{ product.provider }}</td>
          <td>{{ product.description }}</td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from '../../api/api.js';

export default {
  name: "ProductPage",
  components: {HeadSiteForBoss},

  data() {
    return {
      search: '',
      products: [
        {
          id: 1,
          name: 'Вареники',
          price: '22',
          weight: '100',
          units: 'шт',
          provider: 'five',
          description: 'Хорошие вареники'
        },
        {
          id: 2,
          name: 'Вареники',
          price: '22',
          weight: '100',
          units: 'шт',
          provider: 'five',
          description: 'Хорошие вареники'
        },
        {
          id: 3,
          name: 'Вареники',
          price: '22',
          weight: '100',
          units: 'шт',
          provider: 'five',
          description: 'Хорошие вареники'
        },
        {
          id: 4,
          name: 'Вареники',
          price: '22',
          weight: '100',
          units: 'шт',
          provider: 'five',
          description: 'Хорошие вареники'
        },
      ]
    }
  },
  created() {
    this.getAllProducts();
  },

  methods: {
    getAllProducts() {
      api.getAllProducts().then(response => {
        this.products = response.data;
        console.log(response.status);
      })
          .catch(error => {
            console.error(error);
          });
    },
    searchProduct(parameters) {
      console.log(parameters);
      api.searchProducts(parameters).then(response => {
        this.products = response.data;
        console.log(response.status);
      })
          .catch(error => {
            console.error(error);
          });
    }
  }

};
</script>

<style scoped>
/*div {*/
/*  border: 1px solid black;*/
/*}*/

.prodPageBoss {
  display: flex;
  flex-direction: column;
  align-items: center;
  height: 100%;
  width: 100%;
  overflow-y: visible;

}

h2 {
  align-items: center;
}

.searchDiv {
  display: flex;
  align-items: center;
  flex-direction: row;
  width: 200%;
  margin-left: -25%;
}

.searchDiv input {
  padding: 12px; /* Увеличиваем внутренние отступы */
  border-radius: 40px; /* Увеличиваем радиус скругления */
  border: 2px solid #F9F6DE; /* Увеличиваем толщину границы */
  margin-right: 10px; /* Уменьшаем отступ между строкой поиска и кнопкой */
  font-size: 16px; /* Увеличиваем размер шрифта */
  width: 33%;
}

.searchDiv .actions {
  margin-right: 10px;
  border-radius: 40px;
  display: block;
  padding: 10px;
  width: 33%;
}

.table {
  align-self: flex-start;
  width: 100%;
}

.table table {
  width: 95%;
  border-collapse: collapse;
  position: absolute;
}

.table th, td {
  border: 1px solid #7B5244; /* Изменил цвет границ ячеек на черный */
  padding: 8px;
  text-align: center;
  color: #7B5244;
}

.table th {
  background-color: #D3AFAA;
}

.action {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 10px;
  margin-bottom: 15px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 70%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
