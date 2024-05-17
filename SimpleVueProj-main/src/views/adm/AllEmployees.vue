<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSite/>

    <div class="searchDiv">
      <button class="butt">
        <router-link to="/employee/newUser" class="actions">Добавить</router-link>
      </button>
      <input type="text" v-model="search" placeholder="Поиск...">
      <button class="actions" @click="searchEmployers(search)">найти</button>
    </div>

    <!-- Формы для каждого сотрудника -->
    <div v-for="(employee) in employees" :key="employee.id" class="employee-form">

      <div>
        <img src="../assect/Face.jpg" class="avatar" alt="StockTrack Pro Logo">
      </div>

      <div>
        <p>{{ employee.name }}</p>
        <p>{{ employee.position }}</p>
      </div>

      <div>
        <button>
          <router-link :to="{name : 'editEmpl', params:{id: employee.id}}" class="actions">Редактировать</router-link>
        </button>
        <button class="actions" @click="deleteEmployer(employee.id)">
          Удалить
        </button>
      </div>
    </div>
  </div>
</template>

<script>
import HeadSite from "@/components/HeadSiteForAdm";
import api from '../../api/api.js';

export default {
  components: {
    HeadSite
  },

  data() {
    return {
      employees: [
        {id: 11, name: 'Иван Иванов', position: 'Кладовщик'},
        {id: 12, name: 'Иван Иванов', position: 'Кладовщик'},
        {id: 13, name: 'Иван Иванов', position: 'Кладовщик'},
        {id: 14, name: 'Иван Иванов', position: 'Кладовщик'},
        {id: 15, name: 'Иван Иванов', position: 'Кладовщик'},
        {id: 16, name: 'Иван Иванов', position: 'Кладовщик'},
      ],
      search:''
    };
  },

  created() {
    this.getAllEmployers();
  },

  methods: {
    getAllEmployers() {
      api.getAllEmployers().then(entities => {
        this.employees = entities;
      })
          .catch(error => {
            console.error(error);
          });
    },
    deleteEmployer(id) {
      api.deleteEmployer(id).then(response => {
        console.log(response.data);
        this.getAllEmployers();
      })
          .catch(error => {
            console.error(error);
          });
    },
    searchEmployers(parameters){
      api.searchEmployers(parameters).then(response => {
        this.employees = response;
      })
          .catch(error => {
            console.error(error);
          });
    }
  }

};
</script>

<style scoped>
/*div{*/
/*  border: 1px solid black;*/
/*}*/
#home {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
  height: 600px;
  overflow-y: visible;
  width: 50%;
}

.searchDiv {
  margin-top: 15%;
  display: flex;
  align-items: center;
  width: 80%;
}

.searchDiv input {
  padding: 12px; /* Увеличиваем внутренние отступы */
  border-radius: 40px; /* Увеличиваем радиус скругления */
  border: 2px solid #F9F6DE; /* Увеличиваем толщину границы */
  margin-right: 10px; /* Уменьшаем отступ между строкой поиска и кнопкой */
  font-size: 16px; /* Увеличиваем размер шрифта */
  margin-top: 31px;
  width: 33%;
}

.searchDiv .actions{
  display: block;
  padding: 10px;
  border-radius: 40px;
  width: 33%;
}

.butt {
  width: 33%; /* Автоматическая ширина, чтобы кнопка подстраивалась под содержимое */
  border: 10px solid #ffffff;
}

.actions {
  display: block;
  padding: 10px;
  border-radius: 40px;
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