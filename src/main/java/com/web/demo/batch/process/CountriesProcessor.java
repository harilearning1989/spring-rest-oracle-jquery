package com.web.demo.batch.process;

import com.web.demo.dtos.CountriesDTO;
import com.web.demo.entities.Countries;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component
public class CountriesProcessor implements ItemProcessor<CountriesDTO, Countries> {

    @Override
    public Countries process(final CountriesDTO dto) throws Exception {
        final Countries countries = new Countries();
        countries.setName(dto.getName());
        countries.setAlpha2(dto.getAlpha2());
        countries.setAlpha3(dto.getAlpha3());
        countries.setCountryCode(dto.getCountryCode());
        countries.setRegion(dto.getRegion());
        countries.setSubRegion(dto.getSubRegion());
        countries.setIntermediateRegion(dto.getIntermediateRegion());
        countries.setRegionCode(dto.getRegionCode());
        countries.setSubRegionCode(dto.getSubRegionCode());
        countries.setIntermediateRegionCode(dto.getIntermediateRegionCode());

        return countries;
    }
}

