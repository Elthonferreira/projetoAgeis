import BodyRegion1 from './pages/BodyRegion1.vue'
import userRegister from './pages/userRegister.vue'
import Clinica from './components/Clinica.vue'

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
        }
    ]
}


export default Routes