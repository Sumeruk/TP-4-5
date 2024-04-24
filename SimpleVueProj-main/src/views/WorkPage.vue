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

    <div class="homeBoss">
      <div class="info-row">
        <img src="./assect/Face.jpg" alt="StockTrack Pro Logo" class="avatar">
        <div>
          <h1 class="welcome-text">Привет, Добро пожаловать</h1>
          <h1 class="welcome-text">Джон доу</h1>
        </div>
      </div>
    </div>

    <!-- Формы для каждого сотрудника -->
    <div v-for="(employee, index) in employees" :key="index" class="employee-form" :class="{ 'first-form': index === 0 }">
      <div class="number">
        <p>№240502-2845</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  data() {
    return {
      employees: [
        { name: 'Иван Иванов', position: 'Кладовщик'},
        { name: 'Иван Иванов', position: 'Кладовщик'},
        { name: 'Иван Иванов', position: 'Кладовщик'},
        { name: 'Иван Иванов', position: 'Кладовщик'},
        { name: 'Иван Иванов', position: 'Кладовщик'}
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
  text-decoration: underline;
}

.search {
  margin-top: 200px;
  display: flex;
  align-items: center;
  width: 80%;
}

.search input {
  flex: 1; /* Растягиваем на всю доступную ширину */
  padding: 12px; /* Увеличиваем внутренние отступы */
  border-radius: 40px; /* Увеличиваем радиус скругления */
  border: 2px solid #F9F6DE; /* Увеличиваем толщину границы */
  margin-right: 10px; /* Уменьшаем отступ между строкой поиска и кнопкой */
  font-size: 16px; /* Увеличиваем размер шрифта */
  margin-top: 31px;
}

.butt {
  width: 50%; /* Автоматическая ширина, чтобы кнопка подстраивалась под содержимое */
  border: 10px solid #ffffff;
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
