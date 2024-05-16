<!--todo сделать шапку для админа-->
<!--todo переделать под админа-->
<template>
  <div>
    <HeadSiteForAdm/>

    <h2 class="page-title">Список продуктов</h2>

    <div class="addAndSearch">
      <button>
        <router-link to="/product/addProduct" class="action">Добавить товар</router-link>
      </button>
      <input type="text" placeholder="Поиск...">
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
        <th></th>
        <th></th>

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
        <td>
          <button @click="deleteProduct(product.id)">Удалить</button>
        </td>
        <td>
          <button>
            <!--            <router-link :to="{name : 'editProduct', params:{id: product.id}}>Изменить</router-link></button>-->
            Изменить
          </button>
        </td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import HeadSiteForAdm from "@/components/HeadSiteForAdm";
import api from '../../api/api.js';

export default {
  name: "ProductPage",
  components: {HeadSiteForAdm},

  data() {
    return {
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
      })
          .catch(error => {
            console.error(error);
          });
    },
    deleteProduct(id) {
      api.deleteProduct(id).then(response => {
        console.log(response.data);
        this.getAllProducts();
      })
          .catch(error => {
            console.error(error);
          });
    }
  }

};
</script>

<style scoped>
.page-title {
  text-align: center;
  margin-top: -300px; /* Уменьшил отрицательный отступ */
}
.addAndSearch{
  flex-direction: row;
}
.addAndSearch button{
  margin-top: 10px;
  margin-bottom: 15px;
  margin-right: 10px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 40%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

.addAndSearch input{
  width: 40%;
  margin-left: 10px;
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
