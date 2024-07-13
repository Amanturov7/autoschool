package kg.amanturov.doska.service.impl;

import kg.amanturov.doska.dto.CertificateDTO;
import kg.amanturov.doska.models.Certificate;
import kg.amanturov.doska.repository.CertificateRepository;
import kg.amanturov.doska.repository.UserRepository;
import kg.amanturov.doska.service.CertificateService;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CertificateServiceImpl implements CertificateService {
    private final CertificateRepository certificateRepository;
    private final UserRepository userRepository;

    public CertificateServiceImpl(CertificateRepository certificateRepository, UserRepository userRepository) {
        this.certificateRepository = certificateRepository;
        this.userRepository = userRepository;
    }

    @Override
    public CertificateDTO save(CertificateDTO certificateDTO) {
        Certificate certificate = toEntity(certificateDTO);
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        certificate.setCreatedAt(timestamp);
        certificate = certificateRepository.save(certificate);
        return toDTO(certificate);
    }

    @Override
    public CertificateDTO update(Long id, CertificateDTO certificateDTO) {
        Certificate existingCertificate = certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Certificate not found"));
        Certificate updatedCertificate = toEntity(certificateDTO);
        updatedCertificate.setId(existingCertificate.getId());
        LocalDateTime now = LocalDateTime.now();
        Timestamp timestamp = Timestamp.valueOf(now);
        updatedCertificate.setUpdatedAt(timestamp);
        updatedCertificate = certificateRepository.save(updatedCertificate);
        return toDTO(updatedCertificate);
    }

    @Override
    public void delete(Long id) {
        Certificate certificate = certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Certificate not found"));
        certificateRepository.delete(certificate);
    }

    @Override
    public CertificateDTO findById(Long id) {
        Certificate certificate = certificateRepository.findById(id).orElseThrow(() -> new RuntimeException("Certificate not found"));
        return toDTO(certificate);
    }

    @Override
    public List<CertificateDTO> findAll() {
        return certificateRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    private CertificateDTO toDTO(Certificate certificate) {
        CertificateDTO dto = new CertificateDTO();
        dto.setId(certificate.getId());
        dto.setCreatedAt(certificate.getCreatedAt());
        dto.setUpdatedAt(certificate.getUpdatedAt());
        dto.setName(certificate.getName());
        if (certificate.getUser() != null) {
            dto.setUserId(certificate.getUser().getId());
        }
        return dto;
    }

    private Certificate toEntity(CertificateDTO dto) {
        Certificate certificate = new Certificate();
        certificate.setId(dto.getId());
        certificate.setCreatedAt(dto.getCreatedAt());
        certificate.setUpdatedAt(dto.getUpdatedAt());
        certificate.setName(dto.getName());
        if (dto.getUserId() != null) {
            certificate.setUser(userRepository.findById(dto.getUserId()).orElse(null));
        }
        return certificate;
    }
}
