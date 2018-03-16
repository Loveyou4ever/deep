package com.deep.api.resource;

import com.deep.api.response.Response;
import com.deep.api.response.Responses;
import com.deep.domain.model.NutritionPlanExample;
import com.deep.domain.model.NutritionPlanWithBLOBs;
import com.deep.domain.service.NutritionPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
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
 * date: 2018/2/21  19:34
 */
@Controller
public class NurtritionController {
    @Resource
    private NutritionPlanService nutritionPlanService;

    @ResponseBody
    @RequestMapping(value = "/NutritionPlan",method = RequestMethod.GET)
    public String helloNutrition() {
        return "Hello NutritionPlan!";
    }

    @RequestMapping(value = "/NutritionInsert",method = RequestMethod.GET)
    public String addPlan(){
        return "NutritionInsert";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionInsert/show",method = RequestMethod.GET)
    public Response addPlan(@Valid NutritionPlanWithBLOBs insert, BindingResult result
                            ) throws ParseException {
        if(result.hasErrors()){
            List<ObjectError> ls = result.getAllErrors();
            for (int i = 0; i < ls.size(); i++) {
                System.out.println("error:"+ls.get(i));
            }
        }
        Date nutritionT = new Date();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:SS");
        if (insert.getNutritionT().toString() != "") {
            nutritionT =  formatter.parse(insert.getNutritionT().toString());
        }

        Byte zero = 0;
        insert.setGmtCreate(new Date());
        insert.setFactoryNum(insert.getFactoryNum());
        insert.setBuilding(insert.getBuilding());
        insert.setNutritionT(nutritionT);
        insert.setQuantity(insert.getQuantity());
        insert.setAverage(insert.getAverage());
        insert.setPeriod(insert.getPeriod());
        insert.setWater(insert.getWater());
        insert.setOperator(insert.getOperator());
        insert.setRemark(insert.getRemark());
        insert.setIsPass(zero);
        insert.setIsPass1(zero);
        insert.setMaterialA(insert.getMaterialA());
        insert.setMaterialM(insert.getMaterialM());
        insert.setMaterialO(insert.getMaterialO());
        insert.setMaterialWM(insert.getMaterialWM());
        insert.setMaterialWO(insert.getMaterialWO());
        insert.setRoughageP(insert.getRoughageP());
        insert.setRoughageD(insert.getRoughageD());
        insert.setRoughageWP(insert.getRoughageWP());
        insert.setRoughageWD(insert.getRoughageWD());
        insert.setRoughageWO(insert.getRoughageWO());
        insert.setPickingM(insert.getPickingM());
        insert.setPickingR(insert.getPickingR());
        insert.setPickingO(insert.getPickingO());
        nutritionPlanService.addPlan(insert);

        NutritionPlanExample nutritionPlanExample = new NutritionPlanExample();
        NutritionPlanExample.Criteria criteria = nutritionPlanExample.createCriteria();
        criteria.andFactoryNumEqualTo(insert.getFactoryNum());
        criteria.andBuildingEqualTo(insert.getBuilding());
        criteria.andNutritionTEqualTo(nutritionT);
        criteria.andQuantityEqualTo(insert.getQuantity());
        criteria.andAverageEqualTo(insert.getAverage());
        criteria.andPeriodEqualTo(insert.getPeriod());
        criteria.andWaterEqualTo(insert.getWater());
        criteria.andOperatorEqualTo(insert.getOperator());
        criteria.andRemarkEqualTo(insert.getRemark());
        criteria.andIsPassEqualTo(insert.getIsPass());
        criteria.andIsPass1EqualTo(insert.getIsPass1());

        List<NutritionPlanWithBLOBs> select = nutritionPlanService.findPlanSelective(nutritionPlanExample);

        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",select);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/NutritionDeleteById",method = RequestMethod.GET)
    public String dropPlan(){
        return "NutritionDeleteById";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionDeleteById/show",method = RequestMethod.GET)
    public Response dropPlan(@RequestParam("id") Integer id){
        NutritionPlanWithBLOBs delete = new NutritionPlanWithBLOBs();
        nutritionPlanService.dropPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",delete);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/NutritionUpdateByProfessor",method = RequestMethod.GET)
    public String changePlan(){
        return "NutritionUpdateByProfessor";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionUpdateByProfessor/show",method = RequestMethod.GET)
    public Response changePlan(@Valid NutritionPlanWithBLOBs update
                               ) throws ParseException {
        Date nutritionT = new Date();
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:SS");
        if (update.getNutritionT().toString() != "") {
            nutritionT =  formatter.parse(update.getNutritionT().toString());
        }

        update.setId(update.getId());
        update.setGmtModified(new Date());
        update.setFactoryNum(update.getFactoryNum());
        update.setBuilding(update.getBuilding());
        update.setNutritionT(nutritionT);
        update.setQuantity(update.getQuantity());
        update.setAverage(update.getAverage());
        update.setPeriod(update.getPeriod());
        update.setWater(update.getWater());
        update.setProfessor(update.getProfessor());
        update.setRemark(update.getRemark());
        update.setIsPass(update.getIsPass());
        update.setUpassReason(update.getUpassReason());
        update.setMaterialA(update.getMaterialA());
        update.setMaterialM(update.getMaterialM());
        update.setMaterialO(update.getMaterialO());
        update.setMaterialWM(update.getMaterialWM());
        update.setMaterialWO(update.getMaterialWO());
        update.setRoughageP(update.getRoughageP());
        update.setRoughageD(update.getRoughageD());
        update.setRoughageWP(update.getRoughageWP());
        update.setRoughageWD(update.getRoughageWD());
        update.setRoughageWO(update.getRoughageWO());
        update.setPickingM(update.getPickingM());
        update.setPickingR(update.getPickingR());
        update.setPickingO(update.getPickingO());
        nutritionPlanService.changePlanByProfessor(update);

        NutritionPlanWithBLOBs selectById = nutritionPlanService.findPlanById(update.getId());
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",selectById);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/NutritionUpdateBySupervisor",method = RequestMethod.GET)
    public String changePlanBySupervisor(){
        return "NutritionUpdateBySupervisor";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionUpdateBySupervisor/show",method = RequestMethod.GET)
    public Response changePlanBySupervisor(@Valid NutritionPlanWithBLOBs update){
        update.setId(update.getId());
        update.setGmtSupervised(new Date());
        update.setOperator(update.getSupervisor());
        update.setIsPass(update.getIsPass1());
        nutritionPlanService.changePlanBySupervisor(update);

        NutritionPlanWithBLOBs selectById = nutritionPlanService.findPlanById(update.getId());
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",selectById);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/NutritionSelectById",method = RequestMethod.GET)
    public String findPlanById(){
        return "NutritionSelectById";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionSelectById/show",method = RequestMethod.GET)
    public Response findPlanById(@RequestParam("id") Integer id) {
        NutritionPlanWithBLOBs selectById = nutritionPlanService.findPlanById(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",selectById);
        response.setData(data);
        return response;
    }

    //根据条件查询信息
    @RequestMapping(value = "/NutritionSelective",method = RequestMethod.GET)
    public String findPlanSelective(){
        return "NutritionSelective";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionSelective/show",method = RequestMethod.GET)
    public Response findPlanSelective(@Valid NutritionPlanWithBLOBs nutritionPlanWithBLOBs,
                                      @RequestParam("s_nutritionT1") String s_nutritionT1,
                                      @RequestParam("s_nutritionT2") String s_nutritionT2
                                      ) throws ParseException {
        Date nutritionT1 = null;
        Date nutritionT2 = null;
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:SS");
        if (s_nutritionT1 != "" && s_nutritionT2 != "") {
            nutritionT1 =  formatter.parse(s_nutritionT1);
            nutritionT2 =  formatter.parse(s_nutritionT2);
        }

        NutritionPlanExample nutritionPlanExample = new NutritionPlanExample();
        NutritionPlanExample.Criteria criteria = nutritionPlanExample.createCriteria();

        if(nutritionPlanWithBLOBs.getId() != null && nutritionPlanWithBLOBs.getId().toString() !=""){
            criteria.andIdEqualTo(nutritionPlanWithBLOBs.getId());
        }
        if(nutritionPlanWithBLOBs.getFactoryNum() != null && nutritionPlanWithBLOBs.getFactoryNum().toString() !=""){
            criteria.andFactoryNumEqualTo(nutritionPlanWithBLOBs.getFactoryNum());
        }
        if(nutritionPlanWithBLOBs.getBuilding() != null && nutritionPlanWithBLOBs.getBuilding() !=""){
            criteria.andBuildingEqualTo(nutritionPlanWithBLOBs.getBuilding());
        }
        if(nutritionPlanWithBLOBs.getQuantity() != null && nutritionPlanWithBLOBs.getQuantity().toString() !=""){
            criteria.andQuantityEqualTo(nutritionPlanWithBLOBs.getQuantity());
        }
        if(nutritionPlanWithBLOBs.getAverage() != null && nutritionPlanWithBLOBs.getAverage() !=""){
            criteria.andAverageGreaterThanOrEqualTo(nutritionPlanWithBLOBs.getAverage());
        }
        if(nutritionT1 != null && nutritionT2 != null){
            criteria.andNutritionTBetween(nutritionT1,nutritionT2);
        }
        if (nutritionPlanWithBLOBs.getPeriod()!= null && nutritionPlanWithBLOBs.getPeriod() !=""){
            criteria.andPeriodEqualTo(nutritionPlanWithBLOBs.getPeriod());
        }
        if (nutritionPlanWithBLOBs.getWater()!= null && nutritionPlanWithBLOBs.getWater() !=""){
            criteria.andWaterEqualTo(nutritionPlanWithBLOBs.getWater());
        }
        if(nutritionPlanWithBLOBs.getOperator() != null && nutritionPlanWithBLOBs.getOperator() !=""){
            criteria.andOperatorEqualTo(nutritionPlanWithBLOBs.getOperator());
        }
        if(nutritionPlanWithBLOBs.getProfessor() != null && nutritionPlanWithBLOBs.getProfessor() !=""){
            criteria.andProfessorEqualTo(nutritionPlanWithBLOBs.getProfessor());
        }
        if(nutritionPlanWithBLOBs.getSupervisor() != null && nutritionPlanWithBLOBs.getSupervisor() !=""){
            criteria.andSupervisorEqualTo(nutritionPlanWithBLOBs.getSupervisor());
        }
        if(nutritionPlanWithBLOBs.getIsPass() != null && nutritionPlanWithBLOBs.getIsPass().toString() !=""){
            criteria.andIsPassEqualTo(nutritionPlanWithBLOBs.getIsPass());
        }
        if(nutritionPlanWithBLOBs.getUpassReason() != null && nutritionPlanWithBLOBs.getUpassReason() !=""){
            criteria.andUpassReasonLike(nutritionPlanWithBLOBs.getUpassReason());
        }
        if(nutritionPlanWithBLOBs.getIsPass1() != null && nutritionPlanWithBLOBs.getIsPass1().toString() !=""){
            criteria.andIsPass1EqualTo(nutritionPlanWithBLOBs.getIsPass1());
        }
        List<NutritionPlanWithBLOBs> select = nutritionPlanService.findPlanSelective(nutritionPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",select);
        response.setData(data);
        return response;
    }
    /*//根据日期查询信息
    @RequestMapping(value = "/NutritionSelectByDate",method = RequestMethod.GET)
    public String findPlanSelectByDate(){
        return "NutritionSelectByDate";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionSelectByDate/show",method = RequestMethod.GET)
    public Response findPlanSelectByDate(@Valid NutritionPlanWithBLOBs nutritionPlanWithBLOBs,
                                         @RequestParam("s_nutritionT1") String s_nutritionT1,
                                         @RequestParam("s_nutritionT2") String s_nutritionT2
    ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:SS");
        Date nutritionT1 =  formatter.parse(s_nutritionT1);
        Date nutritionT2 =  formatter.parse(s_nutritionT2);

        NutritionPlanExample nutritionPlanExample = new NutritionPlanExample();
        NutritionPlanExample.Criteria criteria = nutritionPlanExample.createCriteria();

        if(nutritionT1 != null && nutritionT2 != null){
            criteria.andNutritionTBetween(nutritionT1,nutritionT2);
        }
        List<NutritionPlanWithBLOBs> select = nutritionPlanService.findPlanSelectByDate(nutritionPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",select);
        response.setData(data);
        return response;
    }*/
    //供技术审核查询信息
    @RequestMapping(value = "/NutritionSelectByProfessor",method = RequestMethod.GET)
    public String findPlanSelectByProfessor(){
        return "NutritionSelectByProfessor";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionSelectByProfessor/show",method = RequestMethod.GET)
    public Response findPlanSelectByProfessor(@Valid NutritionPlanWithBLOBs nutritionPlanWithBLOBs) {
        NutritionPlanExample nutritionPlanExample = new NutritionPlanExample();
        NutritionPlanExample.Criteria criteria = nutritionPlanExample.createCriteria();
        if(nutritionPlanWithBLOBs.getId() != null && nutritionPlanWithBLOBs.getId().toString() !=""){
            criteria.andIdEqualTo(nutritionPlanWithBLOBs.getId());
        }
        if(nutritionPlanWithBLOBs.getProfessor() != null && nutritionPlanWithBLOBs.getProfessor() !=""){
            criteria.andProfessorEqualTo(nutritionPlanWithBLOBs.getProfessor());
        }
        if(nutritionPlanWithBLOBs.getIsPass() != null && nutritionPlanWithBLOBs.getIsPass().toString() !=""){
            criteria.andIsPassEqualTo(nutritionPlanWithBLOBs.getIsPass());
        }
        if(nutritionPlanWithBLOBs.getUpassReason() != null && nutritionPlanWithBLOBs.getUpassReason() !=""){
            criteria.andUpassReasonLike(nutritionPlanWithBLOBs.getUpassReason());
        }
        List<NutritionPlanWithBLOBs> select = nutritionPlanService.findPlanSelectByProfessor(nutritionPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",select);
        response.setData(data);
        return response;
    }
    //供监督查询信息
    @RequestMapping(value = "/NutritionSelectBySupervisor",method = RequestMethod.GET)
    public String findPlanSelectBySupervisor(){
        return "NutritionSelectBySupervisor";
    }
    @ResponseBody
    @RequestMapping(value = "/NutritionSelectBySupervisor/show",method = RequestMethod.GET)
    public Response findPlanSelectBySupervisor(@Valid NutritionPlanWithBLOBs nutritionPlanWithBLOBs) {
        NutritionPlanExample nutritionPlanExample = new NutritionPlanExample();
        NutritionPlanExample.Criteria criteria = nutritionPlanExample.createCriteria();
        if(nutritionPlanWithBLOBs.getId() != null && nutritionPlanWithBLOBs.getId().toString() !=""){
            criteria.andIdEqualTo(nutritionPlanWithBLOBs.getId());
        }
        if(nutritionPlanWithBLOBs.getSupervisor() != null && nutritionPlanWithBLOBs.getSupervisor() !=""){
            criteria.andSupervisorEqualTo(nutritionPlanWithBLOBs.getSupervisor());
        }
        if(nutritionPlanWithBLOBs.getIsPass1() != null && nutritionPlanWithBLOBs.getIsPass1().toString() !=""){
            criteria.andIsPass1EqualTo(nutritionPlanWithBLOBs.getIsPass1());
        }
        List<NutritionPlanWithBLOBs> select = nutritionPlanService.findPlanSelectBySupervisor(nutritionPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",select);
        response.setData(data);
        return response;
    }
}
