package org.example.service.impl;

import org.example.dto.JournalDTO;
import org.example.exception.ServiceException;
import org.example.repository.JournalRepository;
import org.example.service.JournalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalServiceImpl implements JournalService {

    @Autowired
    private JournalRepository journalRepository;

    @Autowired
    private org.example.mapper.JournalToJournalDTOMapper journalToJournalDTOMapper;

    public JournalServiceImpl() {
    }

    @Override
    public JournalDTO getJournalById(final Long id) {

        return journalToJournalDTOMapper.toDTO(journalRepository.getJournalById(id));
    }

    @Override
    public List<JournalDTO> getAllJournals() {
        return journalRepository.getAllJournals().stream()
                .map(e -> journalToJournalDTOMapper.toDTO(e))
                .collect(Collectors.toList());
    }

    @Override
    public JournalDTO createJournal(final JournalDTO journalDTO) {
        if(journalDTO.getId() != null){
            throw new ServiceException(400, "Journal shouldn't have an id ", null);
        }

        return journalToJournalDTOMapper.toDTO(journalRepository.createJournal(journalToJournalDTOMapper.toEntity(journalDTO)));
    }

    @Override
    public JournalDTO updateJournal(final JournalDTO journalDTO) {
        if(journalDTO.getId() == null){
            throw new ServiceException(400, "Journal have an id ", null);
        }

        return journalToJournalDTOMapper.toDTO(journalRepository.updateJournal(journalToJournalDTOMapper.toEntity(journalDTO)));
    }

    @Override
    public void deleteJournalById(final Long id) {
        journalRepository.deleteJournalById(id);
    }
}