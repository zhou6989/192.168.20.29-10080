package com.itcast.recon.analyse;

import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/2/17.
 */
public interface AnalyzeFileService<T> {

    int batchInsert(List<T> list);

    int delete(Date reconDate);

    List<T> transfer(List<String> rows, Date reconDate);

}
