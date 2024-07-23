package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.CarsDTO;
import kg.amanturov.doska.models.Cars;

import java.util.List;

public interface CarsService {
    CarsDTO save(CarsDTO carDTO);
    CarsDTO update(Long id, CarsDTO carDTO);
    void delete(Long id);
    CarsDTO findById(Long id);
    List<CarsDTO> findAll();
}
