package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.GroupsDTO;
import kg.amanturov.doska.models.Groups;
import kg.amanturov.doska.repository.CommonReferenceRepository;
import kg.amanturov.doska.repository.EmployeeRepository;
import kg.amanturov.doska.repository.GroupsRepository;
import kg.amanturov.doska.service.GroupsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GroupsServiceImpl implements GroupsService {
    private final GroupsRepository groupsRepository;
    private final CommonReferenceRepository commonReferenceRepository;
    private final EmployeeRepository employeeRepository;

    public GroupsServiceImpl(GroupsRepository groupsRepository, CommonReferenceRepository commonReferenceRepository, EmployeeRepository employeeRepository) {
        this.groupsRepository = groupsRepository;
        this.commonReferenceRepository = commonReferenceRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public GroupsDTO save(GroupsDTO groupDTO) {
        Groups group = toEntity(groupDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        group.setCreatedAt(timestamp);
        group = groupsRepository.save(group);
        return toDTO(group);
    }

    @Override
    public GroupsDTO update(Long id, GroupsDTO groupDTO) {
        Groups existingGroup = groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        Groups updatedGroup = toEntity(groupDTO);
        updatedGroup.setId(existingGroup.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedGroup.setUpdatedAt(timestamp);
        updatedGroup.setCreatedAt(existingGroup.getCreatedAt());
        updatedGroup = groupsRepository.save(updatedGroup);
        return toDTO(updatedGroup);
    }

    @Override
    public void delete(Long id) {
        Groups group = groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        groupsRepository.delete(group);
    }

    @Override
    public GroupsDTO findById(Long id) {
        Groups group = groupsRepository.findById(id).orElseThrow(() -> new RuntimeException("Group not found"));
        return toDTO(group);
    }

    @Override
    public List<GroupsDTO> findAll() {
        return groupsRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private GroupsDTO toDTO(Groups group) {
        GroupsDTO dto = new GroupsDTO();
        dto.setId(group.getId());
        dto.setCreatedAt(group.getCreatedAt());
        dto.setUpdatedAt(group.getUpdatedAt());
        dto.setName(group.getName());
        if (group.getTypeStudy() != null) {
            dto.setTypeStudyId(group.getTypeStudy().getId());
        }
        if (group.getCategory() != null) {
            dto.setCategoryId(group.getCategory().getId());
        }
        if (group.getEmployee() != null) {
            dto.setEmployeeId(group.getEmployee().getId());
        }
        return dto;
    }

    private Groups toEntity(GroupsDTO dto) {
        Groups group = new Groups();
        group.setId(dto.getId());
        group.setCreatedAt(dto.getCreatedAt());
        group.setUpdatedAt(dto.getUpdatedAt());
        group.setName(dto.getName());
        if (dto.getTypeStudyId() != null) {
            group.setTypeStudy(commonReferenceRepository.findById(dto.getTypeStudyId()).orElse(null));
        }
        if (dto.getCategoryId() != null) {
            group.setCategory(commonReferenceRepository.findById(dto.getCategoryId()).orElse(null));
        }
        if (dto.getEmployeeId() != null) {
            group.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElse(null));
        }
        return group;
    }
}
