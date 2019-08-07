package com.itcast.recon.enums;

/**
 * Created by zhou on 2019/2/17.
 */
public class ReconFileType {

   /* INNER("inner", "下载存管对账文件"),

    OUTER("outer", "下载对账文件至本地");
*/
    private String desc;

    private String code;

    ReconFileType(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }
    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
