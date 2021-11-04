package com.caer.recapspring.Service;

import com.caer.recapspring.Model.Note;
import com.caer.recapspring.Repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    @Autowired
    NoteRepository nr;

    public void addNoteToDatabase(Note n) {
        nr.addNoteToDatabase(n);
    }

    public Note findNoteById(String id) {
        return nr.findNoteById(id);
    }

    public void deleteNoteFromDatabase(String id) {
        nr.deleteNoteFromDatabase(id);
    }

    public void updateNoteInDatabase(Note n) {
        nr.updateNoteInDatabase(n);
    }

    public List<Note> listNotesInDatabase() {
        return nr.listNotesInDatabase();
    }
}
