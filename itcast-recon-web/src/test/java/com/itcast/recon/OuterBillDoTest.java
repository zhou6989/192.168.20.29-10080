package com.itcast.recon;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import com.itcast.ReconApplication;
import com.itcast.recon.service.IOuterBillDoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by zhou on 2019/1/23.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReconApplication.class})
public class OuterBillDoTest {

    @Autowired
    private IOuterBillDoService outerBillDoService;

    @Test
    public  void outTest(){


        List<OuterBillDo> outerBillDoList = new ArrayList<OuterBillDo>();

        OuterBillDo outerBillDo = new OuterBillDo();

        outerBillDo.setAmount(new BigDecimal(54.43));
        outerBillDo.setCreateTime(new Date());
        outerBillDo.setId(1L);
        outerBillDo.setOuterBillNo("SUCT672923232");
        outerBillDo.setOuterNo("234232232");
        outerBillDo.setReconStatus("5");

        outerBillDoList.add(outerBillDo);

        OuterBillDo outerBillDo1 = new OuterBillDo();
        outerBillDo1.setReconStatus("3");
        outerBillDo1.setOuterNo("23423556");
        outerBillDo1.setId(2L);
        outerBillDo1.setCreateTime(new Date());
        outerBillDo1.setOuterBillNo("SUCT84793022");

        outerBillDoList.add(outerBillDo1);

        outerBillDoService.batchInsert(outerBillDoList);





    }
}
