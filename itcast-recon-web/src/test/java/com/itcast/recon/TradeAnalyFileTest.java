package com.itcast.recon;

import com.itcast.ReconApplication;
import com.itcast.recon.service.ItradeFileAnalyzeService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by zhou on 2019/2/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ReconApplication.class)
public class TradeAnalyFileTest {

//    static  String key = "inner";
    static  String key = "outer";
    static  String filePath = "E:\\itcast\\recon\\recon_file.txt";
    static  Date reconDate = new Date();

    @Autowired
    private ItradeFileAnalyzeService tradeFileAnalyzeService;

    @Test
    public  void  tradeAnalyFile(){

        tradeFileAnalyzeService.analyzeTradeFile(filePath,key,reconDate);

        System.out.print("-----tradeFile--------结束线程--------------");
    }
}
