package com.itcast.recon.service;

import com.itcast.recon.bean.Response;

import java.util.Date;

/**
 * Created by zhou on 2019/2/17.
 */
public interface ItradeFileAnalyzeService {

    Response analyzeTradeFile(String filePath, String type, Date reconDate);

}
