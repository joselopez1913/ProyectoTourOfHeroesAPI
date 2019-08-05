package co.udea.heroes.api.controller;

import co.udea.heroes.api.exception.DataNotFoundException;
import co.udea.heroes.api.model.Hero;
import co.udea.heroes.api.service.HeroServiceInt;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tour-heroes")
public class HeroController {

    private final Logger log = LoggerFactory.getLogger(HeroController.class);

    private HeroServiceInt heroService;

    public HeroController (HeroServiceInt heroService){
        this.heroService = heroService;
    }

    @GetMapping
    @ApiOperation(value = "Buscar todos los heroes", response = Page.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Los heroes fueron buscados", response = Page.class),
            @ApiResponse(code = 400, message = "La petición es invalida"),
            @ApiResponse(code = 500, message = "Error interno al procesar la respuesta")})

    public ResponseEntity<List<Hero>> getHeroes(){
        return ResponseEntity.ok(heroService.getHeroes());
    }

    //Obtener heroe por id
    @GetMapping("/{id}")
    public ResponseEntity<Hero> getHero(@PathVariable("id") String id){
        return ResponseEntity.ok(heroService.getHero(id));
    }

    //Obtener heroe por nombre
    @GetMapping("name/{name}")
    public ResponseEntity<Hero> getHeroByName(@PathVariable("name") String name){
        return ResponseEntity.ok(heroService.getHeroByName(name));
    }

    /*
    //Respuesta error 404
   /@RequestMapping(value="consultar404", method=RequestMethod.GET)
    public Hero getHeroNo404<Hero>(String id) {
    */


    //buscar heroe
    @RequestMapping(value="buscar", method=RequestMethod.GET)
    public Hero searchHeroes(String term){
        Optional<Hero> hero = heroService.searchHeroes(term);
        return hero.get();
    }

    //Actualizar heroe
    @RequestMapping(value="actualizar", method=RequestMethod.PUT)
    public ResponseEntity<Hero> updateHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.updateHero(hero));
    }

    //crear heroe
    @RequestMapping(value="crear", method=RequestMethod.POST)
    public ResponseEntity<Hero> addHero(@RequestBody Hero hero){
        return ResponseEntity.ok(heroService.addHero(hero));
    }

    //Borrar heroe
    @RequestMapping(method=RequestMethod.DELETE, value="borrar")
    public String deleteHero(@RequestBody Hero hero) {
        String hId = hero.getId();
        Optional<Hero> oldHero = Optional.ofNullable(heroService.getHero(hId));
        heroService.deleteHero(hero);
        return null;
    }

    }


















