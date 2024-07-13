package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.JournalDTO;
import kg.amanturov.doska.models.Journal;
import kg.amanturov.doska.repository.JournalRepository;
import kg.amanturov.doska.service.JournalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class JournalServiceImpl implements JournalService {
    private final JournalRepository journalRepository;

    public JournalServiceImpl(JournalRepository journalRepository) {
        this.journalRepository = journalRepository;
    }

    @Override
    public JournalDTO save(JournalDTO journalDTO) {
        Journal journal = toEntity(journalDTO);
        journal = journalRepository.save(journal);
        return toDTO(journal);
    }

    @Override
    public JournalDTO update(Long id, JournalDTO journalDTO) {
        Journal existingJournal = journalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        Journal updatedJournal = toEntity(journalDTO);
        updatedJournal.setId(existingJournal.getId());
        updatedJournal.setCreatedAt(existingJournal.getCreatedAt());
        updatedJournal = journalRepository.save(updatedJournal);
        return toDTO(updatedJournal);
    }

    @Override
    public void delete(Long id) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        journalRepository.delete(journal);
    }

    @Override
    public JournalDTO findById(Long id) {
        Journal journal = journalRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Journal not found"));
        return toDTO(journal);
    }

    @Override
    public List<JournalDTO> findAll() {
        return journalRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private JournalDTO toDTO(Journal journal) {
        JournalDTO dto = new JournalDTO();
        dto.setId(journal.getId());
        dto.setCreatedAt(journal.getCreatedAt());
        dto.setUpdatedAt(journal.getUpdatedAt());
        dto.setName(journal.getName());
        return dto;
    }

    private Journal toEntity(JournalDTO dto) {
        Journal journal = new Journal();
        journal.setId(dto.getId());
        journal.setCreatedAt(dto.getCreatedAt());
        journal.setUpdatedAt(dto.getUpdatedAt());
        journal.setName(dto.getName());
        return journal;
    }
}
