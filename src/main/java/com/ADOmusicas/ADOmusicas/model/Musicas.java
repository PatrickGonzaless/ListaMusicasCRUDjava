package com.ADOmusicas.ADOmusicas.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Musicas")
public class Musicas {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer ID;
    @Column(name = "titulo" , length = 100, nullable = true)
    private String titulo;

    @Column(name = "artista" , length = 100, nullable = true)
    private String artista;

    @Column(name = "anolancamento", nullable = true)
    private Integer anolancamento;

    public Musicas() {
    }

    public Musicas(Integer ID, String titulo, String artista, Integer anolancamento) {
        this.ID = ID;
        this.titulo = titulo;
        this.artista = artista;
        this.anolancamento = anolancamento;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public Integer getAnolancamento() {
        return anolancamento;
    }

    public void setAnolancamento(Integer anolancamento) {
        this.anolancamento = anolancamento;
    }
}
