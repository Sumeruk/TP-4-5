<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSite />

    <div class="search">
      <button class="butt">
        <router-link to="/registration">Добавить</router-link>
      </button>
      <input type="text" placeholder="Поиск...">
    </div>

    <!-- Формы для каждого сотрудника -->
    <div v-for="(employee, index) in employees" :key="index" class="employee-form" :class="{ 'first-form': index === 0 }">

      <div>
        <img src="./assect/Face.jpg" class="avatar" alt="StockTrack Pro Logo">
      </div>

      <div>
        <p>{{ employee.name }}</p>
        <p>{{ employee.position }}</p>
      </div>

      <div>
        <button>
          <router-link to="/edit">Редактировать</router-link>
        </button>
        <button>
          <router-link to="/delete">Удалить</router-link>
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import HeadSite from "@/components/HeadSiteForBoss";
export default {
  components: {
    HeadSite
  },

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
}

.first-form {
  margin-top: 50px; /* Отступ сверху только для первой формы */
}

.avatar {
  width: 100px;
  height: 100px; /* Устанавливаем размеры */
  border-radius: 50%; /* Добавляем скругление */
  margin-bottom: 10px;
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
</style>