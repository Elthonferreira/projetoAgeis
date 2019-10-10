import BodyRegion1 from './pages/BodyRegion1.vue'
import userRegister from './pages/userRegister.vue'
import Clinica from './pages/Clinica.vue'
import login from './pages/Login.vue'

const Routes = {
    routes : [
        { path: '/bodyregion1',
          component: BodyRegion1
        },
        {
          path: '/clinica',
          name: 'clinica',
          component: Clinica
        },
        { path: '/userRegister',
          component: userRegister
        },
        { path: '/login',
          component: login
        }
    ]
}

export default Routes