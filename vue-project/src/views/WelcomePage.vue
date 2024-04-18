<template>
  <div id="WelcomePage">
    <form @submit.prevent="submitForm" class="login-form">
      <img src="./assect/Logo.jpg" alt="StockTrack Pro Logo" class="logo">

      <h1>StockTrack Pro</h1>

      <button>
        <router-link to="/login">Войти</router-link>
      </button>
    </form>
  </div>
</template>

<style scoped>

.login-form {
  text-align: center;
}

.logo {
  width: 250px;
  height: auto;
  margin-bottom: 10px;
}

h1 {
  font-family: 'Segoe UI Light', sans-serif;
  align-items: center;
  margin-bottom: 200px;
  color: #7B5244;
}


</style>

<script>
export default {
  name: "WelcomePage",
  methods: {
    submitForm() {
      // Логика отправки формы
    }
  }
}
</script>
