package com.itcast.recon.service.impl;

import cn.com.itcast.recon.dao.mapper.OuterBillDao;
import cn.com.itcast.recon.dao.mapper.OuterBillDoMapper;
import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.recon.service.IOuterBillDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/23.
 */
@Service
public class OuterBillDoServiceImpl implements IOuterBillDoService {

    @Autowired
    private OuterBillDoMapper outerBillDoMapper;

    @Autowired
    private OuterBillDao outerBillDao;

    @Override
    public int insert(OuterBillDo outerBillDo) {

        return outerBillDoMapper.insert(outerBillDo);
    }

    @Override
    public int batchInsert(List<OuterBillDo> outerBillDoList) {
        return outerBillDao.batchInsert(outerBillDoList);
    }

    @Override
    public int delete(Date reconDate) {
        return 0;
    }
}
