package fr.efrei.pokemon.services;


import fr.efrei.pokemon.models.Ligue;
import fr.efrei.pokemon.repositories.LigueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LigueService {

    private final LigueRepository repository;

    @Autowired
    public LigueService(LigueRepository repository) {
        this.repository = repository;
    }

    public List<Ligue> findAll() {
        return repository.findAll();
    }

    public Ligue findById(String id) {
        return repository.findById(id).orElse(null);
    }

    public Ligue save(Ligue ligue) {
        return repository.save(ligue);
    }

    public void delete(Ligue ligue) {
        repository.delete(ligue);
    }

    public void update(String id, Ligue ligue) {
        Ligue ligueAModifier = findById(id);
        ligueAModifier.setName(ligue.getName());
        ligueAModifier.setRegion(ligue.getRegion());
        repository.save(ligueAModifier);
    }

    public void partialUpdate(String id, Ligue ligue) {
        Ligue ligueAModifier = findById(id);
        if (ligueAModifier.getName() != null) {
            ligueAModifier.setName(ligue.getName());
        }

        if (ligue.getRegion() != null) {
            ligueAModifier.setRegion(ligue.getRegion());
        }
        repository.save(ligueAModifier);
    }
}
