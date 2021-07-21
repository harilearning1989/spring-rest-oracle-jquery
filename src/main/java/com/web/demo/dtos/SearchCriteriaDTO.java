package com.web.demo.dtos;

import javax.validation.constraints.NotBlank;

public class SearchCriteriaDTO {

    @NotBlank(message = "state can't empty!")
    private String mandal;

    public String getMandal() {
        return mandal;
    }

    public void setMandal(String mandal) {
        this.mandal = mandal;
    }
}
