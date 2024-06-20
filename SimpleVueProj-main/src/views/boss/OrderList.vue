<template>
  <div>
    <HeadSiteForBoss/>

    <h2 class="page-title">Список заказа</h2>

    <div class="table">
      <table class="table">
        <thead>
        <tr>
          <th>Артикул</th>
          <th>Название</th>
          <th>Количество</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(product, index) in order" :key="index">
          <td>{{ product.id }}</td>
          <td>{{ product.name }}</td>
          <td>{{ product.amount }}</td>
        </tr>
        </tbody>
      </table>
    </div>

  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from "@/api/api";

export default {
  components: {
    HeadSiteForBoss
  },
  name: "OrderList",
  data() {
    return {
      order: [
        {id:'',name: '', amount: '33'},
      ],
      orderId: this.$route.params.orderId,
      shopId: 0
    }
  },
  created() {
    this.getProductsFromOrder()
  },
  methods: {
    getProductsFromOrder() {
      api.getProductsFromOrder(this.shopId, this.orderId).then(response => {
        this.order = response.data;
        console.log(response.data);
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
.page-title {
  text-align: center;
  margin-top: 7%; /* Уменьшил отрицательный отступ */
}

.table {
  align-self: center;
  width: 100%;
  margin-left: 0;
}

.table table {
  width: 99%;
  border-collapse: collapse;
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

button {
  margin-top: 40px;
  padding: 10px 20px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 25%;
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>