package com.indiacleantool.cleantool.web.modules.staticservices;

import com.indiacleantool.cleantool.web.domain.Services;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StaticServiceRepository extends CrudRepository<Services,Long> {
}
