package fr.efrei.pokemon.controller;


import fr.efrei.pokemon.models.Ligue;
import fr.efrei.pokemon.services.LigueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ligues")
public class LigueController {

    private final LigueService ligueService;

    @Autowired
    public LigueController(LigueService ligueService) {
        this.ligueService = ligueService;
    }

    @GetMapping
    public ResponseEntity<List<Ligue>> findAll() {
        return new ResponseEntity<>(ligueService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ligue> findById(@PathVariable String id) {
        Ligue ligue = ligueService.findById(id);
        if (ligue == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ligue, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Ligue> create(@RequestBody Ligue ligue) {
        ligueService.save(ligue);
        return new ResponseEntity<>(ligue, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<Ligue> update(@PathVariable String id, @RequestBody Ligue ligue) {
        Ligue ligue1 = ligueService.findById(id);
        if (ligue1 == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        ligueService.save(ligue);
        return new ResponseEntity<>(ligue, HttpStatus.OK);
    }


}
