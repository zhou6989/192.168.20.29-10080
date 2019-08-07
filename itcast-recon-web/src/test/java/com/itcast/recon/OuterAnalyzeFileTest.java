package com.itcast.recon;

import com.itcast.ReconApplication;
import com.itcast.recon.service.IOuterAnalyzeFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;

/**
 * Created by zhou on 2019/2/16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes={ReconApplication.class})
public class OuterAnalyzeFileTest {

    private static  String filePath = "E:\\itcast\\recon\\recon_file.txt";

    @Autowired
    private IOuterAnalyzeFileService outerAnalyzeFileService;

    @Test
    public  void outerAnalyzeFile(){

        outerAnalyzeFileService.outAnalyzeFile(new Date(),filePath);

        System.out.print("-----结束线程--------------");

    }
}
