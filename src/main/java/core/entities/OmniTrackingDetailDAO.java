package core.entities;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OmniTrackingDetailDAO extends CrudRepository<OmniTrackingDetail, Long> {
    List<OmniTrackingDetail> findByOmniTrackingId(long omniTrackingId);
}
