package com.web.demo.dtos;

import com.opencsv.bean.CsvBindByName;

public class CropInsuranceDTO {

    @CsvBindByName(column = "SERIALNO")
    private int serialNumber;
    @CsvBindByName(column = "MANDALNAME")
    private String mandalName;
    @CsvBindByName(column = "VILLAGENAME")
    private String villageName;
    @CsvBindByName(column = "NAMEOFTHEBENEFICIARY")
    private String nameOfTheBeneficiary;
    @CsvBindByName(column = "CROP")
    private String crop;
    @CsvBindByName(column = "EXTENTHA")
    private double extentHa;
    @CsvBindByName(column = "CLAIMAMOUNTRS")
    private double claimAmountRs;
    @CsvBindByName(column = "CATEGORYLOANEENONLOANEE")
    private String categoryLoaneeNonLoanee;
    @CsvBindByName(column = "BANKNAME")
    private String bankName;
    @CsvBindByName(column = "BRANCHNAME")
    private String branchName;
    @CsvBindByName(column = "ACCOUNTNUMBER")
    private String accountNumber;

    public int getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(int serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillageName() {
        return villageName;
    }

    public void setVillageName(String villageName) {
        this.villageName = villageName;
    }

    public String getNameOfTheBeneficiary() {
        return nameOfTheBeneficiary;
    }

    public void setNameOfTheBeneficiary(String nameOfTheBeneficiary) {
        this.nameOfTheBeneficiary = nameOfTheBeneficiary;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getExtentHa() {
        return extentHa;
    }

    public void setExtentHa(double extentHa) {
        this.extentHa = extentHa;
    }

    public double getClaimAmountRs() {
        return claimAmountRs;
    }

    public void setClaimAmountRs(double claimAmountRs) {
        this.claimAmountRs = claimAmountRs;
    }

    public String getCategoryLoaneeNonLoanee() {
        return categoryLoaneeNonLoanee;
    }

    public void setCategoryLoaneeNonLoanee(String categoryLoaneeNonLoanee) {
        this.categoryLoaneeNonLoanee = categoryLoaneeNonLoanee;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
