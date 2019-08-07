package com.itcast.recon.service;

import com.itcast.recon.bean.Response;

import java.util.Date;

/**
 * Created by zhou on 2019/2/16.
 */
public interface IOuterAnalyzeFileService {

    Response outAnalyzeFile(Date reconDate, String filePath);

}
