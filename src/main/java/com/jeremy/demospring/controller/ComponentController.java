package com.jeremy.demospring.controller;

import com.jeremy.demospring.dao.ComponentDao;
import com.jeremy.demospring.model.Component;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
public class ComponentController {

    protected final ComponentDao componentDao;

    public ComponentController(ComponentDao componentDao) {
        this.componentDao = componentDao;
    }

    @GetMapping("/component/list")
    public List<Component> getAll() {

        return componentDao.findAll();
    }

    @GetMapping("/component/{id}")

    public ResponseEntity<Component> get(@PathVariable int id) {

        Optional<Component> optionalComponent = componentDao.findById(id);

        if(optionalComponent.isEmpty()) {

            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(optionalComponent.get(),HttpStatus.OK);
    }

    @PostMapping("/component")
    public  Component create(
            @RequestBody
            @Valid
            Component componentToInsert
    ) {

        componentToInsert.setId(null);

        componentDao.save(componentToInsert);

        return componentToInsert;

    }

    @DeleteMapping("/component/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id) {

        Optional<Component> optionalComponent = componentDao.findById(id);

        if (optionalComponent.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }
        componentDao.deleteById(id);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

    @PutMapping("/component/{id}")
    public ResponseEntity<Void> update(
            @PathVariable int id,
            @RequestBody
            @Valid
            Component componentToUpdate) {

        componentToUpdate.setId(id);

        Optional<Component> optionalComponent = componentDao.findById(id);

        if (optionalComponent.isEmpty()) {
            return new ResponseEntity<>((HttpStatus.NOT_FOUND));
        }

        componentDao.save(componentToUpdate);

        return new ResponseEntity<>((HttpStatus.NO_CONTENT));

    }

}
