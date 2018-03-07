package com.deep.domain.service;

import com.deep.domain.model.BreedingPlan;
import com.deep.domain.model.BreedingPlanExample;
import com.deep.domain.model.DiagnosisPlanExample;
import com.deep.domain.model.DiagnosisPlanWithBLOBs;
import com.deep.infra.persistence.sql.mapper.BreedingPlanMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/2/2  17:08
 */
@Service
public class BreedingPlanService {
    @Resource
    private BreedingPlanMapper breedingPlanMapper;

        public int addPlan(BreedingPlan breedingPlan){
            int add = this.breedingPlanMapper.insert(breedingPlan);
            return add;
    }
        public int dropPlan(Integer id){
            int drop = this.breedingPlanMapper.deleteByPrimaryKey(id);
            return drop;
    }
        public int changePlan(BreedingPlan breedingPlan){
            int change = this.breedingPlanMapper.updateByPrimaryKeySelective(breedingPlan);
            return change;
    }
        public BreedingPlan findPlanById(Integer id){
            BreedingPlan find = this.breedingPlanMapper.selectByPrimaryKey(id);
            return find;
    }
        public List<BreedingPlan> findPlanSelective(BreedingPlanExample breedingPlanExample){
            List<BreedingPlan> find = this.breedingPlanMapper.selectByExample(breedingPlanExample);
        return find;
    }
}

