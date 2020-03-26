package com.indiacleantool.cleantool.web.modules.asset;

import com.indiacleantool.cleantool.web.domain.assets.Asset;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssetRepository extends CrudRepository<Asset,Long> {

    Asset findByCode(String code);

    Iterable<Asset> findByCompanyCode(String companyCode);
}
