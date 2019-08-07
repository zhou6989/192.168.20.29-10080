package com.itcast.recon.thread;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.recon.Utils.FileUtil;
import com.itcast.recon.constant.ConstantValues;
import com.itcast.recon.service.IOuterBillDoService;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Created by zhou on 2019/2/11.
 */
public class AnalyseFileThread implements Runnable {


    private FileUtil fileUtil;
    private File file;
    //    private IInnerBillDoService innerBillDoService;
    private IOuterBillDoService outerBillDoService;
    private CountDownLatch latch;
    private AtomicBoolean result;
    private Date reconDate;

    public AnalyseFileThread(FileUtil fileUtil, File file, IOuterBillDoService outerBillDoService, CountDownLatch latch, AtomicBoolean result, Date reconDate) {
        this.fileUtil = fileUtil;
        this.file = file;
        this.outerBillDoService = outerBillDoService;
        this.latch = latch;
        this.result = result;
        this.reconDate = reconDate;
    }



    /*public AnalyseFileThread(FileUtil fileUtil, File file, IInnerBillDoService innerBillDoService, CountDownLatch latch, AtomicBoolean result, Date reconDate) {
        this.fileUtil = fileUtil;
        this.file = file;
        this.innerBillDoService = innerBillDoService;
        this.latch = latch;
        this.result = result;
        this.reconDate = reconDate;
    }*/




    @Override
    public void run() {

        /*try {
            List<String> strList = fileUtil.readLine(file, ConstantValues.ENCODING, ConstantValues.READER_NUMBER); //读取所有数据
            List arrayList = new ArrayList<>(ConstantValues.BATCH_INSERT_NUM);
            int len = strList.size();
            for (int i = 0; i < strList.size(); i++) {
                String value = strList.get(i);
                arrayList.add(value);
                if (arrayList.size() == ConstantValues.BATCH_INSERT_NUM || i == len - 1) {
                    List<InnerBillDo> list = transfer(arrayList, reconDate);
                    innerBillDoService.batchInsert(list);
                    arrayList.clear();
                }
            }
        } catch (Exception e) {
            result.set(false);
        } finally {
            latch.countDown();
        }*/





        try {
            List<String> strList = fileUtil.readLine(file, ConstantValues.ENCODING, ConstantValues.READER_NUMBER); //读取所有数据
            List arrayList = new ArrayList<>(ConstantValues.BATCH_INSERT_NUM);
            int len = strList.size();
            for (int i = 0; i < strList.size(); i++) {
                String value = strList.get(i);
                arrayList.add(value);
                if (arrayList.size() == ConstantValues.BATCH_INSERT_NUM || i == len - 1) {
                    List<OuterBillDo> list = transfer(arrayList, reconDate);
                    outerBillDoService.batchInsert(list);
                    arrayList.clear();
                }
            }
        } catch (Exception e) {
            result.set(false);
        } finally {
            latch.countDown();
        }






    }




   /* public List<InnerBillDo> transfer(List<String> rows, Date reconDate) {
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
    }*/




    public List<OuterBillDo> transfer(List<String> rows, Date reconDate) {
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
    }

}
