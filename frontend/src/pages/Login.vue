<template>
  <div class="login">
      <app-header></app-header>
      
        ,<div class="row d-flex justify-content-center mt-5">
            <div class="login-row col-sm-4">
                <h4 class="pb-4 text-center">Entrar</h4>
                <form>
                    <div class="form-group">
                        <label for="exampleInputEmail1">E-mail</label>
                        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" placeholder="Digite seu email...">
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Senha</label>
                        <input type="password" class="form-control" id="exampleInputPassword1" placeholder="******">
                    </div>
                    
                    <button type="submit" class="btn btn-primary">Entrar</button>
                </form>
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

    .login-row{
        background-color: #f6f6f6;
        padding-top: 20px;
        padding-bottom: 50px;
        padding-left: 30px;
        padding-right: 30px;

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