package br.com.starttech.cadastro_user.cadastro_user.controller;

import br.com.starttech.cadastro_user.cadastro_user.repository.UserCadastro;
import br.com.starttech.cadastro_user.cadastro_user.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

}
