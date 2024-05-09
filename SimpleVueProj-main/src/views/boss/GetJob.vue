<template>
  <div id="home">
    <!-- Шапка с кнопками -->
    <HeadSiteForBoss/>

    <div class="job">
      Заказ:
      <div v-for="(job, index) in jobs" :key="index" class="jobs-form"
           :class="{ 'first-form': index === 0 }">

        <div>
          {{ job.name }}
          {{ job.amount }}
        </div>
      </div>
    </div>

    <div class="empl">

      <div v-for="(employee, index) in employees" :key="index" class="employee-form"
           :class="{ 'first-form': index === 0 }">

        <div>
          <img src="../assect/Face.jpg" class="avatar" alt="StockTrack Pro Logo">
        </div>

        <div>
          <p>{{ employee.name }}</p>
          <p>{{ employee.position }}</p>
        </div>

        <div>
          <button>
            <router-link to="/home" class="actions">Выдать задачу</router-link>
          </button>
        </div>
      </div>
    </div>

  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";

export default {
  components: {
    HeadSiteForBoss
  },
  name: "GetJob",
  data() {
    return {
      employees: [
        {name: 'Иван Иванов', position: 'Кладовщик'},
        {name: 'Иван Иванов', position: 'Кладовщик'},
        {name: 'Иван Иванов', position: 'Кладовщик'},
        {name: 'Иван Иванов', position: 'Кладовщик'},
        {name: 'Иван Иванов', position: 'Кладовщик'}
      ],
      jobs: [
        {name: 'SNICKERS', amount: '30шт'},
        {name: 'Ноутбук Vivo', amount: '5шт'},
      ]
    };
  },
}
</script>

<style scoped>
/*div {*/
/*  border: 1px solid black;*/
/*}*/

#home {
  display: flex;
  flex-direction: row;
  align-items: center;
  min-height: 100vh;
  width: 50%;
  overflow-y: visible;
}

.actions {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

.job {
  width: 50%;
  margin-top: -60%;
}
.jobs-form{
  max-width: 600px; /* Ограничиваем максимальную ширину формы */
  padding: 20px;
  border: 5px solid #ffffff;
  border-radius: 40px;
  font-family: 'Roboto', sans-serif;
  background-color: #D3AFAA;
  text-align: center;
  display: flex;

}

.empl {
  margin-top: 29%;
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