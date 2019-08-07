package com.itcast.recon.service.impl;

import com.itcast.recon.Utils.FileUtil;
import com.itcast.recon.analyse.AnalyzeFileService;
import com.itcast.recon.bean.Response;
import com.itcast.recon.constant.ConstantValues;
import com.itcast.recon.factory.AnalyzeFileServiceFactory;
import com.itcast.recon.service.ItradeFileAnalyzeService;
import com.itcast.recon.thread.TradeFileAnalyzeThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhou on 2019/2/17.
 */
@Service
public class TradeFileAnalyzeServiceImpl implements ItradeFileAnalyzeService {

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Autowired
    private AnalyzeFileServiceFactory analyzeFileServiceFactory;



    @Override
    public Response analyzeTradeFile(String filePath, String type, Date reconDate) {

        long start = System.currentTimeMillis();

        Response response = new Response();
        File file = new File(filePath);
        if (!file.exists()) {
            response.setSuccess(false);
            return response;
        }

        try {
            int readerNumber = ConstantValues.READER_NUMBER;
            int totalNumber = FileUtil.getFileLineNumber(filePath);//获取文件的总行数
            int number = (totalNumber - 1) / readerNumber + 1;  //读取文件的次数

            FileUtil fileUtil = new FileUtil();
            CountDownLatch latch = new CountDownLatch(number);
            AtomicBoolean result = new AtomicBoolean();
            result.set(true);

            AnalyzeFileService analyzeFileService = analyzeFileServiceFactory.getservicebykey(type);

            for (int i = 0; i < number; i++) {
                TradeFileAnalyzeThread thread = new TradeFileAnalyzeThread(fileUtil, file, analyzeFileService, latch, result, reconDate);
                threadPoolTaskExecutor.execute(thread);
            }
            latch.await();
        } catch (Exception e) {
            e.printStackTrace();

        }
        long end = System.currentTimeMillis();
        long i = end - start;

        System.out.print("时间:"+i);

        return response;
    }
}
