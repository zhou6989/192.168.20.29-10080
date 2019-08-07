package com.itcast.recon;

import com.itcast.ReconApplication;
import com.itcast.recon.service.IInnerAnalyzeFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by zhou on 2019/2/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReconApplication.class})
public class InnerAnalyzeFileTest {

    private static  String filePath = "E:\\itcast\\recon\\recon_file.txt";

    @Autowired
    private IInnerAnalyzeFileService innerAnalyzeFileService;

    @Test
    public  void  analyzeFile(){

//        innerAnalyzeFileService.analyseFile(new Date(),filePath);

        innerAnalyzeFileService.analyseFileTwo(new Date(),filePath);


        System.out.print("-----结束线程--------------");


//        try {
//            Thread.sleep(600000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }
}
