package com.secure.notes.repositories;

import com.secure.notes.models.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface NoteRepository extends JpaRepository<Note, Long> {
    // Custom query methods can be defined here if needed
    // For example, to find notes by owner username:
    List<Note> findByOwnerUsername(String ownerUsername);
}