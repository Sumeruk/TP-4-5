<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSiteForStorekeep/>
    <!-- Формы для каждого заказа -->
    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>

    <div v-for="(order, index) in orders" :key="index" class="employee-form" :class="{ 'first-form': index === 0 }">
      <div class="number" v-if="orders">
        <router-link :to="{name: 'orderForStorekeeper', params:{orderId: order.id}}">
          №{{ order.id }}
        </router-link>
      </div>
    </div>
  </div>
</template>

<script>
import HeadSiteForStorekeep from "@/components/HeadSiteForStorekeep";
import api from "@/api/api";

export default {
  components: {
    HeadSiteForStorekeep
  },
  data() {
    return {
      orders: [],
      errorMessage:'dfvdf',
    };
  },

  created() {
    this.getOrdersForEmployer();
  },

  methods: {

    getOrdersForEmployer(){

      api.getOrdersForEmployer(localStorage.getItem("id")).then(response =>{
        this.orders = response.data;
        console.log(response.status);

        if (this.orders.length === 0){
          this.showErrorMessage();
          this.errorMessage = "Нет заказов для выполнения";
        }
      }).catch(error => {
        console.log(error.status);
        this.showErrorMessage();
        this.errorMessage = "Не удалось отобразить заказы";
      })
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

.hidden {
  display: none;
}

.show {
  margin-top: 100px;
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}

#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
  height: 600px;
  overflow-y: visible;
}
.homeBoss{
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
.employee-form {
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
