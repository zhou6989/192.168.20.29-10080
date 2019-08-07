package com.itcast.recon;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import com.itcast.ReconApplication;
import com.itcast.recon.service.IInnerBillDoService;
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
 * Created by zhou on 2019/1/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = {ReconApplication.class})
public class InnerBillDoTest {

    @Autowired
    private IInnerBillDoService innerBillDoService;



    @Test
    public void test(){

        InnerBillDo innerBillDo = new InnerBillDo();

        innerBillDo.setId(1L);
        innerBillDo.setAmount(new BigDecimal(20.89));
        innerBillDo.setCreateTime(new Date());
        innerBillDo.setInnerBillNo("SUCT34560987");
        innerBillDoService.insert(innerBillDo);
    }

    @Test
    public void testbatch(){

        List<InnerBillDo>  innerBillDoList  = new ArrayList<InnerBillDo>();

        InnerBillDo innerBillDo = new InnerBillDo();

        innerBillDo.setId(2L);
        innerBillDo.setInnerBillNo("SUCT8765439");
        innerBillDo.setCreateTime(new Date());
        innerBillDo.setReconStatus("S");
        innerBillDo.setAmount(new BigDecimal(87.90));
        innerBillDo.setInnerNo("3827385239");

        innerBillDoList.add(innerBillDo);

        InnerBillDo innerBillDo1 = new InnerBillDo();

        innerBillDo1.setId(3L);
        innerBillDo1.setInnerBillNo("SUCT87785930");
        innerBillDo1.setCreateTime(new Date());
        innerBillDo1.setReconStatus("V");
        innerBillDo1.setAmount(new BigDecimal(86.90));
        innerBillDo1.setInnerNo("38272392");

        innerBillDoList.add(innerBillDo1);

        innerBillDoService.batchInsert(innerBillDoList);

    }
}
