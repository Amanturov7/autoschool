package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.GroupsDTO;
import kg.amanturov.doska.models.Groups;

import java.util.List;

public interface GroupsService {
    GroupsDTO save(GroupsDTO groupDTO);
    GroupsDTO update(Long id, GroupsDTO groupDTO);
    void delete(Long id);
    GroupsDTO findById(Long id);

    Groups findGroupById(Long id);

    List<GroupsDTO> findAll();
}
