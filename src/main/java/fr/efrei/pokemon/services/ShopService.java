package fr.efrei.pokemon.services;

import fr.efrei.pokemon.models.Shop;
import fr.efrei.pokemon.repositories.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {

    private final ShopRepository repository;

    @Autowired
    public ShopService(ShopRepository repository) {
        this.repository = repository;
    }

    public List<Shop> findAll() {
        return  repository.findAll();
    }

    public Shop findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Shop save(Shop shop) {
        return repository.save(shop);
    }

    public void delete(Shop shop) {
        repository.delete(shop);
    }

    public void update(String id, Shop shop) {
        Shop shopAModifier = findById(id);
        shopAModifier.setPrice(shop.getPrice());
        repository.save(shopAModifier);
    }

    public void partialUpdate(String id, Shop shop) {
        Shop shopAModifier = findById(id);
        if(shopAModifier.getPrice() != 0) {
            shopAModifier.setPrice(shop.getPrice());
        }
        repository.save(shopAModifier);
    }
}
