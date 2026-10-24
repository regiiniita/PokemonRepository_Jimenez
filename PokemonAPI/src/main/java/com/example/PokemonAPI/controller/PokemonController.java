package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.obtenerTodos();
    }

    @PostMapping()
    public Pokemon crear(@RequestBody Pokemon pokemon){
        return pokemonService.crear(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon obtenerPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id);
    }

    @PutMapping("{/id}")
    public Pokemon actualizar(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return pokemonService.actualizar(id, pokemon).orElse(null);
    }

    @PatchMapping("{/id}")
    public Pokemon actualizarParcialmente(@PathVariable Long id, @RequestBody Pokemon pokemon){
        return pokemonService.actualizarParcialmente(id, pokemon).orElse(null);
    }

    @DeleteMapping("{/id}")
    public void eliminar(@PathVariable Long id){
        pokemonService.eliminarPokemon(id);
    }
}
