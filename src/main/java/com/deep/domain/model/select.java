package com.deep.domain.model;

import java.io.Serializable;
/**
 * author: Created  By  Caojiawei
 * date: 2018/3/26  19:28
 */
public class Select implements Serializable {
    private String s_gmtCreate1;

    private String s_gmtCreate2;

    private String s_gmtModified1;

    private String s_gmtModified2;

    private static final long serialVersionUID = 1L;

    public String getS_gmtCreate1() {
        return s_gmtCreate1;
    }

    public void setS_gmtCreate1(String s_gmtCreate1) {
        this.s_gmtCreate1 = s_gmtCreate1;
    }

    public String getS_gmtCreate2() {
        return s_gmtCreate2;
    }

    public void setS_gmtCreate2(String s_gmtCreate2) {
        this.s_gmtCreate2 = s_gmtCreate2;
    }

    public String getS_gmtModified1() {
        return s_gmtModified1;
    }

    public void setS_gmtModified1(String s_gmtModified1) {
        this.s_gmtModified1 = s_gmtModified1;
    }

    public String getS_gmtModified2() {
        return s_gmtModified2;
    }

    public void setS_gmtModified2(String s_gmtModified2) {
        this.s_gmtModified2 = s_gmtModified2;
    }

}
