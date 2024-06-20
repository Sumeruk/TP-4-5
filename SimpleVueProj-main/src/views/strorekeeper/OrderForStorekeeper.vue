<template>
  <div class="ordSt">
    <HeadSiteForStorekeep/>
    <h2 class="page-title">Список заказа</h2>
    <button class="actions" @click="checkIfAllItemsChecked">Заказ собран</button>
    <p v-if="showAttentionMessage">Внимание! Собран не весь заказ</p>
    <div class="table">
      <table class="table">
        <thead>
        <tr>
          <th>Артикул</th>
          <th>Название</th>
          <th>Количество</th>
          <th>Собран</th>
        </tr>
        </thead>
        <tbody>
        <tr v-for="(product, index) in order" :key="index">
          <td>{{ product.id }}</td>
          <td>{{ product.name }}</td>
          <td>{{ product.amount }}</td>
          <td><input type="checkbox" v-model="product.checked"/></td>
        </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import HeadSiteForStorekeep from "@/components/HeadSiteForStorekeep";
import api from "@/api/api";
import router from "@/router";

export default {
  components: {
    HeadSiteForStorekeep
  },
  name: "OrderListForStorekeeper",
  data() {
    return {
      order: [],
      showAttentionMessage: false,
      orderId: this.$route.params.orderId,
      shopId: 0
    }
  },
  created() {
    this.getProductsFromOrder()
  },
  methods: {
    getProductsFromOrder() {
      // const apiDat = [
      //   {id: '123', name: 'Name  tovar', amount: '20'}
      //   // {name: 'Кофе', amount: '30'}
      // ];
      //
      // this.order = apiDat.map((item) => ({...item, checked: false}));

      api.getProductsFromOrder(this.shopId, this.orderId).then(response => {
        this.order = response.data.map((item) => ({ ...item, checked: false }));
        console.log(response.status);
      })
          .catch(error => {
            console.error(error);
          });
    },
    checkIfAllItemsChecked() {
      this.showAttentionMessage = !this.order.every((item) => item.checked);
      if (this.showAttentionMessage !== true) {

        api.setOrderFromEmployer(this.orderId).then(response => {
          router.push("/orders/toDo");
          console.log(response.status);
        }).catch(error => {
          console.log(error)
        })
      }
    }
  }

}
</script>

<style scoped>

.ordSt {
  flex-direction: column;
}

.page-title {
  text-align: center;
  margin-top: 100px; /* Уменьшил отрицательный отступ */
}

.table {
  margin-top: 20px;
  align-self: center;
  width: 100%;
  margin-left: 5%;
}

.table table {
  width: 80%;
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
  width: 100%;
  font-size: 18px;
}

.actions {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>