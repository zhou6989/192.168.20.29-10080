package com.itcast.recon;

import com.itcast.ReconApplication;
import com.itcast.recon.service.ICreateFileService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

/**
 * Created by zhou on 2019/1/24.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReconApplication.class})
public class CreateFileServiceTest {

    @Autowired
    private ICreateFileService createFileService;

    @Test
    public  void  createFileTest(){

        try {
            createFileService.createFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }




}
