package com.secure.notes.models;

import jakarta.persistence.*;
import lombok.Data;

//str+alt+O = rermove unused imports
@Entity
@Data
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Lob
    private String content;
    private String ownerUsername;

    public void setContent(String content) {
        this.content = content;
    }

    public void setOwnerUsername(String ownerUsername) {
        this.ownerUsername = ownerUsername;
    }
}
