package com.web.demo.batch.write;

import com.web.demo.entities.CropInsurance;
import com.web.demo.repos.CropInsuranceRepository;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class CropInsuranceWriter implements ItemWriter<CropInsurance> {

    private CropInsuranceRepository cropInsuranceRepository;

    @Autowired
    public void setCropInsuranceRepository(CropInsuranceRepository cropInsuranceRepository) {
        this.cropInsuranceRepository = cropInsuranceRepository;
    }

    @Override
    @Transactional
    public void write(List<? extends CropInsurance> users) throws Exception {
        cropInsuranceRepository.saveAll(users);
    }
}
