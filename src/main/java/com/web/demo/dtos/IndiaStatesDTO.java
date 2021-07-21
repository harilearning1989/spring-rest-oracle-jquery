package com.web.demo.dtos;

import java.util.Objects;

public class IndiaStatesDTO {

    private int id;
    private int mddsStc;
    private String stateName;
    private String districtName;
    private String subDistrictName;
    private String areaName;
    private int mddsDtc;
    private int mddsSubDt;
    private int mddsPlcn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMddsStc() {
        return mddsStc;
    }

    public void setMddsStc(int mddsStc) {
        this.mddsStc = mddsStc;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getSubDistrictName() {
        return subDistrictName;
    }

    public void setSubDistrictName(String subDistrictName) {
        this.subDistrictName = subDistrictName;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public int getMddsDtc() {
        return mddsDtc;
    }

    public void setMddsDtc(int mddsDtc) {
        this.mddsDtc = mddsDtc;
    }

    public int getMddsSubDt() {
        return mddsSubDt;
    }

    public void setMddsSubDt(int mddsSubDt) {
        this.mddsSubDt = mddsSubDt;
    }

    public int getMddsPlcn() {
        return mddsPlcn;
    }

    public void setMddsPlcn(int mddsPlcn) {
        this.mddsPlcn = mddsPlcn;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IndiaStatesDTO that = (IndiaStatesDTO) o;
        return id == that.id && mddsStc == that.mddsStc && mddsDtc == that.mddsDtc && mddsSubDt == that.mddsSubDt && mddsPlcn == that.mddsPlcn && Objects.equals(stateName, that.stateName) && Objects.equals(districtName, that.districtName) && Objects.equals(subDistrictName, that.subDistrictName) && Objects.equals(areaName, that.areaName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, mddsStc, stateName, districtName, subDistrictName, areaName, mddsDtc, mddsSubDt, mddsPlcn);
    }

    @Override
    public String toString() {
        return "IndiaStatesDTO{" +
                "id=" + id +
                ", mddsStc=" + mddsStc +
                ", stateName='" + stateName + '\'' +
                ", districtName='" + districtName + '\'' +
                ", subDistrictName='" + subDistrictName + '\'' +
                ", areaName='" + areaName + '\'' +
                ", mddsDtc=" + mddsDtc +
                ", mddsSubDt=" + mddsSubDt +
                ", mddsPlcn=" + mddsPlcn +
                '}';
    }
}
