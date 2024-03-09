package com.note.techNote.controller;

import com.note.techNote.model.Note;
import com.note.techNote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/notes")
public class NoteController {
    @Autowired
    private NoteRepository repository;

    @PostMapping
    public ResponseEntity<Note> create(@RequestBody Note dataNote) {
        try {
//          Nota nota = new Nota(dadosNota);
            return ResponseEntity.ok(repository.saveAndFlush(dataNote));
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Note>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            Optional note = repository.findById(id);

            if (note.isPresent()){
                repository.deleteById(id);
                ResponseEntity response = ResponseEntity.ok().build();

                if (repository.findById(id) == null) {
                    Note.decreaseCounterNotes();
                }
                return response;
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Note dadaNote) {
        try {
            Optional<Note> note = repository.findById(id);

            if (note.isPresent() && id == dadaNote.getId()){
                Note noteUpdated = note.get();

                noteUpdated.updateNote(dadaNote);

                repository.saveAndFlush(noteUpdated);
                return ResponseEntity.ok().build();
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }


}
