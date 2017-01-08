package core.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface CourierSlugNameDAO extends CrudRepository<CourierSlugName, Long> {
    CourierSlugName findBySlug(String slug);
}
