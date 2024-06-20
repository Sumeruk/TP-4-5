<template>
  <div class="containerForAddUser">
    <HeadSiteForAdm/>
    <h2>Новый аккаунт</h2>
    <p id="error-message" class="hidden" v-if="errorMessage">{{ errorMessage }}</p>
    <form @submit.prevent="createUser">
      <label for="username">Имя</label>
      <input type="text" id="username" v-model="newUser.name" required>
      <label for="usersurname">Фамилия</label>
      <input type="text" id="usersurname" v-model="newUser.surname">
      <label for="email">Почта</label>
      <input type="email" id="email" v-model="newUser.email" required>

      <label for="phone">Номер телефона</label>
      <input type="tel" id="phone" v-model="newUser.phone">

      <label for="birthdate">Дата Рождения</label>
      <input type="date" id="birthdate" v-model="newUser.birthday">

      <label for="position">Должность</label>
      <select id="position" name="position" v-model="newUser.role" required>
        <option value="Кладовщик">Кладовщик</option>
        <option value="Магазин">Магазин</option>
        <option value="Начальник склада">Начальник склада</option>
        <option value="Администратор">Администратор</option>
      </select>

      <button type="submit">
        Создать
      </button>
    </form>
  </div>

</template>

<script>
import HeadSiteForAdm from "@/components/HeadSiteForAdm";
import api from "@/api/api";
import router from "@/router";

export default {
  components: {
    HeadSiteForAdm
  },

  data() {
    return {
      newUser: {
        name: '',
        surname: '',
        email: '',
        phone: '',
        birthday: '',
        role: '',
      },
      errorMessage: 'dfvdf'
    }
  },

  methods: {
    createUser() {
      if (this.newUser.role === "Магазин") {
        api.createUser(this.newUser).then(response => {
          console.log(response.status);
          router.push('/employee/allEmployers');
        })
            .catch(error => {
              console.error(error);
            });
      } else {
        if (this.newUser.surname === '') {
          this.showErrorMessage();
          this.errorMessage = 'Необходимо заполнить фамилию!';
        } else {
          api.createUser(this.newUser).then(response => {
            console.log(response.status);
            router.push('/employee/allEmployers');
          })
              .catch(error => {
                console.error(error);
              });
        }
      }
    },
    showErrorMessage() {
      const errorMessage = document.getElementById('error-message');
      errorMessage.classList.remove('hidden');
      errorMessage.classList.add('show');
    }
  }

// Логика компонента
}
;
</script>

<style scoped>
.hidden {
  display: none;
}

.show {
  display: block;
  font-family: 'Roboto', sans-serif;
  color: #7B5244;
  font-size: 20px;
}

/*div{*/
/*  border: 1px solid black;*/
/*}*/

.containerForAddUser {
  width: 30%;
  margin-top: 8%;
  margin-left: 35%;

}

form {
  display: flex;
  flex-direction: column;
  align-items: flex-start; /* располагаем элементы слева */
  padding: 20px;
  border: 1px solid #fff;
  border-radius: 5px;
  font-family: 'Roboto', sans-serif;
}

h2 {
  margin-top: 50px;
  color: #7B5244;
}

form label {
  margin-bottom: 5px; /* добавляем небольшое расстояние между метками и полями ввода */
}

form input {
  margin-bottom: 10px; /* добавляем небольшое расстояние между полями ввода */
  padding: 8px;
  width: 95%;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
}

.action {
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 10px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%; /* Ширина кнопки равна ширине формы */
  font-size: 18px;
  padding: 10px;

  /*padding: 10px 20px;
  border-radius: 5px;
  background-color: #007bff;
  color: #fff;
  border: none;
  cursor: pointer;
  width: 100%;*/

}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
