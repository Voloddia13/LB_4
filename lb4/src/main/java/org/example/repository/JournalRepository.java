package org.example.repository;

import org.example.entity.Journal;
import org.example.exception.ServiceException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class JournalRepository {

    @PostConstruct
    public void init(){
        savedJournals = new ArrayList<>();
    }

    private static Long lastId = 1L;
    private List<Journal> savedJournals;

    public Journal getJournalById(final Long id){
        return savedJournals.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Journal with id: " + id + " not found ", null));
    }

    public List<Journal> getAllJournals(){
        return savedJournals;
    }

    public Journal createJournal(final Journal journal){
        if(journal.getId() != null){
            throw new ServiceException(400, "Journal shouldn't have an id ", null);
        }

        ++lastId;
        journal.setId(lastId);

        savedJournals.add(journal);

        return journal;
    }

    public Journal updateJournal(final Journal journal){
        if(journal.getId() == null){
            throw new ServiceException(400, "User shouldn't have an id ", null);
        }

        final Journal savedJournal = getJournalById(journal.getId());


        savedJournal.setTitle(journal.getTitle());
        savedJournal.setPrice(journal.getPrice());
        savedJournal.setAuthorName(journal.getAuthorName());

        return savedJournal;
    }

    public void deleteJournalById(final Long id){
        if(id == null){
            throw new ServiceException(400, "Id isn't specified", null);
        }

        savedJournals.stream()
                .filter(e -> e.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ServiceException(400, "Journal with id: " + id + " not found ", null));

        savedJournals = savedJournals.stream()
                .filter(e -> !e.getId().equals(id))
                .collect(Collectors.toList());

    }
}