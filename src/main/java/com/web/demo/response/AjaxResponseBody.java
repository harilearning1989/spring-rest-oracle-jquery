package com.web.demo.response;

import com.web.demo.dtos.CropInsuranceDTO;

import java.util.List;

public class AjaxResponseBody<T> {

    String msg;
    List<CropInsuranceDTO> result;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<CropInsuranceDTO> getResult() {
        return result;
    }

    public void setResult(List<CropInsuranceDTO> result) {
        this.result = result;
    }
}
