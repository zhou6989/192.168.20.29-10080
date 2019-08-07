package cn.com.itcast.recon.dao.mapper;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import java.text.MessageFormat;
import java.util.List;

/**
 * Created by zhou on 2019/1/22.
 */
public interface InnerBillDao {

    @InsertProvider(type = InnerBillDao.InnerBillDaoMapperProvider.class, method = "batchInsert")
    int batchInsert(@Param("list") List<InnerBillDo> list);


    class InnerBillDaoMapperProvider {
        public String batchInsert(@Param("list") List<InnerBillDo> record) {
            StringBuilder sb = new StringBuilder();
            sb.append(
                    " insert into t_inner_bill (recon_date,recon_status,amount," +
                            "trade_status,inner_bill_no,inner_no,create_time,modify_time,remark" +
                            ")  values ");
            MessageFormat messageFormat = new MessageFormat(
                    "(  #'{'list[{0}].reconDate},#'{'list[{0}].reconStatus}," +
                            "#'{'list[{0}].amount},#'{'list[{0}].tradeStatus},#'{'list[{0}].innerBillNo}," +
                            "#'{'list[{0}].innerNo},#'{'list[{0}].createTime},#'{'list[{0}].modifyTime}," +
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
