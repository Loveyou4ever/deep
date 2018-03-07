package com.deep.api.resource;

import com.deep.api.response.Response;
import com.deep.api.response.Responses;
import com.deep.domain.model.DiagnosisPlan;
import com.deep.domain.model.DiagnosisPlanExample;
import com.deep.domain.model.DiagnosisPlanWithBLOBs;
import com.deep.domain.service.DiagnosisPlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * author: Created  By  Caojiawei
 * date: 2018/2/18  11:46
 */
@Controller
public class DiagnosisController {
    @Resource
    private DiagnosisPlanService diagnosisPlanService;

    @ResponseBody
    @RequestMapping(value = "/DiagnosisPlan",method = RequestMethod.GET)
    public String helloDiagnosis() {
        return "Hello DiagnosisPlan!";
    }

    //插入一条完整信息
    @RequestMapping(value = "/DiagnosisInsert",method = RequestMethod.GET)
    public String addPlan(){
        return "DiagnosisInsert";
    }
    @ResponseBody
    @RequestMapping(value = "/DiagnosisInsert/show",method = RequestMethod.GET)
    public Response addPlan(@Valid DiagnosisPlanWithBLOBs insert,
                            @RequestParam("s_diagnosisT") String s_diagnosisT
    ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss");
        Date diagnosisT =  formatter.parse(s_diagnosisT);
        insert.setId(insert.getId());
        insert.setGmtCreate(new Date());
        insert.setGmtModified(new Date());
        insert.setFactoryNum(insert.getFactoryNum());
//        insert.setDiagnosisT(insert.getDiagnosisT());
        insert.setDiagnosisT(diagnosisT);
        insert.setEtB(insert.getEtB());
        insert.setOperator(insert.getOperator());
        insert.setProfessor(insert.getProfessor());
        insert.setSupervisor(insert.getSupervisor());
        insert.setRemark(insert.getRemark());
        insert.setIsPass(insert.getIsPass());
        insert.setUpassReason(insert.getUpassReason());
        insert.setBuilding(insert.getBuilding());
        insert.setDiagnosisC(insert.getDiagnosisC());
        insert.setDiagnosisM(insert.getDiagnosisM());
        insert.setDrugQ(insert.getDrugQ());
        diagnosisPlanService.addPlan(insert);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("diagnosis_plan",insert);
        response.setData(data);
        return response;
    }

    //根据主键删除信息
    @RequestMapping(value = "/DiagnosisDeleteById",method = RequestMethod.GET)
    public String dropPlan(){
        return "DiagnosisDeleteById";
    }
    @ResponseBody
    @RequestMapping(value = "/DiagnosisDeleteById/show",method = RequestMethod.GET)
    public Response dropPlan(@RequestParam("id") Integer id){
        DiagnosisPlan delete = new DiagnosisPlan();
        diagnosisPlanService.dropPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("diagnosis_plan",delete);
        response.setData(data);
        return response;
    }

    //根据主键修改信息
    @RequestMapping(value = "/DiagnosisUpdate",method = RequestMethod.GET)
    public String changePlan(){
        return "DiagnosisUpdate";
    }
    @ResponseBody
    @RequestMapping(value = "/DiagnosisUpdate/show",method = RequestMethod.GET)
    public Response changePlan(@Valid DiagnosisPlanWithBLOBs update,
                               @RequestParam("s_diagnosisT") String s_diagnosisT
    ) throws ParseException {
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd");
        Date diagnosisT =  formatter.parse(s_diagnosisT);

        update.setId(update.getId());
        update.setGmtModified(new Date());
        update.setFactoryNum(update.getFactoryNum());
//        update.setDiagnosisT(update.getDiagnosisT());
        update.setDiagnosisT(diagnosisT);
        update.setEtB(update.getEtB());
        update.setOperator(update.getOperator());
        update.setProfessor(update.getProfessor());
        update.setSupervisor(update.getSupervisor());
        update.setRemark(update.getRemark());
        update.setIsPass(update.getIsPass());
        update.setUpassReason(update.getUpassReason());
        update.setBuilding(update.getBuilding());
        update.setDiagnosisC(update.getDiagnosisC());
        update.setDiagnosisM(update.getDiagnosisM());
        update.setDrugQ(update.getDrugQ());
        diagnosisPlanService.changePlan(update);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("diagnosis_plan",update);
        response.setData(data);
        return response;
    }

    //根据主键查询
    @RequestMapping(value = "/DiagnosisSelectById",method = RequestMethod.GET)
    public String findPlanById(){
        return "DiagnosisSelectById";
    }
    @ResponseBody
    @RequestMapping(value = "/DiagnosisSelectById/show",method = RequestMethod.GET)
    public Response findPlanById(@Valid DiagnosisPlan diagnosisPlan){
        //查询语句的写法：一定要在声明对象时把值直接赋进去
        DiagnosisPlanWithBLOBs select = diagnosisPlanService.findPlanById(diagnosisPlan.getId());
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("diagnosis_plan",select);
        response.setData(data);
        return response;
    }

    //根据条件查询信息
   @RequestMapping(value = "/DiagnosisSelective",method = RequestMethod.GET)
   public String findPlanSelective(){
       return "DiagnosisSelective";
   }
    @ResponseBody
    @RequestMapping(value = "/DiagnosisSelective/show",method = RequestMethod.GET)
    public Response findPlanSelective(@Valid DiagnosisPlanWithBLOBs diagnosisPlanWithBLOBs) {

        DiagnosisPlanExample diagnosisPlanExample = new DiagnosisPlanExample();
        DiagnosisPlanExample.Criteria criteria = diagnosisPlanExample.createCriteria();

        if(diagnosisPlanWithBLOBs.getId() != null && diagnosisPlanWithBLOBs.getId().toString() !=""){
            criteria.andIdEqualTo(diagnosisPlanWithBLOBs.getId());
        }
        if(diagnosisPlanWithBLOBs.getFactoryNum() != null && diagnosisPlanWithBLOBs.getFactoryNum().toString() !=""){
            criteria.andFactoryNumEqualTo(diagnosisPlanWithBLOBs.getFactoryNum());
        }
        if(diagnosisPlanWithBLOBs.getEtB() != null && diagnosisPlanWithBLOBs.getEtB() !=""){
            criteria.andEtBEqualTo(diagnosisPlanWithBLOBs.getEtB());
        }
        if(diagnosisPlanWithBLOBs.getOperator() != null && diagnosisPlanWithBLOBs.getOperator() !=""){
            criteria.andOperatorEqualTo(diagnosisPlanWithBLOBs.getOperator());
        }
        if(diagnosisPlanWithBLOBs.getProfessor() != null && diagnosisPlanWithBLOBs.getProfessor() !=""){
            criteria.andProfessorEqualTo(diagnosisPlanWithBLOBs.getProfessor());
        }
        if(diagnosisPlanWithBLOBs.getSupervisor() != null && diagnosisPlanWithBLOBs.getSupervisor() !=""){
            criteria.andSupervisorEqualTo(diagnosisPlanWithBLOBs.getSupervisor());
        }
        if(diagnosisPlanWithBLOBs.getIsPass() != null && diagnosisPlanWithBLOBs.getIsPass().toString() !=""){
            criteria.andIsPassEqualTo(diagnosisPlanWithBLOBs.getIsPass());
        }
        List<DiagnosisPlanWithBLOBs> select = diagnosisPlanService.findPlanSelective(diagnosisPlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("diagnosis_plan",select);
        response.setData(data);
        return response;
    }
}
