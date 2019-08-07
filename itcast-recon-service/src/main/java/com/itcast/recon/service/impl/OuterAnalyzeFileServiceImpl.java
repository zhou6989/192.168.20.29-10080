package com.itcast.recon.service.impl;

import com.itcast.recon.Utils.FileUtil;
import com.itcast.recon.bean.Response;
import com.itcast.recon.constant.ConstantValues;
import com.itcast.recon.service.IOuterAnalyzeFileService;
import com.itcast.recon.service.IOuterBillDoService;
import com.itcast.recon.thread.AnalyseFileThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.Date;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;


/**
 * Created by zhou on 2019/2/16.
 */
@Service
public class OuterAnalyzeFileServiceImpl implements IOuterAnalyzeFileService {


    @Autowired
    private IOuterBillDoService outerBillDoService;

    public  static ExecutorService executor = Executors.newFixedThreadPool(10);


    @Override
    public Response outAnalyzeFile(Date reconDate, String filePath) {

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
            for (int i = 0; i < number; i++) {

//                List<String> readLine = fileUtil.readLine(file, ConstantValues.ENCODING, ConstantValues.READER_NUMBER);

               /* int length = readLine.size();
                for (int j = 0; j < length; j++) {
                    String value = readLine.get(j);
                    strList.add(value);
                    if (strList.size() == ConstantValues.BATCH_INSERT_NUM || j == (length - 1)) {
                        //strList.size()==j+1   j==(length-1)表示循环到最后一行
                        List<OuterBillDo> outerBillDos = transfer(strList, reconDate);
                        outerBillDao.batchInsert(outerBillDos);
                    }
                }*/

                AnalyseFileThread thread = new AnalyseFileThread(fileUtil, file, outerBillDoService, latch, result, reconDate);
                executor.execute(thread);
            }

            latch.await();
        } catch (Exception e) {
            e.printStackTrace();
           // outerBillDao

        }
        long end = System.currentTimeMillis();
        long i = end - start;

        System.out.print("时间:"+i);

        return response;
    }




   /* public List<OuterBillDo> transfer(List<String> rows, Date reconDate) {
        List<OuterBillDo> outerBillDoList = new ArrayList<>();
        for (String row : rows) {
            String[] values = row.split(",");
            OuterBillDo outerBillDo = new OuterBillDo();
            outerBillDo.setAmount(new BigDecimal(values[0]));
            outerBillDo.setReconDate(reconDate);
            outerBillDo.setOuterNo(values[1]);
            outerBillDo.setOuterBillNo(values[2]);
            outerBillDo.setReconStatus(values[3]);
            outerBillDo.setTradeStatus(values[4]);
            outerBillDo.setRemark("remark");
            outerBillDo.setCreateTime(new Date());
            outerBillDo.setModifyTime(new Date());
            outerBillDoList.add(outerBillDo);
        }
        return outerBillDoList;
    }*/
    /* if ( CollectionUtils.isEmpty(readLine)) {
                    response.setSuccess(false);
                    return response;
}*/
}
