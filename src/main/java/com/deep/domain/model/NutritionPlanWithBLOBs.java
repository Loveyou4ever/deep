package com.deep.domain.model;

import java.io.Serializable;
import java.util.Date;

public class NutritionPlanWithBLOBs extends NutritionPlan implements Serializable {
    private String building;

    private String period;

    private String materialA;

    private String materialM;

    private String materialO;

    private String materialWM;

    private String materialWO;

    private String roughageP;

    private String roughageD;

    private String roughageWP;

    private String roughageWD;

    private String roughageWO;

    private String water;

    private String pickingM;

    private String pickingR;

    private String pickingO;

    private static final long serialVersionUID = 1L;

    public NutritionPlanWithBLOBs(){}

    public NutritionPlanWithBLOBs(String building, String period, String materialA, String materialM, String materialO, String materialWM, String materialWO, String roughageP, String roughageD, String roughageWP, String roughageWD, String roughageWO, String water, String pickingM, String pickingR, String pickingO) {
        this.building = building;
        this.period = period;
        this.materialA = materialA;
        this.materialM = materialM;
        this.materialO = materialO;
        this.materialWM = materialWM;
        this.materialWO = materialWO;
        this.roughageP = roughageP;
        this.roughageD = roughageD;
        this.roughageWP = roughageWP;
        this.roughageWD = roughageWD;
        this.roughageWO = roughageWO;
        this.water = water;
        this.pickingM = pickingM;
        this.pickingR = pickingR;
        this.pickingO = pickingO;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building == null ? null : building.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getMaterialA() {
        return materialA;
    }

    public void setMaterialA(String materialA) {
        this.materialA = materialA == null ? null : materialA.trim();
    }

    public String getMaterialM() {
        return materialM;
    }

    public void setMaterialM(String materialM) {
        this.materialM = materialM == null ? null : materialM.trim();
    }

    public String getMaterialO() {
        return materialO;
    }

    public void setMaterialO(String materialO) {
        this.materialO = materialO == null ? null : materialO.trim();
    }

    public String getMaterialWM() {
        return materialWM;
    }

    public void setMaterialWM(String materialWM) {
        this.materialWM = materialWM == null ? null : materialWM.trim();
    }

    public String getMaterialWO() {
        return materialWO;
    }

    public void setMaterialWO(String materialWO) {
        this.materialWO = materialWO == null ? null : materialWO.trim();
    }

    public String getRoughageP() {
        return roughageP;
    }

    public void setRoughageP(String roughageP) {
        this.roughageP = roughageP == null ? null : roughageP.trim();
    }

    public String getRoughageD() {
        return roughageD;
    }

    public void setRoughageD(String roughageD) {
        this.roughageD = roughageD == null ? null : roughageD.trim();
    }

    public String getRoughageWP() {
        return roughageWP;
    }

    public void setRoughageWP(String roughageWP) {
        this.roughageWP = roughageWP == null ? null : roughageWP.trim();
    }

    public String getRoughageWD() {
        return roughageWD;
    }

    public void setRoughageWD(String roughageWD) {
        this.roughageWD = roughageWD == null ? null : roughageWD.trim();
    }

    public String getRoughageWO() {
        return roughageWO;
    }

    public void setRoughageWO(String roughageWO) {
        this.roughageWO = roughageWO == null ? null : roughageWO.trim();
    }

    public String getWater() {
        return water;
    }

    public void setWater(String water) {
        this.water = water == null ? null : water.trim();
    }

    public String getPickingM() {
        return pickingM;
    }

    public void setPickingM(String pickingM) {
        this.pickingM = pickingM == null ? null : pickingM.trim();
    }

    public String getPickingR() {
        return pickingR;
    }

    public void setPickingR(String pickingR) {
        this.pickingR = pickingR == null ? null : pickingR.trim();
    }

    public String getPickingO() {
        return pickingO;
    }

    public void setPickingO(String pickingO) {
        this.pickingO = pickingO == null ? null : pickingO.trim();
    }
}