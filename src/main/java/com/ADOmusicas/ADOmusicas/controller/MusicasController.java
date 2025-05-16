package com.ADOmusicas.ADOmusicas.controller;

import com.ADOmusicas.ADOmusicas.model.Musicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ADOmusicas.ADOmusicas.service.MusicaService;

import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/musicas")
public class MusicasController {

    @Autowired
    private MusicaService musicaService;

    @GetMapping
    public List<Musicas> listarMusicas(){
        return musicaService.listarMusicas();
    }

    @PostMapping
    public Musicas adicionarMusica(@RequestBody Musicas musicas){
        try {
            return musicaService.salvarMusica(musicas);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao salvar a música: " + e.getMessage());
        }
    }

}
