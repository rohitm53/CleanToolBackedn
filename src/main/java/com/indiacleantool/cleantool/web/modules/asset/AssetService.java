package com.indiacleantool.cleantool.web.modules.asset;

import com.indiacleantool.cleantool.web.domain.assets.Asset;
import com.indiacleantool.cleantool.web.exceptions.asset.AssetException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssetService {

    @Autowired
    private AssetRepository assetRepository;

    public Asset saveAsset(Asset asset){
        try{
            return assetRepository.save(asset);
        }catch (Exception e){
            throw new AssetException("Asset code : "+asset.getCode()+" , already existed");
        }
    }
    public Iterable<Asset> getAllAssets(){
        return assetRepository.findAll();
    }
    public Iterable<Asset> getAllAssetsByCompanyCode(String companycode){
        return assetRepository.findByCompanyCode(companycode);
    }

    public Asset getAssetByCode(String code){
        Asset asset = assetRepository.findByCode(code);
        if(asset==null){
            throw new AssetException("Asset with code :"+code+", does not exist");
        }
        return asset;
    }

    public void deleteAsset(String code){
        assetRepository.delete(getAssetByCode(code));
    }

    public Long getCountByCompanyCode(String companyCode){
        return assetRepository.countByCompanyCode(companyCode);
    }

}
