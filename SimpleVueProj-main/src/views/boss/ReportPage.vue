<template>
  <div id="Report">
    <HeadSiteForBoss />

    <h2>Отчет</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Тип</label>
      <select v-model="selectedValue">
        <option value="1">Отчет по заказам</option>
        <option value="2">Отчет по работе кладовщиков</option>
        <option value="3">Отчет по дате</option>
        <option value="4">Отчет по товарам</option>
      </select>

      <br>

      <label for="periodStart">Период составления отчета</label>
      <input id="periodStart" type="date" v-model="periodStart">
      <input id="periodEnd" type="date" v-model="periodEnd">

    </form>
    <button @click="createReport">
      Создать
    </button>

    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>

    <div v-if="this.orderReport.length !== 0" class="productTable">
      <table>
        <thead>
        <tr>
          <th>Номер заказа</th>
          <th>Магазин</th>
          <th>Имя кладовщика</th>
          <th>Фамилия кладовщика</th>
          <th>Телефон</th>
          <th>Дата</th>
          <th>Количество позиций товаров</th>
          <th>Количество товаров</th>
          <th>Общая стоимость</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(record, index) in orderReport" :key="index">
          <td >{{ record.orderId }}</td>
          <td >{{ record.shop }}</td>
          <td >{{ record.empl_name }}</td>
          <td >{{ record.empl_surname }}</td>
          <td >{{ record.phone }}</td>
          <td >{{ record.date }}</td>
          <td >{{ record.numb_prod_items }}</td>
          <td >{{ record.prod_amount }}</td>
          <td >{{ record.cost}}</td>
        </tr>
        </tbody>
      </table>
    </div>

    <div v-if="this.userReport.length !== 0" class="productTable">
      <table>
        <thead>
        <tr>
          <th>Имя кладовщика</th>
          <th>Фамилия кладовщика</th>
          <th>Собрано позиций товаров</th>
          <th>Собрано количество товаров</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(record, index) in userReport" :key="index">
          <td >{{ record.name }}</td>
          <td >{{ record.surname }}</td>
          <td >{{ record.position_amount }}</td>
          <td >{{ record.all_amount }}</td>
        </tr>
        </tbody>
      </table>
    </div>

    <div v-if="this.dateReport.length !== 0" class="productTable">
      <table>
        <thead>
        <tr>
          <th>Номер заказа</th>
          <th>Магазин</th>
          <th>Имя кладовщика</th>
          <th>Фамилия кладовщика</th>
          <th>Телефон</th>
          <th>Название товара</th>
          <th>Количество товаров</th>
          <th>Дата</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(record, index) in dateReport" :key="index">
          <td >{{ record.orderId }}</td>
          <td >{{ record.shop }}</td>
          <td >{{ record.empl_name }}</td>
          <td >{{ record.empl_surname }}</td>
          <td >{{ record.phone }}</td>
          <td >{{ record.prod_name }}</td>
          <td >{{ record.prod_amount }}</td>
          <td >{{ record.date }}</td>
        </tr>
        </tbody>
      </table>
    </div>

    <div v-if="this.productReport.length !== 0" class="productTable">
      <table>
        <thead>
        <tr>
          <th>Артикул</th>
          <th>Название товара</th>
          <th>Магазин</th>
          <th>Количество</th>
          <th>Общая стоимость товара</th>

        </tr>
        </thead>
        <tbody>
        <tr v-for="(record, index) in productReport" :key="index">
          <td >{{ record.id }}</td>
          <td >{{ record.prod_name }}</td>
          <td >{{ record.shop }}</td>
          <td >{{ record.amount }}</td>
          <td >{{ record.cost }}</td>
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
  components:{
    HeadSiteForBoss
  },
  data(){
    return {
      selectedValue: null,
      periodStart: '',
      periodEnd:'',
      report:[],
      orderReport:[],
      userReport:[],
      dateReport:[],
      productReport:[],

      errorMessage:'dfvdf'
    }
  },

  methods:{
    createReport(){
      console.log(this.selectedValue);

      if (this.selectedValue === "1"){
        api.ordersAnalytics(this.periodStart, this.periodEnd).then(response =>{
          console.log(response.data)
          this.orderReport = response.data;
          console.log(response.status);
        }).catch(error =>{
          console.error(error)
          this.showErrorMessage();
          this.errorMessage = 'Невозможно создать отчет!';
        })
      }

      if (this.selectedValue === "2"){
        api.userAnalytic(this.periodStart, this.periodEnd).then(response =>{
          this.userReport = response.data;
          console.log(response.status);
        }).catch(error =>{
          console.error(error)
          this.showErrorMessage();
          this.errorMessage = 'Невозможно создать отчет!';
        })
      }

      if (this.selectedValue === "3"){
        api.dateAnalytic(this.periodStart).then(response =>{
          this.dateReport = response.data;
          console.log(response.status);
        }).catch(error =>{
          console.error(error)
          this.showErrorMessage();
          this.errorMessage = 'Невозможно создать отчет!';
        })
      }

      if (this.selectedValue === "4"){
        api.productAnalytic(this.periodStart, this.periodEnd).then(response =>{
          console.log(response.data);
          this.productReport = response.data;
          console.log(response.status);
        }).catch(error =>{
          console.error(error)
          this.showErrorMessage();
          this.errorMessage = 'Невозможно создать отчет!';
        })
      }
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

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}

.hidden {
  display: none;
}

form {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
  position: relative;
  margin-left: 43.5%;
}

select{
  width: 300px;
  margin-left: -10%;
}

h2 {
  margin-top: 7%;
  color: #7B5244;
}

.actions{
  display: block;
  padding: 10px;
  border-radius: 40px;
}
form label {
  margin-bottom: 5px;
  margin-left: -10%/* добавляем небольшое расстояние между метками и полями ввода */
}

form input {
  margin-bottom: 10px; /* добавляем небольшое расстояние между полями ввода */
  padding: 8px;
  width: 300px;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
  margin-left: -10%;
}

button {
  margin-top: 10px;
  border-radius: 40px;
  padding: 10px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 30%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}

table {
  width: 95%;
  margin-top: 5px;
  margin-left: 2%;
  margin-right: 2%;
  border-collapse: collapse;
  align-items: center;
}

th, tr, td {
  max-width: 50%;
  min-width: 100px;
  border: 1px solid #7B5244; /* Изменил цвет границ ячеек на черный */
  padding: 8px;
  text-align: center;
  color: #7B5244;
  word-wrap: anywhere;
}

th {
  background-color: #D3AFAA;
}
</style>
