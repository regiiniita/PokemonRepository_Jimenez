package com.example.PokemonAPI.service;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos(){
        return pokemonRepository.findAll();
    }

    public Pokemon obtenerPorId(Long id){
        return pokemonRepository.findById(id).orElse(null);
    }

    public Pokemon crear(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    public Optional<Pokemon> actualizar(Long id, Pokemon pokemon){
        return pokemonRepository.findById(id).map(pokemonExists -> {
            pokemonExists.setNombre(pokemon.getNombre());
            pokemonExists.setTipo(pokemon.getTipo());
            pokemonExists.setNivel(pokemon.getNivel());
            pokemonExists.setAtaque(pokemon.getAtaque());
            pokemonExists.setDefensa(pokemon.getDefensa());
            pokemonExists.setDescripcion(pokemon.getDescripcion());
            pokemonExists.setImageUrl(pokemon.getImageUrl());
            return pokemonRepository.save(pokemonExists);
        });
    }

    public Optional<Pokemon> actualizarParcialmente(Long id, Pokemon pokemon){
        return pokemonRepository.findById(id).map(pokemonExists -> {
            if(pokemonExists.getNombre()!=null){
                pokemonExists.setNombre(pokemon.getNombre());
            }
            if(pokemonExists.getTipo()!=null){
                pokemonExists.setTipo(pokemon.getTipo());
            }
            if(pokemonExists.getNivel()!=null){
                pokemonExists.setNivel(pokemon.getNivel());
            }
            if(pokemonExists.getAtaque()!=null){
                pokemonExists.setAtaque(pokemon.getAtaque());
            }
            if(pokemonExists.getDefensa()!=null){
                pokemonExists.setDefensa(pokemon.getDefensa());
            }
            if(pokemonExists.getDescripcion()!=null){
                pokemonExists.setDescripcion(pokemon.getDescripcion());
            }
            if(pokemonExists.getImageUrl()!=null) {
                pokemonExists.setImageUrl(pokemon.getImageUrl());
            }
            return pokemonRepository.save(pokemonExists);
        });
    }

    public void eliminarPokemon(Long id){
        pokemonRepository.deleteById(id);
    }
}



