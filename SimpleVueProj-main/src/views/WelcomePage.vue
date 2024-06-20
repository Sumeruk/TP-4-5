<template>
  <div id="WelcomePage">
    <form @submit.prevent="submitForm" class="login-form">
      <img src="./assect/Logo.jpg" alt="StockTrack Pro Logo" class="logo">
      <h1>StockTrack Pro</h1>

    </form>
    <button>
      <router-link to="/login" class="actions">Войти</router-link>
    </button>
  </div>
</template>

<script>
import api from "@/api/api";

export default {
  name: "WelcomePage",

  created() {
    this.logout();
    this.reset();
  },
  methods: {
    logout(){
      api.logout(localStorage.getItem('id')).then(response =>{
        console.log(response.status);
      }).catch(error =>{
        console.log(error.status);
      })
    },
    reset(){
      localStorage.removeItem("jwtToken");
      localStorage.removeItem("role");
      localStorage.removeItem("id");
    }
  }
}
</script>


<style scoped>

.login-form {
  text-align: center;
  margin-top: 10%;
}

.logo {
  width: 150px;
  height: auto;
  margin-bottom: 10px;
  /*margin-left: 10%; !* Сдвигаем картинку вправо на 20% относительно ширины родительского элемента *!*/
}

h1 {
  font-family: 'Segoe UI Light', sans-serif;
  align-items: center;
  color: #7B5244;
  /*margin-top: 140px;*/
}

.actions{
  display: block;
  padding: 10px;
  border-radius: 40px;
}

button {
  margin-top: 80px; /* Отступ сверху для кнопки */
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 40%;
  font-size: 18px;
}

button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}

</style>


