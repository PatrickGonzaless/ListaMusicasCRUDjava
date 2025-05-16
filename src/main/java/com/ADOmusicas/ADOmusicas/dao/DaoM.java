package com.ADOmusicas.ADOmusicas.dao;

import com.ADOmusicas.ADOmusicas.model.Musicas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DaoM extends JpaRepository<Musicas, Integer> {
}
