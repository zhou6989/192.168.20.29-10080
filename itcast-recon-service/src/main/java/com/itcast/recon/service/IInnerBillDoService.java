package com.itcast.recon.service;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/21.
 */
public interface IInnerBillDoService {

     int insert(InnerBillDo innerBillDo);

     int batchInsert(List<InnerBillDo> innerBillDoList);

     int delete(Date reconDate);

}
