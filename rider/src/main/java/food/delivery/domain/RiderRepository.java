package food.delivery.domain;

import food.delivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "riders", path = "riders")
public interface RiderRepository
    extends PagingAndSortingRepository<Rider, Long> {}
