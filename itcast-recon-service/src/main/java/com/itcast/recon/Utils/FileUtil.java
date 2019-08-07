package com.itcast.recon.Utils;

import org.springframework.util.StringUtils;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FileUtil {

    private volatile long pointer=0;

    private Lock lock=new ReentrantLock();
    /**
     * 通过BufferedRandomAccessFile读取文件,推荐
     *
     * @param file     源文件
     * @param encoding 文件编码
     * @param
     * @param num      读取量
     * @return pins文件内容，pos当前偏移量
     */
    public List<String> readLine(File file, String encoding, int num) throws IOException {
        List<String> rows=new ArrayList<>();
        BufferedRandomAccessFile reader = null;
        try {
            lock.lock();
            reader = new BufferedRandomAccessFile(file, "r");
            reader.seek(pointer);
            for (int i = 0; i < num;i++){
                String pin = reader.readLine();
                if (StringUtils.isEmpty(pin)) {
                    break;
                }
                rows.add(new String(pin.getBytes("8859_1"), encoding));
            }
            pointer=reader.getFilePointer();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                reader.close();
            }
            lock.unlock();
        }
        return rows;
    }

    /**
     * 通过BufferedRandomAccessFile读取文件,推荐
     *
     * @param file     源文件
     * @param encoding 文件编码
     * @param pointer  偏移量
     * @param num      读取量
     * @return pins文件内容，pos当前偏移量
     */
    public static Map<String, Object> BufferedRandomAccessFileReadLine(File file, String encoding, long pointer, int num) throws IOException {
        Map<String,Object> result=new HashMap<>();
        List<String> rows=new ArrayList<>();
        result.put("rows",rows);
        BufferedRandomAccessFile reader = null;
        try {
            reader = new BufferedRandomAccessFile(file, "r");
            reader.seek(pointer);
            for (int i = 0; i < num;i++){
                String pin = reader.readLine();
                if (StringUtils.isEmpty(pin)) {
                    break;
                }
                rows.add(new String(pin.getBytes("8859_1"), encoding));
            }
            result.put("pointer", reader.getFilePointer());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if(reader!=null){
                reader.close();
            }
        }
        return result;
    }

    /**
     * 获取文件行数
     * @param filePath
     * @return
     * @throws Exception
     */
    public static int getFileLineNumber(String filePath) throws Exception{
        LineNumberReader lineNumberReader = new LineNumberReader(new FileReader(filePath));
        lineNumberReader.skip(Long.MAX_VALUE);
        int lineNumber = lineNumberReader.getLineNumber();
        lineNumber++;
        lineNumberReader.close();
        return lineNumber;
    }



}
