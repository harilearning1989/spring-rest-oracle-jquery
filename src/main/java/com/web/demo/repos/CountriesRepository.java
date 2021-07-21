package com.web.demo.repos;

import com.web.demo.entities.Countries;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CountriesRepository extends CrudRepository<Countries, Integer> {

    public List<Countries> findByIntermediateRegionNull();

    public List<Countries> findByIntermediateRegionNotNull();

}
