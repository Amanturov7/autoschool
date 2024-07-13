package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.JournalDTO;

import java.util.List;

public interface JournalService {
    JournalDTO save(JournalDTO journalDTO);
    JournalDTO update(Long id, JournalDTO journalDTO);
    void delete(Long id);
    JournalDTO findById(Long id);
    List<JournalDTO> findAll();

}
