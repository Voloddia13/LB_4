package org.example.service;

import org.example.dto.JournalDTO;

import java.util.List;

public interface JournalService {
    JournalDTO getJournalById(Long id);
    List<JournalDTO> getAllJournals();
    JournalDTO createJournal(JournalDTO journalDTO);
    JournalDTO updateJournal(JournalDTO journalDTO);
    void deleteJournalById(Long id);

}