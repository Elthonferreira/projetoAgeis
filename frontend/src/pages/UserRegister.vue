<template>
  <div id="userRegister" >
        <app-header></app-header>
        <div class="content-body">
            <h3>Cadastro de Usuário</h3>
            <div class="row" >
                 <form @submit.prevent="save()" class="form col s12">
                     <h4>Dados Pessoais</h4>
                    <div class="input-field col s12">
                        <input id="nome" type="text" class="validate" v-model="user.name" required>
                        <label for="nome">Nome</label>
                    </div>
                    <div class="input-field col s8">
                            <input id="street" type="text" class="validate" v-model="user.street" required>
                            <label for="street">Rua</label>
                        </div>
                    <div class="input-field col s4">
                        <input id="number" type="text" class="validate" v-model="user.number" required>
                        <label for="number">Número</label>
                    </div>
                    <div class="input-field col s8">
                        <input id="neighborhood" type="text" class="validate" v-model="user.neighborhood" required>
                        <label for="neighborhood">Bairro</label>
                    </div>
                    <div class="input-field col s4">
                        <select class="select-UF" v-model="user.state">
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
                        <label>Estado</label>
                    </div>

                    <div class="input-field col s8">
                        <input id="Telephone" type="tel" pattern= "[0-9]*" class="validate" v-model="user.telephone" required>
                        <label for="Telephone">Telefone</label>
                    </div>
                     <div class="input-field col s4">
                        <label for="birthdate">Data de Nascimento</label>
                        <input id="birthdate" type="text" class="datepicker" required>
                    </div>
                    <h4>Dados da Conta</h4>
                    <div class="input-field col s12">
                        <input id="email" type="email" class="validate" v-model="user.email" required>
                        <label for="email">E-mail</label>
                    </div>
                    <div class="input-field col s12">
                        <input id="password" type="password" class="validate" v-model="user.password" required>
                        <label for="password">Senha</label>
                    </div>
                    <div class="input-field col s12">
                        <input id="confirmPassword" type="password" class="validate" required>
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
import AppHeader from "../components/Header.vue"
import AppFooter from "../components/Footer.vue"
import axios from 'axios';
import md5 from 'md5';

export default {
    name: "userRegister",
    components: {
      AppHeader, AppFooter
    },
    data: () => {
    return {
      url: "http://localhost:8081/api",
      user: {
        name: "",
        street: "",
        number: "",
        neighborhood: "",
        state: "",
        telephone: "",
        birthdate: "",
        email: "",
        password: ""
      },
      error: "",
      condicao: false
    };
  },
  methods: {
    save() {
        var datepicker = document.querySelectorAll('.datepicker');
        this.user.birthdate = datepicker[0].value;
        this.user.password = md5(this.user.password);

      axios
        .post(this.url + "/user", this.user)
        .then(function() {
            M.toast({html: 'Usuário cadastrado com sucesso!', classes: 'rounded'});
            window.location.href = "/#/login";
        })
        .catch(error => {
            this.error = error.response.data;
        });
    }
  },
}
</script>

<style >
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

   .datepicker-modal {
       height: auto !important;
   }
</style>