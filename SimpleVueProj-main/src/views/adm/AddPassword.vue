<template>
  <div id="Registration">
    <HeadSiteForAdm/>

    <h2>Установка пароля</h2>
    <form @submit.prevent="submitForm">
      <label for="username">Пароль</label>
      <input type="text" id="username" v-model="username">

      <label for="usersurname">Подтвердите пароль</label>
      <input type="text" id="usersurname" v-model="usersurname">
    </form>
    <button>
      <router-link to="/adm" class="action">Создать новый пароль</router-link>
    </button>

  </div>
</template>

<script>
import HeadSiteForAdm from "@/components/HeadSiteForAdm";
export default {
  components:{
    HeadSiteForAdm
  }
  // Логика компонента
};
</script>

<style scoped>

@import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;700&display=swap');

/*#Registration{*/
/*  width: 20%;*/
/*}*/

/*form {*/
/*  display: flex;*/
/*  flex-direction: column;*/
/*  align-items: flex-start; !* располагаем элементы слева *!*/
/*  padding: 20px;*/
/*  border: 1px solid #fff;*/
/*  border-radius: 5px;*/
/*  font-family: 'Roboto', sans-serif;*/
/*  position: relative;*/
/*}*/

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
  width: 300px;
  border-radius: 3px;
  border: 1px solid #ccc;
  background-color: #F9F6DE;
}
.action{
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
}
button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
