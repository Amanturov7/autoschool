package kg.amanturov.doska.controllers;

import kg.amanturov.doska.dto.CertificateDTO;
import kg.amanturov.doska.service.CertificateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/certificate")
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }


    @PostMapping
    public CertificateDTO create(@RequestBody CertificateDTO certificateDTO) {
        return certificateService.save(certificateDTO);
    }

    @PutMapping("/{id}")
    public CertificateDTO update(@PathVariable Long id, @RequestBody CertificateDTO certificateDTO) {
        return certificateService.update(id, certificateDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        certificateService.delete(id);
    }

    @GetMapping("/{id}")
    public CertificateDTO getById(@PathVariable Long id) {
        return certificateService.findById(id);
    }

    @GetMapping
    public List<CertificateDTO> getAll() {
        return certificateService.findAll();
    }
}
