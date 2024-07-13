package kg.amanturov.doska.controllers;

import kg.amanturov.doska.dto.CarsDTO;
import kg.amanturov.doska.service.CarsService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/cars")
public class CarsController {
    private final CarsService carsService;

    public CarsController(CarsService carsService) {
        this.carsService = carsService;
    }

    @PostMapping("/create")
    public CarsDTO create(@RequestBody CarsDTO carsDTO) {
        return carsService.save(carsDTO);
    }

    @PutMapping("/update/{id}")
    public CarsDTO update(@PathVariable Long id, @RequestBody CarsDTO carsDTO) {
        return carsService.update(id, carsDTO);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        carsService.delete(id);
    }

    @GetMapping("/car/{id}")
    public CarsDTO getById(@PathVariable Long id) {
        return carsService.findById(id);
    }

    @GetMapping("/all")
    public List<CarsDTO> getAll() {
        return carsService.findAll();
    }
}
