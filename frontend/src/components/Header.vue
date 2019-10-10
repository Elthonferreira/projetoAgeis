<template>
 <div>
    <nav>
        <div class="nav-wrapper">
            <a href="#!" class="brand-logo">Logo</a>
            <a href="#!" data-target="mobile-demo" class="sidenav-trigger"><i class="material-icons">menu</i></a>
            <ul class="right hide-on-med-and-down">
                <li><a href="#!">Entrar</a></li>
                <li><a class='dropdown-trigger btn' href='#!' data-target='dropdown1'>Registrar</a></li>
            </ul>
        </div>
    </nav>

    <!-- Dropdown Structure -->
    <ul id='dropdown1' class='dropdown-content'>
        <li><a href="/#/userRegister">Registrar-se como um usuário</a></li>
        <li class="divider" tabindex="-1"></li>
        <li><a href="#!">Registrar-se como uma clínica</a></li>
    </ul>

    <ul class="sidenav" id="mobile-demo">
        <li><a href="#">Home</a></li>
    </ul>
 </div>
</template>

<script>
    document.addEventListener('DOMContentLoaded', function() {
        var elems = document.querySelectorAll('.dropdown-trigger');
        var instances = M.Dropdown.init(elems, {
            hover: true,
            constrainWidth: false
        });
    });

    export default {

    }
</script>

<style scoped>
    .nav-wrapper {
        background: #4676ff;
    }

    .dropdown-trigger {
        background: #355dd1;
        text-transform: capitalize;
    }

    .dropdown-trigger:focus {
        background: #2f52b9;
    }

    .dropdown-content {
        background: #fff;
        color: #4676ff;
    }

    .dropdown-content li a{
        color: #4676ff;
    }

    .dropdown-content li a:hover{
        background: #f3f3f3;
    }
</style>