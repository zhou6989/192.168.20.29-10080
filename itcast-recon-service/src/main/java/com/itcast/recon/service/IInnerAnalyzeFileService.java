package com.itcast.recon.service;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import com.itcast.recon.bean.Response;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/30.
 */
public interface IInnerAnalyzeFileService {

    Response analyseFile(Date reconDate, String filePath);

    Response analyseFileTwo(Date reconDate, String filePath);

    List<InnerBillDo> transfer(List<String> rows, Date reconDate);
}
