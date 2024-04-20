<template>
  <div class="privacy-policy">
    <div class="header">
      <router-link to="/home">
        <img src="./assect/Home.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/registration">
        <img src="./assect/Profile.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/product">
        <img src="./assect/Add.jpg" alt="StockTrack Pro Logo">
      </router-link>
    </div>

    <h2>Политика конфиденциальности</h2>
    <p>Последнее обновление: 14.08.2024</p>
    <ul>Мы,  обязуемся соблюдать законодательство в области защиты персональных данных и гарантировать конфиденциальность и безопасность персональных данных пользователей.</ul>

    <p>Условия использования</p>
    <ul>Настоящая Политика может быть изменена или прекращена Администрацией в одностороннем порядке без предварительного уведомления Пользователя. Новая редакция Политики вступает в силу с момента ее размещения на Сайте. Действующая редакция Политики находится на Сайте</ul>

    <ul>Мы не продаем, не обмениваем и не передаем вашу личную информацию третьим лицам без вашего согласия, за исключением случаев, когда это необходимо для выполнения наших обязательств перед вами, или когда это требуется законом.</ul>
  </div>
</template>

<script>
export default {
  name: "PrivacyPolicy"
}
</script>

<style scoped>
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

.privacy-policy {
  max-width: 800px;
  margin: 0 auto;
  padding: 20px;
  font-family: Arial, sans-serif;
  color: #333;
}

h2 {
  color: #7B5244;
  margin-bottom: 10px;
  margin-top: 110px;
}

p{
  text-align: left;
  color: #7B5244;
}

h3 {
  color: #000;
  margin-top: 20px;
}

ul {
  margin-bottom: 20px;
}

li {
  margin-bottom: 5px;
}
</style>
