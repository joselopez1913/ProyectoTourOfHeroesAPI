package co.udea.heroes.api.repository;

import co.udea.heroes.api.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HeroRepository extends JpaRepository<Hero, String>{

    public Optional<Hero> findById(String id);
    public Optional<Hero> findByName(String name);


}
