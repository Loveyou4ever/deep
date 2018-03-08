package com.deep.api.resource;

import com.deep.api.response.Response;
import com.deep.api.response.Responses;
import com.deep.domain.model.BreedingPlan;
import com.deep.domain.model.BreedingPlanExample;
import com.deep.domain.service.BreedingPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/2/2  12:52
 */
@Controller
public class BreedingController {

    @Resource
    private BreedingPlanService breedingPlanService;

    @ResponseBody
    @RequestMapping(value = "/BreedingPlan",method = RequestMethod.GET)
    public String helloBreed() {
        return "Hello BreedingPlan!";
    }

    @RequestMapping(value = "/BreedingInsert",method = RequestMethod.GET)
    public String addPlan(){
        return "BreedingInsert";
    }
    @ResponseBody
    @RequestMapping(value = "/BreedingInsert/show",method = RequestMethod.GET)
    public Response addPlan(@Valid BreedingPlan insert,
                            @RequestParam("s_breedingT") String s_breedingT,
                            @RequestParam("s_gestationT") String s_gestationT,
                            @RequestParam("s_prenatalIT") String s_prenatalIT,
                            @RequestParam("s_cubT") String s_cubT
                            ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date breedingT =  formatter.parse(s_breedingT);
        Date gestationT =  formatter.parse(s_gestationT);
        Date prenatalIT =  formatter.parse(s_prenatalIT);
        Date cubT =  formatter.parse(s_cubT);

        insert.setId(insert.getId());
        insert.setGmtCreate(new Date());
        insert.setGmtModified(new Date());
        insert.setFactoryNum(insert.getFactoryNum());
        insert.setBuilding(insert.getBuilding());
        insert.setmEtI(insert.getmEtI());
        insert.setmEtB(insert.getmEtB());
        insert.setfEtI(insert.getfEtI());
        insert.setfEtB(insert.getfEtB());
        /*update.setBreedingT(update.getBreedingT());
        update.setGestationT(update.getGestationT());
        update.setPrenatalIT(update.getPrenatalIT());
        update.setCubT(update.getCubT());*/
        insert.setBreedingT(breedingT);
        insert.setGestationT(gestationT);
        insert.setPrenatalIT(prenatalIT);
        insert.setCubT(cubT);
        insert.setQuantity(insert.getQuantity());
        insert.setOperator(insert.getOperator());
        insert.setProfessor(insert.getProfessor());
        insert.setSupervisor(insert.getSupervisor());
        insert.setRemark(insert.getRemark());
        insert.setIsPass(insert.getIsPass());
        insert.setUpassReason(insert.getUpassReason());

        breedingPlanService.addPlan(insert);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("breeding_Plan",insert);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/BreedingDeleteById",method = RequestMethod.GET)
    public String dropPlan(){
        return "BreedingDeleteById";
    }
    @ResponseBody
    @RequestMapping(value = "/BreedingDeleteById/show",method = RequestMethod.GET)
    public Response dropPlan(@RequestParam("id") Integer id){
        BreedingPlan delete = new BreedingPlan();
        breedingPlanService.dropPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("breeding_plan",delete);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/BreedingUpdate",method = RequestMethod.GET)
    public String changePlan(){
        return "BreedingUpdate";
    }
    @ResponseBody
    @RequestMapping(value = "/BreedingUpdate/show",method = RequestMethod.GET)
    public Response changePlan(@Valid BreedingPlan update,
                               @RequestParam("s_breedingT") String s_breedingT,
                               @RequestParam("s_gestationT") String s_gestationT,
                               @RequestParam("s_prenatalIT") String s_prenatalIT,
                               @RequestParam("s_cubT") String s_cubT
                               ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date breedingT =  formatter.parse(s_breedingT);
        Date gestationT =  formatter.parse(s_gestationT);
        Date prenatalIT =  formatter.parse(s_prenatalIT);
        Date cubT =  formatter.parse(s_cubT);

        update.setId(update.getId());
        update.setGmtModified(new Date());
        update.setFactoryNum(update.getFactoryNum());
        update.setBuilding(update.getBuilding());
        update.setmEtI(update.getmEtI());
        update.setmEtB(update.getmEtB());
        update.setfEtI(update.getfEtI());
        update.setfEtB(update.getfEtB());
        /*update.setBreedingT(update.getBreedingT());
        update.setGestationT(update.getGestationT());
        update.setPrenatalIT(update.getPrenatalIT());
        update.setCubT(update.getCubT());*/
        update.setBreedingT(breedingT);
        update.setGestationT(gestationT);
        update.setPrenatalIT(prenatalIT);
        update.setCubT(cubT);
        update.setQuantity(update.getQuantity());
        update.setOperator(update.getOperator());
        update.setProfessor(update.getProfessor());
        update.setSupervisor(update.getSupervisor());
        update.setRemark(update.getRemark());
        update.setIsPass(update.getIsPass());
        update.setUpassReason(update.getUpassReason());

        breedingPlanService.changePlan(update);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("breeding_plan",update);
        response.setData(data);
        return response;
    }

    //根据主键查询
    @RequestMapping(value = "/BreedingSelectById",method = RequestMethod.GET)
    public String findPlanById(){
        return "BreedingSelectById";
    }
    @ResponseBody
    @RequestMapping(value = "/BreedingSelectById/show",method = RequestMethod.GET)
    public Response findPlanById(@RequestParam Integer id){
        //查询语句的写法：一定要在声明对象时把值直接赋进去
        BreedingPlan selectById = breedingPlanService.findPlanById(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("breeding_plan",selectById);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/BreedingSelective",method = RequestMethod.GET)
    public String findPlanSelective(){
        return "BreedingSelective";
    }
    @ResponseBody
    @RequestMapping(value = "/BreedingSelective/show",method = RequestMethod.GET)
    public Response findPlanSelective(@Valid BreedingPlan breedingPlan,
                                      @RequestParam("s_breedingT1") String s_breedingT1,
                                      @RequestParam("s_breedingT2") String s_breedingT2,
                                      @RequestParam("s_gestationT1") String s_gestationT1,
                                      @RequestParam("s_gestationT2") String s_gestationT2,
                                      @RequestParam("s_prenatalIT1") String s_prenatalIT1,
                                      @RequestParam("s_prenatalIT2") String s_prenatalIT2,
                                      @RequestParam("s_cubT1") String s_cubT1,
                                      @RequestParam("s_cubT2") String s_cubT2
                                      ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date breedingT1 =  formatter.parse(s_breedingT1);
        Date breedingT2 =  formatter.parse(s_breedingT2);
        Date gestationT1 =  formatter.parse(s_gestationT1);
        Date gestationT2 =  formatter.parse(s_gestationT2);
        Date prenatalIT1 =  formatter.parse(s_prenatalIT1);
        Date prenatalIT2 =  formatter.parse(s_prenatalIT2);
        Date cubT1 =  formatter.parse(s_cubT1);
        Date cubT2 =  formatter.parse(s_cubT2);

        BreedingPlanExample breedingPlanExample = new BreedingPlanExample();
        BreedingPlanExample.Criteria criteria = breedingPlanExample.createCriteria();

        if(breedingPlan.getId() != null && breedingPlan.getId().toString() !=""){
            criteria.andIdEqualTo(breedingPlan.getId());
        }
        if(breedingPlan.getId() != null && breedingPlan.getId().toString() !=""){
            criteria.andIdEqualTo(breedingPlan.getId());
        }
        if(breedingPlan.getFactoryNum() != null && breedingPlan.getFactoryNum().toString() !=""){
            criteria.andFactoryNumEqualTo(breedingPlan.getFactoryNum());
        }
        if(breedingPlan.getmEtI() != null && breedingPlan.getmEtI() !=""){
            criteria.andMEtIEqualTo(breedingPlan.getmEtI());
        }
        if(breedingPlan.getmEtB() != null && breedingPlan.getmEtB() !=""){
            criteria.andMEtBEqualTo(breedingPlan.getmEtI());
        }
        if(breedingPlan.getfEtI() != null && breedingPlan.getfEtI() !=""){
            criteria.andFEtIEqualTo(breedingPlan.getfEtI());
        }
        if(breedingPlan.getfEtB() != null && breedingPlan.getfEtB() !=""){
            criteria.andFEtBEqualTo(breedingPlan.getfEtB());
        }
        if(breedingT1 != null && breedingT2 != null ){
            criteria.andBreedingTBetween(breedingT1,breedingT2);
        }
        if(gestationT1 != null && gestationT2 != null ){
            criteria.andGestationTBetween(gestationT1,gestationT2);
        }
        if(prenatalIT1 != null && breedingT2 != null ){
            criteria.andPrenatalITBetween(prenatalIT1,prenatalIT2);
        }
        if(cubT1 != null && cubT2 != null ){
            criteria.andCubTBetween(cubT1,cubT2);
        }
//        if(breedingPlan.getBreedingT() != null && breedingPlan.getBreedingT().toString() !=""){
//            criteria.andBreedingTEqualTo(breedingPlan.getBreedingT());
//        }
//        if(breedingPlan.getGestationT() != null && breedingPlan.getGestationT().toString() !=""){
//            criteria.andGestationTEqualTo(breedingPlan.getGestationT());
//        }
//        if(breedingPlan.getPrenatalIT() != null && breedingPlan.getPrenatalIT().toString() !=""){
//            criteria.andPrenatalITEqualTo(breedingPlan.getPrenatalIT());
//        }
//        if(breedingPlan.getCubT() != null && breedingPlan.getCubT().toString() !=""){
//            criteria.andCubTEqualTo(breedingPlan.getCubT());
//        }
        if(breedingPlan.getQuantity() != null && breedingPlan.getQuantity().toString() !=""){
            criteria.andQuantityEqualTo(breedingPlan.getQuantity());
        }
        if(breedingPlan.getOperator() != null && breedingPlan.getOperator() !=""){
            criteria.andOperatorEqualTo(breedingPlan.getOperator());
        }
        if(breedingPlan.getProfessor() != null && breedingPlan.getProfessor() !=""){
            criteria.andProfessorEqualTo(breedingPlan.getProfessor());
        }
        if(breedingPlan.getSupervisor() != null && breedingPlan.getSupervisor() !=""){
            criteria.andSupervisorEqualTo(breedingPlan.getSupervisor());
        }
        if(breedingPlan.getIsPass() != null && breedingPlan.getIsPass().toString() !=""){
            criteria.andIsPassEqualTo(breedingPlan.getIsPass());
        }
        if(breedingPlan.getUpassReason() != null && breedingPlan.getUpassReason() !=""){
            criteria.andUpassReasonLike(breedingPlan.getUpassReason());
        }
        List<BreedingPlan> select = breedingPlanService.findPlanSelective(breedingPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("breeding_plan",select);
        response.setData(data);
        return response;
    }
}

