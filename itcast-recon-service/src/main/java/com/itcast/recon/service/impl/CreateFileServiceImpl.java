package com.itcast.recon.service.impl;

import com.itcast.recon.service.ICreateFileService;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by zhou on 2019/1/24.
 */
@Service
public class CreateFileServiceImpl implements ICreateFileService {

    private  static  String path = "E:\\itcast\\recon";

    private  static  int num =  50000;

    private  static  String fileName = "recon_file.txt";


    @Override
    public void createFile() throws IOException {

        File filePath = new File(path);
        if(!filePath.exists()){
            filePath.mkdirs();
        }

        File file = new File(filePath,fileName);

        OutputStreamWriter out = null;

        try {
            out = new OutputStreamWriter(new FileOutputStream(file,true), "UTF-8");

            long start = System.currentTimeMillis();

            for (int i = 0 ; i< 1 ; i++){
                for (int j = 0 ; j < 10000000; j++){
                    out.write(j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+","+j+",\r\n");
                }
            }
            long endTime = System.currentTimeMillis();

            long time = (endTime - start)/1000;
            System.out.print("时间:"+time);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                out.close();
            }
        }





    }
}
