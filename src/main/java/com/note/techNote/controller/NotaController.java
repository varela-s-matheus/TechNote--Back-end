package com.note.techNote.controller;

import com.note.techNote.model.Nota;
import com.note.techNote.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/notes")
public class NotaController {
    @Autowired
    private NoteRepository repository;

    @PostMapping
    public ResponseEntity<Nota> create(@RequestBody Nota dadosNota) {
        try {
//            Nota nota = new Nota(dadosNota);
            return ResponseEntity.ok(repository.saveAndFlush(dadosNota));
        }catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Nota>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    public ResponseEntity<Optional> findById(Long id) {
        return ResponseEntity.ok(repository.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {
        try {
            Optional nota = repository.findById(id);

            if (nota.isPresent()){
                Nota notaVerificadora = (Nota) nota.get();

                repository.deleteById(id);
                ResponseEntity response = ResponseEntity.ok().build();
                if (repository.findById(id) == null) {
                    Nota.diminuiContadorNotas();
                }
                return response;
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return null;
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Long id, @RequestBody Nota dadosNota) {
        try {
            Optional<Nota> nota = repository.findById(id);

            // Validação de duas etapas para atualizar evitando alteração no ID da URL
            if (nota.isPresent() && id == dadosNota.getId()){
                Nota notaAtualizada = nota.get();

                notaAtualizada.atualizaNota(dadosNota);

                repository.saveAndFlush(notaAtualizada);
                return ResponseEntity.ok().build();
            }
        } catch (RuntimeException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
        return ResponseEntity.badRequest().build();
    }


}
