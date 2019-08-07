package com.itcast.recon.analyse.impl;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import com.itcast.recon.analyse.AnalyzeFileService;
import com.itcast.recon.service.IInnerBillDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/2/17.
 */
@Service("innerAnalyzeFileService")
public class InnerAnalyzeFileServiceImpl implements AnalyzeFileService<InnerBillDo> {

    @Autowired
    private IInnerBillDoService innerBillDoService;

    @Override
    public int batchInsert(List<InnerBillDo> list) {
        return innerBillDoService.batchInsert(list);
    }

    @Override
    public int delete(Date reconDate) {
        return innerBillDoService.delete(reconDate);
    }

    @Override
    public List<InnerBillDo> transfer(List<String> rows, Date reconDate) {

        List<InnerBillDo> innerBillDoList=new ArrayList<>();
        for(String row:rows){
            String[] values = row.split(",");
            InnerBillDo innerBillDo=new InnerBillDo();
            innerBillDo.setAmount(new BigDecimal(values[0]));
            innerBillDo.setReconDate(reconDate);
            innerBillDo.setInnerNo(values[1]);
            innerBillDo.setInnerBillNo(values[2]);
            innerBillDo.setReconStatus(values[3]);
            innerBillDo.setTradeStatus(values[4]);
            innerBillDo.setRemark("remark");
            innerBillDo.setCreateTime(new Date());
            innerBillDo.setModifyTime(new Date());
            innerBillDoList.add(innerBillDo);
        }
        return innerBillDoList;

    }
}
