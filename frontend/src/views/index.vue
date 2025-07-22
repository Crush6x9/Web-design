<template>
  <div class="head">
    <img src="../../public/repository.png">
  </div>
</template>

<script>
export default {
  name: 'Header'
}
</script>

<style scoped>
.head {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 100vh;
  width: 100%;
}

.head img {
  max-width: 100%;
  max-height: 100%;
  object-fit: contain;
}
</style>
