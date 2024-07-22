package kg.amanturov.doska.controllers;

import kg.amanturov.doska.dto.GroupsDTO;
import kg.amanturov.doska.service.GroupsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/groups")
public class GroupsController {
    private final GroupsService groupsService;

    public GroupsController(GroupsService groupsService) {
        this.groupsService = groupsService;
    }

    @PostMapping
    public GroupsDTO create(@RequestBody GroupsDTO groupsDTO) {
        return groupsService.save(groupsDTO);
    }

    @PutMapping("/{id}")
    public GroupsDTO update(@PathVariable Long id, @RequestBody GroupsDTO groupsDTO) {
        return groupsService.update(id, groupsDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        groupsService.delete(id);
    }

    @GetMapping("/{id}")
    public GroupsDTO getById(@PathVariable Long id) {
        return groupsService.findById(id);
    }

    @GetMapping("/all")
    public List<GroupsDTO> getAll() {
        return groupsService.findAll();
    }
}
