package com.itcast.recon.thread;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.recon.Utils.FileUtil;
import com.itcast.recon.analyse.AnalyzeFileService;
import com.itcast.recon.constant.ConstantValues;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhou on 2019/2/17.
 */
public class TradeFileAnalyzeThread implements Runnable{

    private FileUtil fileUtil;
    private File file;
    private AnalyzeFileService analyzeFileService;
    private CountDownLatch latch;
    private AtomicBoolean result;
    private Date reconDate;

    public TradeFileAnalyzeThread(FileUtil fileUtil, File file, AnalyzeFileService analyzeFileService, CountDownLatch latch, AtomicBoolean result, Date reconDate) {
        this.fileUtil = fileUtil;
        this.file = file;
        this.analyzeFileService = analyzeFileService;
        this.latch = latch;
        this.result = result;
        this.reconDate = reconDate;
    }

    @Override
    public void run() {

        try {
            List<String> strList = fileUtil.readLine(file, ConstantValues.ENCODING, ConstantValues.READER_NUMBER); //读取所有数据
            List arrayList = new ArrayList<>(ConstantValues.BATCH_INSERT_NUM);
            int len = strList.size();
            for (int i = 0; i < strList.size(); i++) {
                String value = strList.get(i);
                arrayList.add(value);
                if (arrayList.size() == ConstantValues.BATCH_INSERT_NUM || i == len - 1) {
                    List<OuterBillDo> list = analyzeFileService.transfer(arrayList,reconDate);
                    analyzeFileService.batchInsert(list);
                    arrayList.clear();
                }
            }
        } catch (Exception e) {
            result.set(false);
            analyzeFileService.delete(reconDate);
        } finally {
            latch.countDown();
        }
    }
}
