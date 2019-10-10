<template>
  <div class="login">
      <app-header></app-header>
      <div class="content-body">
            <div class="row">
                <div class="box-login">
                    <div class="input-field col s12">
                        <input id="nome" type="text" class="validate">
                        <label for="nome">Nome</label>
                    </div>
                    <div class="input-field col s12">
                        <input id="password" type="password" class="validate">
                        <label for="password">Senha</label>
                    </div>
                </div>
            </div>
          
      </div>
      <app-footer></app-footer>
  </div>
</template>

<script>
    import AppHeader from "../components/Header.vue"
    import AppFooter from "../components/Footer.vue"

export default {
    name: "login",
    components: {
      AppHeader, AppFooter
    },
    data() {
        return {
            
        }
    }, 
    methods: {

    }
}
</script>

<style scoped>
    body {
        background-image: url('http://www.lcrcientifica.com/imagens/posts/large/lcr-cientifica-como-montar-uma-laboratorio-de-analises-clinicas14032019.jpg');
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
    }

    .box-login {
        width: 700px;
        height: 600px;
        background: #f3f3f3;
        border-radius: 15px;
        margin: 0 auto;
        margin-top: 120px;
    }
    
</style>