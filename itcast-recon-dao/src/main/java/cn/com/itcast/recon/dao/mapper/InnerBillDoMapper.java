package cn.com.itcast.recon.dao.mapper;

import cn.com.itcast.recon.dao.model.entity.InnerBillDo;
import cn.com.itcast.recon.dao.model.entity.InnerBillDoExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface InnerBillDoMapper {
    long countByExample(InnerBillDoExample example);

    int deleteByExample(InnerBillDoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(InnerBillDo record);

    int insertSelective(InnerBillDo record);

    List<InnerBillDo> selectByExample(InnerBillDoExample example);

    InnerBillDo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") InnerBillDo record, @Param("example") InnerBillDoExample example);

    int updateByExample(@Param("record") InnerBillDo record, @Param("example") InnerBillDoExample example);

    int updateByPrimaryKeySelective(InnerBillDo record);

    int updateByPrimaryKey(InnerBillDo record);
}