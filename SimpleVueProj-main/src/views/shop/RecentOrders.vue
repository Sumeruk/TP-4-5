<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSiteForShop/>
    <!-- Формы для каждого заказа -->
    <div v-for="(order, index) in orders" :key="index" class="order-form" :class="{ 'first-form': index === 0 }">
      <div class="number">
        <router-link :to="{name : 'oldOrder', params :{shopId : this.shopId, orderId: order.id } }">
          №{{ order.id }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import HeadSiteForShop from "@/components/HeadSiteForShop";
import api from '../../api/api.js';

export default {
  components: {
    HeadSiteForShop
  },
  name: 'RecentOrders',
  data() {
    return {
      shopId: this.$route.params.shopId,
      orders: [
        {id:'12', name: '33442-998'},
        {id:'13',name: '55302-008'},
        {id:'14',name: '22349-994'},
        {id:'15',name: '73800-456'},
        {id:'16',name: '23457-994'}
      ]
    };
  },
  created() {
    this.getAllOrdersFromShopWithShopId();
  },
  methods: {
    getAllOrdersFromShopWithShopId() {
      api.getAllOrdersFromShopWithShopId(this.shopId).then(response => {
        this.orders = response.data;
        console.log(response.status);
        console.log(response.data);
      }).catch(error => {
        console.log(error);
      })
    }
  }
};
</script>

<style scoped>
#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
  height: 600px;
  /*overflow-y: visible;*/
}

.homeBoss {
  display: flex;
}

.welcome-text {
  display: flex;
  margin-top: 40%;

}

.info-row {
  margin-top: 30%;
}

/* Стили для формы */
.order-form {
  max-width: 600px; /* Ограничиваем максимальную ширину формы */
  padding: 20px;
  border: 5px solid #ffffff;
  border-radius: 40px;
  font-family: 'Roboto', sans-serif;
  background-color: #D3AFAA;
  text-align: center;
  display: flex;
  align-items: center; /* Выравниваем содержимое по центру */
}

.first-form {
  margin-top: 50px; /* Отступ сверху только для первой формы */
}

.avatar {
  width: 100px;
  height: 100px; /* Устанавливаем размеры */
  border-radius: 20%; /* Добавляем скругление */
  margin-right: 20px;
}

label {
  display: block;
}

input {
  padding: 8px;
  width: 100%;
  border-radius: 3px;
  border: 1px solid #ccc;
}

button {
  margin-top: 20px;
  padding: 10px 20px;
  border-radius: 40px;
  background-color: #F9F6DE;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

button:hover {
  background-color: #F9F6DE;
  color: #D3AFAA;
}

/* Стили для номеров */
.number {
  flex-grow: 1; /* Растягиваем элемент на всю доступную ширину */
  background-color: #F9F6DE; /* Добавляем фоновый цвет */
  padding: 10px; /* Добавляем внутренние отступы */
  border-radius: 10px; /* Закругляем углы */
  margin-right: 10px; /* Добавляем отступ между номерами */
}

.number p {
  margin: 0; /* Убираем внешние отступы у абзаца */
}
</style>
