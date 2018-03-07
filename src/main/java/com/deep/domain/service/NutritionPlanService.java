package com.deep.domain.service;

import com.deep.domain.model.NutritionPlanWithBLOBs;
import com.deep.infra.persistence.sql.mapper.NutritionPlanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * author: Created  By  Caojiawei
 * date: 2018/2/21  19:36
 */
@Service
public class NutritionPlanService {
    @Resource
    private NutritionPlanMapper nutritionPlanMapper;

    public int addPlan(NutritionPlanWithBLOBs nutritionPlanWithBLOBs){
        int add = this.nutritionPlanMapper.insert(nutritionPlanWithBLOBs);
        return add;
    }
    public int dropPlan(Integer id){
        int drop = this.nutritionPlanMapper.deleteByPrimaryKey(id);
        return drop;
    }
    public int changePlan(NutritionPlanWithBLOBs nutritionPlanWithBLOBs){
        int change = this.nutritionPlanMapper.updateByPrimaryKeyWithBLOBs(nutritionPlanWithBLOBs);
        return change;
    }
    public NutritionPlanWithBLOBs findPlan(Integer id){
        NutritionPlanWithBLOBs find = this.nutritionPlanMapper.selectByPrimaryKey(id);
        return find;
    }
}
