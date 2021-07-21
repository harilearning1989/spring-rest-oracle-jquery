package com.web.demo.dtos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "name",
        "alpha2",
        "alpha3",
        "countrycode",
        "iso_31662",
        "region",
        "subregion",
        "intermediateregion",
        "regioncode",
        "subregioncode",
        "intermediateregioncode"
})
public class CountriesDTO {

    private String name;
    private String alpha2;
    private String alpha3;
    private String countryCode;
    private String iso3166;
    private String region;
    private String subRegion;
    private String intermediateRegion;
    private String regionCode;
    private String subRegionCode;
    private String intermediateRegionCode;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2() {
        return alpha2;
    }

    public void setAlpha2(String alpha2) {
        this.alpha2 = alpha2;
    }

    public String getAlpha3() {
        return alpha3;
    }

    public void setAlpha3(String alpha3) {
        this.alpha3 = alpha3;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIso3166() {
        return iso3166;
    }

    public void setIso3166(String iso3166) {
        this.iso3166 = iso3166;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getSubRegion() {
        return subRegion;
    }

    public void setSubRegion(String subRegion) {
        this.subRegion = subRegion;
    }

    public String getIntermediateRegion() {
        return intermediateRegion;
    }

    public void setIntermediateRegion(String intermediateRegion) {
        this.intermediateRegion = intermediateRegion;
    }

    public String getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    public String getSubRegionCode() {
        return subRegionCode;
    }

    public void setSubRegionCode(String subRegionCode) {
        this.subRegionCode = subRegionCode;
    }

    public String getIntermediateRegionCode() {
        return intermediateRegionCode;
    }

    public void setIntermediateRegionCode(String intermediateRegionCode) {
        this.intermediateRegionCode = intermediateRegionCode;
    }
}
