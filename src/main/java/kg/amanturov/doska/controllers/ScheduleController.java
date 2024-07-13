package kg.amanturov.doska.controllers;

import kg.amanturov.doska.dto.ScheduleDTO;
import kg.amanturov.doska.service.ScheduleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/schedule")
public class ScheduleController {
    private final ScheduleService scheduleService;

    public ScheduleController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ScheduleDTO create(@RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.save(scheduleDTO);
    }

    @PutMapping("/{id}")
    public ScheduleDTO update(@PathVariable Long id, @RequestBody ScheduleDTO scheduleDTO) {
        return scheduleService.update(id, scheduleDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        scheduleService.delete(id);
    }

    @GetMapping("/{id}")
    public ScheduleDTO getById(@PathVariable Long id) {
        return scheduleService.findById(id);
    }

    @GetMapping
    public List<ScheduleDTO> getAll() {
        return scheduleService.findAll();
    }
}
