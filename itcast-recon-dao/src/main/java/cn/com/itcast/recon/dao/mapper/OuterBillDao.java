package cn.com.itcast.recon.dao.mapper;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;

import java.text.MessageFormat;
import java.util.List;

/**
 * Created by zhou on 2019/1/23.
 */
public interface OuterBillDao {

    @InsertProvider(type = OuterBillDao.OuterBillDaoMapperProvider.class, method = "batchInsert")
    int batchInsert(@Param("list") List<OuterBillDo> list);


    class OuterBillDaoMapperProvider {
        public String batchInsert(@Param("list") List<OuterBillDo> record) {
            StringBuilder sb = new StringBuilder();
            sb.append(
                    " insert into t_outer_bill (recon_date,recon_status,amount," +
                            "trade_status,outer_bill_no,outer_no,create_time,modify_time,remark" +
                            ")  values ");
            MessageFormat messageFormat = new MessageFormat(
                    "(  #'{'list[{0}].reconDate},#'{'list[{0}].reconStatus}," +
                            "#'{'list[{0}].amount},#'{'list[{0}].tradeStatus},#'{'list[{0}].outerBillNo}," +
                            "#'{'list[{0}].outerNo},#'{'list[{0}].createTime},#'{'list[{0}].modifyTime}," +
                            "#'{'list[{0}].remark})");
            int length = record.size();
            for (int i = 0; i < length; i++) {
                sb.append(messageFormat.format(new Object[]{i + ""}));
                if (i < record.size() - 1) {
                    sb.append(",");
                }
            }
            return sb.toString();
        }
    }
}
