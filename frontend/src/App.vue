
<template>
  <v-app id="inspire">

    <v-main>
    <router-view></router-view>
    </v-main>
  </v-app>

</template>

<script>
  export default {
    name: 'Main',
    data: () => ({ drawer: null }),
  }
</script>