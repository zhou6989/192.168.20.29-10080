package com.itcast.recon.factory;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.recon.analyse.AnalyzeFileService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhou on 2019/2/17.
 */
@Component
public class AnalyzeFileServiceFactory {

    @Resource(name = "innerAnalyzeFileService")
    private AnalyzeFileService<InnerBillDo>  innerAnalyzeFileService;

    @Resource(name = "outerAnalyzeFileService")
    private AnalyzeFileService<OuterBillDo>  outerAnalyzeFileService;

    private Map<String,AnalyzeFileService>  analyzeFileServiceMap;


    @PostConstruct
    public void  initAnalyzeFileServide (){

        analyzeFileServiceMap = new HashMap<>();
        analyzeFileServiceMap.put("inner",innerAnalyzeFileService);
        analyzeFileServiceMap.put("outer",outerAnalyzeFileService);
    }

    public AnalyzeFileService getservicebykey(String key){

        return  analyzeFileServiceMap.get(key);
    }

}
