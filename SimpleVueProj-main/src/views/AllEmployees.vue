<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <div class="header">
      <router-link to="/home">
        <img src="./assect/Home.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/employees">
        <img src="./assect/Profile.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/product">
        <img src="./assect/Add.jpg" alt="StockTrack Pro Logo">
      </router-link>
    </div>

    <!-- Формы для каждого сотрудника -->
    <div v-for="(employee, index) in employees" :key="index" class="employee-form" :class="{ 'first-form': index === 0 }">
      <h2>{{ employee.name }}</h2>
      <img :src="employee.image" class="avatar" alt="Employee Avatar">
      <label for="username">Имя:</label>
      <input type="text" v-model="employee.name" required>
      <label for="position">Должность:</label>
      <input type="text" v-model="employee.position">
      <label for="department">Отдел:</label>
      <input type="text" v-model="employee.department">
      <label for="salary">Зарплата:</label>
      <input type="number" v-model="employee.salary" min="0">
      <button type="submit">Сохранить</button>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      employees: [
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },
        { name: 'Иван Иванов', position: 'Менеджер', department: 'Продажи', salary: 50000, image: './assect/Face1.jpg' },

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
}

/* Стили для шапки */
.header {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  display: flex;
  justify-content: space-around;
  padding: 5px 10px;
  background-color: #D3AFAA;
  border-bottom: 1px solid #ccc;
}

.header router-link {
  margin-right: 10px; /* Добавляем отступ между элементами */
}

.header router-link, .header button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #D3AFAA;
  color: #7B5244;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.header router-link:hover, .header button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
h1{
  margin-top: 100px;
}

/* Стили для формы */
.employee-form {
  position: ;
  bottom: 20px; /* Расстояние от нижнего края окна браузера до низа формы */
  left: 50%; /* Располагаем форму по горизонтали по центру */
  transform: translateX(-50%); /* Центрируем форму относительно ее ширины */
  width: 90%; /* Задаем ширину формы */
  max-width: 600px; /* Ограничиваем максимальную ширину формы */
  padding: 20px;
  border: 1px solid #ffffff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  background-color: #F9F6DE;
  text-align: center;
}

.first-form {
  margin-top: 250px; /* Отступ сверху только для первой формы */
}

h2 {
  color: #7B5244;
  margin-bottom: 20px;
}

.avatar {
  width: 100px;
  height: auto;
  margin-bottom: 10px;
}

label {
  display: block;
  margin-bottom: 10px;
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
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
