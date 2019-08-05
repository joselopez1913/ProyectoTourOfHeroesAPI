package co.udea.heroes.api.service;

import co.udea.heroes.api.model.Hero;

import java.util.List;
import java.util.Optional;

public interface HeroServiceInt {

    public List<Hero> getHeroes();
    public Hero getHero(String id);
    public Hero getHeroByName(String name);
    public Hero addHero(Hero hero);
    public Optional<Hero> searchHeroes(String term);
    public Hero updateHero(Hero hero);
    public void deleteHero(Hero hero);

}
