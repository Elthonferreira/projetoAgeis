package com.example.saude.controllers;

import com.example.saude.models.*;
import com.example.saude.services.ClinicaService;
import com.example.saude.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> getUsuariosByClinica (@PathVariable("clinica") Long id_clinica){
        //List<Usuario> usuarios = userService.getAll();
        if (clinica.getId_clinica() == doencaEspecialidade.getClinica_id() &&
            doenca.getId() == doencaEspecialidade.getDoenca_id() &&
            doenca.getId() == doencaSubAreaSintoma.getDoenca_id() &&
            doencaSubAreaSintoma.getSub_area_sintoma_id() == subAreaSintoma.getId_sub_area_sintoma() &&
            subAreaSintoma.getId_sub_area_sintoma() == userSubAreaSintoma.getSub_area_sintoma_id() &&
            usuario.getId() == userSubAreaSintoma.getUser_id() &&
            clinica.getId_clinica() == id_clinica){

            System.out.println(usuario.getName());
            System.out.println(doenca.getNome());
            System.out.println(clinica.getNome());
            System.out.println(especialidade.getNome());

            return new ResponseEntity<>(usuario, HttpStatus.OK);
        }
        else {
            System.out.println(usuario.getName());
            System.out.println(doenca.getNome());
            System.out.println(clinica.getNome());
            System.out.println(especialidade.getNome());
            return new ResponseEntity<>("Clinica com id " + id_clinica+ " não existe", HttpStatus.NOT_FOUND);
        }
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
