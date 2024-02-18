package com.note.techNote.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
@Table(name = "notas")
public class Nota {
    private static Long contadorNotas = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dataNota;
    private String informacaoNota;
    @Enumerated(EnumType.STRING)
    private EstiloNota estiloNota;
    private String tituloNota;
    private String nomeAutor;

    // Constructor -----
    public Nota() {
        this.dataNota = new Date();
        contadorNotas ++;
    }

    // Getters and Setters -----

    public Long getId() {
        return id;
    }

    public Date getDataNota() {
        return dataNota;
    }

    public void setDataNota(Date dataNota) {
        this.dataNota = dataNota;
    }

    public String getInformacaoNota() {
        return informacaoNota;
    }

    public void setInformacaoNota(String informacaoNota) {
        this.informacaoNota = informacaoNota;
    }

    public EstiloNota getEstiloNota() {
        return estiloNota;
    }

    public void setEstiloNota(EstiloNota estiloNota) {
        this.estiloNota = estiloNota;
    }

    public String getTituloNota() {
        return tituloNota;
    }

    public void setTituloNota(String tituloNota) {
        this.tituloNota = tituloNota;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public static Long getContadorNotas() {
        return contadorNotas;
    }

    // Methods -----
    public void atualizaNota(@NotNull Nota dadosNota) {
        this.dataNota = new Date();
        this.informacaoNota = dadosNota.informacaoNota;
        this.estiloNota = dadosNota.estiloNota;
        this.tituloNota = dadosNota.tituloNota;
        this.nomeAutor = dadosNota.nomeAutor;
    }

    public static void diminuiContadorNotas() {
        contadorNotas --;
    }

}
