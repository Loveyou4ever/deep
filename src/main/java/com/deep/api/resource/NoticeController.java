package com.deep.api.resource;

import com.deep.api.response.Response;
import com.deep.api.response.Responses;
import com.deep.domain.model.NoticePlan;
import com.deep.domain.model.NoticePlanExample;
import com.deep.domain.service.NoticePlanService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * author: Created  By  Caojiawei
 * date: 2018/3/8  20:14
 */
@Controller
public class NoticeController {
    @Resource
    private NoticePlanService noticePlanService;

    @ResponseBody
    @RequestMapping(value = "/NoticePlan",method = RequestMethod.GET)
    public String helloNotice() {
        return "Hello NoticePlan!";
    }

    //插入一条完整信息
    @RequestMapping(value = "/NoticeInsert",method = RequestMethod.GET)
    public String addPlan(){
        return "NoticeInsert";
    }
    @ResponseBody
    @RequestMapping(value = "/NoticeInsert/show",method = RequestMethod.POST)
    public Response addPlan(@Valid NoticePlan insert, HttpServletRequest request){
        insert.setGmtCreate(new Date());
        insert.setProfessor(insert.getProfessor());
        insert.setType(insert.getType());
        insert.setTitle(insert.getTitle());
        insert.setContent(insert.getContent());

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        String filename = null;
        String suffixname = null;
        String filepath = request.getSession().getServletContext().getContextPath()+"../picture/"+insert.getProfessor()+"/";
        for (int i = 0; i < files.size(); i++) {
            file = files.get(i);
            filename = file.getOriginalFilename();
            suffixname = filename.substring(filename.lastIndexOf("."));
            /*//防止在Linux系统下不识别中文路径名
            filename = UUID.randomUUID() + suffixname;*/
            if (!file.isEmpty()) {
                try {
                    noticePlanService.uploadFile(file.getBytes(), filepath, filename);
                } catch (Exception e) {
                    // TODO: handle exception
                }
            }
            insert.setFilepath(filepath+filename);
            insert.setSuffixname(suffixname);
            noticePlanService.addPlan(insert);
        }
        NoticePlanExample insertExample = new NoticePlanExample();
        NoticePlanExample.Criteria criteria = insertExample.createCriteria();
        criteria.andTitleEqualTo(insert.getTitle());
        criteria.andTypeEqualTo(insert.getType());
        criteria.andProfessorEqualTo(insert.getProfessor());
        List<NoticePlan> select = noticePlanService.findPlanSelective(insertExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("notice_plan",select);
        response.setData(data);
        return response;
    }

    //根据主键删除信息
    @RequestMapping(value = "/NoticeDeleteById",method = RequestMethod.GET)
    public String dropPlan(){
        return "NoticeDeleteById";
    }
    @ResponseBody
        @RequestMapping(value = "/NoticeDeleteById/show",method = RequestMethod.GET)
    public Response dropPlan(@RequestParam("id") Integer id){
        NoticePlan delete = new NoticePlan();
        noticePlanService.dropPlan(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("notice_plan",delete);
        response.setData(data);
        return response;
    }

    //根据主键修改信息
    @RequestMapping(value = "/NoticeUpdate",method = RequestMethod.GET)
    public String changePlan(){
        return "NoticeUpdate";
    }
    @ResponseBody
    @RequestMapping(value = "/NoticeUpdate/show",method = RequestMethod.POST)
    public Response changePlan(@Valid NoticePlan update,HttpServletRequest request){
        update.setId(update.getId());
        update.setGmtModified(new Date());
        update.setType(update.getType());
        update.setTitle(update.getTitle());
        update.setContent(update.getContent());

        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        MultipartFile file = null;
        String filename = null;
        String suffixname = "";
        String filepath = request.getSession().getServletContext().getContextPath()+"../picture/"+update.getProfessor()+"/";
        file = files.get(0);
        filename = file.getOriginalFilename();
        if (!filename.isEmpty())
        {
            suffixname= filename.substring(filename.lastIndexOf("."));
        }
            /*//防止在Linux系统下不识别中文路径名
            filename = UUID.randomUUID() + suffixname;*/
        if (!file.isEmpty()) {
            try {
                noticePlanService.uploadFile(file.getBytes(), filepath, filename);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println(suffixname);
        System.out.println(filename);
        update.setSuffixname(suffixname);
        update.setFilepath(filepath+filename);
        noticePlanService.changePlan(update);

        NoticePlan selectById = noticePlanService.findPlanById(update.getId());
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("notice_plan",selectById);
        response.setData(data);
        return response;
    }

    //根据主键查询
    @RequestMapping(value = "/NoticeSelectById",method = RequestMethod.GET)
    public String findPlanById(){
        return "NoticeSelectById";
    }
    @ResponseBody
    @RequestMapping(value = "/NoticeSelectById/show",method = RequestMethod.GET)
    public Response findPlanById(@RequestParam("id") Integer id){
        NoticePlan selectById = noticePlanService.findPlanById(id);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("notice_plan",selectById);
        response.setData(data);
        return response;
    }

    //根据条件查询信息
    @RequestMapping(value = "/NoticeSelective",method = RequestMethod.GET)
    public String findPlanSelective(){
        return "NoticeSelective";
    }
    @ResponseBody
    @RequestMapping(value = "/NoticeSelective/show",method = RequestMethod.GET)
    public Response findPlanSelective(@Valid NoticePlan noticePlan,
                                      @RequestParam ("s_gmtCreate1") String s_gmtCreate1,
                                      @RequestParam ("s_gmtCreate2") String s_gmtCreate2,
                                      @RequestParam ("s_gmtModified1") String s_gmtModified1,
                                      @RequestParam ("s_gmtModified2") String s_gmtModified2
                                      ) throws ParseException {
        Date gmtCreate1 = null;
        Date gmtCreate2 = null;
        Date gmtModified1 = null;
        Date gmtModified2 = null;
        java.text.SimpleDateFormat formatter = new SimpleDateFormat( "yyyy-MM-dd HH:mm:SS");
        if (s_gmtCreate1 != "" && s_gmtCreate2 != ""){
            gmtCreate1 =  formatter.parse(s_gmtCreate1);
            gmtCreate2 =  formatter.parse(s_gmtCreate2);
        }
        if (s_gmtCreate1 != "" && s_gmtCreate2 != ""){
            gmtModified1 =  formatter.parse(s_gmtModified1);
            gmtModified2 =  formatter.parse(s_gmtModified2);
        }

        NoticePlanExample noticePlanExample = new NoticePlanExample();
        NoticePlanExample.Criteria criteria = noticePlanExample.createCriteria();

        if(noticePlan.getId() != null && noticePlan.getId().toString() !=""){
            criteria.andIdEqualTo(noticePlan.getId());
        }
        if(noticePlan.getGmtCreate() != null && noticePlan.getGmtCreate().toString() !=""){
            criteria.andGmtCreateBetween(gmtCreate1,gmtCreate2);
        }
        if(noticePlan.getGmtModified() != null && noticePlan.getGmtModified().toString() !=""){
            criteria.andGmtModifiedBetween(gmtModified1,gmtModified2);
        }
        if(noticePlan.getProfessor() != null && noticePlan.getProfessor() !=""){
            criteria.andProfessorEqualTo(noticePlan.getProfessor());
        }
        if(noticePlan.getType() != null && noticePlan.getType().toString() !=""){
            criteria.andTypeEqualTo(noticePlan.getType());
        }
        if(noticePlan.getTitle() != null && noticePlan.getTitle() !=""){
            criteria.andTitleEqualTo(noticePlan.getTitle());
        }

        List<NoticePlan> select = noticePlanService.findPlanSelective(noticePlanExample);
        Response response = Responses.successResponse();
        HashMap<String, Object> data = new HashMap<>();
        data.put("notice_plan",select);
        response.setData(data);
        return response;
    }

    @RequestMapping(value = "/Download",method = RequestMethod.GET)
    public String downloadFile(){
        return "Download";
    }
    @ResponseBody
    @RequestMapping(value = "/Download/show",method = RequestMethod.GET)
    public String downloadFile(@RequestParam ("filePath") String filePath,/*HttpServletRequest request,*/
                               HttpServletResponse response){
            File file = new File(filePath);
            if (file.exists()) {
                response.setContentType("application/force-download");// 设置强制下载不打开
                response.addHeader("Content-Disposition", "attachment;file=" + filePath);// 设置文件名
                byte[] buffer = new byte[1024];
                FileInputStream fis = null;
                BufferedInputStream bis = null;
                try {
                    fis = new FileInputStream(file);
                    bis = new BufferedInputStream(fis);
                    OutputStream os = response.getOutputStream();
                    int i = bis.read(buffer);
                    while (i != -1) {
                        os.write(buffer, 0, i);
                        i = bis.read(buffer);
                    }
                    System.out.println("success");
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    if (bis != null) {
                        try {
                            bis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                    if (fis != null) {
                        try {
                            fis.close();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        return null;
    }
}
