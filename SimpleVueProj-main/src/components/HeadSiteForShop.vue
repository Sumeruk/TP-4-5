<template>
  <div class="header">
    <router-link to="/shop">
      <img src="../views/assect/Home.svg" alt="StockTrack Pro Logo">
    </router-link>
    <router-link to="/">
      <img src="../views/assect/logout.svg" alt="StockTrack Pro Logo" width="45" height="35" class="logout">
    </router-link>
  </div>
</template>

<script>
import router from "@/router";

export default {
  name: "HeadSiteForShop",

  created() {
    this.checkRole();
  },

  methods: {
    checkRole(){
      // const decoded = jwtDecode.verify(localStorage.getItem("jwtToken"),
      //     "d02171be0387362dcb67f64f305f2a39bd952b6a527e40134364fc3d9f99d6f9")
      //
      // console.log(decoded);
      if (localStorage.getItem("role") !== "Магазин"){
        router.push('/login');
      }
    }
  }
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
  z-index: 1;
}

.header router-link {
  margin-right: 10px; /* Добавляем отступ между элементами */
}

.header router-link, .header button {
  padding: 10px 20px;
  border: none;
  border-radius: 5px;
  background-color: #D3AFAA;
  color: #7B5244;
  text-decoration: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
}

.header router-link:hover, .header button:hover {
  background-color: #7B5244;
  color: #D3AFAA;
}


.logout{
  margin-top: 8px;
}
</style>