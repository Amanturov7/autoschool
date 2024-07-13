package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.ScheduleDTO;
import kg.amanturov.doska.models.Schedule;
import kg.amanturov.doska.repository.GroupsRepository;
import kg.amanturov.doska.repository.ScheduleRepository;
import kg.amanturov.doska.service.ScheduleService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleRepository scheduleRepository;
    private final GroupsRepository groupsRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository, GroupsRepository groupsRepository) {
        this.scheduleRepository = scheduleRepository;
        this.groupsRepository = groupsRepository;
    }

    @Override
    public ScheduleDTO save(ScheduleDTO scheduleDTO) {
        Schedule schedule = toEntity(scheduleDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        schedule.setCreatedAt(timestamp);
        schedule = scheduleRepository.save(schedule);
        return toDTO(schedule);
    }

    @Override
    public ScheduleDTO update(Long id, ScheduleDTO scheduleDTO) {
        Schedule existingSchedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        Schedule updatedSchedule = toEntity(scheduleDTO);
        updatedSchedule.setId(existingSchedule.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedSchedule.setUpdatedAt(timestamp);
        updatedSchedule = scheduleRepository.save(updatedSchedule);
        return toDTO(updatedSchedule);
    }

    @Override
    public void delete(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        scheduleRepository.delete(schedule);
    }

    @Override
    public ScheduleDTO findById(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow(() -> new RuntimeException("Schedule not found"));
        return toDTO(schedule);
    }

    @Override
    public List<ScheduleDTO> findAll() {
        return scheduleRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private ScheduleDTO toDTO(Schedule schedule) {
        ScheduleDTO dto = new ScheduleDTO();
        dto.setId(schedule.getId());
        dto.setCreatedAt(schedule.getCreatedAt());
        dto.setUpdatedAt(schedule.getUpdatedAt());
        dto.setDate(schedule.getDate());
        dto.setName(schedule.getName());
        if (schedule.getGroup() != null) {
            dto.setGroupId(schedule.getGroup().getId());
        }
        return dto;
    }

    private Schedule toEntity(ScheduleDTO dto) {
        Schedule schedule = new Schedule();
        schedule.setId(dto.getId());
        schedule.setCreatedAt(dto.getCreatedAt());
        schedule.setUpdatedAt(dto.getUpdatedAt());
        schedule.setDate(dto.getDate());
        schedule.setName(dto.getName());
        if (dto.getGroupId() != null) {
            schedule.setGroup(groupsRepository.findById(dto.getGroupId()).orElse(null));
        }
        return schedule;
    }
}
