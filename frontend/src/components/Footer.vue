<template>
  <footer class="footer-wrapper">
    <div class="footer-content">© 2019 Todos os direitos reservados.</div>
  </footer>
</template>

<script>
export default {};
</script>

<style scoped>
.footer-wrapper {
  position: absolute;
  bottom: 0;
  min-width: 100%;
}

.footer-content {
  display: flex;
  justify-content: center;
  align-items: center;
  height: 30px;
  min-width: 100%;
  background: #f7f7f7;
  color: #000;
  font-weight: 500;
  box-shadow: 10px 0px 0px 0px #888888;
}
</style>