<template>
 <div class="header">
    <div class="d-flex flex-row-reverse bd-highlight">
        <div class="p-2 bd-highlight column1">
            <a href="/#/login"><button type="button" class="btn btn-outline-success">Entrar</button></a>
        </div>
        <div class="p-2 bd-highlight column2"></div>
        <div class="p-2 bd-highlight column3">
            <!-- Dropdown Structure -->
            <div class="dropdown">
                <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Registrar
                </button>
                <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                    <a class="dropdown-item" href="/#/userRegister">Registrar-se como um usuário</a>
                    <a class="dropdown-item" href="/#/clinica">Registrar-se como uma clínica</a>
                </div>
            </div>
        </div>
    </div>
 </div>
</template>

<script>

    export default {
        
    }
</script>

<style scoped>
/* #355dd1 #4676ff  #2f52b9*/

.column1 {
    margin-right: 50px;
}

.column1 > a > .btn-outline-success {
    width: 100px;
    background-color: #4676ff;
    border-color: #f3f3f3;
    color: #f3f3f3;
    font-weight: bold;
}

.column1 > a > .btn-outline-success:hover {
    background-color: #f3f3f3;
    color: #4676ff;
}

.column3 > .dropdown > .btn-secondary {
    background-color: #f3f3f3;
    color: #4676ff;
    border-color: #4676ff;
    font-weight: bold;
}

.column3 > .dropdown > .dropdown-menu > .dropdown-item {
    font-weight: bold;
    color: #4676ff;
}

.column3 > .dropdown > .dropdown-menu > .dropdown-item:hover {
    background-color: #f3f3f3;
}

.header {
    width: 100%;
    background-color: #4676ff;
    margin-right: 50px;
    box-shadow: 0px 0px 10px 0px #888888;
}

</style>