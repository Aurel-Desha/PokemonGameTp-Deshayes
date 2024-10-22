package fr.efrei.pokemon.controller;


import fr.efrei.pokemon.models.Shop;
import fr.efrei.pokemon.services.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shops")
public class ShopController {

    @Autowired
    private final ShopService service;

    public ShopController(ShopService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Shop>> findAll() {
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> findById(@PathVariable String id) {
        Shop shop = service.findById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(shop, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Shop> create(@RequestBody Shop shop) {
        service.save(shop);
        return new ResponseEntity<>(service.save(shop), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Shop> update(@PathVariable String id, @RequestBody Shop shop) {
        Shop shopAModifier = service.findById(id);
        if (shopAModifier == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.update(id, shop);
        return new ResponseEntity<>(service.save(shop), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Shop> delete(@PathVariable String id) {
        Shop shop = service.findById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.delete(shop);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Shop> partialUpdate(@PathVariable String id, @RequestBody Shop shopBody) {
        Shop shop = service.findById(id);
        if (shop == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        service.partialUpdate(id, shopBody);
        return new ResponseEntity<>(service.save(shop), HttpStatus.OK);
    }
}
