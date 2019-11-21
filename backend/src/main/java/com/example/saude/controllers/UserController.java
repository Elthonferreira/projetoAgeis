package com.example.saude.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.saude.models.Clinica;
import com.example.saude.models.Login;
import com.example.saude.models.Usuario;
import com.example.saude.services.ClinicaService;
import com.example.saude.services.UserService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;
	
	@Autowired
	private ClinicaService ClinicaService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<Usuario> user = userService.getAll();
        if(user.isEmpty()) {
            return new ResponseEntity<>("Sem usuários cadastrados", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @GetMapping("/{email}")
    public ResponseEntity<?> getByCpf(@PathVariable("email") String email) {
        Usuario user = userService.getByEmail(email);
        if(user == null) {
            return new ResponseEntity<>("Usuário com id " + email + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Usuario userBody) {
        Usuario user = userService.getByEmail(userBody.getEmail());
        Clinica clinica = ClinicaService.getByUsuario(userBody.getEmail());
        
        if(user == null && clinica == null) {
            return new ResponseEntity<>("Usuário não cadastrado!", HttpStatus.BAD_REQUEST);
        }
        else {
        	 if (user != null && userBody.getPassword().equals(user.getPassword())) {
        		 Login login = new Login(user.getId(), user.getName(), user.getEmail(), "Paciente");
        		 
        		 return new ResponseEntity<>(login,HttpStatus.OK);
        	 } else if (clinica != null && userBody.getPassword().equals(clinica.getSenha())) {
        		 Login login = new Login(clinica.getId_clinica(), clinica.getNome(), clinica.getEmail(), "Clinica");
        		 
        		 return new ResponseEntity<>(login,HttpStatus.OK);
        	 }
        	 
        	 return new ResponseEntity<>("Senha incorreta!", HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody Usuario user) {
        Usuario aux = userService.getById(user.getId());
        if(aux == null) {
            return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Usuário já cadastrado!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody Usuario newUser) {
        Usuario oldUser = userService.getById(newUser.getId());
        if(oldUser == null) {
            return new ResponseEntity<>("Usuário não cadastrado!", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(userService.update(newUser), HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody Usuario user) {
        Usuario aux = userService.getById(user.getId());
        if(aux == null) {
            return new ResponseEntity<>("Usuário não existe!", HttpStatus.NOT_FOUND);
        }
        else {
            userService.delete(aux);
            return new ResponseEntity<>("Usuário excluído!", HttpStatus.OK);
        }
    }
}
