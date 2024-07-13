package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.CarsDTO;
import kg.amanturov.doska.models.Cars;
import kg.amanturov.doska.repository.CarsRepository;
import kg.amanturov.doska.repository.EmployeeRepository;
import kg.amanturov.doska.service.CarsService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarsServiceImpl implements CarsService {
    private final EmployeeRepository employeeRepository;
    private final CarsRepository carsRepository;
    public CarsServiceImpl(EmployeeRepository employeeRepository, CarsRepository carsRepository) {
        this.employeeRepository = employeeRepository;
        this.carsRepository = carsRepository;
    }



    @Override
    public CarsDTO save(CarsDTO carDTO) {
        Cars car = toEntity(carDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        car.setCreatedAt(timestamp);
        car = carsRepository.save(car);
        return toDTO(car);
    }

    @Override
    public CarsDTO update(Long id, CarsDTO carDTO) {
        Cars existingCar = carsRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        Cars updatedCar = toEntity(carDTO);
        updatedCar.setId(existingCar.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedCar.setUpdatedAt(timestamp);
        updatedCar = carsRepository.save(updatedCar);
        return toDTO(updatedCar);
    }

    @Override
    public void delete(Long id) {
        Cars car = carsRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        carsRepository.delete(car);
    }

    @Override
    public CarsDTO findById(Long id) {
        Cars car = carsRepository.findById(id).orElseThrow(() -> new RuntimeException("Car not found"));
        return toDTO(car);
    }

    @Override
    public List<CarsDTO> findAll() {
        return carsRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public  CarsDTO toDTO(Cars car) {
        CarsDTO dto = new CarsDTO();
        dto.setId(car.getId());
        dto.setCreatedAt(car.getCreatedAt());
        dto.setUpdatedAt(car.getUpdatedAt());
        dto.setName(car.getName());
        dto.setModel(car.getModel());
        dto.setColor(car.getColor());
        dto.setEngine(car.getEngine());
        dto.setYear(car.getYear());
        dto.setDifficultyLevel(car.getDifficultyLevel());
        if (car.getEmployee() != null) {
            dto.setEmployeeId(car.getEmployee().getId());
        }
        return dto;
    }

    public  Cars toEntity(CarsDTO dto) {
        Cars car = new Cars();
        car.setId(dto.getId());
        car.setCreatedAt(dto.getCreatedAt());
        car.setUpdatedAt(dto.getUpdatedAt());
        car.setName(dto.getName());
        car.setModel(dto.getModel());
        car.setColor(dto.getColor());
        car.setEngine(dto.getEngine());
        car.setYear(dto.getYear());
        car.setDifficultyLevel(dto.getDifficultyLevel());
        if (dto.getEmployeeId() != null) {
            car.setEmployee(employeeRepository.findById(dto.getEmployeeId()).orElse(null));
        }
        return car;
    }
}
