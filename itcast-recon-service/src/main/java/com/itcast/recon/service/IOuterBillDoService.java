package com.itcast.recon.service;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/23.
 */
public interface IOuterBillDoService {

    int insert(OuterBillDo outerBillDo);

    int batchInsert(List<OuterBillDo> outerBillDoList);

    int delete(Date reconDate);
}
