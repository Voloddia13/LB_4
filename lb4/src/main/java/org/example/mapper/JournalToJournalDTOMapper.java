package org.example.mapper;

import org.example.dto.JournalDTO;
import org.example.entity.Journal;
import org.springframework.stereotype.Component;

@Component
public class JournalToJournalDTOMapper {
    public Journal toEntity(final JournalDTO journalDTO){
        final Journal journal = new Journal();

        journal.setId(journalDTO.getId());
        journal.setAuthorName(journalDTO.getAuthorName());
        journal.setPrice(journalDTO.getPrice());
        journal.setTitle(journalDTO.getTitle());

        return journal;
    }

    public JournalDTO toDTO(final Journal journal){
        final JournalDTO journalDTO = new JournalDTO();

        journalDTO.setId(journal.getId());
        journalDTO.setAuthorName(journal.getAuthorName());
        journalDTO.setPrice(journal.getPrice());
        journalDTO.setTitle(journal.getTitle());

        return journalDTO;
    }
}