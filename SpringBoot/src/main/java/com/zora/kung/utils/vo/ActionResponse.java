package com.zora.kung.utils.vo;

import java.io.Serializable;

/**
 * Created by Jack on 2016/12/30.
 */
public class ActionResponse implements Serializable {
    private Boolean succeed = Boolean.TRUE;
    private String message = "OK";
    private String referenceId;
    private Object responseObject;

    public ActionResponse(Boolean succeed, String message, String referenceId, Object responseObject){
        this.succeed = succeed;
        this.message = message;
        this.referenceId = referenceId;
        this.responseObject = responseObject;
    }

    public ActionResponse(Boolean succeed, String message, String referenceId){
        this.succeed = succeed;
        this.message = message;
        this.referenceId = referenceId;
    }

    public ActionResponse(Boolean succeed, String message){
        this.succeed = succeed;
        this.message = message;
    }

    public Boolean getSucceed() {
        return succeed;
    }

    public void setSucceed(Boolean succeed) {
        this.succeed = succeed;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getReferenceId() {
        return referenceId;
    }

    public void setReferenceId(String referenceId) {
        this.referenceId = referenceId;
    }

    public Object getResponseObject() {
        return responseObject;
    }

    public void setResponseObject(Object responseObject) {
        this.responseObject = responseObject;
    }
}
