package kg.amanturov.doska.controllers;

import kg.amanturov.doska.dto.DiaryDTO;
import kg.amanturov.doska.service.DiaryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/diary")
public class DiaryController {
    private final DiaryService diaryService;

    public DiaryController(DiaryService diaryService) {
        this.diaryService = diaryService;
    }

    @PostMapping
    public DiaryDTO create(@RequestBody DiaryDTO diaryDTO) {
        return diaryService.save(diaryDTO);
    }

    @PutMapping("/{id}")
    public DiaryDTO update(@PathVariable Long id, @RequestBody DiaryDTO diaryDTO) {
        return diaryService.update(id, diaryDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        diaryService.delete(id);
    }

    @GetMapping("/{id}")
    public DiaryDTO getById(@PathVariable Long id) {
        return diaryService.findById(id);
    }

    @GetMapping
    public List<DiaryDTO> getAll() {
        return diaryService.findAll();
    }
}
