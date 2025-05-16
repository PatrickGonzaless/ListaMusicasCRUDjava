package com.ADOmusicas.ADOmusicas.service;

import com.ADOmusicas.ADOmusicas.dao.DaoM;
import com.ADOmusicas.ADOmusicas.model.Musicas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicaService {
    @Autowired
    private DaoM daoM;

    public List<Musicas> listarMusicas(){
        return daoM.findAll();
    }

    public Musicas salvarMusica (Musicas musicas){
        return daoM.save(musicas);
    }
}
