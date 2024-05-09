<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSiteForStorekeep/>
    <!-- Формы для каждого сотрудника -->
    <div v-for="(order, index) in orders" :key="index" class="employee-form" :class="{ 'first-form': index === 0 }">
      <div class="number">
        <p>№{{ order.name }}</p>
      </div>
    </div>
  </div>
</template>

<script>
import HeadSiteForStorekeep from "@/components/HeadSiteForStorekeep";

export default {
  components: {
    HeadSiteForStorekeep
  },
  data() {
    return {
      orders: [
        {name: '33442-998'},
        {name: '55302-008'},
        {name: '22349-994'},
        {name: '73800-456'},
        {name: '23457-994'}
      ]
    };
  },
  methods: {
    logout() {
      // Логика выхода пользователя
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
