package com.itcast.recon.service.impl;

import cn.com.itcast.recon.dao.mapper.InnerBillDao;
import cn.com.itcast.recon.dao.mapper.InnerBillDoMapper;
import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import com.itcast.recon.service.IInnerBillDoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/21.
 */
@Service
public class InnerBillDoServiceImpl implements IInnerBillDoService {

    @Autowired
    private   InnerBillDoMapper  innerBillDoMapper;

    @Autowired
    private InnerBillDao innerBillDao;

    @Override
    public int insert(InnerBillDo innerBillDo) {
       return innerBillDoMapper.insert(innerBillDo);
    }

    @Override
    public int batchInsert(List<InnerBillDo> innerBillDoList) {
        return  innerBillDao.batchInsert(innerBillDoList);
    }

    @Override
    public int delete(Date reconDate) {
        return 0;
    }
}
