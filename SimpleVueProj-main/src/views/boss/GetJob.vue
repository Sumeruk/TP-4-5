<template>
  <div id="getJobHome">
    <!-- Шапка с кнопками -->
    <HeadSiteForBoss/>

    <div class="order">
      Заказ:
      <div class="orders-form" v-if="order">
        <router-link :to="{name : 'order', params :{orderId: order.id} }" class="orderLink">
          №{{ this.order.id }}
        </router-link>
      </div>
      <div class="empty-order" v-else>
        <br>
        Заказов для выполнения нет
      </div>
    </div>

    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>

    <div class="empl">

      <div v-for="(employee, index) in employees" :key="index" class="employee-form"
           :class="{ 'first-form': index === 0 }">

        <div>
          <img src="../assect/NullFace.png" class="avatar" alt="StockTrack Pro Logo">
        </div>

        <div>
          <p>{{ employee.name }}</p>
          <p>{{ employee.position }}</p>
        </div>

        <div>
          <button @click='getJobForEmployer(this.order.id, employee.id)'>
            Выдать задание
          </button>
<!--            <router-link to="/home" class="actions">Выдать задачу</router-link>-->

        </div>
      </div>
    </div>

  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
import api from "@/api/api";

export default {
  components: {
    HeadSiteForBoss
  },
  name: "GetJob",
  data() {
    return {
      employees: [
        {id: 0, name: '', position: ''},
        // {id: 13, name: 'Cергей Мамаев', position: 'Кладовщик'},
        // {id: 14, name: 'Максим Иванченко', position: 'Кладовщик'},
        // {id: 15, name: 'Вадим Вахитов', position: 'Кладовщик'},
        // {id: 16, name: 'Сергей Безручко', position: 'Кладовщик'}
      ],
      order: {id: 0, number: ''},
      errorMessage:'dfvdf',
    };
  },
  created() {
    this.getOrder();
    this.getEmployersForJob();
  },
  methods: {
    getOrder() {
      api.getOrderForBoss().then(response => {
        this.order = response.data;
        console.log(response.status);
      }).catch(error => {
        console.log(error)
      });
    },
    getEmployersForJob() {
      api.getEmployersForJob().then(response => {
        this.employees = response.data;
        console.log(response.status);
      }).catch(error => {
        console.log(error);
      });
    },

    getJobForEmployer(orderId, employeeId) {
      console.log(orderId, employeeId);

      if (orderId !== undefined){
        api.setEmployerToOrder(orderId, employeeId).then(response => {
          console.log(response.status);

        }).catch(error => {
          console.log(error);
        });

        api.getJobForEmployer(employeeId).then(response => {
          console.log(orderId)
          console.log(response.status);
        }).catch(error => {
          console.log(error);
        });

        this.getEmployersForJob();

        location.reload();
      } else {
        this.showErrorMessage();
        this.errorMessage = "Нет заказов для выдачи";
      }
    },

    showErrorMessage() {
      const errorMessage = document.getElementById('error-message');
      errorMessage.classList.remove('hidden');
      errorMessage.classList.add('show');
    }

  }
}
</script>

<style scoped>
/*div {*/
/*  border: 1px solid black;*/
/*}*/

.hidden {
  display: none;
}

.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}

#getJobHome {
  display: flex;
  flex-direction: column;
  align-items: center;
  min-height: 100vh;
  width: 50%;
  margin-left: 26%;
  /*overflow-y: visible;*/
}

.actions {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

.order {
  width: 30%;
  margin-top: 12%;
  /*position: absolute;*/
}

.orders-form {
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
  margin-top: 0;
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
  padding: 10px;
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

.orderLink:hover {
  color: #654321;
}
</style>