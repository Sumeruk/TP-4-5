<template>
  <div class="ProductBoss">
    <HeadSiteForBoss/>

    <h2 class="page-title">Остатки товара</h2>


    <div class="searchProductsBoss">
      <input type="text" v-model="search" placeholder="Поиск...">
      <button class="searchProductsBossButton" @click="searchProduct(search)">Найти</button>
    </div>

    <table>

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
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from "@/api/api";

export default {
  components: {
    HeadSiteForBoss
  },
  name: "LeftoversPage",
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

}
</script>

<style scoped>
.ProductBoss {
  display: flex;
  flex-direction: column;
}

.ProductBoss h2 {
  margin-top: -20%;
}

.page-title {
  text-align: center;
  margin-top: -300px; /* Уменьшил отрицательный отступ */
}

.searchProductsBoss {
  display: flex;
  align-items: center;
  flex-direction: row;
  width: 80%;
  margin-left: 24%;
}

.searchProductsBoss input {
  padding: 10px; /* Увеличиваем внутренние отступы */
  border-radius: 40px; /* Увеличиваем радиус скругления */
  border: 2px solid #F9F6DE; /* Увеличиваем толщину границы */
  margin-right: 10px; /* Уменьшаем отступ между строкой поиска и кнопкой */
  font-size: 16px; /* Увеличиваем размер шрифта */
  width: 33%;
}

.searchProductsBoss .searchProductsBossButton {
  margin-top: -10px;
  margin-right: 10px;
  border-radius: 40px;
  display: block;
  padding: 10px;
  width: 33%;
}


table {
  width: 100vw;
  border-collapse: collapse;
  margin: auto;
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