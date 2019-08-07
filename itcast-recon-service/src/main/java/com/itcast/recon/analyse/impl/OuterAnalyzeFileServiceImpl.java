package com.itcast.recon.analyse.impl;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.recon.analyse.AnalyzeFileService;
import com.itcast.recon.service.IOuterBillDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/2/17.
 */
@Service("outerAnalyzeFileService")
public class OuterAnalyzeFileServiceImpl implements AnalyzeFileService<OuterBillDo> {

    @Autowired
    private IOuterBillDoService outerBillDoService;

    @Override
    public int batchInsert(List<OuterBillDo> list) {
        return outerBillDoService.batchInsert(list);
    }

    @Override
    public int delete(Date reconDate) {
        return outerBillDoService.delete(reconDate);
    }

    @Override
    public List<OuterBillDo> transfer(List<String> rows, Date reconDate) {

        List<OuterBillDo> outerBillDoList = new ArrayList<>();
        for (String row : rows) {
            String[] values = row.split(",");
            OuterBillDo outerBillDo = new OuterBillDo();
            outerBillDo.setAmount(new BigDecimal(values[0]));
            outerBillDo.setReconDate(reconDate);
            outerBillDo.setOuterNo(values[1]);
            outerBillDo.setOuterBillNo(values[2]);
            outerBillDo.setReconStatus(values[3]);
            outerBillDo.setTradeStatus(values[4]);
            outerBillDo.setRemark("remark");
            outerBillDo.setCreateTime(new Date());
            outerBillDo.setModifyTime(new Date());
            outerBillDoList.add(outerBillDo);
        }
        return outerBillDoList;
    }

}
