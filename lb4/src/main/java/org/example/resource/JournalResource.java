package org.example.resource;

import org.example.dto.JournalDTO;
import org.example.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class JournalResource {
    @Autowired
    private JournalService journalService;

    @GetMapping("/journals/{id}")
    public JournalDTO getJournalById(final @PathVariable Long id){
        return journalService.getJournalById(id);
    }

    @GetMapping("/journals")
    public List<JournalDTO> getAllJournals(){
        return journalService.getAllJournals();
    }

    @PostMapping("/journals")
    public JournalDTO createJournal(final @RequestBody JournalDTO journalDTO){
        return journalService.createJournal(journalDTO);
    }

    @PutMapping("/journals")
    public JournalDTO updateJournal(final @RequestBody JournalDTO journalDTO){
        return journalService.updateJournal(journalDTO);
    }

    @DeleteMapping("/journals/{id}")
    public void deleteJournalById(final @PathVariable Long id){
        journalService.deleteJournalById(id);
    }
}