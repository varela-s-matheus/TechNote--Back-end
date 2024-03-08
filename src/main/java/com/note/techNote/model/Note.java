package com.note.techNote.model;

import jakarta.persistence.*;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

@Entity
@Table(name = "notas")
public class Note {
    private static Long counterNotes = 0L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date dateNote;
    @Column(length = 1024)
    private String content;
    @Enumerated(EnumType.STRING)
    private StyleNote style;
    private String title;
    private String author;
    private String type;

    // Constructor -----
    public Note() {
        this.dateNote = new Date();
        counterNotes++;
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

    public StyleNote getStyle() {
        return style;
    }

    public void setStyle(StyleNote style) {
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

    public static Long getCounterNotes() {
        return counterNotes;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    // Methods -----
    public void updateNote(@NotNull Note dadosNote) {
        this.dateNote = new Date();
        this.content = dadosNote.content;
        this.style = dadosNote.style;
        this.title = dadosNote.title;
        this.author = dadosNote.author;
    }

    public static void decreaseCounterNotes() {
        counterNotes--;
    }

}
