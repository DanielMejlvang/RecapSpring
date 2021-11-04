package com.caer.recapspring.Repository;

import com.caer.recapspring.Model.Note;
import com.caer.recapspring.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class NoteRepository {
    @Autowired
    JdbcTemplate template;

    public void addNoteToDatabase(Note n) {
        String sql = "INSERT INTO notes VALUES (?, ?, ?)";
        template.update(sql, n.getId(), n.getTitle(), n.getText());
    }

    public Note findNoteById(String id) {
        String sql = "SELECT * FROM notes WHERE id = ?";
        RowMapper<Note> rm = new BeanPropertyRowMapper<>(Note.class);
        return template.queryForObject(sql, rm, id);
    }

    public void deleteNoteFromDatabase(String id) {
        String sql = "DELETE FROM notes WHERE id = ?";
        template.update(sql, id);
    }

    public void updateNoteInDatabase(Note n) {
        String sql = "UPDATE notes SET title = ?, text = ? WHERE id = ?";
        template.update(sql, n.getTitle(), n.getText(), n.getId());
    }

    public List<Note> listNotesInDatabase() {
        String sql = "SELECT * FROM notes";
        RowMapper<Note> rm = new BeanPropertyRowMapper<>(Note.class);
        return template.query(sql, rm);
    }
}
