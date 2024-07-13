package kg.amanturov.doska.service;

import kg.amanturov.doska.dto.CertificateDTO;

import java.util.List;

public interface CertificateService {
    CertificateDTO save(CertificateDTO certificateDTO);
    CertificateDTO update(Long id, CertificateDTO certificateDTO);
    void delete(Long id);
    CertificateDTO findById(Long id);
    List<CertificateDTO> findAll();
}
