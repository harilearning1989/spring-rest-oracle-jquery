package com.web.demo.entities;

import javax.persistence.*;

@Entity
@Table(name = "CROP_INSURANCE")

@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(name = "in_only_test_crop",
                procedureName = "test_pkg.in_only_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class)
                }),
        @NamedStoredProcedureQuery(name = "in_and_out_test_crop",
                procedureName = "test_pkg.in_and_out_test",
                parameters = {
                        @StoredProcedureParameter(mode = ParameterMode.IN, name = "inParam1", type = String.class),
                        @StoredProcedureParameter(mode = ParameterMode.OUT, name = "outParam1", type = String.class)
                }),
        @NamedStoredProcedureQuery(
                name = CropInsurance.NamedQuery_FetchCropInsurance,
                procedureName = "practiced_pkg.fetch_crop_insurance_ref_cursor",
                resultClasses = CropInsurance.class,
                parameters = {
                        @StoredProcedureParameter(type = void.class, mode = ParameterMode.REF_CURSOR)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "CropInsurance.findCropsViaProcedure",
                procedureName = "collect_roles",
                resultClasses = CropInsurance.class,
                parameters = {
                        @StoredProcedureParameter(name = "role_list_o", mode = ParameterMode.REF_CURSOR, type = void.class)
                }
        )
})
public class CropInsurance {
    public static final String NamedQuery_FetchCropInsurance = "fetchFromHistoryOld";

    @Id
    @Column(name = "SERIAL_NO")
    private int id;
    @Column(name = "MANDAL_NAME")
    private String mandalName;
    @Column(name = "VILLAGE_NAME")
    private String villName;
    @Column(name = "NAME_OF_THE_BENEFICIARY")
    private String beneficiary;
    @Column(name = "CROP")
    private String crop;
    @Column(name = "EXTENT_HA")
    private int extentHa;
    @Column(name = "CLAIM_AMOUNT_RS")
    private int claimAmount;
    @Column(name = "CATEGORY_LOANEE_NON_LOANEE")
    private String loanee;
    @Column(name = "BANK_NAME")
    private String bankName;
    @Column(name = "BRANCH_NAME")
    private String branchName;
    @Column(name = "ACCOUNT_NUMBER")
    private String accNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMandalName() {
        return mandalName;
    }

    public void setMandalName(String mandalName) {
        this.mandalName = mandalName;
    }

    public String getVillName() {
        return villName;
    }

    public void setVillName(String villName) {
        this.villName = villName;
    }

    public String getBeneficiary() {
        return beneficiary;
    }

    public void setBeneficiary(String beneficiary) {
        this.beneficiary = beneficiary;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public int getExtentHa() {
        return extentHa;
    }

    public void setExtentHa(int extentHa) {
        this.extentHa = 10;
    }

    public int getClaimAmount() {
        return claimAmount;
    }

    public void setClaimAmount(int claimAmount) {
        this.claimAmount = claimAmount;
    }

    public String getLoanee() {
        return loanee;
    }

    public void setLoanee(String loanee) {
        this.loanee = loanee;
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

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

}
