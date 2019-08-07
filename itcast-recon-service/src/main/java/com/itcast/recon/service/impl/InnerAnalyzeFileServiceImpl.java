package com.itcast.recon.service.impl;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import com.itcast.recon.Utils.FileUtil;
import com.itcast.recon.bean.Response;
import com.itcast.recon.constant.ConstantValues;
import com.itcast.recon.service.IInnerAnalyzeFileService;
import com.itcast.recon.service.IInnerBillDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhou on 2019/1/30.
 */
@Service
public class InnerAnalyzeFileServiceImpl implements IInnerAnalyzeFileService {

    @Autowired
    private IInnerBillDoService innerBillDoService;

    @Autowired
    private  IInnerAnalyzeFileService innerAnalyzeFileService;

    private static int num = ConstantValues.BATCH_INSERT_NUM;

    public  static ExecutorService executor = Executors.newFixedThreadPool(10);


    @Override
    public Response analyseFile(Date reconDate, String filePath) {
        long beingTime=System.currentTimeMillis();
        Boolean flag = true;
        Response response = new Response();
        File file = new File(filePath);
        if(!file.exists()){
            response.setSuccess(false);
            return  response;
        }
        try {
            int totalNumber = FileUtil.getFileLineNumber(filePath);// 文件总行数
            int threadNum = (totalNumber - 1) / num + 1;// 读取的次数
            FileUtil fileUtil = new FileUtil();

            for (int k = 0; k<threadNum; k++){

            List<String> strList = fileUtil.readLine(file, ConstantValues.ENCODING, ConstantValues.READER_NUMBER); //读取所有数据
            if (strList == null || strList.size() < 0){
                response.setSuccess(false);
                return  response;
            }
            List<String> arrayList = new ArrayList<>(ConstantValues.BATCH_INSERT_NUM);
            int len = strList.size();
                try {
                    for (int i = 0 ; i < strList.size(); i++){
                        String value = strList.get(i);
                        arrayList.add(value);
                        if( arrayList.size() == ConstantValues.BATCH_INSERT_NUM || i == len - 1){
                            List<InnerBillDo> list = transfer(arrayList, reconDate);
                            innerBillDoService.batchInsert(list);
                            arrayList.clear();
                        }
                    }
                }catch (Exception e){
                    flag = false;
                }
            }
            if (!flag){
                innerBillDoService.delete(reconDate);
                response.setSuccess(false);
                return response;
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            return response;
        }
        long endTime=System.currentTimeMillis();
        long time=endTime-beingTime;
        System.out.println("花费的时间:"+time);
        return response;
    }

    @Override
    public Response analyseFileTwo(Date reconDate, String filePath) {

        long beingTime = System.currentTimeMillis();

        Boolean flag = true;
        Response response = new Response();
        File file = new File(filePath);
        if (!file.exists()) {
            response.setSuccess(false);
            return response;
        }
        try {
            int totalNumber = FileUtil.getFileLineNumber(filePath);// 文件总行数
            int threadNum = (totalNumber - 1) / num + 1;// 读取的次数
            FileUtil fileUtil = new FileUtil();
            CountDownLatch latch = new CountDownLatch(threadNum);
            AtomicBoolean result = new AtomicBoolean();
            result.set(true);

            for (int k = 0; k < threadNum; k++) {
                try {
//                    AnalyseFileThread thread = new AnalyseFileThread(fileUtil, file, innerBillDoService, latch, result, reconDate);
//                    executor.execute(thread);
                } catch (TaskRejectedException ex) {
                    //log.info("{}，第{}个任务被拒绝，对账日期：{}", reconOperateStep.getDesc(), i, reconDate);
//                    try {
//                        Thread.sleep(100L);
//                    } catch (InterruptedException e) {
//                        //log.error(e.getMessage(), e);
//                    }
//                    k--;
                }
            }

            latch.await();
            flag = result.get();
            if (!flag) {
                int num = innerBillDoService.delete(reconDate);
                response.setSuccess(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.setSuccess(false);
            return response;
        }
        long endTime = System.currentTimeMillis();
        long time = endTime - beingTime;
        System.out.println("花费的时间:" + time);
        return response;
    }


    @Override
    public List<InnerBillDo> transfer(List<String> rows, Date reconDate) {

        List<InnerBillDo> innerBillDoList=new ArrayList<>();
        for(String row:rows){
            String[] values = row.split(",");
            InnerBillDo innerBillDo=new InnerBillDo();
            innerBillDo.setAmount(new BigDecimal(values[0]));
            innerBillDo.setReconDate(reconDate);
            innerBillDo.setInnerNo(values[1]);
            innerBillDo.setInnerBillNo(values[2]);
            innerBillDo.setReconStatus(values[3]);
            innerBillDo.setTradeStatus(values[4]);
            innerBillDo.setRemark("remark");
            innerBillDo.setCreateTime(new Date());
            innerBillDo.setModifyTime(new Date());
            innerBillDoList.add(innerBillDo);
        }
        return innerBillDoList;
    }


}
