package cn.com.itcast.recon.dao.mapper;

import cn.com.itcast.recon.dao.model.entity.OuterBillDo;
import cn.com.itcast.recon.dao.model.entity.OuterBillDoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OuterBillDoMapper {
    long countByExample(OuterBillDoExample example);

    int deleteByExample(OuterBillDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OuterBillDo record);

    int insertSelective(OuterBillDo record);

    List<OuterBillDo> selectByExample(OuterBillDoExample example);

    OuterBillDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OuterBillDo record, @Param("example") OuterBillDoExample example);

    int updateByExample(@Param("record") OuterBillDo record, @Param("example") OuterBillDoExample example);

    int updateByPrimaryKeySelective(OuterBillDo record);

    int updateByPrimaryKey(OuterBillDo record);
}