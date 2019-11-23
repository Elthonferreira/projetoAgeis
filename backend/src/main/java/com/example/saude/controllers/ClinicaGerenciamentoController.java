package com.example.saude.controllers;

import com.example.saude.models.*;
import com.example.saude.services.ClinicaService;
import com.example.saude.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/clinicaGerenciamento")
public class ClinicaGerenciamentoController {

    @Autowired
    private ClinicaService clinicaService;
    private UserService userService;

  // clinica - doenca_especialidade - doencas - doenca_sub_area_sintoma - sub_area_sintoma - user_sub_area_sintoma

    Clinica clinica = new Clinica();
    DoencaEspecialidade doencaEspecialidade = new DoencaEspecialidade();
    Doenca doenca = new Doenca();
    DoencaSubAreaSintoma doencaSubAreaSintoma = new DoencaSubAreaSintoma();
    SubAreaSintoma subAreaSintoma = new SubAreaSintoma();
    UserSubAreaSintoma userSubAreaSintoma = new UserSubAreaSintoma();
    Usuario usuario = new Usuario();
    Especialidade especialidade = new Especialidade();


    @GetMapping("/{clinica}")
    public void getUsuariosByClinica (@PathVariable("clinica") Long id_clinica) throws SQLException {
        //List<Usuario> usuarios = userService.getAll();
        //this.clinica.setId_clinica(id_clinica);

        Conexao con = new Conexao();
        Statement statement = con.conexao.createStatement();

        //Statement stm = con.conexao.createStatement();
        //stm.executeQuery("select * from doencas d join  doenca_especialidade de on de.doenca_id = d.id");

        statement.executeQuery("select distinct u.name, d.nome, c.nome, e.nome from \n" +
                "area a join sub_area sa on a.id_area = sa.area_id join\n" +
                "sub_area_sintoma sas on sas.sub_area_id = sa.id join\n" +
                "sintomas s on s.id = sas.sintoma_id join\n" +
                "doenca_sub_area_sintoma dsas on sas.id_sub_area_sintoma = dsas.sub_area_sintoma_id join\n" +
                "doencas d on d.id = dsas.doenca_id join \n" +
                "doenca_especialidade de on d.id = de.doenca_id join\n" +
                "especialidade e on e.id = de.especialidade_id join\n" +
                "clinica c on c.id = de.clinica_id join\n" +
                "user_sub_area_sintoma usas on usas.sub_area_sintoma_id = id_sub_area_sintoma join\n" +
                "user u on u.id = usas.user_id where c.id = " + id_clinica);

        //ResultSet rs = stm.getResultSet();
        ResultSet resultSet = statement.getResultSet();

        while (resultSet.next()){
            System.out.println(resultSet.getString("u.name") +
                    ", "+ resultSet.getString("d.nome") +
                    ", "+ resultSet.getString("c.nome") +
                    ", "+ resultSet.getString("e.nome"));
        }

        // Código abaixo tentando fazer na mão, mas sem sucesso
        /*if (this.clinica.getId_clinica() == id_clinica){
        System.out.println("oi");
        this.doencaEspecialidade.setClinica_id(this.clinica.getId_clinica());

        }
        if (this.clinica.getId_clinica() == this.doencaEspecialidade.getClinica_id() &&
                this.doenca.getId() == this.doencaEspecialidade.getDoenca_id() &&
                this.doenca.getId() == this.doencaSubAreaSintoma.getDoenca_id() &&
                this.doencaSubAreaSintoma.getSub_area_sintoma_id() == this.subAreaSintoma.getId_sub_area_sintoma() &&
                this.subAreaSintoma.getId_sub_area_sintoma() == this.userSubAreaSintoma.getSub_area_sintoma_id() &&
                this.usuario.getId() == this.userSubAreaSintoma.getUser_id() &&
                this.clinica.getId_clinica() == id_clinica){

        System.out.println(this.usuario.getName());
        System.out.println(this.doenca.getNome());
        System.out.println(this.clinica.getNome());
        System.out.println(this.especialidade.getNome());

        return new ResponseEntity<>(usuario, HttpStatus.OK);
    }
        else {
        System.out.println(this.usuario.getName());
        System.out.println(this.doenca.getNome());
        System.out.println(this.clinica.getNome());
        System.out.println(this.especialidade.getNome());
        return new ResponseEntity<>("Clinica com id " + id_clinica+ " não existe", HttpStatus.NOT_FOUND);
    }*/
}


   /* @GetMapping("/{clinicaId}")
    public ResponseEntity<?> getById(@PathVariable("clinicaId") Long clinica_id) {
        Clinica clinica = clinicaService.getById(clinica_id);
        System.out.println(clinica.getNome());
        if(clinica == null) {
            return new ResponseEntity<>("Clinica com id " + clinica_id + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinica, HttpStatus.OK);
        }
    }*/

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Clinica> clinicas = clinicaService.getAll();
        if(clinicas.isEmpty()) {
            return new ResponseEntity<>("Sem clinicas cadastradas", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(clinicas, HttpStatus.OK);
        }
    }
}
