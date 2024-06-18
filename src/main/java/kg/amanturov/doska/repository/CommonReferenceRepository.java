package kg.amanturov.doska.repository;


import kg.amanturov.doska.models.CommonReference;
import kg.amanturov.doska.models.CommonReferenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommonReferenceRepository extends JpaRepository<CommonReference, Long> {

    List<CommonReference> findAllByType(CommonReferenceType code);

    CommonReference findByTitle(String title);

    List<CommonReference> findByTypeId(Long id);

    List<CommonReference> findAllByTypeId(Long id);

    CommonReference findByTypeIdAndCode(Long id, String code);
    List<CommonReference> findByParentId (Long id);

    List<CommonReference> findAllByParentIdAndType(Long parentId, CommonReferenceType type);
}
