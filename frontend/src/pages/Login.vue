<template>
  <div class="login">
      <body>
          <app-header></app-header>
      
            <div class="login-content">
                <div class="login-row">
                    <h4 class="text-center">Login</h4>
                    <form action="/#/bodyregion1">
                        <div class="form-group">
                            <label for="exampleInputEmail1">E-mail</label>
                            <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp" >
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Senha</label>
                            <input type="password" class="form-control" id="exampleInputPassword1" >
                        </div>
                        <div class="wrapper-button-submit">
                            <button type="submit" class="btn btn-primary">Entrar</button>
                        </div>

                        <div class="box-register">
                            <a class="waves-effect waves-light btn button-register" href="/#/userRegister">Registrar-se como um usuário</a>
                            <a class="waves-effect waves-light btn button-register" href="/#/clinica">Registrar-se como uma clínica</a>
                        </div>
                    </form>
                </div>
            </div>

        <app-footer></app-footer>
      </body>
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
        height: 100vh;
        background-image: url('http://www.lcrcientifica.com/imagens/posts/large/lcr-cientifica-como-montar-uma-laboratorio-de-analises-clinicas14032019.jpg');
        background-repeat: no-repeat;
        background-position: center;
        background-size: cover;
    }

    h4 {
        color: #4676ff;
        font-weight: bold;
        font-size: 50px;
    }

    form {
        margin-top: 40px;
        display: flex;
        flex-direction: column;
        justify-content: center;
        align-items: center;
    }

    input {
        width: 400px;
    }

    .login-row{
        width: 800px;
        height: 500px;
        background-color: #fff;
        padding-top: 20px;
        padding-bottom: 50px;
        padding-left: 30px;
        padding-right: 30px;
        border-radius: 15px;
        margin: 0 auto;
        margin-top: 5%;

        -webkit-box-shadow: 10px 10px 19px -8px rgba(0,0,0,0.48);
        -moz-box-shadow: 10px 10px 19px -8px rgba(0,0,0,0.48);
        box-shadow: 10px 10px 19px -8px rgba(0,0,0,0.48);
    }

    .wrapper-button-submit {
        margin-top: 40px;
    }

    .wrapper-button-submit > .btn-primary {
        width: 150px;
        height: 50px;
        font-size: 24px;
        font-weight: bold;
        background-color: #4676ff;
    }

    .wrapper-button-submit > .btn-primary:hover {
        background-color: #355dd1;
    }
    
    .button-submit button:hover {
        background: #355dd1;
        color: #fff;
    }
    
    .box-register {
        display: flex;
        justify-content: space-around;
        align-items: center;
        color: #fff;
        margin-top: 40px;
    }

    .button-register {
        background: #4676ff;   
        border-radius: 20px;
        color: #f3f3f3;
        margin-left: 30px;
        margin-right: 30px;
    }

    .button-register:hover {
        background: #355dd1;   
    }

</style>