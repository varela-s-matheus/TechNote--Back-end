package com.note.techNote.repository;

import com.note.techNote.model.Nota;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Nota, Long> {
}
