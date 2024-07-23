package kg.amanturov.doska.repository;

import kg.amanturov.doska.models.Attachments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AttachmentRepository extends JpaRepository<Attachments, Long> {

    Attachments findByGroupsId(Long id);
    Attachments findByCarsId(Long id);
    Attachments findByTicketsId(Long id);
//
    Attachments findByUserIdAndType(Long id, String type);


    Optional<Attachments> findById(Long id);
}
