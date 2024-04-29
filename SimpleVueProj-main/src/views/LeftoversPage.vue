<template>
  <div>
    <HeadSiteForBoss />

    <h2 class="page-title">Остатки товара</h2>

    <table>
      <thead>
      <tr>
        <th>Название продукта</th>
        <th>Количество</th>
        <th>Штрихкод</th>
        <th>Артикул</th>
      </tr>
      </thead>
      <tbody>
      <tr>
        <td>Название продукта</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
      </tr>
      <tr>
        <td>Название продукта</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
      </tr>
      <tr>
        <td>Название продукта</td>
        <td>0</td>
        <td>0</td>
        <td>0</td>
      </tr>
      </tbody>
    </table>
  </div>
</template>

<script>
import HeadSiteForBoss from "@/components/HeadSiteForBoss";
export default {
  components:{
    HeadSiteForBoss
  },
  name: "LeftoversPage"
}
</script>

<style scoped>
.page-title {
  text-align: center;
  margin-top: -300px; /* Уменьшил отрицательный отступ */
}

table {
  width: 100vw;
  border-collapse: collapse;
  margin: auto;
}

th, td {
  border: 1px solid #7B5244; /* Изменил цвет границ ячеек на черный */
  padding: 8px;
  text-align: center;
  color: #7B5244;
}

th {
  background-color: #D3AFAA;
}
</style>