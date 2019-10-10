<template>
  <div id="userRegister" >
        <app-header></app-header>
        <div class="content-body">
            <h3>Cadastro de Usuário</h3>
            <div class="row" >
                 <form action="" class="form col s12">
                     <h4>Dados Pessoais</h4>
                    <div class="input-field col s12">
                        <input id="nome" type="text" class="validate">
                        <label for="nome">Nome</label>
                    </div>
                    <div class="input-field col s8">
                            <input id="street" type="text" class="validate">
                            <label for="street">Rua</label>
                        </div>
                    <div class="input-field col s4">
                        <input id="numberHome" type="text" class="validate">
                        <label for="numberHome">Número</label>
                    </div>
                    <div class="input-field col s8">
                        <input id="neighborhood" type="text" class="validate">
                        <label for="neighborhood">Bairro</label>
                    </div>
                    <div class="input-field col s4">
                        <select class="select-UF">
                            <option value="" disabled selected>UF</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                        <label>Materialize Select</label>
                    </div>

                    <div class="input-field col s8">
                        <input id="Telephone" type="tel" pattern= "[0-9]*" class="validate">
                        <label for="Telephone">Telefone</label>
                    </div>
                    <div class="row">
                        <div class="input-field col s4">
                            <label for="birthdate">Data de Nascimento</label>
                            <input id="birthdate" type="text" class="datepicker">
                        </div>
                    </div>
                    <h4>Dados da Conta</h4>
                    <div class="input-field col s12">
                        <input id="email" type="email" class="validate">
                        <label for="email">Email</label>
                    </div>
                    <div class="input-field col s12">
                        <input id="password" type="password" class="validate">
                        <label for="password">Senha</label>
                    </div>
                    <div class="input-field col s12">
                        <input id="confirmPassword" type="password" class="validate">
                        <label for="confirmPassword">Confirmar Senha</label>
                    </div>

                    <div class="button-submit">
                        <button class="btn waves-effect waves-light" type="submit" name="action">
                            Cadastrar
                        </button>
                    </div>
                </form>
            </div>
        </div>
        <app-footer></app-footer>
  </div>
</template>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('select');
        var instances = M.FormSelect.init(elems, {});
    });

    import AppHeader from "../components/Header.vue"
    import AppFooter from "../components/Footer.vue"

export default {
    name: "userRegister",
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
    .content-body {
        max-width: 800px;
        margin: 0 auto;
        padding: 80px 0;

    }

    .content-body h3{
        text-align: center;
        color: #2f52b9;
        font-weight: bold;  
    }

    .content-body h4 {
        color: #2f52b9;
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
        border-radius: 5px;
    }

    .button-submit button:hover {
        background: #2f52b9;
        color: #fff;
    }

    .input-field input[type=text]:focus, .input-field input[type=email]:focus, .input-field input[type=tel]:focus,
    .input-field input[type=password]:focus {
     border-bottom: 1px solid #4676ff;
     box-shadow: 0 1px 0 0 #4676ff;
   }

    /*
    .select-wrapper input.select-dropdown:focus {
        border-bottom: 1px solid #4676ff;
        box-shadow: 0 1px 0 0 #4676ff;
    }

    .select-css option {
        color: #4676ff;
    }
    */

   .input-field input[type=text]:focus + label, .input-field input[type=email]:focus + label,
    .input-field input[type=tel]:focus + label, .input-field input[type=password]:focus + label {
     color: #4676ff;
   }
</style>