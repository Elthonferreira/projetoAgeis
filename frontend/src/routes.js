import BodyRegion1 from "./pages/BodyRegion1.vue";
import userRegister from "./pages/userRegister.vue";
import Clinica from "./pages/Clinica.vue";
import ClinicaGerenciamento from "./pages/ClinicaGerenciamento.vue";
import ClinicaEspecialidade from "./pages/ClinicaEspecialidade.vue";
import login from "./pages/Login.vue";
import Diagnostico from "./pages/Diagnostico.vue";

const Routes = {
  routes: [
    { path: "/bodyregion1", component: BodyRegion1 },
    {
      path: "/clinica",
      name: "clinica",
      component: Clinica
    },
    {
      path: "/clinicaGerenciamento",
      name: "clinicaGerenciamento",
      component: ClinicaGerenciamento
    },
    {
      path: "/clinicaEspecialidade",
      name: "clinicaEspecialidade",
      component: ClinicaEspecialidade
    },
    { path: "/userRegister", component: userRegister },
    { path: "/login", component: login },
    { path: "/diagnostico/:id", component: Diagnostico },
    { path: "/", component: login }
  ]
};

export default Routes;
