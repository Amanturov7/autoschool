package kg.amanturov.doska.controllers;

import kg.amanturov.doska.RestResponse;
import kg.amanturov.doska.dto.LessonsDTO;
import kg.amanturov.doska.service.LessonsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/lessons")
public class LessonsController {

        private final LessonsService lessonsService;

    public LessonsController(LessonsService lessonsService) {
        this.lessonsService = lessonsService;
    }


    @PostMapping
    public RestResponse create(@RequestBody LessonsDTO lessonsDTO) {
        return lessonsService.save(lessonsDTO);
    }

    @PutMapping("/{id}")
    public RestResponse update(@PathVariable Long id, @RequestBody LessonsDTO lessonsDTO) {
        return lessonsService.update(id, lessonsDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        lessonsService.delete(id);
    }


    @GetMapping("/by-group/{id}")
    public RestResponse findAllByGroupsId(@PathVariable Long id) {
        return lessonsService.findAllByGroupsId(id);
    }

    @GetMapping("/by-type-group")
    public RestResponse findAllByGroupsId(@RequestParam(name = "typeId") Long typeId,
                                               @RequestParam(name = "groupId") Long groupId) {
        return lessonsService.findAllByLessonTypeAndGroupsId(typeId,groupId);
    }

    @GetMapping("/{id}")
    public RestResponse findById(@PathVariable Long id) {
        return lessonsService.findById(id);
    }

    @GetMapping("/all")
    public RestResponse getAll() {
        return lessonsService.findAll();
        }

}


