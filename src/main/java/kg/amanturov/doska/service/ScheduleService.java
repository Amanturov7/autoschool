package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.ScheduleDTO;

import java.util.List;

public interface ScheduleService {
    ScheduleDTO save(ScheduleDTO scheduleDTO);
    ScheduleDTO update(Long id, ScheduleDTO scheduleDTO);
    void delete(Long id);
    ScheduleDTO findById(Long id);
    List<ScheduleDTO> findAll();
}
