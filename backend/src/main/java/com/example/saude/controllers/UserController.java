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

import com.example.saude.models.User;
import com.example.saude.services.UserService;

@CrossOrigin("*") // Depois trocar o * pelo endereço do frontend
@RestController
@RequestMapping("/api/user")
public class UserController {
	
	@Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<?> getAll() {
        List<User> user = userService.getAll();
        if(user.isEmpty()) {
            return new ResponseEntity<>("Sem usuários cadastrados", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getByCpf(@PathVariable("id") Long id) {
        User user = userService.getById(id);
        if(user == null) {
            return new ResponseEntity<>("Usuário com id " + id + " não existe", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody User user) {
        User aux = userService.getById(user.getId());
        if(aux == null) {
            return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("Usuário já cadastrado!", HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody User newUser) {
        User oldUser = userService.getById(newUser.getId());
        if(oldUser == null) {
            return new ResponseEntity<>("Usuário não cadastrado!", HttpStatus.NOT_FOUND);
        }
        else {
            return new ResponseEntity<>(userService.update(newUser), HttpStatus.OK);
        }
    }

    @DeleteMapping
    public ResponseEntity<?> delete(@RequestBody User user) {
        User aux = userService.getById(user.getId());
        if(aux == null) {
            return new ResponseEntity<>("Usuário não existe!", HttpStatus.NOT_FOUND);
        }
        else {
            userService.delete(aux);
            return new ResponseEntity<>("Usuário excluído!", HttpStatus.OK);
        }
    }
}