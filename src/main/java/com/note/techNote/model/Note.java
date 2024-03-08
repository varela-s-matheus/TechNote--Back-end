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
    private Date dateNote;
    private String content;
    @Enumerated(EnumType.STRING)
    private EstiloNota style;
    private String title;
    private String author;
    private String type;

    // Constructor -----
    public Nota() {
        this.dateNote = new Date();
        contadorNotas ++;
    }

    // Getters and Setters -----

    public Long getId() {
        return id;
    }

    public Date getDateNote() {
        return dateNote;
    }

    public void setDateNote(Date dateNote) {
        this.dateNote = dateNote;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public EstiloNota getStyle() {
        return style;
    }

    public void setStyle(EstiloNota style) {
        this.style = style;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public static Long getContadorNotas() {
        return contadorNotas;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Methods -----
    public void atualizaNota(@NotNull Nota dadosNota) {
        this.dateNote = new Date();
        this.content = dadosNota.content;
        this.style = dadosNota.style;
        this.title = dadosNota.title;
        this.author = dadosNota.author;
    }

    public static void diminuiContadorNotas() {
        contadorNotas --;
    }

}
