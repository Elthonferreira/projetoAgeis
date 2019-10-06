<template>
  <footer class="footer-wrapper">
        <div class="footer-content">
            © 2019 Todos os direitos reservados.
        </div>
    </footer>
</template>

<script>
export default {

}
</script>

<style scoped>
    .footer-wrapper {
        position: absolute;
        bottom: 0;
        width: 100%;
    }

    .footer-content {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 30px;
        width: 100%;
        margin-top: 20px;
        background: #4676ff;
        color: #fff;
        font-weight: 500;   
    }
</style>