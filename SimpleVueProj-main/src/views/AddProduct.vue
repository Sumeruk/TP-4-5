<template>
  <div class="container">
    <div class="header">
      <router-link to="/home">
        <img src="./assect/Home.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/employees">
        <img src="./assect/Profile.jpg" alt="StockTrack Pro Logo">
      </router-link>
      <router-link to="/report">
        <img src="./assect/Add.jpg" alt="StockTrack Pro Logo">
      </router-link>
    </div>
    <h1>Добавить товар</h1>
    <form action="/submit_product" method="POST">
      <label for="product_name">Название товара</label>
      <input type="text" id="product_name" name="product_name" required>

      <label for="description">Описание</label>
      <textarea id="description" name="description"></textarea>

      <label for="sku">Артикул</label>
      <input type="text" id="sku" name="sku">

      <label for="barcode">Штрих-код</label>
      <input type="text" id="barcode" name="barcode">

      <label for="weight">Вес (г)</label>
      <input type="number" id="weight" name="weight" min="0.01" step="0.01">

      <label for="unit">Единица измерения</label>
      <select id="unit" name="unit">
        <option value="шт">шт</option>
        <option value="кг">кг</option>
        <option value="г">г</option>
        <option value="л">л</option>
        <option value="мл">мл</option>
      </select>

      <label for="supplier">Поставщик</label>
      <input type="text" id="supplier" name="supplier">

      <label for="price">Цена</label>
      <input type="number" id="price" name="price" min="0.01" step="0.01" required>

      <label for="quantity">Количество</label>
      <input type="number" id="quantity" name="quantity" min="1" required>

      <input type="submit" value="Добавить товар">
    </form>
  </div>
</template>

<script>
export default {
  // Логика компонента
};
</script>

<style>
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
  z-index: 1;
}

h1{
  margin-top: 100px;
}
body {
  font-family: Arial, sans-serif;
  margin: 20px;
  padding: 20px;
  box-sizing: border-box;
}
.container {
  width: 30%;
  margin: 20px auto;
  margin-top: 200px;
}
form {
  border: 1px solid #fff;
  padding: 20px;
  border-radius: 5px;
}
h1 {
  position: absolute;
  top: 10px;
  left: 50%;
  transform: translateX(-50%);
  color: #7B5244;
}
label {
  display: block;
  margin-bottom: 10px;
}
input[type="text"],
input[type="number"] {
  width: 100%;
  padding: 8px;
  margin-bottom: 10px;
  border: 1px solid #F9F6DE;
  background-color: #F9F6DE;
  border-radius: 4px;
  box-sizing: border-box;
}
input[type="submit"] {
  margin-top: 10px;
  padding: 10px 60px;
  border-radius: 40px;
  background-color: #D3AFAA;
  color: #7B5244;
  border: none;
  cursor: pointer;
  width: 100%;
  font-size: 18px;
}
input[type="submit"]:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}
</style>
