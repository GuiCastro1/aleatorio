package br.com.starttech.cadastro_user.cadastro_user.controller;

import br.com.starttech.cadastro_user.cadastro_user.repository.UserCadastro;
import br.com.starttech.cadastro_user.cadastro_user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/usuario")
public class UserController {
    @Autowired
    private UserCadastro repository;

    @GetMapping
    public List<User> pegaUser(){
        return repository.findAll();
    }

    @PostMapping
    public void salvarUser(@RequestBody User usuarios){
        repository.save(usuarios);
    }

    @DeleteMapping(value = "/{IdUser}")
    public void deletar(@PathVariable Integer IdUser){
        repository.deleteById(IdUser);
    }

    @PutMapping(value = "/{idUser}")
    public User atualizaUsuario(@PathVariable Integer idUsuario, @RequestBody User usuario) {

        User usuarioExistente = repository.findById(idUsuario).orElse(null);

        if (usuarioExistente != null) {
            usuarioExistente.setNameUser(usuario.getNameUser());
            usuarioExistente.setEmailUser(usuario.getEmailUser());
            usuarioExistente.setTelefoneUser(usuario.getTelefoneUser());
            usuarioExistente.setPasswordUser(usuario.getPasswordUser());

            return repository.save(usuarioExistente);
        }

        return null;
    }

}
//
//package br.com.starttech.cadastro_user.cadastro_user.controller;
//
//import br.com.starttech.cadastro_user.cadastro_user.repository.UserCadastro;
//import br.com.starttech.cadastro_user.cadastro_user.model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import  org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/usuario")
//@CrossOrigin(origins = {"http://127.0.0.1:5500","http://localhost:5500","http://localhost:3000"}) // ajuste seu dev origin(s)
//public class UserController {
//
//    @Autowired
//    private UserCadastro repository;
//
//    @GetMapping
//    public List<User> pegaUsers() {
//        return repository.findAll();
//    }
//
//    // <-- ADICIONE este método GET por id (isso resolve o 405 no GET do navegador)
//    @GetMapping("/{IdUser}")
//    public ResponseEntity<User> pegaUserPorId(@PathVariable("IdUser") Integer IdUser) {
//        return repository.findById(IdUser)
//                .map(user -> ResponseEntity.ok(user))
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//
//    @PostMapping
//    public ResponseEntity<User> salvarUser(@RequestBody User usuarios) {
//        User saved = repository.save(usuarios);
//        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
//    }
//
//    @DeleteMapping("/{IdUser}")
//    public ResponseEntity<Void> deletar(@PathVariable Integer IdUser){
//        if (!repository.existsById(IdUser)) return ResponseEntity.notFound().build();
//        repository.deleteById(IdUser);
//        return ResponseEntity.noContent().build();
//    }
//
//    @PutMapping("/{IdUser}")
//    public ResponseEntity<User> atualizaUsuario(@PathVariable("IdUser") Integer IdUser, @RequestBody User usuario) {
//        return repository.findById(IdUser)
//                .map(usuarioExistente -> {
//                    usuarioExistente.setNameUser(usuario.getNameUser());
//                    usuarioExistente.setEmailUser(usuario.getEmailUser());
//                    usuarioExistente.setTelefoneUser(usuario.getTelefoneUser());
//                    usuarioExistente.setPasswordUser(usuario.getPasswordUser());
//                    User atualizado = repository.save(usuarioExistente);
//                    return ResponseEntity.ok(atualizado);
//                })
//                .orElseGet(() -> ResponseEntity.notFound().build());
//    }
//}
