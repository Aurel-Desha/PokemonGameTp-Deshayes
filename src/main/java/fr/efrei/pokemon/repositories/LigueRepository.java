package fr.efrei.pokemon.repositories;


import fr.efrei.pokemon.models.Ligue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigueRepository extends JpaRepository<Ligue, String> {
}