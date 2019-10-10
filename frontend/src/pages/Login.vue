<template>
  <div class="login">
      <body>
          <app-header></app-header>
      
            <div class="row d-flex justify-content-center mt-5">
                <div class="login-row col-sm-5">
                    <h4 class="pb-4 text-center">Login</h4>
                    <form action="/#/bodyRegion1">
                        <div class="input-field col s8 offset-s2">
                            <input id="email" type="email" class="validate">
                            <label for="email">E-mail</label>
                        </div>
                        <div class="input-field col s8 offset-s2">
                            <input id="password" type="password" class="validate">
                            <label for="password">Senha</label>
                        </div>
                        
                        <div class="button-submit">
                            <button class="btn waves-effect waves-light" type="submit" name="action">
                                Entrar
                            </button>
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
        color: #2f52b9;
        font-weight: bold;
        font-size: 50px;
    }

    .login-row{
        width: 800px;
        height: 500px;
        background-color: #f6f6f6;
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

    .input-field input[type=email]:focus, .input-field input[type=password]:focus {
     border-bottom: 1px solid #4676ff;
     box-shadow: 0 1px 0 0 #4676ff;
   }

   .input-field input[type=email]:focus + label, .input-field input[type=password]:focus + label {
     color: #4676ff;
   }

   .button-submit {
        width: 100%;
        display: flex;
        justify-content: center;
        margin: 0 auto;
        padding-top: 20px;
    }    

    .button-submit button {
        width: 180px;
        height: 50px;
        font-size: 20px;
        background: #4676ff;
        font-weight: bold;
        border-radius: 25px;
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
        background: #355dd1;   
        border-radius: 20px;
    }

    .button-register:hover {
        background: #4676ff;   
    }

</style>