package com.jeremy.demospring.controller;

import com.jeremy.demospring.dao.AppUserDao;
import com.jeremy.demospring.model.AppUser;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Optional;

// indique que cette classe gère des requêtes HTTP et retourne du JSON
@RestController
public class AppUserController {

    //Spring injecte automatiquement une instance de AppUserDao sans que l'on ai à faire new AppUserDao()
    protected final AppUserDao appUserDao;

    public AppUserController(AppUserDao appUserDao) {
        this.appUserDao = appUserDao;
    }

    // Récupère tous les utilisateurs
    @GetMapping("/user/list")
    public List<AppUser> getAll() {

        return appUserDao.findAll();
    }

    // Récupère un utilisateur
    @GetMapping("/user/{id}")

    public ResponseEntity<AppUser> get(@PathVariable int id) {

        Optional<AppUser> optionalUser = appUserDao.findById(id);

        if(optionalUser.isEmpty()) {

            // return ResponseEntity.notFound().build()
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // return ResponseEntity.ok(optionalUser.get())
        return new ResponseEntity<>(optionalUser.get(),HttpStatus.OK);
    }

    @PostMapping("/user")
    public  AppUser create(
            @RequestBody
            @Validated(AppUser.OnCreate.class)
            AppUser userToInsert
    ) {

        userToInsert.setId(null);

        appUserDao.save(userToInsert);

        return userToInsert;

    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<AppUser> optionalUser = appUserDao.findById(id);

        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        appUserDao.deleteById(id);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody
            @Validated(AppUser.OnUpdate.class)
            AppUser userToUpdate) {

        // On écrase l'id du json par celui en paramètre
        userToUpdate.setId(id);

        Optional<AppUser> optionalUser = appUserDao.findById(id);

        if (optionalUser.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }

        // On récupère les anciennes valeurs qui ne doivent pas être changées
        userToUpdate.setEmail(optionalUser.get().getEmail());
        userToUpdate.setPassword(optionalUser.get().getPassword());

        appUserDao.save(userToUpdate);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

}
