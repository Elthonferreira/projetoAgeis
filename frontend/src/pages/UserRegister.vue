<template>
  <div id="userRegister" >
        <app-header></app-header>
        <div>
            <div class="content-body">
                <div class="alert alert-success" hidden id="alert" role="alert">
                    Paciente cadastrado com sucesso! Redirecionando para a tela de login em 3 segundos...
                </div>
                <h3>Cadastro de Usuário</h3>
                <form  @submit.prevent="save()">
                    <h4>Dados Pessoais</h4>
                    <div class="form-group">
                        <div class="name-column1">
                            <label for="name">Nome:</label>
                            <input id="name" type="text" class="form-control" v-model="user.name" required>
                        </div>
                    </div>
                    <div class="form-group">
                        <div class="street-number-column1">
                            <label for="street">Rua</label>
                            <input id="street" type="text" class="form-control" v-model="user.street" required>
                        </div>

                        <div class="street-number-column2">
                            <label for="number">Número</label>
                            <input id="number" type="text" class="form-control" v-model="user.number" required>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="neighborhood-state-column1">
                            <label for="neighborhood">Bairro</label>
                            <input id="neighborhood" type="text" class="form-control" v-model="user.neighborhood" required>
                        </div>
                        <div class="neighborhood-state-column2">
                            <label>Estado</label>
                            <select class="form-control" v-model="user.state">
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
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="telephone-birthdate-column1">
                            <label for="Telephone">Telefone</label>
                            <input id="Telephone" type="tel" pattern= "[0-9]*" class="form-control" v-model="user.telephone" required>
                        </div>
                        <div class="telephone-birthdate-column2">
                            <label for="birthdate">Data de Nascimento</label>
                            <input id="birthdate" type="text" class="form-control" v-model="user.birthdate" required>
                        </div>

                        <div class="telephone-birthdate-column3"></div>
                    </div>

                    <h4>Dados da Conta</h4>

                    <div class="form-group">
                        <div class="email-column1">
                            <label for="email">E-mail</label>
                            <input id="email" type="email" class="form-control" v-model="user.email" required>
                        </div>
                        <div class="email-column2"></div>
                    </div>

                    <div class="form-group">
                        <div class="password-confirmPassword-column1">
                            <label for="password">Senha</label>
                            <input id="password" type="password" class="form-control" v-model="user.password" required>
                        </div>
                        <div class="password-confirmPassword-column2">
                            <label for="confirmPassword">Confirmar Senha</label>
                            <input id="confirmPassword" type="password" class="form-control" required>
                        </div>

                        <div class="password-confirmPassword-column3"></div>
                    </div>

                    <div class="form-group wrapper-button-submit">
                        <button type="submit" class="btn btn-primary">Cadastrar</button>
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
        this.user.password = md5(this.user.password);

      axios
        .post(this.url + "/user", this.user)
        .then(function() {
            //M.toast({html: 'Usuário cadastrado com sucesso!', classes: 'rounded'});
            let message = document.getElementById("alert");
            message.removeAttribute("hidden");
            setTimeout(() => {
                window.location.href = "/#/login";
            }, 3000);
            
        })
        .catch(error => {
            //this.error = error.response.data;
            console.log(error);
        });
    }
  },
}
</script>

<style scoped>
    .name-column1 {
        width: 100%;
    }

    .street-number-column1 {
        width: 80%;
    }

    .street-number-column2 {
        width: 15%;
        margin-left: 5%;
    }

    .neighborhood-state-column1 {
        width: 70%;
    }

    .neighborhood-state-column2 {
        width: 25%;
        margin-left: 5%;
    }

    .telephone-birthdate-column1 {
        width: 35%;
    }

    .telephone-birthdate-column2 {
        width: 25%;
        margin-left: 5%;
    }

    .telephone-birthdate-column3 {
        width: 35%;
    }
    
    .email-column1 {
        width: 55%;
    }

    .email-column2 {
        width: 45%;
    }

    .password-confirmPassword-column1 {
        width: 25%;
    }

    .password-confirmPassword-column2 {
        width: 25%;
        margin-left: 5%;
    }

    .password-confirmPassword-column3{
        width: 45%;
    }

    .form-group {
        display: flex;
        justify-content: center;
        align-items: center;
    }

    .form-group > label {
        height: 100%;
        margin: auto 0;
    }

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

    .btn-primary {
        width: 150px;
        font-weight: bold;
        margin-top: 20px;
    }

</style>