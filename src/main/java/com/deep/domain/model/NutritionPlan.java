package com.deep.domain.model;

import java.io.Serializable;
import java.util.Date;

public class NutritionPlan implements Serializable {
    private Integer id;

    private Date gmtCreate;

    private Date gmtModified;

    private Long factoryNum;

    private Date nutritionT;

    private Long quantity;

    private String average;

    private String operator;

    private String professor;

    private String supervisor;

    private String remark;

    private Byte isPass;

    private String upassReason;

    private static final long serialVersionUID = 1L;

    public NutritionPlan() {}

    public NutritionPlan(Integer id, Date gmtCreate, Date gmtModified, Long factoryNum, Date nutritionT, Long quantity, String average, String operator, String professor, String supervisor, String remark, Byte isPass, String upassReason) {
        this.id = id;
        this.gmtCreate = gmtCreate;
        this.gmtModified = gmtModified;
        this.factoryNum = factoryNum;
        this.nutritionT = nutritionT;
        this.quantity = quantity;
        this.average = average;
        this.operator = operator;
        this.professor = professor;
        this.supervisor = supervisor;
        this.remark = remark;
        this.isPass = isPass;
        this.upassReason = upassReason;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    public Long getFactoryNum() {
        return factoryNum;
    }

    public void setFactoryNum(Long factoryNum) {
        this.factoryNum = factoryNum;
    }

    public Date getNutritionT() {
        return nutritionT;
    }

    public void setNutritionT(Date nutritionT) {
        this.nutritionT = nutritionT;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public String getAverage() {
        return average;
    }

    public void setAverage(String average) {
        this.average = average == null ? null : average.trim();
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator == null ? null : operator.trim();
    }

    public String getProfessor() {
        return professor;
    }

    public void setProfessor(String professor) {
        this.professor = professor == null ? null : professor.trim();
    }

    public String getSupervisor() {
        return supervisor;
    }

    public void setSupervisor(String supervisor) {
        this.supervisor = supervisor == null ? null : supervisor.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Byte getIsPass() {
        return isPass;
    }

    public void setIsPass(Byte isPass) {
        this.isPass = isPass;
    }

    public String getUpassReason() {
        return upassReason;
    }

    public void setUpassReason(String upassReason) {
        this.upassReason = upassReason == null ? null : upassReason.trim();
    }
}