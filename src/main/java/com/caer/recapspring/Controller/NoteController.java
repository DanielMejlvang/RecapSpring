package com.caer.recapspring.Controller;

import com.caer.recapspring.Model.Note;
import com.caer.recapspring.Service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NoteController {
    private String path = "notes/";
    @Autowired
    NoteService noteService;

    @GetMapping("/notebook")
    public String notebook(Model model) {
        model.addAttribute("notes", noteService.listNotesInDatabase());
        return path + "notebook";
    }

    @GetMapping("/createNote")
    public String createNote() {
        return path + "createNote";
    }

    @PostMapping("/createNote")
    public String createNote(@ModelAttribute Note note) {
        noteService.addNoteToDatabase(note);
        return "redirect:/notebook";
    }

    @GetMapping("/viewNote/{id}")
    public String viewNote(@PathVariable("id") String id, Model model) {
        model.addAttribute("note", noteService.findNoteById(id));
        return path + "viewNote";
    }

    @PostMapping("/updateNote")
    public String updateNote(@ModelAttribute Note note) {
        noteService.updateNoteInDatabase(note);
        return "redirect:/notebook";
    }

    @GetMapping("/deleteNote/{id}")
    public String deleteNote(@PathVariable("id") String id) {
        noteService.deleteNoteFromDatabase(id);
        return "redirect:/notebook";
    }
}
