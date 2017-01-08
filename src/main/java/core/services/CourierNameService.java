package core.services;

import core.entities.CourierSlugName;
import core.entities.CourierSlugNameDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class CourierNameService {

    private final CourierSlugNameDAO courierSlugNameDAO;

    @Autowired
    public CourierNameService(CourierSlugNameDAO courierSlugNameDAO) {
        Assert.notNull(courierSlugNameDAO, "CourierSlugNameDAO must not be null!");
        this.courierSlugNameDAO = courierSlugNameDAO;
    }

    @Cacheable("slugNames")
    public String getCourierName(String slug) {
        CourierSlugName courierSlugName = courierSlugNameDAO.findBySlug(slug);
        if(courierSlugName !=null && courierSlugName.getName() != null && courierSlugName.getName().trim().length() > 0) {
            return courierSlugName.getName();
        }
        return "Unknown";
    }

    @CacheEvict(value = { "slugNames"}, allEntries = true)
    public void evictSlugNamesCaches() {
    }

    @Scheduled(fixedRate = 82800000) // 23hrs
    public void runEvict() {
        evictSlugNamesCaches();
    }
}
