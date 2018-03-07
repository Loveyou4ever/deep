package com.deep.api.resource;

import com.deep.api.response.Response;
import com.deep.api.response.Responses;
import com.deep.domain.model.NutritionPlan;
import com.deep.domain.model.NutritionPlanWithBLOBs;
import com.deep.domain.service.NutritionPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

/**
 * author: Created  By  Caojiawei
 * date: 2018/2/21  19:34
 */
@Controller
public class NurtritionController {
    @Resource
    private NutritionPlanService nutritionPlanService;

    @ResponseBody
    @RequestMapping(value = "/nutritionPlan",method = RequestMethod.GET)
    public String hellonutritionPlan() {
        return "Hello NutritionPlan!";
    }

    @RequestMapping(value = "/nutritionPlan/add",method = RequestMethod.GET)
    public String addPlan(){
        return "NutritionInsert";
    }
    @ResponseBody
    @RequestMapping(value = "/nutritionPlan/addshow",method = RequestMethod.GET)
    public Response addPlan(@RequestParam("id") Integer id,
                            @RequestParam("s_gmtCreate") String s_gmtCreate,
                            @RequestParam("s_gmtModified") String s_gmtModified,
                            @RequestParam("factoryNum") Long factoryNum,
                            @RequestParam("s_nutritionT") String s_nutritionT,
                            @RequestParam("quantity") Long quantity,
                            @RequestParam("average") String average,
                            @RequestParam("operator") String operator,
                            @RequestParam("professor") String professor,
                            @RequestParam("supervisor") String supervisor,
                            @RequestParam("remark") String remark,
                            @RequestParam("isPass") Byte isPass,
                            @RequestParam("upassReason") String upassReason,
                            @RequestParam("building") String building,
                            @RequestParam("period") String period,
                            @RequestParam("materialA") String materialA,
                            @RequestParam("materialM") String materialM,
                            @RequestParam("materialO") String materialO,
                            @RequestParam("materialWM") String materialWM,
                            @RequestParam("materialWO") String materialWO,
                            @RequestParam("roughageP") String roughageP,
                            @RequestParam("roughageD") String roughageD,
                            @RequestParam("roughageWP") String roughageWP,
                            @RequestParam("roughageWD") String roughageWD,
                            @RequestParam("roughageWO") String roughageWO,
                            @RequestParam("water") String water,
                            @RequestParam("pickingM") String pickingM,
                            @RequestParam("pickingR") String pickingR,
                            @RequestParam("pickingO") String pickingO
    ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date gmtCreate =  formatter.parse(s_gmtCreate);
        Date gmtModified =  formatter.parse(s_gmtModified);
        Date nutritionT =  formatter.parse(s_nutritionT);
//        Date gmtCreate =  formatter.parse(s_gmtCreate);
//        Date gmtModified =  formatter.parse(s_gmtModified);
//        Date nutritionT =  formatter.parse(s_nutritionT);

        NutritionPlanWithBLOBs nutritionPlanWithBLOBs_insert = new NutritionPlanWithBLOBs();
        nutritionPlanWithBLOBs_insert.setId(id);
        nutritionPlanWithBLOBs_insert.setGmtCreate(gmtCreate);
        nutritionPlanWithBLOBs_insert.setGmtModified(gmtModified);
        nutritionPlanWithBLOBs_insert.setFactoryNum(factoryNum);
        nutritionPlanWithBLOBs_insert.setNutritionT(nutritionT);
        nutritionPlanWithBLOBs_insert.setQuantity(quantity);
        nutritionPlanWithBLOBs_insert.setAverage(average);
        nutritionPlanWithBLOBs_insert.setOperator(operator);
        nutritionPlanWithBLOBs_insert.setProfessor(professor);
        nutritionPlanWithBLOBs_insert.setSupervisor(supervisor);
        nutritionPlanWithBLOBs_insert.setRemark(remark);
        nutritionPlanWithBLOBs_insert.setIsPass(isPass);
        nutritionPlanWithBLOBs_insert.setUpassReason(upassReason);
        nutritionPlanWithBLOBs_insert.setBuilding(building);
        nutritionPlanWithBLOBs_insert.setPeriod(period);
        nutritionPlanWithBLOBs_insert.setMaterialA(materialA);
        nutritionPlanWithBLOBs_insert.setMaterialM(materialM);
        nutritionPlanWithBLOBs_insert.setMaterialO(materialO);
        nutritionPlanWithBLOBs_insert.setMaterialWM(materialWM);
        nutritionPlanWithBLOBs_insert.setMaterialWO(materialWO);
        nutritionPlanWithBLOBs_insert.setRoughageP(roughageP);
        nutritionPlanWithBLOBs_insert.setRoughageD(roughageD);
        nutritionPlanWithBLOBs_insert.setRoughageWP(roughageWP);
        nutritionPlanWithBLOBs_insert.setRoughageWD(roughageWD);
        nutritionPlanWithBLOBs_insert.setRoughageWO(roughageWO);
        nutritionPlanWithBLOBs_insert.setWater(water);
        nutritionPlanWithBLOBs_insert.setPickingM(pickingM);
        nutritionPlanWithBLOBs_insert.setPickingR(pickingR);
        nutritionPlanWithBLOBs_insert.setPickingO(pickingO);
        nutritionPlanService.addPlan(nutritionPlanWithBLOBs_insert);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",nutritionPlanWithBLOBs_insert);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/nutritionPlan/drop",method = RequestMethod.GET)
    public String dropPlan(){
        return "NutritionDeleteById";
    }
    @ResponseBody
    @RequestMapping(value = "/nutritionPlan/dropshow",method = RequestMethod.GET)
    public Response dropPlan(@RequestParam("id") Integer id){
        NutritionPlan NutritionPlan_delete = new NutritionPlan();
        nutritionPlanService.dropPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",NutritionPlan_delete);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/nutritionPlan/change",method = RequestMethod.GET)
    public String changePlan(){
        return "NutritionUpdate";
    }
    @ResponseBody
    @RequestMapping(value = "/nutritionPlan/changeshow",method = RequestMethod.GET)
    public Response changePlan(@RequestParam("id") Integer id,
                               @RequestParam("s_gmtCreate") String s_gmtCreate,
                               @RequestParam("s_gmtModified") String s_gmtModified,
                               @RequestParam("factoryNum") Long factoryNum,
                               @RequestParam("s_nutritionT") String s_nutritionT,
                               @RequestParam("quantity") Long quantity,
                               @RequestParam("average") String average,
                               @RequestParam("operator") String operator,
                               @RequestParam("professor") String professor,
                               @RequestParam("supervisor") String supervisor,
                               @RequestParam("remark") String remark,
                               @RequestParam("isPass") Byte isPass,
                               @RequestParam("upassReason") String upassReason,
                               @RequestParam("building") String building,
                               @RequestParam("period") String period,
                               @RequestParam("materialA") String materialA,
                               @RequestParam("materialM") String materialM,
                               @RequestParam("materialO") String materialO,
                               @RequestParam("materialWM") String materialWM,
                               @RequestParam("materialWO") String materialWO,
                               @RequestParam("roughageP") String roughageP,
                               @RequestParam("roughageD") String roughageD,
                               @RequestParam("roughageWP") String roughageWP,
                               @RequestParam("roughageWD") String roughageWD,
                               @RequestParam("roughageWO") String roughageWO,
                               @RequestParam("water") String water,
                               @RequestParam("pickingM") String pickingM,
                               @RequestParam("pickingR") String pickingR,
                               @RequestParam("pickingO") String pickingO
    ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date gmtCreate =  formatter.parse(s_gmtCreate);
        Date gmtModified =  formatter.parse(s_gmtModified);
        Date nutritionT =  formatter.parse(s_nutritionT);

        NutritionPlanWithBLOBs nutritionPlanWithBLOBs_update = new NutritionPlanWithBLOBs();
        nutritionPlanWithBLOBs_update.setId(id);
        nutritionPlanWithBLOBs_update.setGmtCreate(gmtCreate);
        nutritionPlanWithBLOBs_update.setGmtModified(gmtModified);
        nutritionPlanWithBLOBs_update.setFactoryNum(factoryNum);
        nutritionPlanWithBLOBs_update.setNutritionT(nutritionT);
        nutritionPlanWithBLOBs_update.setQuantity(quantity);
        nutritionPlanWithBLOBs_update.setAverage(average);
        nutritionPlanWithBLOBs_update.setOperator(operator);
        nutritionPlanWithBLOBs_update.setProfessor(professor);
        nutritionPlanWithBLOBs_update.setSupervisor(supervisor);
        nutritionPlanWithBLOBs_update.setRemark(remark);
        nutritionPlanWithBLOBs_update.setIsPass(isPass);
        nutritionPlanWithBLOBs_update.setUpassReason(upassReason);
        nutritionPlanWithBLOBs_update.setBuilding(building);
        nutritionPlanWithBLOBs_update.setPeriod(period);
        nutritionPlanWithBLOBs_update.setMaterialA(materialA);
        nutritionPlanWithBLOBs_update.setMaterialM(materialM);
        nutritionPlanWithBLOBs_update.setMaterialO(materialO);
        nutritionPlanWithBLOBs_update.setMaterialWM(materialWM);
        nutritionPlanWithBLOBs_update.setMaterialWO(materialWO);
        nutritionPlanWithBLOBs_update.setRoughageP(roughageP);
        nutritionPlanWithBLOBs_update.setRoughageD(roughageD);
        nutritionPlanWithBLOBs_update.setRoughageWP(roughageWP);
        nutritionPlanWithBLOBs_update.setRoughageWD(roughageWD);
        nutritionPlanWithBLOBs_update.setRoughageWO(roughageWO);
        nutritionPlanWithBLOBs_update.setWater(water);
        nutritionPlanWithBLOBs_update.setPickingM(pickingM);
        nutritionPlanWithBLOBs_update.setPickingR(pickingR);
        nutritionPlanWithBLOBs_update.setPickingO(pickingO);
        nutritionPlanService.changePlan(nutritionPlanWithBLOBs_update);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",nutritionPlanWithBLOBs_update);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/nutritionPlan/find",method = RequestMethod.GET)
    public String findPlan(){
        return "NutritionSelectById";
    }
    @ResponseBody
    @RequestMapping(value = "/nutritionPlan/findshow",method = RequestMethod.GET)
    public Response findPlan(@RequestParam("id") Integer id) {
        NutritionPlan nutritionPlan_select = nutritionPlanService.findPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("nutrition_plan",nutritionPlan_select);
        response.setData(data);
        return response;
    }
}
