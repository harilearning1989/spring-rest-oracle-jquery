package com.web.demo.batch.process;

import com.web.demo.dtos.CropInsuranceDTO;
import com.web.demo.entities.CropInsurance;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CropInsuranceProcessor implements ItemProcessor<CropInsuranceDTO, CropInsurance> {

    @Override
    public CropInsurance process(final CropInsuranceDTO dto) throws Exception {
        final CropInsurance crop = new CropInsurance();
        crop.setId(dto.getSerialNumber());
        crop.setMandalName(dto.getMandalName());
        crop.setVillName(dto.getVillageName());
        crop.setBeneficiary(dto.getNameOfTheBeneficiary());
        crop.setCrop(dto.getCrop());
        int i = (int) dto.getClaimAmountRs();
        crop.setClaimAmount(i);
        crop.setBankName(dto.getBankName());
        crop.setBranchName(dto.getBranchName());
        crop.setAccNumber(dto.getAccountNumber());
        crop.setLoanee(dto.getCategoryLoaneeNonLoanee());
        //System.out.println("Transforming CropInsurance(s) to CropInsuranceDTO(s).." + cropDto.getSerialNumber());
        return crop;
    }
}
