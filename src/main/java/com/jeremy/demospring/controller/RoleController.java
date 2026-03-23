package com.jeremy.demospring.controller;

import com.jeremy.demospring.dao.RoleDao;
import com.jeremy.demospring.model.Role;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class RoleController {

    protected final RoleDao roleDao;

    public RoleController(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @GetMapping("/role/list")
    public List<Role> getAll() {

        return roleDao.findAll();
    }

    @GetMapping("/role/{id}")

    public ResponseEntity<Role> get(@PathVariable int id) {

        Optional<Role> optionalRole = roleDao.findById(id);

        if(optionalRole.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalRole.get(),HttpStatus.OK);
    }

    @PostMapping("/role")
    public  Role create(
            @RequestBody
            @Valid
            Role roleToInsert
    ) {

        roleToInsert.setId(null);

        roleDao.save(roleToInsert);

        return roleToInsert;

    }

    @DeleteMapping("/role/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<Role> optionalRole = roleDao.findById(id);

        if (optionalRole.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        roleDao.deleteById(id);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

    @PutMapping("/role/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody
            @Valid
            Role roleToUpdate) {

        roleToUpdate.setId(id);

        Optional<Role> optionalRole = roleDao.findById(id);

        if (optionalRole.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }

        roleDao.save(roleToUpdate);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

}
