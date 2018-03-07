package com.deep.infra.persistence.sql.mapper;

import com.deep.domain.model.BreedingPlan;
import com.deep.domain.model.BreedingPlanExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

public interface BreedingPlanMapper {
    int countByExample(BreedingPlanExample example);

    int deleteByExample(BreedingPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(BreedingPlan record);

    int insertSelective(BreedingPlan record);

    List<BreedingPlan> selectByExampleWithBLOBsWithRowbounds(BreedingPlanExample example, RowBounds rowBounds);

    List<BreedingPlan> selectByExampleWithBLOBs(BreedingPlanExample example);

    List<BreedingPlan> selectByExampleWithRowbounds(BreedingPlanExample example, RowBounds rowBounds);

    List<BreedingPlan> selectByExample(BreedingPlanExample example);

    BreedingPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") BreedingPlan record, @Param("example") BreedingPlanExample example);

    int updateByExampleWithBLOBs(@Param("record") BreedingPlan record, @Param("example") BreedingPlanExample example);

    int updateByExample(@Param("record") BreedingPlan record, @Param("example") BreedingPlanExample example);

    int updateByPrimaryKeySelective(BreedingPlan record);

    int updateByPrimaryKeyWithBLOBs(BreedingPlan record);

    int updateByPrimaryKey(BreedingPlan record);

}