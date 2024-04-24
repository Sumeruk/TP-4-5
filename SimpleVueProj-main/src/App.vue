<template>
  <router-view/>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

a{
  text-decoration: none;
  color: #7B5244;
}
router-link{
  text-decoration: none;
  color: #D3AFAA;
}

a:hover{
  text-decoration: none;
  color: #D3AFAA;
}
router-link:hover{
  text-decoration: none;
  color: #7B5244;
}

nav {
  padding: 30px;
}

nav a {
  font-weight: bold;
  color: #2c3e50;
}

nav a.router-link-exact-active {
  color: #42b983;
}
</style>
