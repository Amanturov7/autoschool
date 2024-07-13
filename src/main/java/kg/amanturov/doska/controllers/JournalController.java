package kg.amanturov.doska.controllers;



import kg.amanturov.doska.dto.JournalDTO;
import kg.amanturov.doska.service.JournalService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/journal")
public class JournalController {
    private final JournalService journalService;

    public JournalController(JournalService journalService) {
        this.journalService = journalService;
    }

    @PostMapping
    public JournalDTO create(@RequestBody JournalDTO journalDTO) {
        return journalService.save(journalDTO);
    }

    @PutMapping("/{id}")
    public JournalDTO update(@PathVariable Long id, @RequestBody JournalDTO journalDTO) {
        return journalService.update(id, journalDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        journalService.delete(id);
    }

    @GetMapping("/{id}")
    public JournalDTO getById(@PathVariable Long id) {
        return journalService.findById(id);
    }

    @GetMapping
    public List<JournalDTO> getAll() {
        return journalService.findAll();
    }
}
